package package_imageMagick.rdfPackage;
import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.viskoService.Toolkit;
import edu.utep.trustlab.visko.ontology.viskoView.VisualizationAbstraction;
import edu.utep.trustlab.visko.ontology.vocabulary.ViskoV;

public class PackageSource extends RDFPackage {

	private static final class Resources {
		//formats
		private static final Format fits = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/FITS.owl#FITS");
		private static final Format png = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/PNG.owl#PNG");
		
		private static final VisualizationAbstraction spherizedImage = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_SpherizedRaster);
	}
	
	@Override
	public void populateServices() {
		String wsdlURL = getWSDLURL();
						
		String operationName = "fits2png";
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(null, operationName);
		service1.setComment("Converts Flexible Image Transport System (FITS) to Portable Network Graphic (PNG)");
		service1.setLabel("FITS to PNG");
		service1.setWSDLURL(wsdlURL);
		service1.setInputFormat(Resources.fits);
		service1.setOutputFormat(Resources.png);
		
		operationName = "spherize";
		PackageOperatorService service2 = getPackageWriter().createNewOperatorService(null, operationName);
		service2.setComment("Wraps a Portable Network Graphic (PNG) image around a spherical surface");
		service2.setLabel("spherize");
		service2.setWSDLURL(wsdlURL);
		service2.setInputFormat(Resources.png);
		service2.setOutputFormat(Resources.png);
		service2.setView(Resources.spherizedImage);
	}

	@Override
	public void populateToolkit() {
		Toolkit toolkit = getPackageWriter().createNewToolkit("image-magick");
		toolkit.setComment("ImageMagick");
		toolkit.setLabel("ImageMagick");
	}

	@Override
	public void populateViewerSets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void populateParameterBindings() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getWSDLURL() {
		return "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
	}
}
