package com.reports;

import java.awt.AWTException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.base.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public  class Reporting  {

	public static void generateJVMReport(String jsonFile) {
			
		//1.Mention the path of JVM Report file-->where to file
		File file = new File("D:\\Workspace\\YourAdactinHotel\\target");
		
		//2.create the object for configuration class
		Configuration configuration = new Configuration(file,"Adactin Automation");
		
		//3.Declare k,v-->Browser,version,os ->for desin purpose
		configuration.addClassifications("Browser","chrome");
		configuration.addClassifications("Browser version","107");
		configuration.addClassifications("os","WIN10");
		configuration.addClassifications("sprint","45");
		
		//4.create the object for report bulider class-->pass
		//List<string>jsonFiles[Read the Results],confiuration class object
		List<String>jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder bulider = new ReportBuilder(jsonFiles, configuration);
		
		//5.Generate the jvm project
		bulider.generateReports();
	
	}
}
