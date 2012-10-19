package package_imageJ.rdfPackage;

import com.hp.hpl.jena.ontology.OntResource;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageInputParameterBindings;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.viskoService.Toolkit;
import edu.utep.trustlab.visko.ontology.viskoView.VisualizationAbstraction;
import edu.utep.trustlab.visko.ontology.vocabulary.ViskoV;
import edu.utep.trustlab.visko.ontology.vocabulary.supplemental.OWL;

public class PackageSource extends RDFPackage {

	private static final class Resources {
		//formats
		private static final Format png = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/PNG.owl#PNG");
		
		//views
		private static final VisualizationAbstraction surfacePlot = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_3D_SurfacePlot);
		
		//semantic types
		private static OntResource thing = OWL.getOWLThing();
	}
	
	@Override
	public void populateServices() {
		String wsdlURL = getWSDLURL();	
		
		String operationName = "surfacePlotter";
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(null, operationName);
		service1.setComment("Creates a surface plot of color values contained in an image");
		service1.setLabel("Create a surface plot of color values contained in an image");
		service1.setWSDLURL(wsdlURL);
		service1.setView(Resources.surfacePlot);
		service1.setInputFormat(Resources.png);
		service1.setOutputFormat(Resources.png);
		
	}

	@Override
	public void populateToolkit() {
		Toolkit toolkit = getPackageWriter().createNewToolkit("ImageJ");
		toolkit.setComment("ImageJ from NIH");
		toolkit.setLabel("ImageJ");
	}

	@Override
	public void populateViewerSets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void populateParameterBindings() {
		PackageInputParameterBindings bindings1 = getPackageWriter().createNewInputParameterBindings();
		bindings1.addSemanticType(Resources.thing);
		
		bindings1.addInputBinding("surfacePlotter", "plotWidth", "400");
		bindings1.addInputBinding("surfacePlotter", "polygonMultiplier", "100");
		bindings1.addInputBinding("surfacePlotter", "showWireframe", "true");
		bindings1.addInputBinding("surfacePlotter", "showGrayscale", "true");
		bindings1.addInputBinding("surfacePlotter", "showAxis", "true");
		bindings1.addInputBinding("surfacePlotter", "whiteBackground", "true");
		bindings1.addInputBinding("surfacePlotter", "blackFill", "false");
		bindings1.addInputBinding("surfacePlotter", "smooth", "true");
	}

	@Override
	public String getWSDLURL() {
		return "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
	}
}
