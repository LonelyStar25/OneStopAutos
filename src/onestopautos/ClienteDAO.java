package onestopautos;

import java.sql.*;
import java.util.*;

public class ClienteDAO extends AbstractDAO{

    /**
     * Crea un array de clientes con los datos de la tabla clientes de la base de datos.
     * 
     * @return array de clientes
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosClientes= new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.cliente");
            while(rs.next()){
                datosClientes.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosClientes;
    }

    /**
     * Inserta los datos pasados como parámetro en la tabla clientes de la BD.
     * 
     * @param datos 
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        try {
            for (Object dato : datos){
                Cliente datoCliente=(Cliente)dato;
            stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`cliente` "
                    + "(`DNI_Cliente`, `Nombre`, `Apellidos`, "
                    + "`Teléfono`, `Domicilio`, `Correo`) VALUES ('"+datoCliente.DNI+"', '"+datoCliente.nombre+
                    "', '"+datoCliente.apellidos+"', '"+datoCliente.teléfono+"', '"+
                    datoCliente.domicilio+"', '"+datoCliente.correo+"');");
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
}
