package package_mozilla.rdfPackage;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageViewerSet;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.operator.Viewer;
import edu.utep.trustlab.visko.ontology.pmlp.Format;

public class PackageSource extends RDFPackage {
	private static final class Resources {
		//formats
		private static final Format ps = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT");
		private static final Format pdf = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PDF.owl#PDF");
		private static final Format png = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PNG.owl#PNG");
		private static final Format jpg = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/JPEG.owl#JPEG");
		private static final Format gif = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/GIF.owl#GIF");
		private static final Format plain = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PLAIN.owl#PLAIN");
		private static final Format plainText = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PLAINTEXT.owl#PLAINTEXT");
		private static final Format latex = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VNDLATEXZ.owl#VNDLATEXZ");
		private static final Format html = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/HTML.owl#HTML");
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
		PackageViewerSet viewerSet = getPackageWriter().createNewViewerSet("mozilla-firefox");
		viewerSet.setComment("Internet Explorer Web Browser");
		viewerSet.setLabel("Internet Explorer");
		
		Viewer viewer1 = viewerSet.createNewViewer("firefox-browser-image-viewer");
		viewer1.setLabel("Mozilla Firefox Browser Image Viewer");
		viewer1.setComment("Views a few standard image formats");
		viewer1.addOperatesOnFormat(Resources.gif);
		viewer1.addOperatesOnFormat(Resources.png);
		viewer1.addOperatesOnFormat(Resources.jpg);
		
		Viewer viewer2 = viewerSet.createNewViewer("firefox-pdf-viewer");
		viewer2.setLabel("Adobe Portable Document Format (PDF) Viewer");
		viewer2.setComment("Renders PDF document and allows for zooming.");
		viewer2.addOperatesOnFormat(Resources.pdf);
		
		Viewer viewer3 = viewerSet.createNewViewer("firefox-text-viewer");
		viewer3.setLabel("Plain Text Viewer");
		viewer3.setComment("Just a plain old text viewer.");
		viewer3.addOperatesOnFormat(Resources.plain);
		viewer3.addOperatesOnFormat(Resources.plainText);
		viewer3.addOperatesOnFormat(Resources.latex);
		viewer3.addOperatesOnFormat(Resources.ps);
		
		Viewer viewer4 = viewerSet.createNewViewer("firefox-html-viewer");
		viewer4.setLabel("HyperText Markup Language (HTML) Viewer");
		viewer4.setComment("Renders HTML documents.");
		viewer4.addOperatesOnFormat(Resources.html);	
	}

	@Override
	public void populateParameterBindings() {
		// TODO Auto-generated method stub
		
	}	
}
