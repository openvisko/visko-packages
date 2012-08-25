package package_paraview.rdfPackage;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageViewerSet;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.operator.Viewer;
import edu.utep.trustlab.visko.ontology.pmlp.Format;

public class PackageSource extends RDFPackage {

	private static final class Resources{
		//formats
		private static final Format xdmf = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/XDMF.owl#XDMF");
	}
	
	@Override
	public void populateServices() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void populateToolkit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void populateViewerSets() {
		PackageViewerSet viewerSet = getPackageWriter().createNewViewerSet("paraview");
		viewerSet.setComment("Kitware Paraview");
		viewerSet.setLabel("Kitware Paraview");
		
		Viewer viewer1 = viewerSet.createNewViewer("xdmf-viewer");
		viewer1.setComment("XDMF Viewer of the ParaView Distribution");
		viewer1.setLabel("XDMF Viewer");
		viewer1.addOperatesOnFormat(Resources.xdmf);
	}
}