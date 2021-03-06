package co.com.sofka.util;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Accountant {
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String celular;
    private String identificacion;
    private List<Student> hijos;

    public Accountant(int numHijos) {
        Faker falseador = new Faker(new Locale("en_US"));
        nombre = falseador.name().firstName();
        apellido = falseador.name().lastName();
        correo = falseador.name().username() + "@classgate.com";
        direccion = falseador.address().streetAddress(true);
        celular = String.valueOf(falseador.number().numberBetween(300, 354)) +
                String.valueOf(falseador.number().numberBetween(1000000, 9999999));
        identificacion = "10" + falseador.numerify("########");

        hijos = new ArrayList<Student>();
        for(int i = 0; i<numHijos ; i++) {
            hijos.add(new Student(apellido, identificacion));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCelular() {
        return celular;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public List<Student> getHijos() {
        return hijos;
    }

    @Override
    public String toString()
    {
        String texto;
        texto = "Nombre Acudiente: "+getNombre();
        texto = texto + "\nApellido Acudiente: "+ getApellido();
        texto = texto + "\nCorreo Acudiente: " + getCorreo();
        texto = texto + "\nDireccion Acudiente: " +getDireccion();
        texto = texto + "\nCelular Acudiente: "+getCelular();
        texto = texto + "\nIdentificacion Acudiente: "+getIdentificacion();
        return texto;
    }

}
