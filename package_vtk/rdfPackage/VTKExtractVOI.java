package package_vtk.rdfPackage;

import package_vtk.rdfPackage.PackageSource.Resources;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;

public class VTKExtractVOI {
	
	public static void populateVTKExtractVOIs(String wsdlURL, PackageWriter packageWriter){

		PackageOperatorService service1 = packageWriter.createNewOperatorService(null, PackageSource.Resources.vtkExtractVOI3D);
		service1.setInputFormat(Resources.xml);
		service1.setOutputFormat(Resources.xml);
		service1.setLabel(PackageSource.Resources.vtkExtractVOI3D);
		service1.setComment("Extracts a subset volume");
		service1.setWSDLURL(wsdlURL);
		service1.setInputDataType(Resources.vtkImageData3D);
		service1.setOutputDataType(Resources.vtkImageData3D);
		
		PackageOperatorService service2 = packageWriter.createNewOperatorService(null, PackageSource.Resources.vtkExtractVOIXYPlane);
		service2.setInputFormat(Resources.xml);
		service2.setOutputFormat(Resources.xml);
		service2.setLabel(PackageSource.Resources.vtkExtractVOIXYPlane);
		service2.setComment("Extracts a subset XY plane by specifying plane bounds and location on Z axix");
		service2.setWSDLURL(wsdlURL);
		service2.setInputDataType(Resources.vtkImageData3D);
		service2.setOutputDataType(Resources.vtkImageData2D);
		service2.setAsDimensionFilter();
		
		PackageOperatorService service3 = packageWriter.createNewOperatorService(null, PackageSource.Resources.vtkExtractVOIXZPlane);
		service3.setInputFormat(Resources.xml);
		service3.setOutputFormat(Resources.xml);
		service3.setLabel(PackageSource.Resources.vtkExtractVOIXZPlane);
		service3.setComment("Extracts a subset XY plane by specifying plane bounds and location on Z axix");
		service3.setWSDLURL(wsdlURL);
		service3.setInputDataType(Resources.vtkImageData3D);
		service3.setOutputDataType(Resources.vtkImageData2D);
		service3.setAsDimensionFilter();
		
		PackageOperatorService service4 = packageWriter.createNewOperatorService(null, PackageSource.Resources.vtkExtractVOIYZPlane);
		service4.setInputFormat(Resources.xml);
		service4.setOutputFormat(Resources.xml);
		service4.setLabel(PackageSource.Resources.vtkExtractVOIYZPlane);
		service4.setComment("Extracts a subset XY plane by specifying plane bounds and location on Z axix");
		service4.setWSDLURL(wsdlURL);
		service4.setInputDataType(Resources.vtkImageData3D);
		service4.setOutputDataType(Resources.vtkImageData2D);
		service4.setAsDimensionFilter();
	}
}
