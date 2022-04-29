package co.com.sofka.util;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Student {
    private String nombre;
    private String apellido;
    private String Edad;
    private String identificacion;
    private String identificacionAcudiente;
    private String grupo;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEdad() {
        return Edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getIdentificacionAcudiente() {
        return identificacionAcudiente;
    }

    public String getGrupo() {
        return grupo;
    }

    public Student(String apellido, String identificacionAcudiente)
    {
        Faker falseador = new Faker(new Locale("en_US"));
        String letraGrupo;
        int letraInt = falseador.number().numberBetween( 65, 70);
        letraGrupo = String.valueOf(Character.toChars(letraInt));
        this.identificacionAcudiente = identificacionAcudiente;
        this.apellido = apellido;
        this.nombre = falseador.name().firstName();
        this.Edad = String.valueOf(falseador.number().numberBetween( 8, 16));
        this.identificacion = "10" + falseador.numerify("########");
        this.grupo = String.valueOf(falseador.number().numberBetween(1,11));
    }

}
