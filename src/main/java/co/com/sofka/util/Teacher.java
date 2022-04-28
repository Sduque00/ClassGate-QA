package co.com.sofka.util;
import com.github.javafaker.Faker;

import java.util.*;

import static com.juanmaya.utilities.Especialidades.*;

public class Teacher {
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String celular;
    private String especialidad;
    private String identificacion;



    private List<String> listaEspecialidades;

    public Teacher()
    {
        Faker falseador = new Faker(new Locale("es_CO"));
        nombre = falseador.name().firstName();
        apellido = falseador.name().lastName();
        correo = falseador.name().username() + "@classgate.com";
        direccion = falseador.address().streetAddress(true);
        celular = String.valueOf( falseador.number().numberBetween(300, 354)) +
                String.valueOf( falseador.number().numberBetween(0, 9999999)) ;
        listaEspecialidades = especialidadAleatoria();
        especialidad = listaEspecialidades.get(0);
        identificacion = "10"+falseador.numerify("########");
    }

    public List<String> especialidadAleatoria()
    {
        List<String> especialidad = new ArrayList<>();
        especialidad.add(TRIGONOMETRIA.getValue());
        especialidad.add(FILOSOFIA.getValue());
        especialidad.add(ESPANOL.getValue());
        especialidad.add(INGLES.getValue());
        especialidad.add(POLITICA.getValue());
        especialidad.add(RELIGION.getValue());
        especialidad.add(FISICA.getValue());
        especialidad.add(QUIMICA.getValue());
        Collections.shuffle(especialidad);
        return especialidad;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    @Override
    public String toString()
    {
        String texto;
        texto = "Nombre Profesor: "+getNombre();
        texto = texto + "\nApellido Profesor: "+ getApellido();
        texto = texto + "\nCorreo Profesor: " + getCorreo();
        texto = texto + "\nDireccion: " +getDireccion();
        texto = texto + "\nCelular: "+getCelular();
        texto = texto + "\nIdentificacion: "+getIdentificacion();
        texto = texto + "\nEspecialidad: "+getEspecialidad();
        return texto;
    }
}
