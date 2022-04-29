package co.com.sofka.question.landing;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.sofka.userinterface.landingpage.LandingPage.PAQUETE_BASE;

public class Landing implements Question {

    public String answeredBy(Actor actor) {
        return Text.of(PAQUETE_BASE).viewedBy(actor).asString();
    }

    public static Landing landingValidation(){
        return new Landing();
    }
}
