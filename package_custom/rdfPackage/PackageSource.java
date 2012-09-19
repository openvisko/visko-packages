package package_custom.rdfPackage;

import com.hp.hpl.jena.ontology.OntResource;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageInputParameterBindings;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.viskoService.Toolkit;

public class PackageSource extends RDFPackage {

	private static final class Resources {
		//formats
		private static final Format spaceSeparatedValues = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/SPACESEPARATEDVALUES.owl#SPACESEPARATEDVALUES");
		private static final Format commaSeparatedvalues = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/CSV.owl#CSV");
		static final Format littleEndianSequence = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/LITTLE-ENDIAN-SEQUENCE.owl#LITTLE-ENDIAN-SEQUENCE");

		//semantic type uris
		private static final OntResource gravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d19");
		private static final OntResource velocityDataURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d14-0");
		private static final OntResource velocityDataURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d2");
		private static final OntResource velocityDataURI_3 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d2-1");
		
		private static final OntResource griddedTimeURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d4-0");
		private static final OntResource griddedTimeURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d4");		
		
		private static final OntResource dusumDataURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d8-0");
		private static final OntResource dusumDataURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d8");

		
		//data types 		
		private static final OntResource xyzData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d18");		
		private static final OntResource fieldTrmmedGravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#FieldTrimmedGravityData");
		
		static final OntResource array1DFloat = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DFloat");
		static final OntResource array1DInteger = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DInteger");
		static final OntResource array1DUnsignedShortInteger = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DUnsignedShortInteger");

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
		service2.setInputDataType(Resources.xyzData);
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
	}

	@Override
	public void populateToolkit() {
		Toolkit toolkit = getPackageWriter().createNewToolkit("nick-delrio-data-readers");
		toolkit.setComment("Custom data readers by Nicholas Del Rio");
		toolkit.setLabel("Custom data readers by Nicholas Del Rio");
	}

	@Override
	public void populateViewerSets() {
		// TODO Auto-generated method stub
		
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
