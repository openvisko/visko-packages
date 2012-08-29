package package_vtk.rdfPackage;

import package_vtk.servicePackage.ServiceSource;
import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageInputParameterBindings;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.service.Toolkit;
import edu.utep.trustlab.visko.ontology.view.View;

public class PackageSource extends RDFPackage {
	
	private static final class Resources {
		
		//formats
		private static final Format binaryIntArrayLE = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/BINARYINTARRAYLENDIAN.owl#BINARYINTARRAYLENDIAN");
		private static final Format binaryShortIntArrayLE = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/BINARYSHORTINTARRAYLENDIAN.owl#BINARYSHORTINTARRAYLENDIAN");
		private static final Format binaryFloatArrayLE = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/BINARYFLOATARRAYLENDIAN.owl#BINARYFLOATARRAYLENDIAN");
		private static final Format vtkImageDataShortInts = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/VTKIMAGEDATASHORTINTS.owl#VTKIMAGEDATASHORTINTS");
		private static final Format vtkImageData = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/VTKIMAGEDATA.owl#VTKIMAGEDATA");
		private static final Format vtkPolyData = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/VTKPOLYDATA.owl#VTKPOLYDATA");
		private static final Format jpeg = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/JPEG.owl#JPEG");
		private static final Format tiff = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/TIFF.owl#TIFF");
		private static final Format binaryUnsignedIntArrayLE = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/BINARYUNSIGNEDINTARRAYLENDIAN.owl#BINARYUNSIGNEDINTARRAYLENDIAN");
	
		//views
		private static final View isosurfaces = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/iso-surfaces.owl#iso-surfaces");
		private static final View raster = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/raster.owl#raster");
		private static final View volume = PackageWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/volume.owl#volume");
		
		//type uris
		private static final String velocityDataURI_1 = "http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d14-0";
		private static final String velocityDataURI_2 = "http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d2";
		private static final String velocityDataURI_3 = "http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d2-1";
		
		private static final String coverageDataURI = "http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d7-0";

		private static final String griddedTimeURI_1 = "http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d4-0";
		private static final String griddedTimeURI_2 = "http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d4";		
		
		private static final String dusumDataURI_1 = "http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d8-0";
		private static final String dusumDataURI_2 = "http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d8";
	}

