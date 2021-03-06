package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestHelperUtility {
    WebDriver driver;

    /**
     * Page Constructor
     **/
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Page Elements
     **/
    private final String _userName = "username";
    @FindBy(id = _userName)
    private WebElement userName;

    private final String _password = "password";
    @FindBy(id = _password)
    private WebElement password;

    private final String _loginButton = "//div[@class='col-md-8 col-md-offset-4']/button[@type='submit']";
    @FindBy(xpath = _loginButton)
    private WebElement loginButton;

    private final String _rememberMeCheckBox = "//div[@class='checkbox']//input[@type='checkbox']";
    @FindBy(xpath = _rememberMeCheckBox)
    private WebElement rememberMeCheckBox;

    private final String _errorMessage = "//span[@class='help-block']/strong";
    @FindBy(xpath = _errorMessage)
    private WebElement errorMessage;

    private final String _forgotYourPassword = "//div[@class='col-md-8 col-md-offset-4']//a[@class='btn btn-link']";
    @FindBy(xpath = _forgotYourPassword)
    private WebElement forgotYourPassword;

    /**
     * User Action Methods
     **/
    public String getLoginPageTitle() {
        String title = page.getPageTitle(driver);
        return title;
    }

    public void enterUserName(String uname) {
        page.enterText(userName, uname);
    }

    public void enterPassword(String pswd) {
        page.enterText(password, pswd);
    }

    public HomePage clickOnLoginButton() {
        page.clickOnElement(loginButton);
        return new HomePage(driver);
    }

    public void clickOnRememberMeCheckBox() {
        page.clickOnElement(rememberMeCheckBox);
    }

    public boolean rememberMeCheckBoxIsSelected() {
        return page.isSelected(rememberMeCheckBox);
    }

    public String getErrorMessage() {
        return page.getElementText(errorMessage);
    }

    public ResetPasswordPage clickOnForgotPassword() {
        page.clickOnElement(forgotYourPassword);
        return new ResetPasswordPage(driver);
    }
}
