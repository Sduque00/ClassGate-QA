package co.com.sofka.util;

public enum Especialidades {
    TRIGONOMETRIA("Trigonometria"),
    FILOSOFIA("Filosofía"),
    ESPANOL("Español y Literatura"),
    INGLES("Inglés"),
    POLITICA("Política y Economía"),
    RELIGION("Religión"),
    FISICA("Física"),
    QUIMICA("Química");


    private String value;

    Especialidades(String value)
    {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
