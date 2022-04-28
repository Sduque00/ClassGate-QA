package co.com.sofka.userinterface.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.*;

public class LoginPage extends PageObject {

    public static final Target USERNAME = Target
            .the("UserName")
            .located(id("inputUsername"));

    public static final Target PASSWORD = Target
            .the("Password")
            .located(id("inputPassword"));

    public static final Target SUBMIT = Target
            .the("Submit")
            .located(xpath("//*[@id='root']/div[2]/form/button"));


    //For validations.
    public static final Target LOGIN_VALIDATION= Target
            .the("Login_Validation")
            .locatedBy("//*[text()='{0}']");
}
