package co.com.sofka.userinterface.landingpage;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LandingPage extends PageObject {

    public static final Target BTN_INGRESAR = Target
            .the("btn_ingresar")
            .locatedBy("//*[text()=' Ingresar a la plataforma']");
}
