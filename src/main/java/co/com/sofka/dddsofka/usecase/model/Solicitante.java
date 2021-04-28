package co.com.sofka.dddsofka.usecase.model;

public class Solicitante {

    private String nombre;
    private Boolean activo;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getActivo() {
        return activo;
    }
}
