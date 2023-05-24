package PageObjects.Account;

import PageObjects.BasePageObject;

import java.util.Map;

public class RegisterPageObject extends BasePageObject {
    public static void fillInNewUserInformation(Map<String, String> customer) {
        String firstNameXPath = "//input[@id='firstname']";
        type(firstNameXPath, customer.get("firstName"));
        String lastNameXPath = "//input[@id='lastname']";
        type(lastNameXPath, customer.get("lastName"));
        String emailXPath = "//input[@id='email_address']";
        type(emailXPath, customer.get("email"));
        String passwordXPath = "//input[@id='password']";
        type(passwordXPath, customer.get("password"));
        String confirmationXPath = "//input[@id='confirmation']";
        type(confirmationXPath, customer.get("password"));
    }

    public static void clickOnRegister() {
        String registerButtonXPath = "//button[.='Register']";
        click(registerButtonXPath);
    }

    public static void verifyRegistration() {
        String successMessageXPath = "//li[@class='success-msg' and .='Thank you for registering with Main Website Store.']";
        waitVisible(successMessageXPath);
    }
}
