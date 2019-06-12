package sky.framework.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import sky.framework.pageobjects.HomePage;

import java.util.List;

public class HomePageSteps {

    private HomePage homePage;
    private static WebElement clickedCategory;

    public HomePageSteps(){
        this.homePage = new HomePage();
    }

    @Given("I navigate to skynews homepage")
    public void iNavigateToSkyNewsHomepage() throws Throwable {
        homePage.goToSkyNewsHomepage();
    }

    @And("I see the homepage banner")
    public void iSeeTheHomageBanner(){
        Assert.assertTrue(homePage.isSkyBannerLogoDisplayed());
    }

    @And("I verify the title of the browser tab is '(.*)'")
    public void iVerifyTheTitleOfTheHomepageTab(String title){
        Assert.assertEquals(title, homePage.getHomePageTitle());
    }

    @And("I verify {int} categories are displayed")
    public void iVerifyCategoriesAreDisplayed(int expectedNumberOfCategories){
        Assert.assertEquals(expectedNumberOfCategories, homePage.numberOfCategoriesDisplayed());
    }

    @And("I verify below is list of categories displayed")
    public void iVerifyTheNamesOfTheCategories(List expectedCategoriesToBeDisplayed){
        Assert.assertEquals(expectedCategoriesToBeDisplayed, homePage.listOfCategoriesDisplayed());
    }

    @Then("I verify that the default focus point is on '(.*)' category")
    public void defaultFocusIsOnHomeCategory(String category){
        Assert.assertTrue(homePage.isCategoryFocusedUpon(homePage.findACategory("Home")));
    }

    @And("I click '(.*)' category")
    public void iClickACategory(String category){
        homePage.clickACategory(category);
    }

    @And("I verify that the focus is now on Ocean Rescue")
    public void iVerifyMySelectedCategoryIsFocused(String category){
        Assert.assertTrue(homePage.isCategoryFocusedUpon(homePage.findACategory(category)));
    }

    @Then("I verify I am taken to the correct page")
    public void iVerfyIAmTakenToCorrectPage(){
        Assert.assertTrue(homePage.getDriver().getCurrentUrl().endsWith("/world"));
    }
}
