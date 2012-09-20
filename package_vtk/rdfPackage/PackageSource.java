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
		static final OntResource array1DFloat = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DFloat");
		static final OntResource array1DInteger = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DInteger");
		static final OntResource array1DUnsignedShortInteger = PackageWriter.getDataType("http://rio.cs.utep.edu/ciserver/ciprojects/HolesCode/HolesCodeSAW3.owl#Array1DUnsignedShortInteger");

		static final OntResource vtkImageData3D = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData3D");
		static final OntResource vtkImageData3DUnsignedShortIntegers = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData3DUnsignedShortIntegers");
		static final OntResource vtkImageData3DIntegers = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData3DIntegers");
		static final OntResource vtkImageData3DFloats = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData3DFloats");

		static final OntResource vtkImageData2D = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData2D");
		static final OntResource vtkImageData2DUnsignedShortIntegers = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData2DUnsignedShortIntegers");
		static final OntResource vtkImageData2DIntegers = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData2DShortIntegers");
		static final OntResource vtkImageData2DFloats = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkImageData2DFloats");
		
		static final OntResource vtkPolyData = PackageWriter.getDataType("http://www.vtk.org/vtk-data.owl#vtkPolyData");
		
		//views
		static final View surfacePlot3D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_3D_SurfacePlot);
		static final View contourMap2D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_ContourMap);
		static final View isosurfaces3D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_3D_IsoSurfaceRendering);
		static final View rasterCube3D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_3D_RasterCube);
		static final View volume3D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_3D_VolumeRendering);
		static final View rasterMap2D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_2D_RasterMap);
		static final View pointsPlot3D = PackageWriter.getView(ViskoV.INDIVIDUAL_URI_3D_PointPlot);
		
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
		
		static String vtkPolyDataMapper = "vtkPolyDataMapper";
		static String vtkVolume = "vtkVolume";
		static String vtkDataObjectToDataSetFilter3DGravity = "vtkDataObjectToDataSetFilter3DGravityData";		
		static String vtkShepardMethod = "vtkShepardMethod";
		static String vtkSurfaceReconstructionAndContourFilter = "vtkSurfaceReconstructionAndContourFilter";
		
		static String vtkContourFilter = "vtkContourFilter";
		static String vtkContourFilter2D = vtkContourFilter + "2D";
		static String vtkContourFilter3D = vtkContourFilter + "3D";
		
		static String vtkExtractVOI3D = "vtkExtractVOI3D";
		static String vtkExtractVOIXYPlane = "vtkExtractVOIXYPlane";
		static String vtkExtractVOIXZPlane = "vtkExtractVOIXZPlane";
		static String vtkExtractVOIYZPlane = "vtkExtractVOIYZPlane";
		
		static String vtkImageDataReader3DFloats = "vtkImageDataReader3DFloats";
		static String vtkImageDataReader3DIntegers = "vtkImageDataReader3DIntegers";
		static String vtkImageDataReader3DUnsignedShortIntegers = "vtkImageDataReader3DUnsignedShortIntegers";
		
		static String vtkGlyph3DSphereSource = "vtkGlyph3DSphereSource";
	}

	@Override
	public void populateServices() {
		
		String wsdlURL = getWSDLURL();		
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
		service4.setView(Resources.volume3D);
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
		
		PackageOperatorService service7 = getPackageWriter().createNewOperatorService(null, Resources.vtkSurfaceReconstructionAndContourFilter);
		service7.setInputFormat(Resources.xml);
		service7.setOutputFormat(Resources.xml);
		service7.setLabel(Resources.vtkSurfaceReconstructionAndContourFilter);
		service7.setComment("Generates a vktImageData surface that wraps unstructured vtkPolyData points");
		service7.setWSDLURL(wsdlURL);
		service7.setView(Resources.surfacePlot3D);
		service7.setInputDataType(Resources.vtkPolyData);
		service7.setOutputDataType(Resources.vtkPolyData);
		
		PackageOperatorService service8 = getPackageWriter().createNewOperatorService(null, Resources.vtkGlyph3DSphereSource);
		service8.setInputFormat(Resources.xml);
		service8.setOutputFormat(Resources.xml);
		service8.setLabel(Resources.vtkGlyph3DSphereSource);
		service8.setComment("Generates a plot of glyphs, where the glyphs have been hard coded to be spheres");
		service8.setWSDLURL(wsdlURL);
		service8.setView(Resources.pointsPlot3D);
		service8.setInputDataType(Resources.vtkPolyData);
		service8.setOutputDataType(Resources.vtkPolyData);

		
		VTKContourFilter.populateVTKContourFilters(wsdlURL, getPackageWriter());
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
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "dataExtent", "0/229/0/24/0/67");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DIntegers, "readLowerLeft","true");
		
		// for vtkImageReader unsigned short integers
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "littleEndian","true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataExtent", "0/229/0/24/0/67");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "readLowerLeft","true");

		// for vtkExtractVOI
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXYPlane, "dataExtent", "0/229/0/24/0/67");		
		
		// for vtkExtractVOIXY
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXYPlane, "dataExtent", "0/229/0/24/30");
		
		// for vtkExtractVOIXZ
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXZPlane, "dataExtent", "0/229/15/0/67");
		
		// for vtkExtractVOIYZ
		bindingsSet.addInputBinding(Resources.vtkExtractVOIYZPlane, "dataExtent", "100/0/24/0/67");
		
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
	}

	public void addGriddedTimeParameterBindings(PackageInputParameterBindings bindingsSet){
		bindingsSet.addSemanticType(Resources.griddedTimeURI_1);
		bindingsSet.addSemanticType(Resources.griddedTimeURI_2);
		
		// for vtkImageReader floats
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "readLowerLeft", "true");

		// for vtkImageReader unsigned short ints
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "readLowerLeft", "true");

		// for vtkExtractVOI
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXYPlane, "dataExtent", "0/230/0/25/0/68");		
		
		// for vtkExtractVOIXY
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXYPlane, "dataExtent", "0/230/0/25/30");
		
		// for vtkExtractVOIXZ
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXZPlane, "dataExtent", "0/230/15/0/68");
		
		// for vtkExtractVOIYZ
		bindingsSet.addInputBinding(Resources.vtkExtractVOIYZPlane, "dataExtent", "100/0/25/0/68");
		
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
	}
	
	public void addDuSumParameterBindings(PackageInputParameterBindings bindingsSet){
		bindingsSet.addSemanticType(Resources.dusumDataURI_1);
		bindingsSet.addSemanticType(Resources.dusumDataURI_2);
				
		// for vtkImageReader floats
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataExtent", "0/229/0/24/0/67");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "readLowerLeft", "true");

		// for vtkImageReader unsigned short integers
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataExtent", "0/229/0/24/0/67");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "readLowerLeft", "true");

		// for vtkExtractVOI
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXYPlane, "dataExtent", "0/229/0/24/0/67");		
		
		// for vtkExtractVOIXY
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXYPlane, "dataExtent", "0/229/0/24/30");
		
		// for vtkExtractVOIXZ
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXZPlane, "dataExtent", "0/229/15/0/67");
		
		// for vtkExtractVOIYZ
		bindingsSet.addInputBinding(Resources.vtkExtractVOIYZPlane, "dataExtent", "100/0/24/0/67");
		
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
	}
	
	public void addVelocityParameterBindings(PackageInputParameterBindings bindingsSet) {
		bindingsSet.addSemanticType(Resources.velocityDataURI_1);
		bindingsSet.addSemanticType(Resources.velocityDataURI_2);
		bindingsSet.addSemanticType(Resources.velocityDataURI_3);
				
		// for vtkImageReader unsigned short integers
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DUnsignedShortIntegers, "readLowerLeft","true");
		
		// for vtkImageReader floats
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "littleEndian", "true");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataOrigin", "0/0/0");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataSpacing", "1/1/1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "dataExtent", "0/230/0/25/0/68");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "numScalarComponents", "1");
		bindingsSet.addInputBinding(Resources.vtkImageDataReader3DFloats, "readLowerLeft","true");
		
		// for vtkExtractVOI
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXYPlane, "dataExtent", "0/230/0/25/0/68");		
		
		// for vtkExtractVOIXY
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXYPlane, "dataExtent", "0/230/0/25/30");
		
		// for vtkExtractVOIXZ
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXZPlane, "dataExtent", "0/230/15/0/68");
		
		// for vtkExtractVOIYZ
		bindingsSet.addInputBinding(Resources.vtkExtractVOIYZPlane, "dataExtent", "100/0/25/0/68");
		
		// for vtkContourFilter
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "numContours", "35");
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "scalarRange", "0.0/9000.0");
		
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
	}
	
	public void addGravityDataParameterBindings(PackageInputParameterBindings bindingsSet) {
		bindingsSet.addSemanticType(Resources.gravityData);
		
		// for vtkShepardMethod
		bindingsSet.addInputBinding(Resources.vtkShepardMethod, "sampleDimensions", "30/30/10");
		bindingsSet.addInputBinding(Resources.vtkShepardMethod, "maximumDistance", "0.2");

		// for vtkExtractVOI2D
		bindingsSet.addInputBinding(Resources.vtkExtractVOIXYPlane, "dataExtent", "0/30/0/30/3");
		
		// for vtkContourFilter 2D
		bindingsSet.addInputBinding(Resources.vtkContourFilter2D, "numContours", "20");
		bindingsSet.addInputBinding(Resources.vtkContourFilter2D, "scalarRange", "-236/-177");		
		
		// for vtkContourFilter 3D
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "numContours", "20");
		bindingsSet.addInputBinding(Resources.vtkContourFilter3D, "scalarRange", "-236/-177");	
		
		// for vtkPolyDataMapper
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "scalarRange", "-236/-177");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "xRotation", "-30");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "yRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "zRotation", "0");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "size", "400/300");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "backgroundColor", "0.5/0.5/0.5");
		bindingsSet.addInputBinding(Resources.vtkPolyDataMapper, "magnification", "3");

		// for vtkGlyph3DShereSource
		bindingsSet.addInputBinding(Resources.vtkGlyph3DSphereSource, "radius", "0.06");
		bindingsSet.addInputBinding(Resources.vtkGlyph3DSphereSource, "scaleFactor", "0.25");
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
