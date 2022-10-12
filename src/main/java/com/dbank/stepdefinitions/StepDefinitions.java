package com.dbank.stepdefinitions;

import java.io.IOException;

import com.dbank.libraries.LIB_NaceDetails;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	LIB_NaceDetails lib_NaceDetails = new LIB_NaceDetails();

	@Given("I GET the details for NACE {string}")
	public void i_GET_the_details_for_NACE(String NACECode) {
		lib_NaceDetails.getNACEDetails(NACECode);
	}

	@When("search is executed successfully {string}")
	public void search_is_executed_successfully(String NACECode) {
		lib_NaceDetails.searchIsExecutedSuccessfully(NACECode);
	}

	@Then("I validate the NACE details for {string} {string}")
	public void i_validate_the_NACE_details_for(String fileName,String NACECode) throws IOException {
		lib_NaceDetails.validateJsonBody(fileName,NACECode);
	}
}
