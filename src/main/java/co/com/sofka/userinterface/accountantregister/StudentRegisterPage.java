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


}

//$x("*//div[contains(concat(' ', @class, ' '), 'option-button-container')]/button")
