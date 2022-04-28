package co.com.sofka.util;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Student {
    private String nombre;
    private String apellido;
    private String Edad;
    private String identificacion;
    private String identificacionAcudiente;

    public Student(String apellido, String identificacionAcudiente)
    {
        Faker falseador = new Faker(new Locale("en_US"));
        this.identificacionAcudiente = identificacionAcudiente;
        this.apellido = apellido;
        this.nombre = falseador.name().firstName();
        this.Edad = String.valueOf(falseador.number().numberBetween( 8, 16));
        this.identificacion = "10" + falseador.numerify("########");
    }
}
