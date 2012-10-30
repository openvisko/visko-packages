package package_d3.rdfPackage;

import com.hp.hpl.jena.ontology.OntResource;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageViewerSet;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.viskoOperator.Viewer;
import edu.utep.trustlab.visko.ontology.viskoService.Toolkit;
import edu.utep.trustlab.visko.ontology.viskoView.VisualizationAbstraction;
import edu.utep.trustlab.visko.ontology.vocabulary.ViskoV;

public class PackageSource extends RDFPackage {

	private static final class Resources {
		//formats
		private static final Format json = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/JSON.owl#JSON");
		
		//data types 				
		private static final OntResource viskoDataTransformationPaths = PackageWriter.getDataType("https://raw.github.com/nicholasdelrio/visko/master/resources/ontology/visko.owl#VisKo_DataTransformationPaths");
		private static final OntResource viskoOperatorPaths = PackageWriter.getDataType("https://raw.github.com/nicholasdelrio/visko/master/resources/ontology/visko.owl#VisKo_OperatorPaths");
		private static final OntResource viskoInstanceSummary = PackageWriter.getDataType("https://raw.github.com/nicholasdelrio/visko/master/resources/ontology/visko.owl#VisKo_InstanceSummary");
		
		//views
		private static final VisualizationAbstraction viskoInstancesBarChart = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_VisKo_Instances_BarChart);
		private static final VisualizationAbstraction viskoOperatorPathsforceGraph = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_VisKo_OperatorPaths_ForceGraph);
		private static final VisualizationAbstraction viskoDataTransformationsForceGraph = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_VisKo_DataTransformations_ForceGraph);
	}

	@Override
	public void populateServices() {
	}

	@Override
	public void populateToolkit() {
		Toolkit toolkit = getPackageWriter().createNewToolkit("data-driven-documents");
		toolkit.setComment("Data Driven Documents");
		toolkit.setLabel("Data Driven Documents");
	}

	@Override
	public void populateViewerSets() {		
		PackageViewerSet viewerSet = getPackageWriter().createNewViewerSet("d3-viewer-set");
		viewerSet.setComment("Data Driven Documents Viewer Set");
		viewerSet.setLabel("D3 Viewer Set");
		
		Viewer viewer1 = viewerSet.createNewViewer("visko-operator-paths-viewer");
		viewer1.setLabel("Force Graph Viewer for Visko Operator Paths");
		viewer1.setComment("Force Graph Viewer for Visko Operator Paths");
		viewer1.addInputFormat(Resources.json);
		viewer1.addInputDataType(Resources.viskoOperatorPaths);
		viewer1.setVisualizationAbstraction(Resources.viskoOperatorPathsforceGraph);
		viewer1.setEndpointURL("http://iw.cs.utep.edu:8080/d3-viewers/Parameterized_Graph_OperatorPaths.html");
		
		Viewer viewer2 = viewerSet.createNewViewer("visko-instances-viewer");
		viewer2.setLabel("Bar Chart Viewer for Visko KB");
		viewer2.setComment("Bar Chart Viewer for Visko KB");
		viewer2.addInputFormat(Resources.json);
		viewer2.addInputDataType(Resources.viskoInstanceSummary);
		viewer2.setVisualizationAbstraction(Resources.viskoInstancesBarChart);
		viewer2.setEndpointURL("http://iw.cs.utep.edu:8080/d3-viewers/Parameterized_Bars_Instances.html");
		
		Viewer viewer3 = viewerSet.createNewViewer("visko-data-transformations-viewer");
		viewer3.setLabel("Force Graph Viewer for Visko Data Transformation Paths");
		viewer3.setComment("Force Graph Viewer for Visko Data Transformation Paths");
		viewer3.addInputFormat(Resources.json);
		viewer3.addInputDataType(Resources.viskoDataTransformationPaths);
		viewer3.setVisualizationAbstraction(Resources.viskoDataTransformationsForceGraph);
		viewer3.setEndpointURL("http://iw.cs.utep.edu:8080/d3-viewers/Parameterized_Graph_DataTransformations.html");
	}

	@Override
	public void populateParameterBindings() {
	}
			
	@Override
	public String getWSDLURL() {
		return "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
	}
}
