package co.com.sofka.question.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.sofka.userinterface.login.LoginPage.LOGIN_VALIDATION;

public class Login implements Question<String> {

    private String email;

    public Login(String email) {
        this.email = email;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LOGIN_VALIDATION.of(email)).viewedBy(actor).asString();
    }

    public static Login loginValidation(String email) {
        return new Login(email);
    }
}
