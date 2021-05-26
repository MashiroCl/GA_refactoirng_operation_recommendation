package org.mashirocl.jxplatform2.main;

import java.util.List;
import java.util.ArrayList;

import org.jtool.eclipse.cfg.builder.JClassExternal;
import org.jtool.eclipse.javamodel.JavaProject;
import org.jtool.eclipse.javamodel.JavaClass;
import org.jtool.eclipse.javamodel.JavaMethod;
import org.jtool.eclipse.javamodel.JavaField;
import org.jtool.eclipse.javamodel.JavaLocalVar;

public class ClassJson {
	private JavaClass jClass;
	private List<JavaField> jFields;
	private List<JavaMethod> jMethods;
	private List<MethodJson> mJ;
	
	public String getClassName() {
		
		String classInfo=String.valueOf(jClass.getModifiers())+"#"+jClass.getName();
		return classInfo;
	}
	
	public void setClass(JavaClass jClass) {
		this.jClass=jClass;
	}
	
	
	public List<String> getJField() {
		List<String> fieldList=new ArrayList<String>();
		try {
			for(JavaField jF:jFields) {
				fieldList.add(String.valueOf(jF.getModifiers())+"#"+jF.toString().split("\nFIELD: ")[1]);
			}
			
			
		}
		catch(Exception e) {
		}
		
		return fieldList;
	}
	public void setJFields(List<JavaField> jFields) {
		this.jFields=jFields;
	}
	
	public List<String> getJMethod() {
		List<String> jMethod = new ArrayList<String>();
		int modifier=0;

		try {
			for(JavaMethod jM:jMethods) {
				modifier=jM.getModifiers();
//				jMethod.add(String.valueOf(modifier));
//				jMethod.add(jM.toString().split("\\nMETHOD: ")[1]);

				String temp=String.valueOf(modifier)+"@"+jM.getName()+"()@"+jM.getReturnType();
				
				for (JavaLocalVar jV:jM.getParameters()) {

					temp=temp+"#"+jV.toString().split("\n")[1];
				}
				jMethod.add(temp);
				
			}

		
		}
		catch(Exception e) {
			
		}
		return jMethod;

	}
	
//	public List<String> getmJ(){
//		List<String> test =new ArrayList<String>();
//		for(MethodJson mJ:this.mJ) {
//			test.add(mJ.getModifier());
//			test.add(mJ.getMethod());
//			test.add(mJ.getParameter());
//		}
//		
//		return test;
//	}
//	
//	public void setmJ(List<JavaMethod> jMethods) {
//		this.mJ=new ArrayList<MethodJson>();
//		for(JavaMethod jM:jMethods) {
//			MethodJson mJ=new MethodJson(jM);
//			this.mJ.add(mJ);
//		}
//	}
//	
	public void setJMethod(List<JavaMethod> jMethods) {
		this.jMethods=jMethods;
	}
	
}
