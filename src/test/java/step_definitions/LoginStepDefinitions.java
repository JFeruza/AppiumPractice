package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;
import pages.LoginPage;

import java.util.Locale;

public class LoginStepDefinitions {

    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();
    @Given("print hello world")
    public void print_hello_world() {

    }

    @Given("user clicks on get started button")
    public void user_clicks_on_get_started_button() {

        loginPage.clickGetStarted();
    }


    @Given("user logs in")
    public void user_logs_in() {
        loginPage.login();
    }


    @When("user searches for {string}")
    public void user_searches_for(String string) {
       homePage.searchFor(string);
    }


    @Then("user verifies that every search result contains {string}")
    public void user_verifies_that_every_search_result_contains(String string) {

       for(String r:homePage.getSearchResultTexts()){
           Assertions.assertTrue(r.toLowerCase().contains(string),
                   "Expected: "+string+", Actual: "+r);
       }

    }




}
