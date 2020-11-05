
package onestopautos;

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
        return "Cliente{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", tel\u00e9fono=" + teléfono + ", domicilio=" + domicilio + ", correo=" + correo + '}';
    }
}
