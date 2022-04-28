package co.com.sofka.task.acudiente;

import co.com.sofka.util.Accountant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.userinterface.accountantregister.AccountantRegisterPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillAccountantRegisterForm implements Task {
    private String identificacion;
    private String nombre;
    private String celular;
    private String direccion;
    private String email;



    public FillAccountantRegisterForm withId(String id) {
        this.identificacion = id;
        return this;
    }

    public FillAccountantRegisterForm andName(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public FillAccountantRegisterForm andCellphone(String celular) {
        this.celular = celular;
        return this;
    }

    public FillAccountantRegisterForm andAddress(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public FillAccountantRegisterForm andEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(IDENTITY, isVisible() ).forNoMoreThan(30).seconds()
        );
        actor.attemptsTo(

                //WaitUntil.the(IDENTITY, isVisible() ).forNoMoreThan(20).seconds(),
                Scroll.to(IDENTITY),
                //Click.on(IDENTITY),
                Enter.theValue(identificacion).into(IDENTITY),

                //WaitUntil.the(FULLNAME, isVisible() ).forNoMoreThan(20).seconds(),
                Scroll.to(FULLNAME),
                //Click.on(FULLNAME),
                Enter.theValue(nombre).into(FULLNAME),

                //WaitUntil.the(CELULAR, isVisible() ).forNoMoreThan(20).seconds(),
                Scroll.to(CELULAR),
                //Click.on(CELULAR),
                Enter.theValue(celular).into(CELULAR),

                //WaitUntil.the(ADDRESS, isVisible() ).forNoMoreThan(20).seconds(),
                Scroll.to(ADDRESS),
                //Click.on(ADDRESS),
                Enter.theValue(direccion).into(ADDRESS),

                //WaitUntil.the(EMAIL, isVisible() ).forNoMoreThan(20).seconds(),
                Scroll.to(EMAIL),
                //Click.on(EMAIL),
                Enter.theValue(email).into(EMAIL),

                //WaitUntil.the(REGISTER_ACCOUNTANT, isVisible() ).forNoMoreThan(20).seconds(),
                //Scroll.to(REGISTER_ACCOUNTANT),
                Click.on(REGISTER_ACCOUNTANT)
        );
    }

    public static FillAccountantRegisterForm fillAccountantRegisterForm()
    {
        return new FillAccountantRegisterForm();
    }
}
