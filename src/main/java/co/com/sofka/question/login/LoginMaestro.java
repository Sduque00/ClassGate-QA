package co.com.sofka.question.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.sofka.userinterface.login.LoginPage.LOGIN_VALIDATION;

public class LoginMaestro implements Question<String> {

    private String email;

    public LoginMaestro(String email) {
        this.email = email;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LOGIN_VALIDATION.of(email)).viewedBy(actor).asString();
    }

    public static LoginMaestro loginMaestroValidation(String email){
        return new LoginMaestro(email);
    }
}
