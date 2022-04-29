package co.com.sofka.question.login;

import co.com.sofka.util.Teacher;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.sofka.userinterface.login.LoginPage.LOGIN_VALIDATION;

public class LoginMaestro implements Question<String> {
    private Teacher teacher;
    private String email = teacher.getCorreo();

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LOGIN_VALIDATION.of(email)).viewedBy(actor).asString();
    }
}
