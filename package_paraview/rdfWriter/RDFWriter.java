package package_paraview.rdfWriter;

import edu.utep.trustlab.visko.ontology.operator.writer.ViewerSetWriter;
import edu.utep.trustlab.visko.ontology.operator.writer.ViewerWriter;
import edu.utep.trustlab.visko.packages.rdf.PackageRDFWriter;

public class RDFWriter implements PackageRDFWriter {

	String paraviewViewerSetURI;
	
	@Override
	public void createServices() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createToolkit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createViewerSets() {
		// TODO Auto-generated method stub
		ViewerSetWriter wtr = new ViewerSetWriter("paraview");
		wtr.setLabel("KitWare Paraview");
		System.out.println(wtr.saveDocument());
		paraviewViewerSetURI = wtr.getURI();
	}

	@Override
	public void createViewers() {
		// TODO Auto-generated method stub
		ViewerWriter wtr = new ViewerWriter("XDMF_Viewer");
		wtr.setLabel("XDMF Viewer");
		wtr.addPartOfSetURI(paraviewViewerSetURI);
		wtr.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/XDMF.owl#XDMF");
		wtr.setViewerComment("XDMF Viewer of the ParaView Distribution");
		System.out.println(wtr.saveDocument());
	}
}