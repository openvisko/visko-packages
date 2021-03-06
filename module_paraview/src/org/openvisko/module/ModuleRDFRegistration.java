package org.openvisko.module;

import org.openvisko.module.registration.AbstractModuleRDFRegistration;
import org.openvisko.module.registration.ModuleViewerSet;
import org.openvisko.module.registration.ModuleWriter;

import com.hp.hpl.jena.ontology.OntResource;

import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.viskoService.Toolkit;
import edu.utep.trustlab.visko.ontology.viskoView.VisualizationAbstraction;
import edu.utep.trustlab.visko.ontology.vocabulary.ViskoV;

import edu.utep.trustlab.visko.ontology.viskoOperator.Viewer;


public class ModuleRDFRegistration extends AbstractModuleRDFRegistration {

	private static final class Resources{
		//formats
		private static final Format xdmf = ModuleWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/XDMF.owl#XDMF");
	}
	
  @Override
   public void populateViewerSets() {
		ModuleViewerSet viewerSet = getPackageWriter().createNewViewerSet("paraview");
		viewerSet.setComment("Kitware Paraview");
		viewerSet.setLabel("Kitware Paraview");
		
		Viewer viewer1 = viewerSet.createNewViewer("xdmf-viewer");
		viewer1.setComment("XDMF Viewer of the ParaView Distribution");
		viewer1.setLabel("XDMF Viewer");
		viewer1.addInputFormat(Resources.xdmf);
  }
	
  @Override
  public void populateToolkit() {
		Toolkit toolkit = getPackageWriter().createNewToolkit("paraview");
		toolkit.setComment("Kitware ParaView");
		toolkit.setLabel("ParaView");
  }

  @Override
  public void populateServices() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void populateParameterBindings() {
    // TODO Auto-generated method stub
    
  }

  /***
   * Child classes can override this method if they want to hard code a specific
   * URL instead of using the URL generated by the build.
   * @see org.openvisko.module.registration.AbstractModuleRDFRegistration#getWSDLURL()
   */
  @Override
  public String getWSDLURL() {
    String wsdlUrl = getWebServerUrl() + "/" + getWebappName() + "/services/ModuleService?wsdl";
    return wsdlUrl;
  }


}
