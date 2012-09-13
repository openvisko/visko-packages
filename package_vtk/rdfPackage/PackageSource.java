package package_vtk.rdfPackage;

import com.hp.hpl.jena.ontology.OntResource;

import edu.utep.trustlab.visko.installation.packages.RDFPackage;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageInputParameterBindings;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;
import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.viskoService.Toolkit;
import edu.utep.trustlab.visko.ontology.viskoView.View;
import edu.utep.trustlab.visko.ontology.vocabulary.ViskoV;

public class PackageSource extends RDFPackage {
	
	private static final class Resources {		
		//formats		
		private static final Format littleEndianIntegers = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/LITTLE-ENDIAN-INTEGERS.owl#LITTLE-ENDIAN-INTEGERS");
		private static final Format littleEndianShortIntegers = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/LITTLE-ENDIAN-SHORT-INTEGERS.owl#LITTLE-ENDIAN-SHORT-INTEGERS");
		private static final Format littleEndianFloats = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/LITTLE-ENDIAN-FLOATS.owl#LITTLE-ENDIAN-FLOATS");
		private static final Format littleEndianUnsignedIntegers = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/LITTLE-ENDIAN-UNSIGNED-INTEGERS.owl#LITTLE-ENDIAN-UNSIGNED-INTEGERS");
		private static final Format xml = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/XML.owl#XML");
		private static final Format jpeg = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/JPEG.owl#JPEG");
		private static final Format tiff = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/TIFF.owl#TIFF");
		

		// data types
		private static final OntResource array1D = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#1D_Array");
		private static final OntResource vtkImageData = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData");
		private static final OntResource vtkImageDataShortIntegers = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageDataShortIntegers");
		private static final OntResource vtkPolyData = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkIPolyData");
		
