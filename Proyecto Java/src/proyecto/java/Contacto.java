package proyecto.java;

public class Contacto {

    private String nombres;
    private int edad;
    private int telefono;
    private String correoElectronico;
    private String notas;

    public Contacto(String nombres, int edad, int telefono, String correoElectronico, String notas) {
        this.nombres = nombres;
        this.edad = edad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.notas = notas;
    }

    
    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}