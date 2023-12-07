package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class LoginPageNegative {
    public class LoginPage {
        public LoginPage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy(name = "email")
        public WebElement email;
        @FindBy(name = "password")
        public WebElement password;
        @FindBy(xpath = "//button[@type='submit']")
        public WebElement loginButtonNeg;

        @FindBy(xpath = "//div[text()='Bad credentials']")
        public WebElement errorMessage;

        @FindBy(xpath = "//div[text()='email must be a valid email']")
        public WebElement invalidEmailMessage;


    }
}
