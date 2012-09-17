package package_vtk.rdfPackage;

import package_vtk.rdfPackage.PackageSource.Resources;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;

public class VTKDataSetMapper {
	
	public static void populateDataSetMappers(String wsdlURL, PackageWriter packageWriter){
		
		PackageOperatorService service1 = packageWriter.createNewOperatorService(PackageSource.Resources.vtkDataSetMapper3D, PackageSource.Resources.vtkDataSetMapper);
		service1.setInputFormat(Resources.xml);
		service1.setOutputFormat(Resources.jpeg);
		service1.setView(Resources.rasterCube);
		service1.setLabel(PackageSource.Resources.vtkDataSetMapper3D);
		service1.setComment("Convert 3D vtkImageData into a raster cube");
		service1.setWSDLURL(wsdlURL);
		service1.setInputDataType(Resources.vtkImageData3D);
		
		PackageOperatorService service2 = packageWriter.createNewOperatorService(PackageSource.Resources.vtkDataSetMapper2D, PackageSource.Resources.vtkDataSetMapper);
		service2.setInputFormat(Resources.xml);
		service2.setOutputFormat(Resources.jpeg);
		service2.setView(Resources.rasterMap);
		service2.setLabel(PackageSource.Resources.vtkDataSetMapper2D);
		service2.setComment("Convert 2D vtkImageData into a raster map");
		service2.setWSDLURL(wsdlURL);
		service2.setInputDataType(Resources.vtkImageData2D);
	}

}
