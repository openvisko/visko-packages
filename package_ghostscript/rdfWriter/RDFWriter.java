package package_ghostscript.rdfWriter;

import edu.utep.trustlab.visko.ontology.service.writer.ServiceOperatorWriter;
import edu.utep.trustlab.visko.ontology.service.writer.ToolkitWriter;
import edu.utep.trustlab.visko.packages.rdf.PackageRDFWriter;

public class RDFWriter implements PackageRDFWriter {

	private String ghostscriptToolkitURI;
	
	@Override
	public void createServices() {

		String wsdlURL = "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
		
		String operationName = "ps2pdf";
		ServiceOperatorWriter wtr1 = new ServiceOperatorWriter(wsdlURL, operationName);
		wtr1.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT", 
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PDF.owl#PDF");
		wtr1.setLabel(operationName);
		wtr1.setSupportingToolkit(ghostscriptToolkitURI);
		wtr1.saveDocument();
	
		operationName = "ps2png";
		ServiceOperatorWriter wtr2 = new ServiceOperatorWriter(wsdlURL, operationName);
		wtr2.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/POSTSCRIPT.owl#POSTSCRIPT", 
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PNG.owl#PNG");
		wtr2.setLabel(operationName);
		wtr2.setSupportingToolkit(ghostscriptToolkitURI);
		wtr2.saveDocument();

		operationName = "pdf2png";
		ServiceOperatorWriter wtr3 = new ServiceOperatorWriter(wsdlURL, operationName);
		wtr3.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PDF.owl#PDF",				
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/PNG.owl#PNG");
		wtr3.setLabel(operationName);
		wtr3.setSupportingToolkit(ghostscriptToolkitURI);
		wtr3.saveDocument();		
	}

	@Override
	public void createToolkit() {
		// TODO Auto-generated method stub
		
		ToolkitWriter wtr = new ToolkitWriter("ghostscript");
		wtr.setLabel("Ghostscript");
		wtr.saveDocument();
		ghostscriptToolkitURI = wtr.getURI();
	}

	@Override
	public void createViewerSets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createViewers() {
		// TODO Auto-generated method stub
		
	}

}
