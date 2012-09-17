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
	
	static final class Resources {		
		//formats		
		static final Format littleEndianSequence = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/LITTLE-ENDIAN-SEQUENCE.owl#LITTLE-ENDIAN-SEQUENCE");
		static final Format xml = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/XML.owl#XML");
		static final Format jpeg = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/JPEG.owl#JPEG");
		static final Format spaceSeparatedValues = PackageWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/SPACESEPARATEDVALUES.owl#SPACESEPARATEDVALUES");

		// data types		
		static final OntResource array1D = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1D");
		static final OntResource array1DFloats = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DFloats");
		static final OntResource array1DIntegers = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DIntegers");
		static final OntResource array1DUnsignedShortIntegers = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DUnsignedShortIntegers");

		static final OntResource vtkImageData3D = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData3D");
		static final OntResource vtkImageData3DUnsignedShortIntegers = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData3DUnsignedShortIntegers");
		static final OntResource vtkImageData3DIntegers = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData3DShortIntegers");
		static final OntResource vtkImageData3DFloats = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData3DFloats");

		static final OntResource vtkImageData2D = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData2D");
		static final OntResource vtkImageData2DUnsignedShortIntegers = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData2DUnsignedShortIntegers");
		static final OntResource vtkImageData2DIntegers = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData2DShortIntegers");
		static final OntResource vtkImageData2DFloats = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData2DFloats");
		
		static final OntResource vtkPolyData = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkPolyData");
		
		//views
		static final View surfacePlot = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_SurfacePlot);
		static final View contourMap = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_ContourMap);
		static final View isosurfaces = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_IsoSurfaceRendering);
		static final View rasterCube = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_RasterCube);
		static final View volume = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_VolumeRendering);
		static final View rasterMap = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_RasterMap);
				
		//type uris
		static final OntResource gravityData = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/CrustalModeling/CrustalModeling.owl#d19");
		
		static final OntResource velocityDataURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d14-0");
		static final OntResource velocityDataURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d2");
		static final OntResource velocityDataURI_3 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d2-1");
		
		static final OntResource coverageDataURI = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d7-0");
		static final OntResource griddedTimeURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d4-0");
		static final OntResource griddedTimeURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d4");		
		
		static final OntResource dusumDataURI_1 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#d8-0");
		static final OntResource dusumDataURI_2 = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeWDO.owl#d8");
		
		static String int2Short = "int2Short";
		static String float2ShortThr = "float2ShortThr";
		static String vtkPolyDataMapper = "vtkPolyDataMapper";
		static String vtkVolume = "vtkVolume";
		static String vtkDataObjectToDataSetFilter3DGravity = "vtkDataObjectToDataSetFilter3DGravityData";		
		static String vtkShepardMethod = "vtkShepardMethod";
		static String vtkSurfaceReconstructionFilter = "vtkSurfaceReconstructionFilter";
		
		static String vtkContourFilter = "vtkContourFilter";
		static String vtkContourFilter2D = vtkContourFilter + "2D";
		static String vtkContourFilter3D = vtkContourFilter + "3D";
		
		static String vtkDataSetMapper = "vtkDataSetMapper";
		static String vtkDataSetMapper2D = vtkDataSetMapper + "2D";
		static String vtkDataSetMapper3D = vtkDataSetMapper + "3D";

		static String vtkExtractVOI3D = "vtkExtractVOI3D";
		static String vtkExtractVOI2D = "vtkExtractVOI2D";
		
		static String vtkImageDataReader3DFloats = "vtkImageDataReader3DFloats";
		static String vtkImageDataReader3DIntegers = "vtkImageDataReader3DIntegers";
		static String vtkImageDataReader3DUnsignedShortIntegers = "vtkImageDataReader3DUnsignedShortIntegers";
	}

	@Override
	public void populateServices() {
		
		String wsdlURL = getWSDLURL();
		PackageOperatorService service1 = getPackageWriter().createNewOperatorService(null, Resources.int2Short);
		service1.setInputFormat(Resources.littleEndianSequence);
		service1.setOutputFormat(Resources.littleEndianSequence);
		service1.setLabel(Resources.int2Short);
		service1.setComment("Converts integer arrays to unsigned short integers");
		service1.setWSDLURL(wsdlURL);
		service1.setInputDataType(Resources.array1DIntegers);
		service1.setOutputDataType(Resources.array1DUnsignedShortIntegers);
		
		PackageOperatorService service2 = getPackageWriter().createNewOperatorService(null, Resources.float2ShortThr);
		service2.setInputFormat(Resources.littleEndianSequence);
		service2.setOutputFormat(Resources.littleEndianSequence);
		service2.setLabel(Resources.float2ShortThr);
		service2.setComment("Converts float arrays to short ints");
		service2.setWSDLURL(wsdlURL);
		service2.setInputDataType(Resources.array1DFloats);
		service2.setOutputDataType(Resources.array1DUnsignedShortIntegers);
		
		PackageOperatorService service3 = getPackageWriter().createNewOperatorService(null, Resources.vtkPolyDataMapper);
		service3.setInputFormat(Resources.xml);
		service3.setOutputFormat(Resources.jpeg);
		service3.setLabel(Resources.vtkPolyDataMapper);
		service3.setComment("Converts vtkPolyData into JPEG images");
		service3.setWSDLURL(wsdlURL);
		service3.setInputDataType(Resources.vtkPolyData);
		
		PackageOperatorService service4 = getPackageWriter().createNewOperatorService(null, Resources.vtkVolume);
		service4.setInputFormat(Resources.xml);
		service4.setOutputFormat(Resources.jpeg);
		service4.setView(Resources.volume);
		service4.setLabel(Resources.vtkVolume);
		service4.setComment("Convert vtkImageData of short integers into a volume JPEG");
		service4.setWSDLURL(wsdlURL);
		service4.setInputDataType(Resources.vtkImageData3DUnsignedShortIntegers);
		
		PackageOperatorService service5 = getPackageWriter().createNewOperatorService(null, Resources.vtkDataObjectToDataSetFilter3DGravity);
		service5.setInputFormat(Resources.spaceSeparatedValues);
		service5.setOutputFormat(Resources.xml);
		service5.setLabel(Resources.vtkDataObjectToDataSetFilter3DGravity);
		service5.setComment("Convert PACES gravity dataset into vtkPolyData of 3D Points");
		service5.setWSDLURL(wsdlURL);
		service5.setInputDataType(Resources.gravityData);
		service5.setOutputDataType(Resources.vtkPolyData);
		
		PackageOperatorService service6 = getPackageWriter().createNewOperatorService(null, Resources.vtkShepardMethod);
		service6.setInputFormat(Resources.xml);
		service6.setOutputFormat(Resources.xml);
		service6.setLabel(Resources.vtkShepardMethod);
		service6.setComment("3D interpolation routine that generates vtkImageData from unstructured points");
		service6.setWSDLURL(wsdlURL);
		service6.setInputDataType(Resources.vtkPolyData);
		service6.setOutputDataType(Resources.vtkImageData3D);
		
		PackageOperatorService service7 = getPackageWriter().createNewOperatorService(null, Resources.vtkSurfaceReconstructionFilter);
		service7.setInputFormat(Resources.xml);
		service7.setOutputFormat(Resources.xml);
		service7.setLabel(Resources.vtkSurfaceReconstructionFilter);
		service7.setComment("Generates a vktImageData surface that wraps unstructured vtkPolyData points");
		service7.setWSDLURL(wsdlURL);
		service7.setInputDataType(Resources.vtkPolyData);
		service7.setOutputDataType(Resources.vtkImageData3D);
		
		VTKContourFilter.populateVTKContourFilters(wsdlURL, getPackageWriter());
		VTKDataSetMapper.populateDataSetMappers(wsdlURL, getPackageWriter());
		VTKExtractVOI.populateVTKExtractVOIs(wsdlURL, getPackageWriter());
		VTKImageDataReader.populateVTKImageDataReaders(wsdlURL, getPackageWriter());
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
		
		// for vtkImageReader integers
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "littleEndian","true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "dim", "3");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "dataExtent", "0/229/0/24/0/67");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "readLowerLeft","true");
		
		// for vtkImageReader unsigned short integers
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "littleEndian","true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dim", "3");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataExtent", "0/229/0/24/0/67");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "readLowerLeft","true");
		
		// for vtkContourFilter
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "numContours", "35");
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "scalarRange", "0.0/9000.0");
		
		// for vtkPolyDataMapper
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "scalarRange","0.0/9000.0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "xRotation", "105");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "magnification", "3");
		
		// for vtkVolume
		bindingsSet.addInputBinding(Resources.vtkVolume, "xRotation", "105");
		bindingsSet.addInputBinding(Resources.vtkVolume, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkVolume, "backgroundColor", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "magnification", "3");
		bindingsSet.addInputBinding(Resources.vtkVolume, "colorFunction", "20,1.0,0.0,0.3/80,1.0,0.0,0.3");
		bindingsSet.addInputBinding(Resources.vtkVolume, "opacityFunction", "0,0.0/40,1.0");
		
		// for vtkDataSetMapper		
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "xRotation", "105");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "magnification", "3");

	}

	public void addGriddedTimeParameterBindings(PackageInputParameterBindings bindingsSet){
		bindingsSet.addSemanticType(Resources.griddedTimeURI_1);
		bindingsSet.addSemanticType(Resources.griddedTimeURI_2);
		
		// for float2shortThr
		bindingsSet.addInputBinding(Resources.float2ShortThr, "scalingFactor", "1000");
		bindingsSet.addInputBinding(Resources.float2ShortThr, "offset", "0");
		
		// for vtkImageReader floats
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dim", "3");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "readLowerLeft", "true");

		// for vtkImageReader unsigned short ints
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dim", "3");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "readLowerLeft", "true");
		
		// for vtkContourFilter
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "numContours", "30");
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "scalarRange", "0.0/30315.0");
	
		// for vtkPolyDataMapper
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "scalarRange", "0.0/30315.0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "xRotation", "105");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "size","400/300");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "magnification", "3");
		
		// for vtkVolume
		bindingsSet.addInputBinding(Resources.vtkVolume, "xRotation", "105");
		bindingsSet.addInputBinding(Resources.vtkVolume, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkVolume, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkVolume, "magnification", "3");
		bindingsSet.addInputBinding(Resources.vtkVolume, "colorFunction", "0.0,0.0,0.0,0.0/1000.0,1.0,0.0,0.0/3000.0,0.0,0.0,1.0/5000.0,0.0,1.0,0.0/7000.0,0.0,0.2,0.0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "opacityFunction", "20,0.0/255,0.2");
		
		// for vtkDataSetMapper		
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "xRotation", "105");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "magnification", "3");
	}
	
	public void addDuSumParameterBindings(PackageInputParameterBindings bindingsSet){
		bindingsSet.addSemanticType(Resources.dusumDataURI_1);
		bindingsSet.addSemanticType(Resources.dusumDataURI_2);
		
		// for float2shortThr
		bindingsSet.addInputBinding(Resources.float2ShortThr, "scalingFactor", "1");
		bindingsSet.addInputBinding(Resources.float2ShortThr, "offset", "10000");
		
		// for vtkImageReader floats
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dim", "3");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataExtent", "0/229/0/24/0/67");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "readLowerLeft", "true");

		// for vtkImageReader unsigned short integers
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dim", "3");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataExtent", "0/229/0/24/0/67");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "readLowerLeft", "true");
		
		// for vtkContourFilter
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "numContours", "35");
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "scalarRange", "9997.0/10014.0");

		// for vtkPolyDataMapper
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "scalarRange", "9997.0/10014.0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "xRotation", "90");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "magnification", "3");
		
		// for vtkVolume
		bindingsSet.addInputBinding(Resources.vtkVolume, "xRotation", "105");
		bindingsSet.addInputBinding(Resources.vtkVolume, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkVolume, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkVolume, "magnification", "3");
		bindingsSet.addInputBinding(Resources.vtkVolume, "colorFunction", "0.0,0.0,0.0,0.0/1000.0,1.0,0.0,0.0/3000.0,0.0,0.0,1.0/5000.0,0.0,1.0,0.0/7000.0,0.0,0.2,0.0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "opacityFunction", "20,0.0/255,0.2");
				
		// for vtkDataSetMapper		
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "xRotation", "105");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "magnification", "3");

	}
	
	public void addVelocityParameterBindings(PackageInputParameterBindings bindingsSet) {
		bindingsSet.addSemanticType(Resources.velocityDataURI_1);
		bindingsSet.addSemanticType(Resources.velocityDataURI_2);
		bindingsSet.addSemanticType(Resources.velocityDataURI_3);
		
		// for float2shortThr
		bindingsSet.addInputBinding(Resources.float2ShortThr, "scalingFactor", "1000");
		bindingsSet.addInputBinding(Resources.float2ShortThr, "offset","0");
		
		// for vtkImageReader unsigned short integers
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dim", "3");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "readLowerLeft","true");
		
		// for vtkImageReader floats
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dim", "3");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "readLowerLeft","true");
		
		// for vtkContourFilter
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "numContours", "35");
		bindingsSet.addInputBinding(Resources.vtkContourFilter, "scalarRange", "0.0/9000.0");
		
		// for vtkPolyDataMapper
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "scalarRange", "0.0/9000.0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "xRotation", "105");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "magnification", "3");

		// for vtkVolume
		bindingsSet.addInputBinding(Resources.vtkVolume, "xRotation", "105");
		bindingsSet.addInputBinding(Resources.vtkVolume, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkVolume, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkVolume, "magnification", "3");
		bindingsSet.addInputBinding(Resources.vtkVolume, "colorFunction", "3000,1,1,0/5000,0.5,0.95,0/5600,0,0,1/6500,0.28,0.2,0.5/7000,1,0,0");
		bindingsSet.addInputBinding(Resources.vtkVolume, "opacityFunction", "4000,0.2/8000,0.5");
				
		// for vtkDataSetMapper		
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "xRotation", "105");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "magnification", "3");
	}
	
	public void addGravityDataParameterBindings(PackageInputParameterBindings bindingsSet) {
		bindingsSet.addSemanticType(Resources.gravityData);
		
		// for vtkShepardMethod
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "sampleDimensions", "30/30/30");

		// for vtkExtractVOI2D
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "sampleDimensions", "0/30/0/30/10");
		
		// for vtkContourFilter
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "numContours", "20");
		bindingsSet.addInputBinding(Resources.vtkContourFilter, "scalarRange", "-260/-170");		
		
		// for vtkPolyDataMapper
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "scalarRange", "-260/-170");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "xRotation", "-70");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "magnification", "3");

		// for vtkDataSetMapper		
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "xRotation", "-70");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "backgroundColor", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkDataSetMapper3D, "magnification", "3");		
	}
	

	@Override
	public void populateParameterBindings() {
		PackageInputParameterBindings bindings1 = getPackageWriter().createNewInputParameterBindings();
		PackageInputParameterBindings bindings2 = getPackageWriter().createNewInputParameterBindings();
		PackageInputParameterBindings bindings3 = getPackageWriter().createNewInputParameterBindings();
		PackageInputParameterBindings bindings4 = getPackageWriter().createNewInputParameterBindings();
		PackageInputParameterBindings bindings5 = getPackageWriter().createNewInputParameterBindings();
		
		addCoverageParameterBindings(bindings1);
		addDuSumParameterBindings(bindings2);
		addVelocityParameterBindings(bindings3);
		addGriddedTimeParameterBindings(bindings4);
		addGravityDataParameterBindings(bindings5);
	}
	
	@Override
	public String getWSDLURL() {
		return "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
	}
}
