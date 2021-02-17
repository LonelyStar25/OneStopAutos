package DAO;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.security.*;

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
                /*byte[] bytesOfMessage = usuario.contraseña.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] digest = md.digest(bytesOfMessage);
                
                if (rs.getString(1).toLowerCase().equals(usuario.usuario.toLowerCase()) 
                        && rs.getString(2).trim().equals(Arrays.toString(digest).trim())) { //funciona así y solo así, a saber por qué
                    return true;
                }*/
                
                if (rs.getString(1).toLowerCase().equals(usuario.usuario.toLowerCase()) 
                        && rs.getString(2).equals(usuario.contraseña)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        } /*catch (UnsupportedEncodingException ex) {
            System.out.println("Oh no, pero en hash");
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Esto no sé ni por qué salta");
        }*/
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
                datosUsuarios.add(new Usuario(rs.getString(1), rs.getString(2), null,
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
    public ArrayList<Mecánico> recibirDatosMecánicos() {
        ArrayList<Object> datosUsuarios = recibirDatos();
        ArrayList<Mecánico> datosMecánicos = new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.mecánico");
            while (rs.next()) {
                for (Object dato : datosUsuarios) {
                    Usuario usuario = (Usuario) dato;
                    if (rs.getString(1).equals(usuario.DNI)) {
                        datosMecánicos.add(new Mecánico(usuario.DNI, usuario.usuario, null,
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
     * Además, si el usuario en cuestión es un mecánico, actualiza la tabla
     * Mecánico. Acepta elementos de ambas clases: Usuario y Mecánico.
     *
     * @param datos
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        Usuario datoUsuario = null;
        Mecánico datoMecánico = null;
        boolean esMecánico = false;

        try {
            for (Object dato : datos) {
                if (dato.getClass() == Class.forName("onestopautos.Mecánico")) {
                    esMecánico = true;
                    datoUsuario = (Mecánico) dato;
                    datoMecánico = (Mecánico) dato;
                } else if (dato.getClass() == Class.forName("onestopautos.Usuario")) {
                    datoUsuario = (Usuario) dato;
                }

                byte[] bytesOfMessage = datoUsuario.contraseña.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] digest = md.digest(bytesOfMessage);

                stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`usuario` "
                        + "(`DNI_Usuario`, `Usuario`, `Contraseña`, `Nombre`, `Apellidos`, "
                        + "`NUSS`, `SueldoBase`, `Correo`, `Profesión`) VALUES ('" + datoUsuario.DNI + "', '"
                        + datoUsuario.usuario + "', '" + Arrays.toString(digest) + "', '" + datoUsuario.nombre
                        + "', '" + datoUsuario.apellidos + "', '" + datoUsuario.NUSS + "', "
                        + datoUsuario.sueldoBase + ", '" + datoUsuario.correo + "', '" + datoUsuario.profesión + "');");
                if (esMecánico) {
                    stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`mecánico` "
                            + "(`DNI_Usuario`, `Es_Jefe`, `Especialidad`) VALUES ('" + datoUsuario.DNI + "', "
                            + datoMecánico.esJefe + ", '" + datoMecánico.especialidad + "');");
                }
                esMecánico = false;
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        } catch (ClassNotFoundException ex) {
            System.out.println("No me metas arrays de cosas raras");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Oh no, pero en hash");
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Esto no sé ni por qué salta");
        }
    }

}
