package package_gmt.rdfPackage;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.service.Toolkit;
import edu.utep.trustlab.visko.ontology.view.View;

public class PackageSource extends RDFPackage {

	private static final class Resources {
		//formats
		private static final Format ps = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT");
		private static final Format netCDFGMT = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/NETCDFGMT.owl#NETCDFGMT");
		private static final Format spaceDelimTabularASCII = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/SPACEDELIMITEDTABULARASCII.owl#SPACEDELIMITEDTABULARASCII");
		private static final Format csv = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/CSV.owl#CSV");

		//views
		private static final View raster = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/contour-lines.owl#contour-lines");
		private static final View contour = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/raster.owl#raster");
		private static final View plot = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/plot-2D.owl#plot-2D");
	}

	@Override
	public void populateServices() {
		String wsdlURL = "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
		
		String operationName = "grdcontour";
		
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(operationName);
		service1.setComment("Generates contour map from netCDF 2D gridded dataset");
		service1.setLabel("GMT grdcontour");
		service1.setWSDLURL(wsdlURL);
		service1.setInputFormat(Resources.netCDFGMT);
		service1.setOutputFormat(Resources.ps);
		service1.setView(Resources.contour);
				
		operationName = "surface";
		PackageOperatorService service2 = getPackageWriter().createNewOperatorService(operationName);
		service2.setComment("Employ tensioned splines to generate gridded data in netCDF from ascii tabular point data");
		service2.setLabel("GMT surface");
		service2.setWSDLURL(wsdlURL);
		service2.setInputFormat(Resources.spaceDelimTabularASCII);
		service2.setOutputFormat(Resources.netCDFGMT);
		
		operationName = "nearneighbor";
		PackageOperatorService service3 = getPackageWriter().createNewOperatorService(operationName);
		service3.setComment("Employ nearest neighbor to generate gridded data in netCDF from ascii tabular point data");
		service3.setLabel("GMT nearneighbor");
		service3.setWSDLURL(wsdlURL);
		service3.setInputFormat(Resources.spaceDelimTabularASCII);
		service3.setOutputFormat(Resources.netCDFGMT);
			
		operationName = "psxy";
		PackageOperatorService service4 = getPackageWriter().createNewOperatorService(operationName);
		service4.setComment("Generate 2D Plot of point data");
		service4.setLabel("GMT psxy");
		service4.setWSDLURL(wsdlURL);
		service4.setInputFormat(Resources.spaceDelimTabularASCII);
		service4.setOutputFormat(Resources.ps);
		service4.setView(Resources.plot);
		
		operationName = "grdimage";
		PackageOperatorService service5 = getPackageWriter().createNewOperatorService(operationName);
		service5.setComment("Generate raster map of gridded data encoded in netCDF");
		service5.setLabel("GMT grdimage");
		service5.setWSDLURL(wsdlURL);
		service5.setInputFormat(Resources.netCDFGMT);
		service5.setOutputFormat(Resources.ps);
		service5.setView(Resources.raster);

		operationName = "csv2tabular";
		PackageOperatorService service6 = getPackageWriter().createNewOperatorService(operationName);
		service6.setComment("Convert comma separated values into ASCII tabular data");
		service6.setLabel("CSV to Tabular ASCII");
		service6.setWSDLURL(wsdlURL);
		service6.setInputFormat(Resources.csv);
		service6.setOutputFormat(Resources.spaceDelimTabularASCII);
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
}
