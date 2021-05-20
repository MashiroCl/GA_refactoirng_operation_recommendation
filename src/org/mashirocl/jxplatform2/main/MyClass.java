package org.mashirocl.jxplatform2.main;

import java.util.List;

import org.jtool.eclipse.javamodel.JavaField;
import org.jtool.eclipse.javamodel.JavaMethod;

import java.util.ArrayList;

public class MyClass {
	private String className;
	private List<JavaField> field = new ArrayList<JavaField>();
	private List<JavaMethod> method = new ArrayList<JavaMethod>();
	
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className=className;
	}
	
	public List<JavaField> getFields(){
		
		return this.field;
	}
	public void setFields(List<JavaField> field) {
		this.field=field;
	}
	
	public List<JavaMethod> getMethods(){
		return this.method;
	}	
	public void setMethod(List<JavaMethod> method) {
		method=this.method;
	}
	
	
	
}