		//views
		private static final View isosurfaces = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_IsoSurfaceRendering);
		private static final View rasterCube = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_RasterCube);
		private static final View volume = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_VolumeRendering);
		
		//type uris
		private static final OntResource velocityDataURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d14-0");
		private static final OntResource velocityDataURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d2");
		private static final OntResource velocityDataURI_3 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d2-1");
		
		private static final OntResource coverageDataURI = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d7-0");

		private static final OntResource griddedTimeURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d4-0");
		private static final OntResource griddedTimeURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d4");		
		
		private static final OntResource dusumDataURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d8-0");
		private static final OntResource dusumDataURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d8");		
	}

	@Override
	public void populateServices() {
		String wsdlURL = getWSDLURL();
		String operationName = "int2Short";
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(operationName);
		service1.setInputFormat(Resources.littleEndianIntegers);
		service1.setOutputFormat(Resources.littleEndianShortIntegers);
		service1.setLabel(operationName);
		service1.setComment("Converts integer arrays to short integers");
		service1.setWSDLURL(wsdlURL);
		service1.setInputDataType(Resources.array1D);
		service1.setOutputDataType(Resources.array1D);
		
		operationName = "float2ShortThr";
		PackageOperatorService service2 = getPackageWriter().createNewOperatorService(operationName);
		service2.setInputFormat(Resources.littleEndianFloats);
		service2.setOutputFormat(Resources.littleEndianShortIntegers);
		service2.setLabel(operationName);
		service2.setComment("Converts float arrays to short ints");
		service2.setWSDLURL(wsdlURL);
		service2.setInputDataType(Resources.array1D);
		service2.setOutputDataType(Resources.array1D);
		
		operationName = "vtkImageDataReader";
		PackageOperatorService service3 = getPackageWriter().createNewOperatorService(operationName);
		service3.setInputFormat(Resources.littleEndianShortIntegers);
		service3.setOutputFormat(Resources.xml);
		service3.setLabel(operationName);
		service3.setComment("Converts binary short integer arrays into vtk image data of short integers");
		service3.setWSDLURL(wsdlURL);
		service3.setInputDataType(Resources.array1D);
		service3.setOutputDataType(Resources.vtkImageDataShortIntegers);
		
		operationName = "vtkContourFilter";
		PackageOperatorService service4 = getPackageWriter().createNewOperatorService(operationName);
		service4.setInputFormat(Resources.xml);
		service4.setOutputFormat(Resources.xml);
		service4.setLabel(operationName);
		service4.setComment("Generates isosurfaces from vtkImageData");
		service4.setWSDLURL(wsdlURL);
		service4.setInputDataType(Resources.vtkImageData);
		service4.setOutputDataType(Resources.vtkPolyData);
		service4.setView(Resources.isosurfaces);
		
		operationName = "vtkPolyDataMapper";
		PackageOperatorService service5 = getPackageWriter().createNewOperatorService(operationName);
		service5.setInputFormat(Resources.xml);
		service5.setOutputFormat(Resources.jpeg);
		service5.setLabel(operationName);
		service5.setComment("Converts poly data into JPEG");
		service5.setWSDLURL(wsdlURL);
		service5.setInputDataType(Resources.vtkPolyData);
		
		operationName = "vtkVolume";
		PackageOperatorService service6 = getPackageWriter().createNewOperatorService(operationName);
		service6.setInputFormat(Resources.xml);
		service6.setOutputFormat(Resources.jpeg);
		service6.setView(Resources.volume);
		service6.setLabel(operationName);
		service6.setComment("Convert vtkImageData of short integers into a volume JPEG");
		service6.setWSDLURL(wsdlURL);
		service6.setInputDataType(Resources.vtkImageDataShortIntegers);		
		
		operationName = "vtkImageDataReaderFloat";
		PackageOperatorService service7 = getPackageWriter().createNewOperatorService(operationName);
		service7.setInputFormat(Resources.littleEndianFloats);
		service7.setOutputFormat(Resources.xml);
		service7.setLabel(operationName);
		service7.setComment("Convert binary float arrays into vtkImageData");
		service7.setWSDLURL(wsdlURL);
		service7.setInputDataType(Resources.array1D);
		service7.setOutputDataType(Resources.vtkImageData);
		
		operationName = "vtkTIFFReader";
		PackageOperatorService service8 = getPackageWriter().createNewOperatorService(operationName);
		service8.setInputFormat(Resources.tiff);
		service8.setOutputFormat(Resources.xml);
		service8.setLabel(operationName);
		service8.setComment("Convert TIFF images into vtkImageData");
		service8.setWSDLURL(wsdlURL);
		service8.setOutputDataType(Resources.vtkImageData);

		operationName = "vtkDataSetMapper";
		PackageOperatorService service9 = getPackageWriter().createNewOperatorService(operationName);
		service9.setInputFormat(Resources.xml);
		service9.setOutputFormat(Resources.jpeg);
		service9.setView(Resources.rasterCube);
		service9.setLabel(operationName);
		service9.setComment("Convert vtkImageData into a raster image");
		service9.setWSDLURL(wsdlURL);
		service1.setInputDataType(Resources.vtkImageData);
		
		operationName = "vtkImageDataReaderUnsignedInts";
		PackageOperatorService service10 = getPackageWriter().createNewOperatorService(operationName);
		service10.setInputFormat(Resources.littleEndianUnsignedIntegers);
		service10.setOutputFormat(Resources.xml);
		service10.setLabel(operationName);
		service10.setComment("Convert binary unsigned interger array into vtkImageData");
		service10.setWSDLURL(wsdlURL);
		service10.setInputDataType(Resources.array1D);
		service10.setInputDataType(Resources.vtkImageData);

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
		bindingsSet.addSemanticType(Resources.coverageDataURI);
		
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
		bindingsSet.addSemanticType(Resources.griddedTimeURI_1);
		bindingsSet.addSemanticType(Resources.griddedTimeURI_2);
		
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
		bindingsSet.addSemanticType(Resources.dusumDataURI_1);
		bindingsSet.addSemanticType(Resources.dusumDataURI_2);
		
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
		bindingsSet.addSemanticType(Resources.velocityDataURI_1);
		bindingsSet.addSemanticType(Resources.velocityDataURI_2);
		bindingsSet.addSemanticType(Resources.velocityDataURI_3);
		
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
	
	@Override
	public String getWSDLURL() {
		return "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
	}
}
