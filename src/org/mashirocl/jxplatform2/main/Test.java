package org.mashirocl.jxplatform2.main;

import java.util.ArrayList;
import java.util.List;

import org.jtool.eclipse.batch.ModelBuilderBatch;
import org.jtool.eclipse.cfg.CCFG;
import org.jtool.eclipse.cfg.CFG;
import org.jtool.eclipse.pdg.ClDG;
import org.jtool.eclipse.pdg.PDG;
import org.jtool.eclipse.cfg.builder.JClassExternal;
import org.jtool.eclipse.javamodel.JavaProject;
import org.jtool.eclipse.javamodel.JavaClass;
import org.jtool.eclipse.javamodel.JavaMethod;
import org.jtool.eclipse.javamodel.JavaField;
import org.jtool.eclipse.javamodel.JavaLocalVar;

import java.io.*;

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
//				List<JavaField> variables=jclass.getFields();
//				List<JavaClass> jc_temp=jclass.getChildren();
//				List<JavaClass> jc_temp2=jclass.getAllSuperClasses();
//				
//				System.out.println("_____________________________________________");
//				for (JavaClass jclass2:jc_temp) {
//					System.out.println(jclass2.getName());
//				}
//				for (JavaClass jclass2:jc_temp2) {
//					System.out.println(jclass2.getName());
//				}

				
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
//				for (JavaField jfield : jclass.getFields()) {
//					jfield.print();
//				}
//				
		}
		
		
		builderBatch.unbuild();
		
	}
	
	public static void writeJson(String filePath, String content) throws IOException {
		FileWriter fw = new FileWriter(filePath);
		PrintWriter out= new PrintWriter(fw);
		out.write(content);
		out.println();
		fw.close();
		out.close();
	}
	
	static JavaProject getProject(ModelBuilderBatch builderBatch,String name, String target,String classpath) {
		builderBatch.setLogVisible(true);
		JavaProject jProject = builderBatch.build(name, target, classpath); 
		return jProject;
	}
	
	static List<ClassJson> getClasses(JavaProject jProject){
		
		
		List<ClassJson> cJList=new ArrayList<ClassJson>();
		
		for(JavaClass jclass:jProject.getClasses()) {	
			ClassJson cJ=new ClassJson();
			cJ.setClass(jclass);
			cJ.setJFields(jclass.getFields());
			cJ.setJMethod(jclass.getMethods());
			cJ.setChildren(jclass);
			cJ.setSuperClass(jclass);
	
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
//		String target="/Users/leichen/JAVA/test_code/refactoring-toy-example/src";	//the path of the top directory that contains Java Source files in the project
//		String classpath="/Users/leichen/JAVA/test_code/refactoring-toy-example/src"; //the path of the top directory that contains Java class files and/or jar files
		
		String target="/Users/leichen/JAVA/test_code/CKJM-extended/src";
		String classpath="/Users/leichen/JAVA/test_code/CKJM-extended/src";
				
//		String path="/Users/leichen/Code/jxplatform2Json/RTE.json";
		String path="/Users/leichen/Code/jxplatform2Json/CKJM_EXT.json";
		
		
		ModelBuilderBatch builderBatch = new ModelBuilderBatch();
		
		int classNum=0;
		
		JavaProject jProject=getProject(builderBatch,name,target,classpath);
		List<ClassJson> cJList=getClasses(jProject);
		
			
		
		classNum=cJList.size();
		
		
		String jsonString=encode(cJList);
		
		System.out.println("classNum is "+String.valueOf(classNum));
		

		try {
			writeJson(path,jsonString);
		} catch (IOException e){
			e.printStackTrace();
		}
		
		jxplatform2();
		
		builderBatch.unbuild();
	}

}
