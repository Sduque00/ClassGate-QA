package co.com.sofka.question.acudiente;

import co.com.sofka.question.login.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.userinterface.accountantregister.AccountantRegisterPage.IDENTITY;
import static co.com.sofka.userinterface.accountantregister.AccountantRegisterPage.WELCOME_MESSAGE;
import static co.com.sofka.userinterface.login.LoginPage.LOGIN_VALIDATION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AcudienteQuestion implements Question<Boolean> {
    private String email;

    public AcudienteQuestion(String email){
        this.email = email;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(WELCOME_MESSAGE, isVisible() ).forNoMoreThan(30).seconds()
        );
        return WELCOME_MESSAGE.resolveFor(actor).containsOnlyText(email);
    }
    public AcudienteQuestion is()
    {
        return this;
    }

    public static AcudienteQuestion acudienteQuestion(String email)
    {
        return new AcudienteQuestion(email);
    }
}
