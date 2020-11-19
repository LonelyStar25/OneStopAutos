package onestopautos;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends AbstractDAO {

    /**
     * Devuelve true si el usuario existe y la contraseña es correcta, o false
     * si no. Las contraseñas son case-sensitive, los nombres de usuario no.
     *
     * @param usuario
     * @return boolean
     */
    public boolean comprobarUsuario(UsuarioLogin usuario) {
        try {
            rs = stm.executeQuery("select usuario, contraseña from desarrollodeinterfaces.usuario");
            while (rs.next()) {
                if (rs.getString(1).toLowerCase().equals(usuario.usuario.toLowerCase()) && rs.getString(2).equals(usuario.contraseña)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return false;
    }

    /**
     * Crea un array de usuarios con los datos de la tabla usuarios de la base
     * de datos.
     *
     * @return array de usuarios
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosUsuarios = new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.usuario");
            while (rs.next()) {
                datosUsuarios.add(new Usuario(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),
                        rs.getString(8), rs.getString(9)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosUsuarios;
    }

    /**
     * Crea un array de mecánicos con los datos de las tablas usuarios y
     * mecánicos de la base de datos.
     *
     * @return array de mecánicos
     */
    public ArrayList<Object> recibirDatosMecánicos() {
        ArrayList<Object> datosUsuarios = recibirDatos();
        ArrayList<Object> datosMecánicos = new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.mecánico");
            while (rs.next()) {
                for (Object dato : datosUsuarios) {
                    Usuario usuario = (Usuario) dato;
                    if (rs.getString(1).equals(usuario.DNI)) {
                        datosMecánicos.add(new Mecánico(usuario.DNI, usuario.usuario, usuario.contraseña,
                                usuario.nombre, usuario.apellidos, usuario.NUSS, usuario.sueldoBase,
                                usuario.correo, usuario.profesión, rs.getBoolean(2), rs.getString(3)));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosMecánicos;
    }

    /**
     * Inserta los datos pasados como parámetro en la tabla usuarios de la BD.
     *
     * @param datos
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        try {
            for (Object dato : datos) {
                Usuario datoUsuario = (Usuario) dato;
                stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`usuario` "
                        + "(`DNI_Usuario`, `Usuario`, `Contraseña`, `Nombre`, `Apellidos`, "
                        + "`NUSS`, `SueldoBase`, `Correo`, `Profesión`) VALUES ('" + datoUsuario.DNI + "', '"
                        + datoUsuario.usuario + "', '" + datoUsuario.contraseña + "', '" + datoUsuario.nombre
                        + "', '" + datoUsuario.apellidos + "', '" + datoUsuario.NUSS + "', "
                        + datoUsuario.sueldoBase + ", '" + datoUsuario.correo + "', '" + datoUsuario.profesión + "');");
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }

}
