package package_probeit.rdfWriter;

import edu.utep.trustlab.visko.ontology.operator.writer.ViewerSetWriter;
import edu.utep.trustlab.visko.ontology.operator.writer.ViewerWriter;
import edu.utep.trustlab.visko.packages.rdf.PackageRDFWriter;

public class RDFWriter implements PackageRDFWriter {

	private String probeitViewerSetURI;
	
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
		
		ViewerSetWriter wtr = new ViewerSetWriter("mozilla-firefox");
		wtr.setLabel("Mozilla Firefox");
		wtr.saveDocument();
		probeitViewerSetURI = wtr.getURI();
	}

	@Override
	public void createViewers() {
		// TODO Auto-generated method stub
		
		ViewerWriter wtr = new ViewerWriter("probeit-imageJ-viewer");
		wtr.setLabel("ImageJ Viewer");
		wtr.addPartOfSetURI(probeitViewerSetURI);
		wtr.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/GIF.owl#GIF");
		wtr.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PNG.owl#PNG");
		wtr.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/JPEG.owl#JPEG");
		wtr.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/DICOM.owl#DICOM");
		wtr.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/TIFF.owl#TIFF");
		wtr.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/FITS.owl#FITS");
		wtr.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/RAW.owl#RAW");
		wtr.setViewerComment("ImageJ is a public domain Java image processing program inspired by NIH Image.");
		wtr.saveDocument();
	
		ViewerWriter wtr1 = new ViewerWriter("probeit-parvis-viewer");
		wtr1.addPartOfSetURI(probeitViewerSetURI);
		wtr1.setLabel("Parvis Parallel Coordinates Viewer");
		wtr1.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VNDWTSTF.owl#VNDWTSTF");
		wtr1.setViewerComment("Parvis is a tool for parallel coordinates (PC) visualisation of multidimensional data sets, as first described in [Inselberg 1981].");
		wtr1.saveDocument();
		
		ViewerWriter wtr2 = new ViewerWriter("probeit-pdf-viewer");
		wtr2.addPartOfSetURI(probeitViewerSetURI);
		wtr2.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PDF.owl#PDF");
		wtr2.setLabel("Adobe Portable Document Format (PDF) Viewer");
		wtr2.setViewerComment("Renders PDF document and allows for zooming.");
		wtr2.saveDocument();
		
		ViewerWriter wtr3 = new ViewerWriter("plain-text-viewer");
		wtr3.addPartOfSetURI(probeitViewerSetURI);
		wtr3.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PLAIN.owl#PLAIN");
		wtr3.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PLAINTEXT.owl#PLAINTEXT");
		wtr3.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VNDLATEXZ.owl#VNDLATEXZ");
		wtr3.setLabel("Plain Text Viewer");
		wtr3.setViewerComment("Does nothing really, just extracts the text from the PML conclusion...");
		wtr3.saveDocument();
		
		ViewerWriter wtr4 = new ViewerWriter("probeit-html-viewer");
		wtr4.addPartOfSetURI(probeitViewerSetURI);
		wtr4.addFormatURI("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/HTML.owl#HTML");
		wtr4.setLabel("HyperText Markup Language (HTML) Viewer");
		wtr4.setViewerComment("Renders HTML documents.");
		wtr4.saveDocument();
	}
}
