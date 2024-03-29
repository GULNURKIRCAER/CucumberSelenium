package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {

        String url = ConfigurationReader.get("url");
       // WebDriver driver = Driver.get();  //BUNA GEREK YOK
        Driver.get().get(url); // get to web page (singleton)

    }
    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() throws InterruptedException {

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage(); //it is page object module
        loginPage.login(username,password);
    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {

        BrowserUtils.waitFor(3);

        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);

    }
    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() throws InterruptedException {

        String username = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }
    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {

        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }
    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {

        System.out.println("expectedTitle = " + expectedTitle);
        BrowserUtils.waitFor(2);

        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));

    }
    @Ignore
    //@Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Driver.get().get(ConfigurationReader.get("url"));

        switch (userType.toLowerCase()){
            case "driver":
                the_user_enters_the_driver_information();
                break;
            case "salesmanager":
                the_user_enters_the_sales_manager_information();
                break;
            case "storemanager":
                the_user_enters_the_store_manager_information();
                break;
            default:
                System.out.println("There is not any user in system such as "+userType);

        }


    }


    @Then("the user should be able to click menu button")
    public void theUserShouldBeAbleToClickMenuButton() throws InterruptedException {
        Thread.sleep(10000);

        Driver.get().findElement(By.id("main-menu-toggle")).click();

        Driver.get().findElement(By.xpath("(//i[@class='fa-asterisk menu-icon'])[1]")).click();

    }
}