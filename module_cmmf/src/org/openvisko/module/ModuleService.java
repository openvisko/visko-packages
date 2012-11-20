package org.openvisko.module;

import javax.jws.WebParam;

public class ModuleService {

  // TODO: add your own methods here
  // use the @WebParam(name="xxx") annotation to declare parameters
  // for your service methods

	//cmmf services
	public String GenGeo(
			@WebParam(name="url") String url,
			@WebParam(name="jobname") String jobname,
			@WebParam(name="ngrains") String ngrains,
			@WebParam(name="scale") String scale
			){
		GenGeo service = new GenGeo(url);
		return service.transform(jobname, ngrains, scale);
	}
	
	public String PolyMesh_py(
			@WebParam(name="url") String url,
			@WebParam(name="cel") String cel,
			@WebParam(name="mid") String mid,
			@WebParam(name="edge") String edge			
			){
		PolyMesh_py service = new PolyMesh_py(url);
		return service.transform(cel, mid, edge);
	}
	
	public String h5WriteMesh(@WebParam(name="url") String url)
	{
		H5WriteMesh service = new H5WriteMesh(url);
		return service.transform();
	}
	
}
