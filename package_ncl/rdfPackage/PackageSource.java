package package_ncl.rdfPackage;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageInputParameterBindings;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.service.Toolkit;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.view.View;

public class PackageSource extends RDFPackage {

	private static final class Resources{
		//formats
		private static final Format netcdf = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/NETCDF.owl#NETCDF");
		private static final Format ps = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT");
		
		//views
		private static final View xyPlot = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/XYPlot.owl#XYPlot");
		private static final View contour = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/contour-lines.owl#contour-lines");
		private static final View raster = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/raster.owl#raster");
		
		private static final String brightnessTemperatureURI = "http://giovanni.gsfc.nasa.gov/data/brightness.owl#brightness";
		private static final String griddedGravityDataURI = "http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d12";
		private static final String gravityDataURI = "http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d19";
	}
	
	@Override
	public void populateServices() {
		// TODO Auto-generated method stub
		String wsdlURL = "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";

		String operationName = "gsn_csm_contour_map";
		
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(operationName);
		service1.setComment("Generate contour map from 2D gridded netCDF");
		service1.setLabel(operationName);
		service1.setWSDLURL(wsdlURL);
		service1.setInputFormat(Resources.netcdf);
		service1.setOutputFormat(Resources.ps);
		service1.setView(Resources.contour);

		operationName = "gsn_csm_contour_map_raster";
		PackageOperatorService service2 = getPackageWriter().createNewOperatorService(operationName);
		service2.setComment("Generate raster map from 2D gridded netCDF");
		service2.setLabel(operationName);
		service2.setWSDLURL(wsdlURL);
		service2.setInputFormat(Resources.netcdf);
		service2.setOutputFormat(Resources.ps);
		service2.setView(Resources.raster);

	
		operationName = "gsn_csm_xy2_time_series";
		PackageOperatorService service3 = getPackageWriter().createNewOperatorService(operationName);
		service3.setComment("Generate time series plot from set of 1D arrays");
		service3.setLabel(operationName);
		service3.setWSDLURL(wsdlURL);
		service3.setInputFormat(Resources.netcdf);
		service3.setOutputFormat(Resources.ps);
		service3.setView(Resources.xyPlot);
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

		String operationName = "gsn_csm_contour_map";
		PackageOperatorService service1 = getPackageWriter().getOperatorService(operationName);
		
		PackageInputParameterBindings bindings1 = service1.createNewInputParameterBindings();
		bindings1.addDataType(Resources.gravityDataURI);
		bindings1.addDataType(Resources.griddedGravityDataURI);
		bindings1.addInputBinding("lbOrientation", "vertical");
		bindings1.addInputBinding("cnLevelSpacingF", "10");
		bindings1.addInputBinding("colorTable", "WhiteBlueGreenYellowRed");
		bindings1.addInputBinding("font", "helvetica");
		bindings1.addInputBinding("cnFillOn", "True");
		bindings1.addInputBinding("cnLinesOn", "False");
		bindings1.addInputBinding("latVariable", "y");
		bindings1.addInputBinding("lonVariable", "x");
		bindings1.addInputBinding("plotVariable", "z");
		bindings1.addInputBinding("indexOfX", "1");
		bindings1.addInputBinding("indexOfY", "0");
		bindings1.addInputBinding("indexOfZ", "-1");
		
		PackageInputParameterBindings bindings2 = service1.createNewInputParameterBindings();
		bindings2.addDataType(Resources.brightnessTemperatureURI);
		bindings2.addInputBinding("plotVariable", "ch4");
		bindings2.addInputBinding("lbOrientation", "vertical");
		bindings2.addInputBinding("cnLevelSpacingF", "10");
		bindings2.addInputBinding("colorTable", "WhiteBlueGreenYellowRed");
		bindings2.addInputBinding("font", "helvetica");
		bindings2.addInputBinding("cnFillOn", "True");
		bindings2.addInputBinding("cnLinesOn", "False");
		bindings2.addInputBinding("latVariable", "latitude");
		bindings2.addInputBinding("lonVariable", "longitude");
		bindings2.addInputBinding("indexOfX", "2");
		bindings2.addInputBinding("indexOfY", "1");
		bindings2.addInputBinding("indexOfZ", "0");
		
		operationName = "gsn_csm_contour_map_raster";
		PackageOperatorService service2 = getPackageWriter().getOperatorService(operationName);
		PackageInputParameterBindings bindings3 = service2.createNewInputParameterBindings();
		bindings3.addDataType(Resources.gravityDataURI);
		bindings3.addDataType(Resources.griddedGravityDataURI);
		bindings3.addInputBinding("lbOrientation", "vertical");
		bindings3.addInputBinding("colorTable", "WhiteBlueGreenYellowRed");
		bindings3.addInputBinding("font", "helvetica");
		bindings3.addInputBinding("latVariable", "y");
		bindings3.addInputBinding("lonVariable", "x");
		bindings3.addInputBinding("plotVariable", "z");
		bindings3.addInputBinding("indexOfX", "1");
		bindings3.addInputBinding("indexOfY", "0");
		bindings3.addInputBinding("indexOfZ", "-1");
		
		PackageInputParameterBindings bindings4 = service2.createNewInputParameterBindings();
		bindings4.addDataType(Resources.brightnessTemperatureURI);
		bindings4.addInputBinding("plotVariable", "ch4");
		bindings4.addInputBinding("lbOrientation", "vertical");
		bindings4.addInputBinding("colorTable", "WhiteBlueGreenYellowRed");
		bindings4.addInputBinding("font", "helvetica");
		bindings4.addInputBinding("latVariable", "latitude");
		bindings4.addInputBinding("lonVariable", "longitude");
		bindings4.addInputBinding("indexOfX", "2");
		bindings4.addInputBinding("indexOfY", "1");
		bindings4.addInputBinding("indexOfZ", "0");
	}
}
