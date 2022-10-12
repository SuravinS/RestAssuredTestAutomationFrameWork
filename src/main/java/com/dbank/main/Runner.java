package com.dbank.main;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	features="src/main/resources/features/naceListValidation/NaceDetails.feature",
	glue={"com.dbank.stepdefinitions"}
)

public class Runner extends AbstractTestNGCucumberTests {

}
