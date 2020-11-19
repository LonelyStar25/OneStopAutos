package onestopautos;

public class Mecánico extends Usuario {

    boolean esJefe;
    String especialidad;

    public Mecánico(String DNI, String usuario, String contraseña, String nombre,
            String apellido, String NUSS, int sueldoBase, String correo, String profesión,
            boolean esJefe, String especialidad) {
        super(DNI, usuario, contraseña, nombre, apellido, NUSS, sueldoBase, correo, profesión);
        this.esJefe = esJefe;
        this.especialidad = especialidad;
    }

    //los ToString solo están aquí para hacer pruebas
    @Override
    public String toString() {
        return "Mec\u00e1nico{" + "esJefe=" + esJefe + ", especialidad=" + especialidad + '}' + DNI;
    }

}
