package com.qa.assessmentTesting;

import org.junit.runner.RunWith;

import com.qa.assessmentTesting.Const;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = Const.FEATURES_PATH)
public class StackRunner {
	
	static public ExtentReports report = new ExtentReports(Const.REPORT_PATH + "assessment.html", true);

}