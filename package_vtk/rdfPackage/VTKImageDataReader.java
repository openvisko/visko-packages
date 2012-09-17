package package_vtk.rdfPackage;

import package_vtk.rdfPackage.PackageSource.Resources;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageOperatorService;
import edu.utep.trustlab.visko.installation.packages.rdf.PackageWriter;

public class VTKImageDataReader {
	
	public static void populateVTKImageDataReaders(String wsdlURL, PackageWriter packageWriter){
		
		PackageOperatorService service1 = packageWriter.createNewOperatorService(PackageSource.Resources.vtkImageDataReader3DFloats, PackageSource.Resources.vtkImageDataReader3DFloats);
		service1.setInputFormat(PackageSource.Resources.littleEndianSequence);
		service1.setOutputFormat(Resources.xml);
		service1.setLabel(PackageSource.Resources.vtkImageDataReader3DFloats);
		service1.setComment("Converts 1D array of float values into 3D vtkImageData of float values");
		service1.setWSDLURL(wsdlURL);
		service1.setInputDataType(Resources.array1DFloats);
		service1.setOutputDataType(Resources.vtkImageData3DFloats);
		
		PackageOperatorService service2 = packageWriter.createNewOperatorService(PackageSource.Resources.vtkImageDataReader3DIntegers, PackageSource.Resources.vtkImageDataReader3DIntegers);
		service2.setInputFormat(Resources.littleEndianSequence);
		service2.setOutputFormat(Resources.xml);
		service2.setLabel(PackageSource.Resources.vtkImageDataReader3DIntegers);
		service2.setComment("Convert arrays of integer values into vtkImageData of integer values");
		service2.setWSDLURL(wsdlURL);
		service2.setInputDataType(Resources.array1DIntegers);
		service2.setOutputDataType(Resources.vtkImageData3DIntegers);

		PackageOperatorService service3 = packageWriter.createNewOperatorService(PackageSource.Resources.vtkImageDataReader3DUnsignedShortIntegers, PackageSource.Resources.vtkImageDataReader3DUnsignedShortIntegers);
		service3.setInputFormat(Resources.littleEndianSequence);
		service3.setOutputFormat(Resources.xml);
		service3.setLabel(PackageSource.Resources.vtkImageDataReader3DUnsignedShortIntegers);
		service3.setComment("Convert array of unsigned short integers into vtkImageData of unsigned short integers values");
		service3.setWSDLURL(wsdlURL);
		service3.setInputDataType(Resources.array1DUnsignedShortIntegers);
		service3.setInputDataType(Resources.vtkImageData3DUnsignedShortIntegers);		
	}
}
