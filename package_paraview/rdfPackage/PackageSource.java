package package_paraview.rdfPackage;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageViewerSet;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.viskoOperator.Viewer;

public class PackageSource extends RDFPackage {

	private static final class Resources{
		//formats
		private static final Format xdmf = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/XDMF.owl#XDMF");
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
		viewer1.addInputFormat(Resources.xdmf);
	}

	@Override
	public void populateParameterBindings() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getWSDLURL() {
		// TODO Auto-generated method stub
		return null;
	}
}