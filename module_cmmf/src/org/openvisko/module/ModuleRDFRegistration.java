package org.openvisko.module;

import org.openvisko.module.registration.AbstractModuleRDFRegistration;
import org.openvisko.module.registration.ModuleOperatorService;
import org.openvisko.module.registration.ModuleWriter;

import edu.utep.trustlab.visko.ontology.pmlp.Format;
import edu.utep.trustlab.visko.ontology.viskoService.Toolkit;
import edu.utep.trustlab.visko.ontology.viskoView.VisualizationAbstraction;
import edu.utep.trustlab.visko.ontology.vocabulary.ViskoV;


public class ModuleRDFRegistration extends AbstractModuleRDFRegistration {

	private static final class Resources{
		//formats
		private static final Format polymesh = ModuleWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/POLYMESH.owl#POLYMESH");
		private static final Format xdmf = ModuleWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/XDMF.owl#XDMF");
		private static final Format gengeo = ModuleWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/GENGEO.owl#GENGEO");
		private static final Format gengeoParams = ModuleWriter.getFormat("https://raw.github.com/nicholasdelrio/visko/master/resources/formats/GENGEOPARAMS.owl#GENGEOPARAMS");
			
		//views
		private static final VisualizationAbstraction mesh = ModuleWriter.getView("https://raw.github.com/nicholasdelrio/visko/master/resources/views/mesh.owl#mesh");
	}
		
		@Override
		public void populateParameterBindings() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void populateServices() {
			String wsdlURL = getWSDLURL();
			
			String operationName = "h5WriteMesh";
			ModuleOperatorService service1 = getPackageWriter().createNewOperatorService(null, operationName);
			service1.setComment(operationName);
			service1.setLabel(operationName);
			service1.setWSDLURL(wsdlURL);
			service1.setInputFormat(Resources.polymesh);
			service1.setOutputFormat(Resources.xdmf);
			service1.setView(Resources.mesh);
			
			operationName = "PolyMesh_py";
			ModuleOperatorService service2 = getPackageWriter().createNewOperatorService(null, operationName);
			service2.setComment(operationName);
			service2.setLabel(operationName);
			service2.setWSDLURL(wsdlURL);
			service2.setInputFormat(Resources.gengeo);
			service2.setOutputFormat(Resources.polymesh);
			
			operationName = "GenGeo";
			ModuleOperatorService service3 = getPackageWriter().createNewOperatorService(null, operationName);
			service3.setComment(operationName);
			service3.setLabel(operationName);
			service3.setWSDLURL(wsdlURL);
			service3.setInputFormat(Resources.gengeoParams);
			service3.setOutputFormat(Resources.gengeo);
		}

		@Override
		public void populateToolkit() {
			Toolkit toolkit = getPackageWriter().createNewToolkit("cmmf");
			toolkit.setComment("Computational Material Modeling Framework");
			toolkit.setLabel("Computational Material Modeling Framework");
		}

		@Override
		public void populateViewerSets() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getWSDLURL() {
			//return "http://visko.pnl.gov/toolkits/services/ToolkitServices?wsdl";
		    String wsdlUrl = getWebServerUrl() + "/" + getWebappName() + "/services/ModuleService?wsdl";
		    return wsdlUrl;
	}
}
