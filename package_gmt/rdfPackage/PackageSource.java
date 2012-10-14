package package_gmt.rdfPackage;

import com.hp.hpl.jena.ontology.OntResource;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageInputParameterBindings;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.viskoService.Toolkit;
import edu.utep.trustlab.visko.ontology.viskoView.VisualizationAbstraction;
import edu.utep.trustlab.visko.ontology.vocabulary.ViskoV;

public class PackageSource extends RDFPackage {

	private static final class Resources {
		//formats
		private static final Format ps = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/POSTSCRIPT.owl#POSTSCRIPT");
		private static final Format netCDF = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/NETCDF.owl#NETCDF");
		private static final Format spaceSeparatedValues = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/SPACESEPARATEDVALUES.owl#SPACESEPARATEDVALUES");
		
		//semantic type uris
		private static final OntResource gravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d19");
		private static final OntResource griddedGravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d12");
		
		//views
		private static final VisualizationAbstraction contourMap2D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_ContourMap);
		private static final VisualizationAbstraction rasterMap2D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_RasterMap);
		private static final VisualizationAbstraction pointMap2D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_PointMap);
		
		//data types 		
		private static final OntResource fieldTrmmedGravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#FieldTrimmedGravityData");
		private static final OntResource COARDS_2D_Grid = PackageWriter.getDataType("http://gmt.soest.hawaii.edu/gmt-data.owl#2D_Grid_COARDS");
	}

	@Override
	public void populateServices() {
		String wsdlURL = getWSDLURL();
		
		String operationName = "grdcontour";
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(null, operationName);
		service1.setComment("Generates contour map from netCDF 2D gridded dataset");
		service1.setLabel("GMT grdcontour");
		service1.setWSDLURL(wsdlURL);
		service1.setInputFormat(Resources.netCDF);
		service1.setOutputFormat(Resources.ps);
		service1.setView(Resources.contourMap2D);
		service1.setInputDataType(Resources.COARDS_2D_Grid);
		// not output type...system will set to owl:Thing
		
		operationName = "surface";
		PackageOperatorService service2 = getPackageWriter().createNewOperatorService(null, operationName);
		service2.setComment("Employ tensioned splines to generate gridded data in netCDF from ascii tabular point data");
		service2.setLabel("GMT surface");
		service2.setWSDLURL(wsdlURL);
		service2.setInputFormat(Resources.spaceSeparatedValues);
		service2.setOutputFormat(Resources.netCDF);
		service2.setInputDataType(Resources.fieldTrmmedGravityData);
		service2.setOutputDataType(Resources.COARDS_2D_Grid);
		service2.setAsInterpolator();
		
		operationName = "nearneighbor";
		PackageOperatorService service3 = getPackageWriter().createNewOperatorService(null, operationName);
		service3.setComment("Employ nearest neighbor to generate gridded data in netCDF from ascii tabular point data");
		service3.setLabel("GMT nearneighbor");
		service3.setWSDLURL(wsdlURL);
		service3.setInputFormat(Resources.spaceSeparatedValues);
		service3.setOutputFormat(Resources.netCDF);
		service3.setInputDataType(Resources.fieldTrmmedGravityData);
		service3.setOutputDataType(Resources.COARDS_2D_Grid);
		service3.setAsInterpolator();
		
		operationName = "psxy";
		PackageOperatorService service4 = getPackageWriter().createNewOperatorService(null, operationName);
		service4.setComment("Generate 2D Plot of point data");
		service4.setLabel("GMT psxy");
		service4.setWSDLURL(wsdlURL);
		service4.setInputFormat(Resources.spaceSeparatedValues);
		service4.setOutputFormat(Resources.ps);
		service4.setView(Resources.pointMap2D);
		service4.setInputDataType(Resources.fieldTrmmedGravityData);
		// not output type...system will set to owl:Thing		
		
		operationName = "grdimage";
		PackageOperatorService service5 = getPackageWriter().createNewOperatorService(null, operationName);
		service5.setComment("Generate raster map of gridded data encoded in netCDF");
		service5.setLabel("GMT grdimage");
		service5.setWSDLURL(wsdlURL);
		service5.setInputFormat(Resources.netCDF);
		service5.setOutputFormat(Resources.ps);
		service5.setView(Resources.rasterMap2D);
		service5.setInputDataType(Resources.COARDS_2D_Grid);
		// not output type...system will set to owl:Thing		
	}

	@Override
	public void populateToolkit() {
		Toolkit toolkit = getPackageWriter().createNewToolkit("gmt");
		toolkit.setComment("Generic Mapping Tools");
		toolkit.setLabel("Generic Mapping Tools");
	}

	@Override
	public void populateViewerSets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void populateParameterBindings() {
		PackageInputParameterBindings bindings1 = getPackageWriter().createNewInputParameterBindings();
		PackageInputParameterBindings bindings2 = getPackageWriter().createNewInputParameterBindings();
		
		addGravityDataBindings(bindings1);
		addGriddedGravityDataBindings(bindings2);
	}
	
	private void addGravityDataBindings(PackageInputParameterBindings bindingsSet){
		String region = "-109/-107/33/34";
		
		bindingsSet.addSemanticType(Resources.gravityData);
		
		// for GMT psxy
		bindingsSet.addInputBinding("psxy", "S", "c0.04c");
		bindingsSet.addInputBinding("psxy", "R", region);
		bindingsSet.addInputBinding("psxy", "J", "x4c");
		bindingsSet.addInputBinding("psxy", "G", "blue");
		bindingsSet.addInputBinding("psxy", "B", "1");
		bindingsSet.addInputBinding("psxy", "indexOfX", "0");
		bindingsSet.addInputBinding("psxy", "indexOfY", "1");
		
		// for GMT nearneighbor
		bindingsSet.addInputBinding("nearneighbor", "I", "0.02");
		bindingsSet.addInputBinding("nearneighbor", "S", "0.2");
		bindingsSet.addInputBinding("nearneighbor", "R", region);
		
		// for GMT surface
		bindingsSet.addInputBinding("surface", "I","0.02");
		bindingsSet.addInputBinding("surface", "T","0.25");
		bindingsSet.addInputBinding("surface", "C", "0.1");
		bindingsSet.addInputBinding("surface", "R", region);

		// for GMT grdimage
		bindingsSet.addInputBinding("grdimage", "B", "1");
		bindingsSet.addInputBinding("grdimage", "J", "x4c");
		bindingsSet.addInputBinding("grdimage", "C", "hot");
		bindingsSet.addInputBinding("grdimage", "T", "-200/200/10");
		bindingsSet.addInputBinding("grdimage", "R", region);
		
		// for GMT grdcontour
		bindingsSet.addInputBinding("grdcontour", "C", "10");
		bindingsSet.addInputBinding("grdcontour", "A", "20");
		bindingsSet.addInputBinding("grdcontour", "B", "0.5");
		bindingsSet.addInputBinding("grdcontour", "S", "5");
		bindingsSet.addInputBinding("grdcontour", "J", "x4c");
		bindingsSet.addInputBinding("grdcontour", "Wc", "thinnest,black");
		bindingsSet.addInputBinding("grdcontour", "Wa", "thinnest,black");
	}

	private void addGriddedGravityDataBindings(PackageInputParameterBindings bindingsSet){
		String region = "-109/-107/33/34";

		bindingsSet.addSemanticType(Resources.griddedGravityData);

		// for GMT grdcontour
		bindingsSet.addInputBinding("grdcontour", "C", "10");
		bindingsSet.addInputBinding("grdcontour", "A", "20");
		bindingsSet.addInputBinding("grdcontour", "B", "0.5");
		bindingsSet.addInputBinding("grdcontour", "S", "5");
		bindingsSet.addInputBinding("grdcontour", "J", "x4c");
		bindingsSet.addInputBinding("grdcontour", "Wc", "thinnest,black");
		bindingsSet.addInputBinding("grdcontour", "Wa", "thinnest,black");

		// for GMT grdimage
		bindingsSet.addInputBinding("grdimage", "B", "1");
		bindingsSet.addInputBinding("grdimage", "J", "x4c");
		bindingsSet.addInputBinding("grdimage", "C", "hot");
		bindingsSet.addInputBinding("grdimage", "T", "-200/200/10");
		bindingsSet.addInputBinding("grdimage", "R", region);		
	}

	@Override
	public String getWSDLURL() {
		return "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
	}
}
