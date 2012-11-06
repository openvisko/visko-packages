package viskoPackage_example.rdf;

import com.hp.hpl.jena.ontology.OntResource;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageInputParameterBindings;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageViewerSet;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.viskoOperator.Viewer;
import edu.utep.trustlab.visko.ontology.viskoService.Toolkit;
import edu.utep.trustlab.visko.ontology.viskoView.VisualizationAbstraction;
import edu.utep.trustlab.visko.ontology.vocabulary.ViskoV;

/*
 * This class generates the VisKo RDF descriptions of the services contained in the class "service.Services" contained in this package.
 * This class assumes that you have already deployed the services and have know the URL of the WSDL associated with those service operators.
 */

public class RDFGenerator extends RDFPackage{
	
	/* You can use this inner class to define resources such as:
	 * - formats
	 * - visualization abstractions
	 * - data types
	 */
	private static final class Resources{
		//formats
		private static final Format netcdf = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/NETCDF.owl#NETCDF");
		private static final Format ps = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/POSTSCRIPT.owl#POSTSCRIPT");
		private static final Format pdf = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/PDF.owl#PDF");
		
		//views
		private static final VisualizationAbstraction contourMap2D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_ContourMap);

		//data types
		private static final OntResource griddedGravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d12");
		private static final OntResource gravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d19");;
	}
	
	@Override
	public void populateServices() {
		//if you are registering only viewers, then populating this method is optional
		
		String wsdlURL = getWSDLURL();
		
		// this code segment below wraps the service operation: exampleOperator_PureJava
		// the service it is wrapping is a "viskoO:Mapper", so we have to call the "setView" method below.
		String operationName = "exampleOperator_PureJava";
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(null, operationName);
		service1.setComment("Some code that generates a contour map");	//set a comment
		service1.setLabel(operationName);								//set a label or use the operation name as the label
		service1.setWSDLURL(wsdlURL);									//set the wsdl where this operation is described
		service1.setInputFormat(Resources.netcdf);						//set the input format
		service1.setOutputFormat(Resources.ps);							//set the output format
		service1.setView(Resources.contourMap2D);						//set the visualization this operator generates
		service1.setInputDataType(Resources.griddedGravityData);		//(optional) set the input data type encoded in the input format
		service1.setOutputDataType(null);								//(optional) set the output data type encoded in the output format

		// this code segment below wraps the service operation: exampleOperator_WrappedExecutable
		// this service is basic data transformer, so we don't have to call the "setView" method below.
		operationName = "exampleOperator_WrappedExecutable";
		PackageOperatorService service2 = getPackageWriter().createNewOperatorService(null, operationName);
		service2.setComment("Some PS to PDF transformer");				//set a comment
		service2.setLabel(operationName);								//set a label or use the operation name as the label
		service2.setWSDLURL(wsdlURL);									//set the wsdl where this operation is described
		service2.setInputFormat(Resources.ps);							//set the input format
		service2.setOutputFormat(Resources.pdf);						//set the output format
		service2.setInputDataType(null);								//(optional) set the input data type encoded in the input format
		service2.setOutputDataType(null);								//(optional) set the output data typ
	}

	@Override
	public void populateToolkit() {
		// populating this method is required
		// the toolkit name must not contain any spaces
		String toolkitName = "example-toolkit";
		Toolkit toolkit = getPackageWriter().createNewToolkit(toolkitName);
		toolkit.setLabel("Some label");
		toolkit.setComment("Some comment");
		
	}

	@Override
	public void populateViewerSets() {
		// populating this method is optional
		
		//A "ViewerSet" contains one or more "Viewer". The name of both "ViewerSet" and "Viewer" must not contain spaces.
		String viewerSetName = "example-viewer-set";
		
		PackageViewerSet viewerSet = getPackageWriter().createNewViewerSet(viewerSetName);
		viewerSet.setComment("some comment");
		viewerSet.setLabel("some label");
		
		String viewerName = "example-viewer";
		Viewer viewer1 = viewerSet.createNewViewer(viewerName);
		viewer1.setLabel("some label");
		viewer1.setComment("some comment");
		viewer1.addInputFormat(Resources.ps);					//viewers can contain more than one input format
		viewer1.addInputFormat(Resources.pdf);
		viewer1.addInputDataType(Resources.griddedGravityData);	//viewers can contain more than one input data type
		
		//like services, viewers can also create visualization abstractions
		viewer1.setVisualizationAbstraction(Resources.contourMap2D);
		
		//if your viewer is on the Web and you know its URL, you can set this property so that VisKo can call it
		//it is expected though that the viewer takes an input parameter called "url" that specifies the input data URL
		viewer1.setEndpointURL("http://iw.cs.utep.edu:8080/d3-viewers/Parameterized_Graph_OperatorPaths.html");
	}
	
	@Override
	public void populateParameterBindings() {
		// populating this method is optional
		// it sets an default setting of input parameter values to your services
		
		//this will set parameter bindings for the service "exampleOperator_PureJava" for the type "griddedGravityData"
		PackageInputParameterBindings bindings1 = getPackageWriter().createNewInputParameterBindings();
		bindings1.addSemanticType(Resources.griddedGravityData);
		String operationName = "exampleOperator_PureJava";		
		bindings1.addInputBinding(operationName, "param1", "someStringValue");
		bindings1.addInputBinding(operationName, "param2", "someStringValue");
		bindings1.addInputBinding(operationName, "param3", "someStringValue");		
		
		//this will set parameter bindings for the service "exampleOperator_WrappedExecutable" for the type "gravityData"
		PackageInputParameterBindings bindings2 = getPackageWriter().createNewInputParameterBindings();
		bindings2.addSemanticType(Resources.gravityData);
		operationName = "exampleOperator_WrappedExecutable";		
		bindings2.addInputBinding(operationName, "param1", "someStringValue");
		bindings2.addInputBinding(operationName, "param2", "someStringValue");
		bindings2.addInputBinding(operationName, "param3", "someStringValue");		
	}
	
	@Override
	public String getWSDLURL() {
		return "http://iw.cs.utep.edu:8080/toolkits/services/Services?wsdl";
	}
}
