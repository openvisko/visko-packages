package package_gmt.rdfWriter;

import edu.utep.trustlab.visko.installation.packages.PackageRDFWriter;
import edu.utep.trustlab.visko.ontology.service.writer.ServiceOperatorWriter;
import edu.utep.trustlab.visko.ontology.service.writer.ToolkitWriter;

public class RDFWriter implements PackageRDFWriter {

	private String gmtToolkitURI;
	
	@Override
	public void createServices() {
		// TODO Auto-generated method stub
		String wsdlURL = "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
		
		String opName = "grdcontour";
		ServiceOperatorWriter wtr1 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr1.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/NETCDFGMT.owl#NETCDFGMT",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT");
		wtr1.setSupportingToolkit(gmtToolkitURI);
		wtr1.setView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/contour-lines.owl#contour-lines");
		wtr1.setLabel(opName);
		wtr1.saveDocument();
		
		opName = "surface";
		ServiceOperatorWriter wtr2 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr2.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/SPACEDELIMITEDTABULARASCII.owl#SPACEDELIMITEDTABULARASCII",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/NETCDFGMT.owl#NETCDFGMT");
		wtr2.setSupportingToolkit(gmtToolkitURI);
		wtr2.setLabel(opName);
		wtr2.saveDocument();

		opName = "nearneighbor";
		ServiceOperatorWriter wtr3 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr3.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/SPACEDELIMITEDTABULARASCII.owl#SPACEDELIMITEDTABULARASCII",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/NETCDFGMT.owl#NETCDFGMT");
		wtr3.setSupportingToolkit(gmtToolkitURI);
		wtr3.setLabel(opName);
		wtr3.saveDocument();
		
		opName = "psxy";
		ServiceOperatorWriter wtr4 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr4.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/SPACEDELIMITEDTABULARASCII.owl#SPACEDELIMITEDTABULARASCII",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT");
		wtr4.setSupportingToolkit(gmtToolkitURI);
		wtr4.setView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/plot-2D.owl#plot-2D");
		wtr4.setLabel(opName);
		wtr4.saveDocument();

		opName = "grdimage";
		ServiceOperatorWriter wtr5 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr5.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/NETCDFGMT.owl#NETCDFGMT",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT");
		wtr5.setSupportingToolkit(gmtToolkitURI);
		wtr5.setView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/raster.owl#raster");
		wtr5.setLabel(opName);
		wtr5.saveDocument();
		
		opName = "csv2tabular";
		ServiceOperatorWriter wtr6 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr6.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/SPACEDELIMITEDTABULARASCII.owl#SPACEDELIMITEDTABULARASCII",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/CSV.owl#CSV");
		wtr6.setSupportingToolkit(gmtToolkitURI);
		wtr6.setLabel(opName);
		wtr6.saveDocument();
	}

	@Override
	public void createToolkit() {
		// TODO Auto-generated method stub
		ToolkitWriter wtr1 = new ToolkitWriter("gmt");
		wtr1.setLabel("Generic Mapping Tools");
		wtr1.saveDocument();
		gmtToolkitURI = wtr1.getURI();	
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
