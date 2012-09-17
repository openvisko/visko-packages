package package_ghostscript.rdfPackage;
import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.viskoService.Toolkit;

public class PackageSource extends RDFPackage {

	private static final class Resources {
		//formats
		private static final Format ps = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/POSTSCRIPT.owl#POSTSCRIPT");
		private static final Format pdf = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/PDF.owl#PDF");
		private static final Format png = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/PNG.owl#PNG");
	}
	
	@Override
	public void populateServices() {
		String wsdlURL = getWSDLURL();	
		
		String operationName = "ps2pdf";
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(null, operationName);
		service1.setComment("Converts PostScript (PS) to Portable Document Format (PDF)");
		service1.setLabel("PS to PDF");
		service1.setWSDLURL(wsdlURL);
		service1.setInputFormat(Resources.ps);
		service1.setOutputFormat(Resources.pdf);
		
		operationName = "ps2png";
		PackageOperatorService service2 = getPackageWriter().createNewOperatorService(null, operationName);
		service2.setComment("Converts PostScript (PS) to Portable Network Graphic (PNG)");
		service2.setLabel("PS to PNG");
		service2.setWSDLURL(wsdlURL);
		service2.setInputFormat(Resources.ps);
		service2.setOutputFormat(Resources.png);
				
		operationName = "pdf2png";
		PackageOperatorService service3 = getPackageWriter().createNewOperatorService(null, operationName);
		service3.setComment("Converts Portable Document Format (PDF) to Portable Network Graphic (PNG)");
		service3.setLabel("PDF to PNG");
		service3.setWSDLURL(wsdlURL);
		service3.setInputFormat(Resources.pdf);
		service3.setOutputFormat(Resources.png);

	}

	@Override
	public void populateToolkit() {
		Toolkit toolkit = getPackageWriter().createNewToolkit("ghostscript");
		toolkit.setComment("GhostScript PostScript and PDF Tools");
		toolkit.setLabel("GhostScript (GS)");
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
