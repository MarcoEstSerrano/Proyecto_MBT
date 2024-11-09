
package proyecto.java;

public class Recordatorios {
    private String descripcion;

    public Recordatorios(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Recordatorio: " + descripcion;
    }
}