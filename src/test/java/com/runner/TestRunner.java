package com.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\$hubhangi\\eclipse-workspace\\swiggy-application\\src\\test\\resources\\Features",
		glue = {"stepDefination"}
		)
public class TestRunner {
	
	/*@AfterClass
	public static void writeReport() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	}*/
	
}
