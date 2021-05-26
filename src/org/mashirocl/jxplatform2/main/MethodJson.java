package org.mashirocl.jxplatform2.main;

import java.util.ArrayList;

import org.jtool.eclipse.javamodel.JavaMethod;



public class MethodJson {
	private String modifier;
	private String method;
	private String parameter;
	private String test="123";
	private JavaMethod jM;
	
	public MethodJson(JavaMethod jM) {
		this.jM=jM;
	}
	
	public String getModifier() {
//		return this.modifier;
		return "modifier";
	}
	public String getMethod() {
//		return this.method;
		return "method";
	}
	public String getParameter() {
		return "parameters";

	}
	
}
