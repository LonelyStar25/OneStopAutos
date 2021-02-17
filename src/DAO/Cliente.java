package DAO;

public class Cliente {

    String DNI, nombre, apellidos, teléfono, domicilio, correo;

    public Cliente(String DNI, String nombre, String apellidos, String teléfono, String domicilio, String correo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.teléfono = teléfono;
        this.domicilio = domicilio;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return DNI + " " + nombre + " " + apellidos + " " + teléfono + " " + domicilio + " " + correo;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getCorreo() {
        return correo;
    }
}
