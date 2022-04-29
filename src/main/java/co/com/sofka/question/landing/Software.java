package co.com.sofka.question.landing;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static co.com.sofka.userinterface.landingpage.LandingPage.SOFTWARE;

public class Software implements Question {
    public String answeredBy(Actor actor) {
        return Text.of(SOFTWARE).viewedBy(actor).asString();
    }

    public static Software softwareValidation(){
        return new Software();
    }
}
