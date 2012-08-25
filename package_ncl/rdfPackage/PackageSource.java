package package_ncl.rdfPackage;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
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
}
