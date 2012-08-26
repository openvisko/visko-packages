package package_probeit.rdfPackage;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageViewerSet;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.operator.Viewer;
import edu.utep.trustlab.visko.ontology.pmlp.Format;

public class PackageSource extends RDFPackage {

	private static final class Resources{
		//formats 
		private static final Format gif = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/GIF.owl#GIF");
		private static final Format png = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PNG.owl#PNG");
		private static final Format jpeg = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/JPEG.owl#JPEG");
		private static final Format dicom = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/DICOM.owl#DICOM");
		private static final Format tiff = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/TIFF.owl#TIFF");
		private static final Format fits = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/FITS.owl#FITS");
		private static final Format raw = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/RAW.owl#RAW");
		private static final Format stf = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VNDWTSTF.owl#VNDWTSTF");
		private static final Format pdf = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PDF.owl#PDF");
		private static final Format plain = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PLAIN.owl#PLAIN");
		private static final Format plainText = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PLAINTEXT.owl#PLAINTEXT");
		private static final Format latex = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VNDLATEXZ.owl#VNDLATEXZ");
		private static final Format html = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/HTML.owl#HTML");
		private static final Format ps = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT");
		
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
		
		PackageViewerSet viewerSet = getPackageWriter().createNewViewerSet("probeit");
		viewerSet.setComment("Probe-It! Provenance Browser");
		viewerSet.setLabel("Probe-It!");
		
		Viewer viewer1 = viewerSet.createNewViewer("probeit-imagej-viewer");
		viewer1.setLabel("ImageJ Viewer");
		viewer1.setComment("ImageJ is a public domain Java image processing program inspired by NIH Image");
		viewer1.addOperatesOnFormat(Resources.gif);
		viewer1.addOperatesOnFormat(Resources.pdf);
		viewer1.addOperatesOnFormat(Resources.jpeg);
		viewer1.addOperatesOnFormat(Resources.dicom);
		viewer1.addOperatesOnFormat(Resources.tiff);
		viewer1.addOperatesOnFormat(Resources.fits);
		viewer1.addOperatesOnFormat(Resources.raw);
		viewer1.addOperatesOnFormat(Resources.png);
			
		Viewer viewer2 = viewerSet.createNewViewer("parvis-viewer");
		viewer2.setLabel("Parvis Parallel Coordinates Viewer");
		viewer2.setComment("Parvis is a tool for parallel coordinates (PC) visualisation of multidimensional data sets, as first described in [Inselberg 1981].");
		viewer2.addOperatesOnFormat(Resources.stf);
		
		Viewer viewer3 = viewerSet.createNewViewer("probeit-pdf-viewer");
		viewer3.setLabel("Adobe Portable Document Format (PDF) Viewer");
		viewer3.setComment("Renders PDF document and allows for zooming.");
		viewer3.addOperatesOnFormat(Resources.pdf);
		
		Viewer viewer4 = viewerSet.createNewViewer("probeit-text-viewer");
		viewer4.setLabel("Plain Text Viewer");
		viewer4.setComment("Just a plain old text viewer");
		viewer4.addOperatesOnFormat(Resources.plain);
		viewer4.addOperatesOnFormat(Resources.plainText);
		viewer4.addOperatesOnFormat(Resources.latex);
		viewer4.addOperatesOnFormat(Resources.ps);
		
		Viewer viewer5 = viewerSet.createNewViewer("probeit-html-viewer");
		viewer5.setLabel("HyperText Markup Language (HTML) Viewer");
		viewer5.setComment("Renders HTML documents.");
		viewer5.addOperatesOnFormat(Resources.html);	
	}

	@Override
	public void populateParameterBindings() {
		// TODO Auto-generated method stub
		
	}
}
