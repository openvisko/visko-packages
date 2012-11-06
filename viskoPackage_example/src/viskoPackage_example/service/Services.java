package viskoPackage_example.service;

import javax.jws.WebParam;

import viskoPackage_example.service.operators.ExampleOperator_PureJava;
import viskoPackage_example.service.operators.ExampleOperator_WrappedExecutable;

public class Services {

	public String exampleOperator_PureJava(
			@WebParam(name="url") String url,
			@WebParam(name="param1")String param1,
			@WebParam(name="param2")String param2,
			@WebParam(name="param3")String param3){
				
		ExampleOperator_PureJava operator = new ExampleOperator_PureJava(url);
		return operator.transform(param1, param2, param3);
	}
	
	public String exampleOperator_WrappedExecutable(
			@WebParam(name="url") String url,
			@WebParam(name="param1")String param1,
			@WebParam(name="param2")String param2,
			@WebParam(name="param3")String param3){
				
		ExampleOperator_WrappedExecutable operator = new ExampleOperator_WrappedExecutable(url);
		return operator.transform(param1, param2, param3);
	}
}
