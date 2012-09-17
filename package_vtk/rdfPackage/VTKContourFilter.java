package package_vtk.rdfPackage;

import package_vtk.rdfPackage.PackageSource.Resources;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;

public class VTKContourFilter {
	
	public static void populateVTKContourFilters(String wsdlURL, PackageWriter packageWriter){
		
		PackageOperatorService service1 = packageWriter.createNewOperatorService(PackageSource.Resources.vtkContourFilter3D, PackageSource.Resources.vtkContourFilter);
		service1.setInputFormat(Resources.xml);
		service1.setOutputFormat(Resources.xml);
		service1.setLabel(PackageSource.Resources.vtkContourFilter3D);
		service1.setComment("Generates isosurfaces from 3D vtkImageData");
		service1.setWSDLURL(wsdlURL);
		service1.setInputDataType(Resources.vtkImageData3D);
		service1.setOutputDataType(Resources.vtkPolyData);
		service1.setView(PackageSource.Resources.isosurfaces);
		
		PackageOperatorService service2 = packageWriter.createNewOperatorService(PackageSource.Resources.vtkContourFilter2D, PackageSource.Resources.vtkContourFilter);
		service2.setInputFormat(Resources.xml);
		service2.setOutputFormat(Resources.xml);
		service2.setLabel(PackageSource.Resources.vtkContourFilter2D);
		service2.setComment("Generates contour map from 2D vtkImageData");
		service2.setWSDLURL(wsdlURL);
		service2.setInputDataType(Resources.vtkImageData2D);
		service2.setOutputDataType(Resources.vtkPolyData);
		service2.setView(Resources.contourMap);
		
	}
}
