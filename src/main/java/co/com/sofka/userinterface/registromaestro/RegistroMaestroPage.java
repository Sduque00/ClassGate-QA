package co.com.sofka.userinterface.registromaestro;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class RegistroMaestroPage extends PageObject {

    public static final Target BTN_RegistroMaestro = Target
            .the("Btn Registro Maestro")
            .locatedBy("//*[text()=' Registrarme como maestro ']");

    public static final Target EMAIL = Target
            .the("Email")
            .located(By.id("inputUsername"));

    public static final Target DIRECCION = Target
            .the("Direccion")
            .located(By.id("inputDireccion"));

    public static final Target CONTRASEÑA = Target
            .the("Contraseña")
            .located(By.id("inputPassword"));

    public static final Target CELULAR = Target
            .the("Celular")
            .located(By.id("inputCelular"));

    public static final Target NOMBRE = Target
            .the("Nombre")
            .located(By.id("inputName"));

    public static final Target ESPECIALIDAD = Target
            .the("Especialidad")
            .located(By.id("inputEspecialidad"));

    public static final Target DOCUMENTO= Target
            .the("Documento")
            .located(By.id("inputDocumento"));

    public static final Target BTN_SUBMIT= Target
            .the("Btn submit")
            .locatedBy("//*[@id='root']/div[2]/form/button");

    public static final Target BTN_CERRAR_SESION= Target
            .the("Btn cerrar sesion")
            .locatedBy("id:btn-cerrar-sesion");

}
