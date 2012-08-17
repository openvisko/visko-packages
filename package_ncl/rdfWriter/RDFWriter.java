package package_ncl.rdfWriter;

import edu.utep.trustlab.visko.installation.packages.PackageRDFWriter;
import edu.utep.trustlab.visko.ontology.service.writer.ServiceOperatorWriter;
import edu.utep.trustlab.visko.ontology.service.writer.ToolkitWriter;

public class RDFWriter implements PackageRDFWriter {

	private String nclToolkitURI;
	
	@Override
	public void createServices() {
		// TODO Auto-generated method stub
		String wsdlURL = "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
		
		String opName = "gsn_csm_contour_map";
		ServiceOperatorWriter wtr1 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr1.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/NETCDF.owl#NETCDF",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT");
		wtr1.setSupportingToolkit(nclToolkitURI);
		wtr1.setView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/contour-lines.owl#contour-lines");
		wtr1.setLabel(opName);
		wtr1.saveDocument();

		opName = "gsn_csm_contour_map_raster";
		ServiceOperatorWriter wtr2 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr2.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/NETCDF.owl#NETCDF",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT");
		wtr2.setSupportingToolkit(nclToolkitURI);
		wtr2.setView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/raster.owl#raster");
		wtr2.setLabel(opName);
		wtr2.saveDocument();

		opName = "gsn_csm_xy2_time_series";
		ServiceOperatorWriter wtr3 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr3.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/NETCDF.owl#NETCDF",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT");
		wtr3.setSupportingToolkit(nclToolkitURI);
		wtr3.setView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/XYPlot.owl#XYPlot");
		wtr3.setLabel(opName);
		wtr3.saveDocument();
	}

	@Override
	public void createToolkit() {
		// TODO Auto-generated method stub
		ToolkitWriter wtr = new ToolkitWriter("ncl");
		wtr.setLabel("NCAR Command Language");
		wtr.saveDocument();
		nclToolkitURI = wtr.getURI();
	}

	@Override
	public void createViewerSets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createViewers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createViews() {
		// TODO Auto-generated method stub
		
	}

}
