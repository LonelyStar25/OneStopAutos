package onestopautos;

import java.sql.*;
import java.util.*;

public abstract class AbstractDAO {

    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/desarrollodeinterfaces";
    private static final String USUARIO = "root";
    private static final String CLAVE = "Pingu3591";

    Connection cn = null;
    Statement stm = null;
    ResultSet rs = null;

    public AbstractDAO() {
        try {
            cn= DriverManager.getConnection(URL, USUARIO, CLAVE);
            stm = cn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
        }
    }
    
    static {
        try {
            Class.forName(CONTROLADOR);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
        }
    }
    
    public abstract ArrayList<Object> recibirDatos();
    
    public abstract void subirDatos(ArrayList<Object> datos);
}
