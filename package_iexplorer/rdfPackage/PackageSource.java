package package_iexplorer.rdfPackage;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageViewerSet;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.operator.Viewer;
import edu.utep.trustlab.visko.ontology.pmlp.Format;

public class PackageSource extends RDFPackage {

	private static final class Resources {
		//formats
		private static final Format pdf = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/PDF.owl#PDF");
		private static final Format png = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/PNG.owl#PNG");
		private static final Format jpg = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/JPEG.owl#JPEG");
		private static final Format gif = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/GIF.owl#GIF");
		private static final Format plain = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/PLAIN.owl#PLAIN");
		private static final Format plainText = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/PLAINTEXT.owl#PLAINTEXT");
		private static final Format html = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/HTML.owl#HTML");
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
		PackageViewerSet viewerSet = getPackageWriter().createNewViewerSet("internet-explorer");
		viewerSet.setComment("Internet Explorer Web Browser");
		viewerSet.setLabel("Internet Explorer");
		
		Viewer viewer1 = viewerSet.createNewViewer("iexplorer-browser-image-viewer");
		viewer1.setLabel("Internet Explorer Browser Image Viewer");
		viewer1.setComment("Views a few standard image formats");
		viewer1.addInputFormat(Resources.gif);
		viewer1.addInputFormat(Resources.png);
		viewer1.addInputFormat(Resources.jpg);
		
		Viewer viewer2 = viewerSet.createNewViewer("iexplorer-pdf-viewer");
		viewer2.setLabel("Adobe Portable Document Format (PDF) Viewer");
		viewer2.setComment("Renders PDF document and allows for zooming.");
		viewer2.addInputFormat(Resources.pdf);
		
		Viewer viewer3 = viewerSet.createNewViewer("iexplorer-text-viewer");
		viewer3.setLabel("Plain Text Viewer");
		viewer3.setComment("Just a plain old text viewer");
		viewer3.addInputFormat(Resources.plain);
		viewer3.addInputFormat(Resources.plainText);
		
		Viewer viewer4 = viewerSet.createNewViewer("iexplorer-html-viewer");
		viewer4.setLabel("HyperText Markup Language (HTML) Viewer");
		viewer4.setComment("Renders HTML documents.");
		viewer4.addInputFormat(Resources.html);	
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
