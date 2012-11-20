package org.openvisko.module;
import edu.utep.trustlab.toolkitOperators.SimulationOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;


public class PolyMesh_py extends SimulationOperator
{
	
	// the output name for the dataset generated by this operator
	private static final String outputFileName = "PolyMesh_out.xml";
	
	public PolyMesh_py(String contextURL) {
		super(contextURL, outputFileName);
	}

	/*
	 * This method accesses the functionality of the wrapped executable. In this example, the exectuable takes
	 * three params (param1, param2, and param3). You can extend this to take as many parameters as necessary. This
	 * examples assume that the executable takes an input file path and an output file path, where the result will be written.
	 */
	/*
	   CFGfile� CFG geometry file (path)
       CEL � characteristic element length (float, user specified)
       MID � turn on mid-edge feature (0/1) (optional, user specified)
       EDGE � refinement control (float) (optional, user specified)
	 */
	public String transform(
			String cel,
			String mid,
			String edge)
	{
		String cfgFilePath = getInputFile("cfg");
		
		//The command string that will be passed to the shell
		// python PolyMesh.py CFGfile �cel CEL �mid_edge MID �edge_factor EDGE
		String cmd = 
			"python /share/apps/cmmf/Gen_Poly/PolyMesh/PolyMesh.py " +
			 cfgFilePath + " " + 
			 " -cel " + cel + " " +
			 " -mid_edge " + mid + " " +
			 " -edge_factor " + edge + " ";
		
		CommandRunner.run(cmd, FileUtils.getWorkspace());

		/*
		     Vertices � CSV file containing the vertex id�s and coordinates
			 Elements � CSV file containing element id, type, material id, and connectivity
			 Components � CSV file listing element edges
             QuadNodes � CSV file containing vertex id�s and coordinates for mid-edge nodes needed for quadratic elements
		 */

		addOutputFile("vertices", "Vertices");
		addOutputFile("elements", "Elements");
		addOutputFile("components", "Components");
		addOutputFile("quadNodes", "QuadNodes");
		
		return writeOutputContextXML();
	}
}