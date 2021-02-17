package DAO;

public class Usuario extends UsuarioLogin {

    String nombre, apellidos, NUSS, correo, profesión, DNI;
    int sueldoBase;

    public Usuario(String DNI, String usuario, String contraseña, String nombre,
            String apellido, String NUSS, int sueldoBase, String correo, String profesión) {
        super(usuario, contraseña);
        this.nombre = nombre;
        this.apellidos = apellido;
        this.NUSS = NUSS;
        this.correo = correo;
        this.profesión = profesión;
        this.DNI = DNI;
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " " + NUSS + " " + correo + " " + profesión
                + " " + DNI + " " + sueldoBase + " " + usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNUSS() {
        return NUSS;
    }

    public String getCorreo() {
        return correo;
    }

    public String getProfesión() {
        return profesión;
    }

    public String getDNI() {
        return DNI;
    }

    public int getSueldoBase() {
        return sueldoBase;
    }
}
