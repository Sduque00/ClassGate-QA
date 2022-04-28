package co.com.sofka.userinterface.accountantregister;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class AccountantRegisterPage extends PageObject {

    public static final Target IDENTITY = Target
            .the("id")
            .located(id("acudienteDocumento"));

    public static final Target FULLNAME = Target
            .the("Nombre Acudiente")
            .located(id("acudienteNombre"));

    public static final Target CELULAR = Target
            .the("Celular")
            .located(id("acudienteCelular"));

    public static final Target ADDRESS = Target
            .the("Direccion")
            .located(id("acudienteDireccion"));

    public static final Target EMAIL = Target
            .the("Correo Electronico")
            .located(id("acudienteCorreo"));

    public static final Target REGISTER_ACCOUNTANT = Target
            .the("Registrar Acudiente")
            .locatedBy("//*[text()=' Registrarme como acudiente']");


    public static final Target WELCOME_MESSAGE = Target
            .the("Email Usuario")
            .located(xpath("//*[@id='root']/div[1]/div[2]/span"));

}
