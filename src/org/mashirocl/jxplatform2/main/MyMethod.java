package org.mashirocl.jxplatform2.main;

import java.util.List;

import org.jtool.eclipse.javamodel.JavaLocalVar;

import java.util.ArrayList;

public class MyMethod {
	private String methodName;
	private List<JavaLocalVar> parameters;
	
//	public MyMethod(String methodName, List<String> parameters) {
//		this.methodName= methodName;
//		this.parameters=parameters;
//	}
//	
	public String getMethodName() {
		return this.methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName=methodName;
	}
	
	public List<JavaLocalVar> getParameters(){
			return this.parameters;
	}
	
	public void setParameters(List<JavaLocalVar> parameters) {
		this.parameters=parameters;
	}
	

//	private List<List> divideParameter(){
//		List<String> parameterName= new ArrayList<String>();
//		List<String> parameterType= new ArrayList<String>();
//		for (String s:this.parameters) {
//			String [] temp=s.split("PARAMETER : ");
//			s=temp[1];
//			temp=s.split("@");
//			parameterName.add(temp[0]);
//			parameterType.add(temp[1]);
//		}
//		List<List> parameter=new ArrayList<List>();
//		parameter.add(parameterName);
//		parameter.add(parameterType);
//		
//		return parameter;
//	}
//	
//	public List<String> getParametersName(){
//		List<List> parameter=this.divideParameter();
//		List<String> name=parameter.get(0);
//		return name;
//	}
//		
//	public List<String> getParametersType(){
//		List<List> parameter=this.divideParameter();
//		List<String> type=parameter.get(1);
//		return type;
//	}
	
}
