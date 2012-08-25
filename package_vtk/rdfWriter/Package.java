package package_vtk.rdfWriter;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.service.Toolkit;
import edu.utep.trustlab.visko.ontology.view.View;

public class Package extends RDFPackage {
	
	private static final class Resources {
		
		//formats
		private static final Format binaryIntArrayLE = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/BINARYINTARRAYLENDIAN.owl#BINARYINTARRAYLENDIAN");
		private static final Format binaryShortIntArrayLE = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/BINARYSHORTINTARRAYLENDIAN.owl#BINARYSHORTINTARRAYLENDIAN");
		private static final Format binaryFloatArrayLE = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/BINARYFLOATARRAYLENDIAN.owl#BINARYFLOATARRAYLENDIAN");
		private static final Format vtkImageDataShortInts = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKIMAGEDATASHORTINTS.owl#VTKIMAGEDATASHORTINTS");
		private static final Format vtkImageData = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKIMAGEDATA.owl#VTKIMAGEDATA");
		private static final Format vtkPolyData = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/VTKPOLYDATA.owl#VTKPOLYDATA");
		private static final Format jpeg = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/JPEG.owl#JPEG");
		private static final Format tiff = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/TIFF.owl#TIFF");
		private static final Format binaryUnsignedIntArrayLE = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/rdf/formats/BINARYUNSIGNEDINTARRAYLENDIAN.owl#BINARYUNSIGNEDINTARRAYLENDIAN");
	
		//views
		private static final View isosurfaces = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/iso-surfaces.owl#iso-surfaces");
		private static final View raster = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/raster.owl#raster");
		private static final View volume = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/volume.owl#volume");
	}

	@Override
	public void populateServices() {
		String wsdlURL = "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
	
		String operationName = "int2short";
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(operationName);
		service1.setInputFormat(Resources.binaryIntArrayLE);
		service1.setOutputFormat(Resources.binaryShortIntArrayLE);
		service1.setLabel(operationName);
		service1.setComment("Converts integer arrays to short integers");
		service1.setWSDLURL(wsdlURL);
		
		operationName = "float2ShortThr";
		PackageOperatorService service2 = getPackageWriter().createNewOperatorService(operationName);
		service2.setInputFormat(Resources.binaryFloatArrayLE);
		service2.setOutputFormat(Resources.binaryShortIntArrayLE);
		service2.setLabel(operationName);
		service2.setComment("Converts float arrays to short ints");
		service2.setWSDLURL(wsdlURL);
		
		operationName = "vtkImageDataReader";
		PackageOperatorService service3 = getPackageWriter().createNewOperatorService(operationName);
		service3.setInputFormat(Resources.binaryShortIntArrayLE);
		service3.setOutputFormat(Resources.vtkImageDataShortInts);
		service3.setLabel(operationName);
		service3.setComment("Converts binary short integer arrays into vtk image data of short integers");
		service3.setWSDLURL(wsdlURL);
		
		operationName = "vtkContourFilter";
		PackageOperatorService service4 = getPackageWriter().createNewOperatorService(operationName);
		service4.setInputFormat(Resources.vtkImageData);
		service4.setOutputFormat(Resources.vtkPolyData);
		service4.setView(Resources.isosurfaces);
		service4.setLabel(operationName);
		service4.setComment("Generates isosurfaces from vtkImageData");
		service4.setWSDLURL(wsdlURL);
		
		operationName = "vtkPolyDataMapper";
		PackageOperatorService service5 = getPackageWriter().createNewOperatorService(operationName);
		service5.setInputFormat(Resources.vtkPolyData);
		service5.setOutputFormat(Resources.jpeg);
		service5.setLabel(operationName);
		service5.setComment("Converts poly data into JPEG");
		service5.setWSDLURL(wsdlURL);
		
		operationName = "vtkVolume";
		PackageOperatorService service6 = getPackageWriter().createNewOperatorService(operationName);
		service6.setInputFormat(Resources.vtkImageDataShortInts);
		service6.setOutputFormat(Resources.jpeg);
		service6.setView(Resources.volume);
		service6.setLabel(operationName);
		service6.setComment("Convert vtkImageData of short integers into a volume JPEG");
		service6.setWSDLURL(wsdlURL);
		
		operationName = "vtkImageDataReaderFloat";
		PackageOperatorService service7 = getPackageWriter().createNewOperatorService(operationName);
		service7.setInputFormat(Resources.binaryFloatArrayLE);
		service7.setOutputFormat(Resources.vtkImageData);
		service7.setLabel(operationName);
		service7.setComment("Convert binary float arrays into vtkImageData");
		service7.setWSDLURL(wsdlURL);
		
		operationName = "vtkTIFFReader";
		PackageOperatorService service8 = getPackageWriter().createNewOperatorService(operationName);
		service8.setInputFormat(Resources.tiff);
		service8.setOutputFormat(Resources.vtkImageData);
		service8.setLabel(operationName);
		service8.setComment("Convert TIFF images into vtkImageData");
		service8.setWSDLURL(wsdlURL);
		
		operationName = "vtkDataSetMapper";
		PackageOperatorService service9 = getPackageWriter().createNewOperatorService(operationName);
		service9.setInputFormat(Resources.vtkImageData);
		service9.setOutputFormat(Resources.jpeg);
		service9.setView(Resources.raster);
		service9.setLabel(operationName);
		service9.setComment("Convert vtkImageData into a raster image");
		service9.setWSDLURL(wsdlURL);
		
		operationName = "vtkImageDataReaderUnsignedInts";
		PackageOperatorService service10 = getPackageWriter().createNewOperatorService(operationName);
		service10.setInputFormat(Resources.binaryUnsignedIntArrayLE);
		service10.setOutputFormat(Resources.vtkImageData);
		service10.setLabel(operationName);
		service10.setComment("Convert binary unsigned interger array into vtkImageData");
		service10.setWSDLURL(wsdlURL);
	}

	@Override
	public void populateToolkit() {
		Toolkit toolkit = getPackageWriter().createNewToolkit("vtk");
		toolkit.setComment("Visualization Toolkit (VTK) Library");
		toolkit.setLabel("Visualization Toolkit (VTK)");
	}

	@Override
	public void populateViewerSets() {
		// TODO Auto-generated method stub
		
	}
}
