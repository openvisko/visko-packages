package package_mozilla.rdfWriter;

import edu.utep.trustlab.visko.ontology.operator.writer.ViewerSetWriter;
import edu.utep.trustlab.visko.ontology.operator.writer.ViewerWriter;
import edu.utep.trustlab.visko.packages.rdf.PackageRDFWriter;

public class RDFWriter implements PackageRDFWriter {

	private String firefoxViewerSetURI;

	@Override
	public void createToolkit() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void createViewerSets() {
		// TODO Auto-generated method stub
		
		ViewerSetWriter wtr1 = new ViewerSetWriter("mozilla-firefox");
		wtr1.setLabel("Mozilla Firefox");
		System.out.println(wtr1.saveDocument());
		firefoxViewerSetURI = wtr1.getURI();
	}

	@Override
	public void createViewers() {
		// TODO Auto-generated method stub
		
		ViewerWriter wtr1 = new ViewerWriter("mozilla-browser-image-viewer");
		wtr1.addPartOfSetURI(firefoxViewerSetURI);
		wtr1.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/GIF.owl#GIF");
		wtr1.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PNG.owl#PNG");
		wtr1.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/JPEG.owl#JPEG");
		wtr1.setLabel("Web Browser Image Viewer");
		wtr1.setViewerComment("Views a few standard image formats");
		wtr1.saveDocument();
		
		ViewerWriter wtr2 = new ViewerWriter("mozilla-pdf-viewer");
		wtr2.addPartOfSetURI(firefoxViewerSetURI);
		wtr2.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PDF.owl#PDF");
		wtr2.setLabel("Adobe Portable Document Format (PDF) Viewer");
		wtr2.setViewerComment("Renders PDF document and allows for zooming.");
		wtr2.saveDocument();
		
		ViewerWriter wtr3 = new ViewerWriter("mozilla-plain-text-viewer");
		wtr3.addPartOfSetURI(firefoxViewerSetURI);
		wtr3.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PLAIN.owl#PLAIN");
		wtr3.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PLAINTEXT.owl#PLAINTEXT");
		wtr3.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VNDLATEXZ.owl#VNDLATEXZ");
		wtr3.setLabel("Plain Text Viewer");
		wtr3.setViewerComment("Does nothing really, just extracts the text from the PML conclusion...");
		wtr3.saveDocument();
		
		ViewerWriter wtr4 = new ViewerWriter("mozilla-html-viewer");
		wtr4.addPartOfSetURI(firefoxViewerSetURI);
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
