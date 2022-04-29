package co.com.sofka.task.landingpage;

import co.com.sofka.userinterface.landingpage.LandingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.landingpage.LandingPage.PAQUETE_BASE;

public class OpenLanding implements Task {

    private LandingPage landingPage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Open.browserOn(landingPage),
                Scroll.to(PAQUETE_BASE)
        );
    }

    public static OpenLanding openLanding(){
        return new OpenLanding();
    }
}
