package package_vtk.rdfWriter;

import edu.utep.trustlab.visko.ontology.service.writer.ServiceOperatorWriter;
import edu.utep.trustlab.visko.ontology.service.writer.ToolkitWriter;
import edu.utep.trustlab.visko.installation.packages.PackageRDFWriter;

public class RDFWriter implements PackageRDFWriter {

	private String vtkToolkitURI;
	
	@Override
	public void createServices() {
		// TODO Auto-generated method stub
		String wsdlURL = "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
		String opName = "int2short";
		ServiceOperatorWriter wtr1 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr1.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/BINARYINTARRAYLENDIAN.owl#BINARYINTARRAYLENDIAN", 
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/BINARYSHORTINTARRAYLENDIAN.owl#BINARYSHORTINTARRAYLENDIAN");
		wtr1.setSupportingToolkit(vtkToolkitURI);
		wtr1.setLabel(opName);
		wtr1.saveDocument();
		
		opName = "float2ShortThr";
		ServiceOperatorWriter wtr2 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr2.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/BINARYFLOATARRAYLENDIAN.owl#BINARYFLOATARRAYLENDIAN",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/BINARYSHORTINTARRAYLENDIAN.owl#BINARYSHORTINTARRAYLENDIAN");
		wtr2.setSupportingToolkit(vtkToolkitURI);
		wtr2.setLabel(opName);
		wtr2.saveDocument();

		opName = "vtkImageDataReader";
		ServiceOperatorWriter wtr3 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr3.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/BINARYSHORTINTARRAYLENDIAN.owl#BINARYSHORTINTARRAYLENDIAN",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKIMAGEDATASHORTINTS.owl#VTKIMAGEDATASHORTINTS");
		wtr3.setSupportingToolkit(vtkToolkitURI);
		wtr3.setLabel(opName);
		wtr3.saveDocument();

		opName = "vtkContourFilter";
		ServiceOperatorWriter wtr4 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr4.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKIMAGEDATA.owl#VTKIMAGEDATA",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKPOLYDATA.owl#VTKPOLYDATA");
		wtr4.setSupportingToolkit(vtkToolkitURI);
		wtr4.setView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/iso-surfaces.owl#iso-surfaces");
		wtr4.setLabel(opName);
		wtr4.saveDocument();
		
		opName = "vtkPolyDataMapper";
		ServiceOperatorWriter wtr5 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr5.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKPOLYDATA.owl#VTKPOLYDATA",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/JPEG.owl#JPEG");
		wtr5.setSupportingToolkit(vtkToolkitURI);
		wtr5.setLabel(opName);
		wtr5.saveDocument();

		opName = "vtkVolume";
		ServiceOperatorWriter wtr6 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr6.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKIMAGEDATASHORTINTS.owl#VTKIMAGEDATASHORTINTS",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/JPEG.owl#JPEG");
		wtr6.setSupportingToolkit(vtkToolkitURI);
		wtr6.setView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/volume.owl#volume");
		wtr6.setLabel(opName);
		wtr6.saveDocument();
		
		opName = "vtkImageDataReaderFloat";
		ServiceOperatorWriter wtr7 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr7.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/BINARYFLOATARRAYLENDIAN.owl#BINARYFLOATARRAYLENDIAN",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKIMAGEDATA.owl#VTKIMAGEDATA");
		wtr7.setSupportingToolkit(vtkToolkitURI);
		wtr7.setLabel(opName);
		wtr7.saveDocument();		
		
		opName = "vtkTIFFReader";
		ServiceOperatorWriter wtr8 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr8.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/TIFF.owl#TIFF",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKIMAGEDATA.owl#VTKIMAGEDATA");
		wtr8.setSupportingToolkit(vtkToolkitURI);
		wtr8.setLabel(opName);
		wtr8.saveDocument();		

		opName = "vtkDataSetMapper";
		ServiceOperatorWriter wtr9 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr9.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKIMAGEDATA.owl#VTKIMAGEDATA",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/JPEG.owl#JPEG");
		wtr9.setSupportingToolkit(vtkToolkitURI);
		wtr9.setView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/raster.owl#raster");
		wtr9.setLabel(opName);
		wtr9.saveDocument();
		
		opName = "vtkImageDataReaderUnsignedInts";
		ServiceOperatorWriter wtr10 = new ServiceOperatorWriter(wsdlURL, opName);
		wtr10.setInputAndOutputFormatURIs(
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/BINARYUNSIGNEDINTARRAYLENDIAN.owl#BINARYUNSIGNEDINTARRAYLENDIAN",
				"https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKIMAGEDATA.owl#VTKIMAGEDATA");
		wtr10.setSupportingToolkit(vtkToolkitURI);
		wtr10.setLabel(opName);
		wtr10.saveDocument();		
	}

	@Override
	public void createToolkit() {
		// TODO Auto-generated method stub
		ToolkitWriter wtr = new ToolkitWriter("vtk");
		wtr.setLabel("Visualization Toolkit");
		wtr.saveDocument();
		vtkToolkitURI = wtr.getURI();
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
