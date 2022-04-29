package co.com.sofka.userinterface.accountantregister;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class StudentRegisterPage extends PageObject {

    public static final Target LOOKFOR_ACCOUNTANT = Target
            .the("Nombre Acudiente")
            .located(id("search"));

    public static final Target ADD_STUDENTS = Target
            .the("Anadir Estudiantes")
            .located(xpath("*//div[contains(concat(' ', @class, ' '), 'option-button-container')]/button"));

    public static final Target STUDENT_ID = Target
            .the("Identificacion Estudiante")
            .located(id("estudianteDocId"));

    public static final Target STUDENT_NAME = Target
            .the("Nombre Estudiante")
            .located(id("estudianteName"));

    public static final Target STUDENT_GROUP = Target
            .the("Grupo Estudiante")
            .located(id("estudianteGrado"));

    public static final Target STUDENT_AGE = Target
            .the("Edad Estudiante")
            .located(id("estudianteEdad"));

    public static final Target REGISTER_STUDENT = Target
            .the("Registrar Estudiante")
            .locatedBy("//*[text()= 'Agregar' ]");

    public static final Target SAVE_STUDENT = Target
            .the("Registrar Estudiante")
            .locatedBy("//*[@id='root']/div[3]/div[2]/div[2]/div/div[2]/button");

    public static final Target CLEAR_LOOKFOR = Target
            .the("Limpiar Acudientes")
            .located(xpath("//*[@id=\"root\"]/div[3]/div[2]/div[1]/div/header/button"));

    public static final Target LOOKFOR_FIRSSON = Target
            .the("primer hijo")
            .locatedBy("//*[text()='{0}']");

    public static final Target LOOKFOR_SECONDSON = Target
            .the("segundo hijo")
            .locatedBy("//*[text()='{0}']");

    public static final Target LOOKFOR_THIRDSON = Target
            .the("tercer hijo")
            .locatedBy("//*[text()='{0}']");

}

//$x("*//div[contains(concat(' ', @class, ' '), 'option-button-container')]/button")
