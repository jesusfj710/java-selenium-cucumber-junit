package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjectmodels.HomePage;

public class HomePageSteps {
    private HomePage homepage;

    public HomePageSteps() {
        this.homepage = new HomePage();
    }

    @Given("the user is on the Amazon homepage")
    public void the_user_is_on_the_Amazon_homepage() {
        homepage.open();
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String string) {
        homepage.searchForItem(string);
    }
}
