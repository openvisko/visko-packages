package package_custom.rdfPackage;

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

public class PackageSource extends RDFPackage {

	private static final class Resources {
		//formats
		private static final Format spaceSeparatedValues = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/SPACESEPARATEDVALUES.owl#SPACESEPARATEDVALUES");
		private static final Format commaSeparatedvalues = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/CSV.owl#CSV");
		private static final Format littleEndianSequence = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/LITTLE-ENDIAN-SEQUENCE.owl#LITTLE-ENDIAN-SEQUENCE");

		private static final Format rdfxml = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/RDFXML.owl#RDFXML");
		private static final Format json = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/JSON.owl#JSON");
		
		//semantic type uris
		private static final OntResource gravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d19");
		private static final OntResource fieldTrmmedGravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#FieldTrimmedGravityData");

		private static final OntResource velocityDataURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d14-0");
		private static final OntResource velocityDataURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d2");
		private static final OntResource velocityDataURI_3 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d2-1");
		
		private static final OntResource griddedTimeURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d4-0");
		private static final OntResource griddedTimeURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d4");		
		
		private static final OntResource dusumDataURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d8-0");
		private static final OntResource dusumDataURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d8");

		
		//data types 				
		private static final OntResource array1DFloat = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DFloat");
		private static final OntResource array1DInteger = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DInteger");
		private static final OntResource array1DUnsignedShortInteger = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DUnsignedShortInteger");
		
		private static final OntResource dataTransformationPaths = PackageWriter.getDataType("https://raw.github.com/nicholasdelrio/visko/master/resources/ontology/visko.owl#DataTransformationPaths");
		private static final OntResource operatorPaths = PackageWriter.getDataType("https://raw.github.com/nicholasdelrio/visko/master/resources/ontology/visko.owl#OperatorPaths");
		private static final OntResource instanceSummary = PackageWriter.getDataType("https://raw.github.com/nicholasdelrio/visko/master/resources/ontology/visko.owl#InstanceSummary");
		private static final OntResource knoweldgeBase = PackageWriter.getDataType("https://raw.github.com/nicholasdelrio/visko/master/resources/ontology/visko.owl#KnowledgeBase");
		
