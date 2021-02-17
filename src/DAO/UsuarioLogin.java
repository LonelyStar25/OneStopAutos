package DAO;

public class UsuarioLogin {
    String usuario, contraseña;

    public UsuarioLogin(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
}
