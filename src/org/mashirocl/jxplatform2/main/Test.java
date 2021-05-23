package org.mashirocl.jxplatform2.main;

import java.util.ArrayList;
import java.util.List;

import org.jtool.eclipse.batch.ModelBuilderBatch;
import org.jtool.eclipse.cfg.builder.JClassExternal;
import org.jtool.eclipse.javamodel.JavaProject;
import org.jtool.eclipse.javamodel.JavaClass;
import org.jtool.eclipse.javamodel.JavaMethod;
import org.jtool.eclipse.javamodel.JavaField;
import org.jtool.eclipse.javamodel.JavaLocalVar;


import com.alibaba.fastjson.JSON;

public class Test {
	
	static void jxplatform2() {
		String name="test";			//an arbitrary project name
		String target="/Users/leichen/JAVA/test_code/refactoring-toy-example/src";	//the path of the top directory that contains Java Source files in the project
		String classpath="/Users/leichen/JAVA/test_code/refactoring-toy-example/src"; //the path of the top directory that contains Java class files and/or jar files
		
		
//		String target =args[0];
//		String classpath = args[1];
		
		
		ModelBuilderBatch builderBatch = new ModelBuilderBatch();
		builderBatch.setLogVisible(true);
		JavaProject jproject = builderBatch.build(name, target, classpath);
		
		

		for (JavaClass jclass : jproject.getClasses()){
				String className=jclass.getName();
				List<JavaField> variables=jclass.getFields();
				
				
//				System.out.println("Class name is:"+className);
//				System.out.println("Variables are:"+variables.toString());
				for (JavaMethod jmethod : jclass.getMethods()) {
//					String temp=jmethod.toString();
					String jName=jmethod.getName();
					String returnType=jmethod.getReturnType();
					String jMethod=jmethod.toString();
//					String parameterInfo=jmethod.getParameterInfo();
					List<JavaLocalVar> parameters= jmethod.getParameters();
					String jParameters=parameters.toString();
//					System.out.println("Method is:"+jMethod);
//					System.out.println("parameters are:"+jParameters);

				
				}
				for (JavaField jfield : jclass.getFields()) {
//					jfield.print();
				}
				
		}
		
		
		builderBatch.unbuild();
		
	}
	
	
	static List<ClassJson> getProject(String name, String target,String classpath){
		ModelBuilderBatch builderBatch = new ModelBuilderBatch();
		builderBatch.setLogVisible(true);
		JavaProject jproject = builderBatch.build(name, target, classpath);
		
		
		List<ClassJson> cJList=new ArrayList<ClassJson>();
		
		for(JavaClass jclass:jproject.getClasses()) {	
			ClassJson cJ=new ClassJson();
			cJ.setClass(jclass);
			cJ.setJFields(jclass.getFields());
			cJ.setJMethod(jclass.getMethods());

			cJList.add(cJ);
		}
		return cJList;
	}
	
	
	static String encode(List<ClassJson> cJ) {
		String jsonString = JSON.toJSONString(cJ);
		System.out.println(jsonString);
		return jsonString;
	}

	
	public static void main(String[] args) {
		String name="test";			//an arbitrary project name
		String target="/Users/leichen/JAVA/test_code/refactoring-toy-example/src";	//the path of the top directory that contains Java Source files in the project
		String classpath="/Users/leichen/JAVA/test_code/refactoring-toy-example/src"; //the path of the top directory that contains Java class files and/or jar files
		
		List<ClassJson> cJList=getProject(name,target,classpath);
		String jsonString=encode(cJList);
		
	}

}
