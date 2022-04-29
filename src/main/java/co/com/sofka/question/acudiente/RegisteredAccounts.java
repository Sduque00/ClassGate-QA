package co.com.sofka.question.acudiente;

import co.com.sofka.util.Accountant;
import co.com.sofka.util.Student;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.userinterface.accountantregister.AccountantRegisterPage.WELCOME_MESSAGE;
import static co.com.sofka.userinterface.accountantregister.StudentRegisterPage.LOOKFOR_FIRSSON;
import static co.com.sofka.userinterface.accountantregister.StudentRegisterPage.LOOKFOR_SECONDSON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisteredAccounts implements Question<String> {
    private Accountant account;
    private Student firstSon;
    private Student secondSon;
    private Student thirdSon;

    public RegisteredAccounts(){
    }

    public RegisteredAccounts withAccount(Accountant account) {
        this.account = account;
        return this;
    }

    public RegisteredAccounts andFirstSon(Student son) {
        this.firstSon = son;
        return this;
    }

    public RegisteredAccounts andSecondSon(Student son) {
        this.secondSon = son;
        return this;
    }

    public RegisteredAccounts andThirdSon(Student son) {
        this.thirdSon = son;
        return this;
    }

    @Override
    public String answeredBy(Actor actor) {
        String response;
        String name1 = firstSon.getNombre() + " "+firstSon.getApellido();
        String name2 = secondSon.getNombre() + " "+secondSon.getApellido();

        response =   Text.of(LOOKFOR_FIRSSON.of(name1)).viewedBy(actor).asString();
        response = response + " " + Text.of(LOOKFOR_SECONDSON.of(name2)).viewedBy(actor).asString();
       return response;
    }
    public RegisteredAccounts is()
    {
        return this;
    }

    public static RegisteredAccounts registeredAccounts()
    {
        return new RegisteredAccounts();
    }
}