		//views
		private static final VisualizationAbstraction barChart = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_BarChart);
		private static final VisualizationAbstraction forceGraph = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_ForceGraph);
	}

	@Override
	public void populateServices() {
		String wsdlURL = getWSDLURL();		
		
		String operationName = "csv2tabular";
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(null, operationName);
		service1.setComment("Convert comma separated values into ASCII tabular data");
		service1.setLabel(operationName);
		service1.setWSDLURL(wsdlURL);
		service1.setInputFormat(Resources.commaSeparatedvalues);
		service1.setOutputFormat(Resources.spaceSeparatedValues);
		
		operationName = "GravityDataFieldFilter";
		PackageOperatorService service2 = getPackageWriter().createNewOperatorService(null, operationName);
		service2.setComment("Filter out field (i.e., columns) from gravity datasets");
		service2.setLabel(operationName);
		service2.setWSDLURL(wsdlURL);
		service2.setInputFormat(Resources.spaceSeparatedValues);
		service2.setOutputFormat(Resources.spaceSeparatedValues);
		service2.setInputDataType(Resources.gravityData);
		service2.setOutputDataType(Resources.fieldTrmmedGravityData);

		operationName = "int2Short";
		PackageOperatorService service3 = getPackageWriter().createNewOperatorService(null, operationName);
		service3.setInputFormat(Resources.littleEndianSequence);
		service3.setOutputFormat(Resources.littleEndianSequence);
		service3.setLabel(operationName);
		service3.setComment("Converts integer arrays to unsigned short integers");
		service3.setWSDLURL(wsdlURL);
		service3.setInputDataType(Resources.array1DInteger);
		service3.setOutputDataType(Resources.array1DUnsignedShortInteger);
		
		operationName = "float2ShortThr";
		PackageOperatorService service4 = getPackageWriter().createNewOperatorService(null, operationName);
		service4.setInputFormat(Resources.littleEndianSequence);
		service4.setOutputFormat(Resources.littleEndianSequence);
		service4.setLabel(operationName);
		service4.setComment("Converts float arrays to short ints");
		service4.setWSDLURL(wsdlURL);
		service4.setInputDataType(Resources.array1DFloat);
		service4.setOutputDataType(Resources.array1DUnsignedShortInteger);
		
		operationName = "jsonGraph_OperatorPaths";
		PackageOperatorService service5 = getPackageWriter().createNewOperatorService(null, operationName);
		service5.setInputFormat(Resources.rdfxml);
		service5.setOutputFormat(Resources.json);
		service5.setLabel(operationName);
		service5.setComment("Converts a Visko KB to Operator Paths encoded in JSON");
		service5.setWSDLURL(wsdlURL);
		service5.setInputDataType(Resources.knoweldgeBase);
		service5.setOutputDataType(Resources.operatorPaths);
		
		operationName = "jsonGraph_DataTransformations";
		PackageOperatorService service6 = getPackageWriter().createNewOperatorService(null, operationName);
		service6.setInputFormat(Resources.rdfxml);
		service6.setOutputFormat(Resources.json);
		service6.setLabel(operationName);
		service6.setComment("Converts a Visko KB to Data Transformation Paths encoded in JSON");
		service6.setWSDLURL(wsdlURL);
		service6.setInputDataType(Resources.knoweldgeBase);
		service6.setOutputDataType(Resources.dataTransformationPaths);

		operationName = "jsonBars_Instances";
		PackageOperatorService service7 = getPackageWriter().createNewOperatorService(null, operationName);
		service7.setInputFormat(Resources.rdfxml);
		service7.setOutputFormat(Resources.json);
		service7.setLabel(operationName);
		service7.setComment("Converts a Visko KB to instance summary encoded in JSON");
		service7.setWSDLURL(wsdlURL);
		service7.setInputDataType(Resources.knoweldgeBase);
		service7.setOutputDataType(Resources.instanceSummary);
	}

	@Override
	public void populateToolkit() {
		Toolkit toolkit = getPackageWriter().createNewToolkit("nick-delrio-data-readers");
		toolkit.setComment("Custom data readers by Nicholas Del Rio");
		toolkit.setLabel("Custom data readers by Nicholas Del Rio");
	}

	@Override
	public void populateViewerSets() {		
		PackageViewerSet viewerSet = getPackageWriter().createNewViewerSet("data-driven-documents");
		viewerSet.setComment("Data Driven Documents Viewer Set");
		viewerSet.setLabel("D3 Viewer Set");
		
		Viewer viewer1 = viewerSet.createNewViewer("operator-paths-force-graph-viewer");
		viewer1.setLabel("Force Graph Viewer for Visko Operator Paths");
		viewer1.setComment("Force Graph Viewer for Visko Operator Paths");
		viewer1.addInputFormat(Resources.json);
		viewer1.addInputDataType(Resources.operatorPaths);
		viewer1.setVisualizationAbstraction(Resources.forceGraph);
		
		Viewer viewer2 = viewerSet.createNewViewer("visko-kb-bar-chart-viewer");
		viewer2.setLabel("Bar Chart Viewer for Visko KB");
		viewer2.setComment("Bar Chart Viewer for Visko KB");
		viewer2.addInputFormat(Resources.json);
		viewer2.addInputDataType(Resources.instanceSummary);
		viewer2.setVisualizationAbstraction(Resources.barChart);
		
		Viewer viewer3 = viewerSet.createNewViewer("data-transformations-paths-force-graph-viewer");
		viewer3.setLabel("Force Graph Viewer for Visko Data Transformation Paths");
		viewer3.setComment("Force Graph Viewer for Visko Data Transformation Paths");
		viewer3.addInputFormat(Resources.json);
		viewer3.addInputDataType(Resources.dataTransformationPaths);
		viewer3.setVisualizationAbstraction(Resources.forceGraph);
	}

	@Override
	public void populateParameterBindings() {
		PackageInputParameterBindings bindings1 = getPackageWriter().createNewInputParameterBindings();
		PackageInputParameterBindings bindings2 = getPackageWriter().createNewInputParameterBindings();
		PackageInputParameterBindings bindings3 = getPackageWriter().createNewInputParameterBindings();
		
		addGravityDataBindings(bindings1);
		
		addDuSumParameterBindings(bindings2);
		addGriddedTimeParameterBindings(bindings3);
	}
	
	private void addGravityDataBindings(PackageInputParameterBindings bindingsSet){		
		bindingsSet.addSemanticType(Resources.gravityData);
				
		// for GMT surface
		bindingsSet.addInputBinding("GravityDataFieldFilter", "indexOfX", "0");
		bindingsSet.addInputBinding("GravityDataFieldFilter", "indexOfY", "1");
		bindingsSet.addInputBinding("GravityDataFieldFilter", "indexOfZ", "2");
	}

	public void addGriddedTimeParameterBindings(PackageInputParameterBindings bindingsSet){
		bindingsSet.addSemanticType(Resources.griddedTimeURI_1);
		bindingsSet.addSemanticType(Resources.griddedTimeURI_2);

		bindingsSet.addSemanticType(Resources.velocityDataURI_1);
		bindingsSet.addSemanticType(Resources.velocityDataURI_2);
		bindingsSet.addSemanticType(Resources.velocityDataURI_3);

		// for float2shortThr
		bindingsSet.addInputBinding("float2ShortThr", "scalingFactor", "1000");
		bindingsSet.addInputBinding("float2ShortThr", "offset", "0");		
	}
	
	public void addDuSumParameterBindings(PackageInputParameterBindings bindingsSet){
		bindingsSet.addSemanticType(Resources.dusumDataURI_1);
		bindingsSet.addSemanticType(Resources.dusumDataURI_2);
		
		// for float2shortThr
		bindingsSet.addInputBinding("float2ShortThr", "scalingFactor", "1");
		bindingsSet.addInputBinding("float2ShortThr", "offset", "10000");
	}
		
	@Override
	public String getWSDLURL() {
		return "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
	}
}
