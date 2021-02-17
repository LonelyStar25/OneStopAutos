package DAO;

import java.lang.reflect.InvocationTargetException;
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
            cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
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

    /**
     * Sube un dato de la clase correspondiente a la tabla correspondiente.
     *
     * @param dato
     */
    public void subirDato(Object dato) {
        ArrayList<Object> datos = new ArrayList<>();
        datos.add(dato);
        subirDatos(datos);
    }

    /**
     * Mi más grande creación. La mejor y más útil función que he hecho nunca.
     * En función de un término de búsqueda cualquiera, devuelve los elementos
     * coincidentes. Puede usarse como término de búsqueda cualquier campo de
     * los datos de la clase en cuestión.
     *
     * @param términoBúsqueda
     * @return resultados
     */
    public ArrayList<Object> buscarDato(String términoBúsqueda) {
        ArrayList<Object> datos = recibirDatos();
        ArrayList<Object> resultados = new ArrayList<>();
        String toString;

        if (!"".equals(términoBúsqueda.trim())) {
            for (Object dato : datos) {
                try {
                    toString = (String) dato.getClass().getMethod("toString").invoke(dato);
                    if (toString.toLowerCase().contains(términoBúsqueda.toLowerCase())) {
                        resultados.add(dato);
                    }
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
                    System.out.println("Esto no debería estar pasando. Échale la culpa a Carmen el desastre con patas");
                }
            }
        }
        return resultados;
    }

    /**
     * buscarDato pero con varios datos. Simple.
     *
     * @param términosBúsqueda
     * @return resultados
     */
    public ArrayList<Object> buscarDatos(String... términosBúsqueda) {
        ArrayList<Object> resultados = new ArrayList<>();

        for (String término : términosBúsqueda) {
            resultados.addAll(buscarDato(término));
        }
        return resultados;
    }
}
