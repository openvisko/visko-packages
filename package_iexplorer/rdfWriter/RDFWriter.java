package package_iexplorer.rdfWriter;

import edu.utep.trustlab.visko.ontology.operator.writer.ViewerSetWriter;
import edu.utep.trustlab.visko.ontology.operator.writer.ViewerWriter;
import edu.utep.trustlab.visko.packages.rdf.PackageRDFWriter;

public class RDFWriter implements PackageRDFWriter {

	private String iexplorerViewerSetURI;

	@Override
	public void createToolkit() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void createViewerSets() {
		// TODO Auto-generated method stub
		
		ViewerSetWriter wtr1 = new ViewerSetWriter("internet-explorer");
		wtr1.setLabel("Internet Explorer");
		System.out.println(wtr1.saveDocument());
		iexplorerViewerSetURI = wtr1.getURI();
	}

	@Override
	public void createViewers() {
		// TODO Auto-generated method stub
		
		ViewerWriter wtr1 = new ViewerWriter("iexplorer-browser-image-viewer");
		wtr1.addPartOfSetURI(iexplorerViewerSetURI);
		wtr1.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/GIF.owl#GIF");
		wtr1.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PNG.owl#PNG");
		wtr1.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/JPEG.owl#JPEG");
		wtr1.setLabel("Web Browser Image Viewer");
		wtr1.setViewerComment("Views a few standard image formats");
		wtr1.saveDocument();
		
		ViewerWriter wtr2 = new ViewerWriter("iexplorer-pdf-viewer");
		wtr2.addPartOfSetURI(iexplorerViewerSetURI);
		wtr2.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PDF.owl#PDF");
		wtr2.setLabel("Adobe Portable Document Format (PDF) Viewer");
		wtr2.setViewerComment("Renders PDF document and allows for zooming.");
		wtr2.saveDocument();
		
		ViewerWriter wtr3 = new ViewerWriter("iexplorer-plain-text-viewer");
		wtr3.addPartOfSetURI(iexplorerViewerSetURI);
		wtr3.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PLAIN.owl#PLAIN");
		wtr3.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PLAINTEXT.owl#PLAINTEXT");
		wtr3.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VNDLATEXZ.owl#VNDLATEXZ");
		wtr3.setLabel("Plain Text Viewer");
		wtr3.setViewerComment("Does nothing really, just extracts the text from the PML conclusion...");
		wtr3.saveDocument();
		
		ViewerWriter wtr4 = new ViewerWriter("iexplorer-html-viewer");
		wtr4.addPartOfSetURI(iexplorerViewerSetURI);
		wtr4.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/HTML.owl#HTML");
		wtr4.setLabel("HyperText Markup Language (HTML) Viewer");
		wtr4.setViewerComment("Renders HTML documents.");
		wtr4.saveDocument();
	}

	
	@Override
	public void createServices() {
		// TODO Auto-generated method stub
		
	}
}
