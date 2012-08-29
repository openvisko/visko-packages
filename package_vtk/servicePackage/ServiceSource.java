package package_vtk.servicePackage;

import edu.utep.trustlab.visko.installation.packages.ServicePackage;

public class ServiceSource extends ServicePackage {

	@Override
	public String getWSDLURL() {
		String wsdlURL = "http://iw.cs.utep.edu:8080/toolkits/services/ToolkitServices?wsdl";
		return wsdlURL;
	}

}