	@Override
	public void populateServices() {
		ServiceSource services = new ServiceSource();
		String wsdlURL = services.getWSDLURL();
		
		String operationName = "int2Short";
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

	public void addCoverageParameterBindings(PackageInputParameterBindings bindingsSet){
		bindingsSet.addDataType(Resources.coverageDataURI);
		
		String operationName = "float2ShortThr";
		
		operationName = "vtkImageDataReader";
		// for vtkImageReader
		bindingsSet.addInputBinding(operationName, "littleEndian","true");
		bindingsSet.addInputBinding(operationName, "dim", "3");
		bindingsSet.addInputBinding(operationName, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(operationName, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(operationName, "dataExtent", "0/229/0/24/0/67");
		bindingsSet.addInputBinding(operationName, "numScalarComponents", "1");
		bindingsSet.addInputBinding(operationName, "readLowerLeft","true");

		operationName = "vtkContourFilter";
		// for vtkContourFilter
		bindingsSet.addInputBinding(operationName, "numContours", "35");
		bindingsSet.addInputBinding(operationName, "scalarRange", "0.0/9000.0");
		
		operationName = "vtkPolyDataMapper";
		// for vtkPolyDataMapper
		bindingsSet.addInputBinding(operationName, "scalarRange","0.0/9000.0");
		bindingsSet.addInputBinding(operationName, "xRotation", "105");
		bindingsSet.addInputBinding(operationName, "yRotation", "0");
		bindingsSet.addInputBinding(operationName, "zRotation", "0");
		bindingsSet.addInputBinding(operationName, "size", "400/300");
		bindingsSet.addInputBinding(operationName, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(operationName, "magnification", "3");
		
		operationName = "vtkVolume";
		// for vtkVolume
		bindingsSet.addInputBinding(operationName, "xRotation", "105");
		bindingsSet.addInputBinding(operationName, "yRotation", "0");
		bindingsSet.addInputBinding(operationName, "zRotation", "0");
		bindingsSet.addInputBinding(operationName, "size", "400/300");
		bindingsSet.addInputBinding(operationName, "backgroundColor", "0/0/0");
		bindingsSet.addInputBinding(operationName, "magnification", "3");
		bindingsSet.addInputBinding(operationName, "colorFunction", "20,1.0,0.0,0.3/80,1.0,0.0,0.3");
		bindingsSet.addInputBinding(operationName, "opacityFunction", "0,0.0/40,1.0");		
	}

	public void addGriddedTimeParameterBindings(PackageInputParameterBindings bindingsSet){
		bindingsSet.addDataType(Resources.griddedTimeURI_1);
		bindingsSet.addDataType(Resources.griddedTimeURI_2);
		
		String operationName = "float2ShortThr";
		// for float2shortThr
		bindingsSet.addInputBinding(operationName, "scalingFactor", "1000");
		bindingsSet.addInputBinding(operationName, "offset", "0");
		
		operationName = "vtkImageDataReader";
		// for vtkImageReader
		bindingsSet.addInputBinding(operationName, "littleEndian", "true");
		bindingsSet.addInputBinding(operationName, "dim", "3");
		bindingsSet.addInputBinding(operationName, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(operationName, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(operationName, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(operationName, "numScalarComponents", "1");
		bindingsSet.addInputBinding(operationName, "readLowerLeft", "true");
		
		operationName = "vtkContourFilter";
		// for vtkContourFilter
		bindingsSet.addInputBinding(operationName, "numContours", "30");
		bindingsSet.addInputBinding(operationName, "scalarRange", "0.0/30315.0");
	
		operationName = "vtkPolyDataMapper";
		// for vtkPolyDataMapper
		bindingsSet.addInputBinding(operationName, "scalarRange", "0.0/30315.0");
		bindingsSet.addInputBinding(operationName, "xRotation", "105");
		bindingsSet.addInputBinding(operationName, "yRotation", "0");
		bindingsSet.addInputBinding(operationName, "zRotation", "0");
		bindingsSet.addInputBinding(operationName, "size","400/300");
		bindingsSet.addInputBinding(operationName, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(operationName, "magnification", "3");
		
		operationName = "vtkVolume";
		// for vtkVolume
		bindingsSet.addInputBinding(operationName, "xRotation", "105");
		bindingsSet.addInputBinding(operationName, "yRotation", "0");
		bindingsSet.addInputBinding(operationName, "zRotation", "0");
		bindingsSet.addInputBinding(operationName, "size", "400/300");
		bindingsSet.addInputBinding(operationName, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(operationName, "magnification", "3");
		bindingsSet.addInputBinding(operationName, "colorFunction", "0.0,0.0,0.0,0.0/1000.0,1.0,0.0,0.0/3000.0,0.0,0.0,1.0/5000.0,0.0,1.0,0.0/7000.0,0.0,0.2,0.0");
		bindingsSet.addInputBinding(operationName, "opacityFunction", "20,0.0/255,0.2");
		
		operationName = "vtkImageDataReaderFloat";
		// for vtkImageReaderFloat
		bindingsSet.addInputBinding(operationName, "littleEndian", "true");
		bindingsSet.addInputBinding(operationName, "dim", "3");
		bindingsSet.addInputBinding(operationName, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(operationName, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(operationName, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(operationName, "numScalarComponents", "1");
		bindingsSet.addInputBinding(operationName, "readLowerLeft", "true");	
	}
	
	public void addDuSumParameterBindings(PackageInputParameterBindings bindingsSet){
		bindingsSet.addDataType(Resources.dusumDataURI_1);
		bindingsSet.addDataType(Resources.dusumDataURI_2);
		
		String operationName = "float2ShortThr";
		// for float2shortThr
		bindingsSet.addInputBinding(operationName, "scalingFactor", "1");
		bindingsSet.addInputBinding(operationName, "offset", "10000");
		
		operationName = "vtkImageDataReader";
		// for vtkImageReader
		bindingsSet.addInputBinding(operationName, "littleEndian", "true");
		bindingsSet.addInputBinding(operationName, "dim", "3");
		bindingsSet.addInputBinding(operationName, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(operationName, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(operationName, "dataExtent", "0/229/0/24/0/67");
		bindingsSet.addInputBinding(operationName, "numScalarComponents", "1");
		bindingsSet.addInputBinding(operationName, "readLowerLeft", "true");

		operationName = "vtkContourFilter";
		// for vtkContourFilter
		bindingsSet.addInputBinding(operationName, "numContours", "35");
		bindingsSet.addInputBinding(operationName, "scalarRange", "9997.0/10014.0");

		operationName = "vtkPolyDataMapper";
		// for vtkPolyDataMapper
		bindingsSet.addInputBinding(operationName, "scalarRange", "9997.0/10014.0");
		bindingsSet.addInputBinding(operationName, "xRotation", "90");
		bindingsSet.addInputBinding(operationName, "yRotation", "0");
		bindingsSet.addInputBinding(operationName, "zRotation", "0");
		bindingsSet.addInputBinding(operationName, "size", "400/300");
		bindingsSet.addInputBinding(operationName, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(operationName, "magnification", "3");
		
		operationName = "vtkVolume";
		// for vtkVolume
		bindingsSet.addInputBinding(operationName, "xRotation", "105");
		bindingsSet.addInputBinding(operationName, "yRotation", "0");
		bindingsSet.addInputBinding(operationName, "zRotation", "0");
		bindingsSet.addInputBinding(operationName, "size", "400/300");
		bindingsSet.addInputBinding(operationName, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(operationName, "magnification", "3");
		bindingsSet.addInputBinding(operationName, "colorFunction", "0.0,0.0,0.0,0.0/1000.0,1.0,0.0,0.0/3000.0,0.0,0.0,1.0/5000.0,0.0,1.0,0.0/7000.0,0.0,0.2,0.0");
		bindingsSet.addInputBinding(operationName, "opacityFunction", "20,0.0/255,0.2");
		
		operationName = "vtkImageDataReaderFloat";
		// for vtkImageReaderFloat
		bindingsSet.addInputBinding(operationName, "littleEndian", "true");
		bindingsSet.addInputBinding(operationName, "dim", "3");
		bindingsSet.addInputBinding(operationName, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(operationName, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(operationName, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(operationName, "numScalarComponents", "1");
		bindingsSet.addInputBinding(operationName, "readLowerLeft", "true");
	}
	
	public void addVelocityParameterBindings(PackageInputParameterBindings bindingsSet) {
		bindingsSet.addDataType(Resources.velocityDataURI_1);
		bindingsSet.addDataType(Resources.velocityDataURI_2);
		bindingsSet.addDataType(Resources.velocityDataURI_3);
		
		String operationName = "float2ShortThr";
		// for float2shortThr
		bindingsSet.addInputBinding(operationName, "scalingFactor", "1000");
		bindingsSet.addInputBinding(operationName, "offset","0");
		
		operationName = "vtkImageDataReader";
		// for vtkImageReader
		bindingsSet.addInputBinding(operationName, "littleEndian", "true");
		bindingsSet.addInputBinding(operationName, "dim", "3");
		bindingsSet.addInputBinding(operationName, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(operationName, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(operationName, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(operationName, "numScalarComponents", "1");
		bindingsSet.addInputBinding(operationName, "readLowerLeft","true");
		
		operationName = "vtkContourFilter";
		// for vtkContourFilter
		bindingsSet.addInputBinding(operationName, "numContours", "35");
		bindingsSet.addInputBinding(operationName, "scalarRange", "0.0/9000.0");
		
		operationName = "vtkPolyDataMapper";
		// for vtkPolyDataMapper
		bindingsSet.addInputBinding(operationName, "scalarRange", "0.0/9000.0");
		bindingsSet.addInputBinding(operationName, "xRotation", "105");
		bindingsSet.addInputBinding(operationName, "yRotation", "0");
		bindingsSet.addInputBinding(operationName, "zRotation", "0");
		bindingsSet.addInputBinding(operationName, "size", "400/300");
		bindingsSet.addInputBinding(operationName, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(operationName, "magnification", "3");

		operationName = "vtkVolume";
		// for vtkVolume
		bindingsSet.addInputBinding(operationName, "xRotation", "105");
		bindingsSet.addInputBinding(operationName, "yRotation", "0");
		bindingsSet.addInputBinding(operationName, "zRotation", "0");
		bindingsSet.addInputBinding(operationName, "size", "400/300");
		bindingsSet.addInputBinding(operationName, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(operationName, "magnification", "3");
		bindingsSet.addInputBinding(operationName, "colorFunction", "3000,1,1,0/5000,0.5,0.95,0/5600,0,0,1/6500,0.28,0.2,0.5/7000,1,0,0");
		bindingsSet.addInputBinding(operationName, "opacityFunction", "4000,0.2/8000,0.5");
		
		operationName = "vtkImageDataReaderFloat";
		// for vtkImageReaderFloat
		bindingsSet.addInputBinding(operationName, "littleEndian", "true");
		bindingsSet.addInputBinding(operationName, "dim", "3");
		bindingsSet.addInputBinding(operationName, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(operationName, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(operationName, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(operationName, "numScalarComponents", "1");
		bindingsSet.addInputBinding(operationName, "readLowerLeft", "true");
			
		operationName = "vtkDataSetMapper";
		// for vtkDataSetMapper
		bindingsSet.addInputBinding(operationName, "xRotation", "105");
		bindingsSet.addInputBinding(operationName, "yRotation", "0");
		bindingsSet.addInputBinding(operationName, "zRotation", "0");
		bindingsSet.addInputBinding(operationName, "size", "400/300");
		bindingsSet.addInputBinding(operationName, "backgroundColor","1/1/1");
		bindingsSet.addInputBinding(operationName, "magnification", "3");		
	}

	@Override
	public void populateParameterBindings() {
		PackageInputParameterBindings bindings1 = getPackageWriter().createNewInputParameterBindings();
		PackageInputParameterBindings bindings2 = getPackageWriter().createNewInputParameterBindings();
		PackageInputParameterBindings bindings3 = getPackageWriter().createNewInputParameterBindings();
		PackageInputParameterBindings bindings4 = getPackageWriter().createNewInputParameterBindings();
		
		addCoverageParameterBindings(bindings1);
		addDuSumParameterBindings(bindings2);
		addVelocityParameterBindings(bindings3);
		addGriddedTimeParameterBindings(bindings4);
	}
}
