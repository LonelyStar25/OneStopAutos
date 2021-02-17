package DAO;

import java.sql.*;
import java.util.*;

public class PropuestaDAO extends AbstractDAO{

    /**
     * Crea un array de propuestas con los datos de la tabla propuestas de la base de datos.
     * 
     * @return array de propuestas
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosPropuestas= new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.propuesta");
            while(rs.next()){
                datosPropuestas.add(new Propuesta(rs.getString(1), rs.getInt(2)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosPropuestas;
    }

    /**
     * Inserta los datos pasados como parámetro en la tabla propuestass de la BD.
     * 
     * @param datos 
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        try {
            for (Object dato : datos){
                Propuesta datoPropuesta=(Propuesta)dato;
            stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`propuesta` "
                    + "(`DNI_Cliente`, `Num_Serial_Vehículo`) VALUES"
                    + " ("+datoPropuesta.DNICliente+", '"+datoPropuesta.numSerial+"');");
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
}

