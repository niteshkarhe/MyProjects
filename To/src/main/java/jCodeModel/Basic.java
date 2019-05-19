package jCodeModel;

import java.io.File;
import java.io.IOException;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JPackage;

public class Basic 
{
	public static void main(String[] args) 
	{
		JCodeModel codeModel = new JCodeModel();
		JPackage jp = codeModel._package("com.sookocheff.example");
		try 
		{
			JDefinedClass jc = jp._class("Generated");
			JDefinedClass jc1 = jp._class("Generated");
			 codeModel.build(new File("src/main/java/"));
		} 
		catch (JClassAlreadyExistsException | IOException e) 
		{
			e.printStackTrace();
		}
	}
}
