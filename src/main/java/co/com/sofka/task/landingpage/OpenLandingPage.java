package co.com.sofka.task.landingpage;

import co.com.sofka.userinterface.landingpage.LandingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.userinterface.landingpage.LandingPage.BTN_INGRESAR;

public class OpenLandingPage implements Task {

    private LandingPage landingPage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Open.browserOn(landingPage),
                WaitUntil.the(BTN_INGRESAR, isVisible() ).forNoMoreThan(20).seconds(),
                Click.on(BTN_INGRESAR)
        );
    }

    public static OpenLandingPage openLandingPage(){
        return new OpenLandingPage();
    }

}
