package org.mashirocl.jxplatform2.main;

import java.util.List;

import org.jtool.eclipse.cfg.builder.JClassExternal;
import org.jtool.eclipse.javamodel.JavaProject;
import org.jtool.eclipse.javamodel.JavaClass;
import org.jtool.eclipse.javamodel.JavaMethod;
import org.jtool.eclipse.javamodel.JavaField;

public class ClassJson {
	private JavaClass jClass;
	private List<JavaField> jFields;
	private List<JavaMethod> jMethods;
	
	
	public String getClassName() {
		return jClass.getName();
	}
	
	public void setClass(JavaClass jClass) {
		this.jClass=jClass;
	}
	
	
	public String getJField() {
		String jField=null;
		try {
			jField=jFields.toString();
			
		}
		catch(Exception e) {
			
		}
		return jField;
	}
	public void setJFields(List<JavaField> jFields) {
		this.jFields=jFields;
	}
	
	public String getJMethod() {
		String jMethod=null;
		int modifiers=0;
		try {
			jMethod=jMethods.toString();
			for (JavaMethod jm:jMethods) {
				modifiers=jm.getModifiers();
			}
		
		}
		catch(Exception e) {
			
		}
//		return jMethod;
		return String.valueOf(modifiers);
	}
	
	public void setJMethod(List<JavaMethod> jMethods) {
		this.jMethods=jMethods;
	}
	
}
