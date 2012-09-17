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
		
		PackageOperatorService service2 = packageWriter.createNewOperatorService(null, PackageSource.Resources.vtkExtractVOI2D);
		service2.setInputFormat(Resources.xml);
		service2.setOutputFormat(Resources.xml);
		service2.setLabel(PackageSource.Resources.vtkExtractVOI2D);
		service2.setComment("Extracts a subset plane");
		service2.setWSDLURL(wsdlURL);
		service2.setInputDataType(Resources.vtkImageData3D);
		service2.setOutputDataType(Resources.vtkImageData2D);
		service2.setView(Resources.contourMap);			
	}
}
