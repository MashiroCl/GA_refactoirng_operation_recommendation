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
	private List<JavaClass> superClass;
	private List<JavaClass> children;
	
//	public ClassJson(JavaClass jc) {
//		this.jClass=jc;
//		this.jFields=jc.getFields();
//		this.jMethods=jc.getMethods();
//		this.superClass=jc.getAllSuperClasses();
//		this.children=jc.getChildren();
//	}
	
	
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
	
	public void setJMethod(List<JavaMethod> jMethods) {
		this.jMethods=jMethods;
	}
	
	public void setSuperClass(JavaClass jclass) {
		this.superClass=jclass.getAllSuperClasses();
	}
	public List<String> getSuperClass(){
		List<String> temp=new ArrayList<String>();
		for (JavaClass jc:this.superClass) {
			ClassJson cj=new ClassJson();
			cj.setClass(jc);
			try {
			temp.add(cj.getClassName());
			}catch (Exception e)
			{}
		}
		return temp;
	}
	
	public void setChildren(JavaClass jclass) {
		this.children=jclass.getChildren();
	}
	public List<String> getChildren(){
		List<String> temp=new ArrayList<String>();
		for (JavaClass jc:this.children) {
			ClassJson cj=new ClassJson();
			cj.setClass(jc);
			try {
			temp.add(cj.getClassName());
			}catch (Exception e)
			{}
		}
		return temp;
	}
}
