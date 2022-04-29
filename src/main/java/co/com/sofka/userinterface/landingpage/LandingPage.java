package co.com.sofka.userinterface.landingpage;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LandingPage extends PageObject {

    public static final Target BTN_INGRESAR = Target
            .the("btn_ingresar")
            .locatedBy("//*[text()=' Ingresar a la plataforma']");

    public static final Target PAQUETE_BASE = Target
            .the("pqt_base")
            .locatedBy("//*[@id='root']/div[2]/div[2]/div/div[5]/div[1]/h1");

    public static final Target SOFTWARE = Target
            .the("software")
            .locatedBy("//*[@id='root']/div[2]/div[2]/div/div[2]/div/h1");
}
