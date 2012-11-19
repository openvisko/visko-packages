package org.openvisko.module.registration;

import java.io.InputStream;
import java.util.Properties;



public abstract class AbstractModuleRDFRegistration {
  private String webappName = "";
	private ModuleWriter packageWriter;
	
	public abstract void populateViewerSets();
	public abstract void populateToolkit();
	public abstract void populateServices();
	public abstract void populateParameterBindings();
	public abstract String getWSDLURL();
	
	public void setPackageWriter(ModuleWriter writer){
		packageWriter = writer;
	}
	
	public ModuleWriter getPackageWriter(){
		return packageWriter;
	}
	
  
  public String getWebappName() {
    return webappName;
  }
  
  public void setWebappName(String webappName) {
    this.webappName = webappName;
  }

  public String getWebServerUrl() {
    
    String url = null;
    
    // Default is to use the module.properties to determine the base URL
    // Child classes can override this method if they would rather use a custom URL
    try {
      Properties packageProps = new Properties();
      InputStream propsFile = getClass().getResourceAsStream("/module.properties");
      packageProps.load(propsFile);
      //module.server.url=http://we20657.pnl.gov:8080
      url = packageProps.getProperty("module.server.url");
          
    } catch (Throwable e) {
      e.printStackTrace();
    }

    return url;
  
  }
}