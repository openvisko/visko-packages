package package_ncl.rdfPackage;

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

	private static final class Resources{
		//formats
		private static final Format netcdf = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/NETCDF.owl#NETCDF");
		private static final Format ps = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/POSTSCRIPT.owl#POSTSCRIPT");
		
		//views
		private static final VisualizationAbstraction timeSeriesPlot2D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_TimeSeriesPlot);
		private static final VisualizationAbstraction contourMap2D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_ContourMap);
		private static final VisualizationAbstraction rasterMap2D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_RasterMap);

		//data types
		private static final OntResource variableWithLatLon = PackageWriter.getDataType("http://iridl.ldeo.columbia.edu/ontologies/cf-obj.owl#Variable_with_LatLon");
		private static final OntResource variableWithTime = PackageWriter.getDataType("http://iridl.ldeo.columbia.edu/ontologies/cf-obj.owl#Variable_with_Time");
		
		//semantic types
		private static final OntResource brightnessTemperature = PackageWriter.getDataType("http://giovanni.gsfc.nasa.gov/giovanni-data.owl#BrightnessTemperature");
		private static final OntResource giovanniTimeSeries = PackageWriter.getDataType("http://giovanni.gsfc.nasa.gov/giovanni-data.owl#Giovanni_Time_Series_Data");
		private static final OntResource griddedGravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d12");
		private static final OntResource gravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d19");
	}
	
	@Override
	public void populateServices() {
		String wsdlURL = getWSDLURL();
		
		String operationName = "gsn_csm_contour_map";
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(null, operationName);
		service1.setComment("Generate contour map from 2D gridded netCDF");
		service1.setLabel(operationName);
		service1.setWSDLURL(wsdlURL);
		service1.setInputFormat(Resources.netcdf);
		service1.setOutputFormat(Resources.ps);
		service1.setView(Resources.contourMap2D);
		service1.setInputDataType(Resources.variableWithLatLon);		
		
		operationName = "gsn_csm_contour_map_raster";
		PackageOperatorService service2 = getPackageWriter().createNewOperatorService(null, operationName);
		service2.setComment("Generate raster map from 2D gridded netCDF");
		service2.setLabel(operationName);
		service2.setWSDLURL(wsdlURL);
		service2.setInputFormat(Resources.netcdf);
		service2.setOutputFormat(Resources.ps);
		service2.setView(Resources.rasterMap2D);
		service2.setInputDataType(Resources.variableWithLatLon);
	
		operationName = "gsn_csm_xy2_time_series";
		PackageOperatorService service3 = getPackageWriter().createNewOperatorService(null, operationName);
		service3.setComment("Generate time series plot from set of 1D arrays");
		service3.setLabel(operationName);
		service3.setWSDLURL(wsdlURL);
		service3.setInputFormat(Resources.netcdf);
		service3.setOutputFormat(Resources.ps);
		service3.setView(Resources.timeSeriesPlot2D);
		service3.setInputDataType(Resources.variableWithTime);
	}

	@Override
	public void populateToolkit() {
		
		Toolkit toolkit = getPackageWriter().createNewToolkit("ncl");
		toolkit.setLabel("NCAR Command Language");
		toolkit.setComment("NCAR Command Language");
		
	}

	@Override
	public void populateViewerSets() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void populateParameterBindings() {
		PackageInputParameterBindings bindings1 = getPackageWriter().createNewInputParameterBindings();
		PackageInputParameterBindings bindings2 = getPackageWriter().createNewInputParameterBindings();
		
		addBrightnessTemperatureBindings(bindings1);
		addGravityDataBindings(bindings2);
	}
	
	public void addGravityDataBindings(PackageInputParameterBindings bindingsSet){
		bindingsSet.addSemanticType(Resources.gravityData);
		bindingsSet.addSemanticType(Resources.griddedGravityData);
		
		String operationName = "gsn_csm_contour_map";		
		bindingsSet.addInputBinding(operationName, "lbOrientation", "vertical");
		bindingsSet.addInputBinding(operationName, "cnLevelSpacingF", "10");
		bindingsSet.addInputBinding(operationName, "colorTable", "WhiteBlueGreenYellowRed");
		bindingsSet.addInputBinding(operationName, "font", "helvetica");
		bindingsSet.addInputBinding(operationName, "cnFillOn", "True");
		bindingsSet.addInputBinding(operationName, "cnLinesOn", "False");
		bindingsSet.addInputBinding(operationName, "latVariable", "y");
		bindingsSet.addInputBinding(operationName, "lonVariable", "x");
		bindingsSet.addInputBinding(operationName, "plotVariable", "z");
		bindingsSet.addInputBinding(operationName, "indexOfX", "1");
		bindingsSet.addInputBinding(operationName, "indexOfY", "0");
		bindingsSet.addInputBinding(operationName, "indexOfZ", "-1");

		operationName = "gsn_csm_contour_map_raster";		
		bindingsSet.addInputBinding(operationName, "lbOrientation", "vertical");
		bindingsSet.addInputBinding(operationName, "colorTable", "WhiteBlueGreenYellowRed");
		bindingsSet.addInputBinding(operationName, "font", "helvetica");
		bindingsSet.addInputBinding(operationName, "latVariable", "y");
		bindingsSet.addInputBinding(operationName, "lonVariable", "x");
		bindingsSet.addInputBinding(operationName, "plotVariable", "z");
		bindingsSet.addInputBinding(operationName, "indexOfX", "1");
		bindingsSet.addInputBinding(operationName, "indexOfY", "0");
		bindingsSet.addInputBinding(operationName, "indexOfZ", "-1");		
	}

	public void addBrightnessTemperatureBindings(PackageInputParameterBindings bindingsSet) {
		
		bindingsSet.addSemanticType(Resources.brightnessTemperature);
		
		String operationName = "gsn_csm_contour_map";
		bindingsSet.addInputBinding(operationName, "plotVariable", "ch4");
		bindingsSet.addInputBinding(operationName, "lbOrientation", "vertical");
		bindingsSet.addInputBinding(operationName, "cnLevelSpacingF", "10");
		bindingsSet.addInputBinding(operationName, "colorTable", "WhiteBlueGreenYellowRed");
		bindingsSet.addInputBinding(operationName, "font", "helvetica");
		bindingsSet.addInputBinding(operationName, "cnFillOn", "True");
		bindingsSet.addInputBinding(operationName, "cnLinesOn", "False");
		bindingsSet.addInputBinding(operationName, "latVariable", "latitude");
		bindingsSet.addInputBinding(operationName, "lonVariable", "longitude");
		bindingsSet.addInputBinding(operationName, "indexOfX", "2");
		bindingsSet.addInputBinding(operationName, "indexOfY", "1");
		bindingsSet.addInputBinding(operationName, "indexOfZ", "0");
		
		operationName = "gsn_csm_contour_map_raster";
		bindingsSet.addInputBinding(operationName, "plotVariable", "ch4");
		bindingsSet.addInputBinding(operationName, "lbOrientation", "vertical");
		bindingsSet.addInputBinding(operationName, "colorTable", "WhiteBlueGreenYellowRed");
		bindingsSet.addInputBinding(operationName, "font", "helvetica");
		bindingsSet.addInputBinding(operationName, "latVariable", "latitude");
		bindingsSet.addInputBinding(operationName, "lonVariable", "longitude");
		bindingsSet.addInputBinding(operationName, "indexOfX", "2");
		bindingsSet.addInputBinding(operationName, "indexOfY", "1");
		bindingsSet.addInputBinding(operationName, "indexOfZ", "0");
	}

	@Override
	public String getWSDLURL() {
		return "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
	}
}
