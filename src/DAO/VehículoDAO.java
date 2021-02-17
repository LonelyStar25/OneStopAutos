package DAO;

import java.sql.*;
import java.util.*;

public class VehículoDAO extends AbstractDAO{

    /**
     * Crea un array de vehículos con los datos de la tabla vehículos de la base de datos.
     * 
     * @return array de vehículos
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosVehículos= new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.vehículo");
            while(rs.next()){
                datosVehículos.add(new Vehículo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehículos;
    }

    /**
     * Inserta los datos pasados como parámetro en la tabla vehículos de la BD.
     * 
     * @param datos 
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        try {
            for (Object dato : datos){
                Vehículo datoVehículo=(Vehículo)dato;
            stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`vehículo` "
                    + "(`Num_Serial`, `Modelo`, `Marca`, "
                    + "`Tipo`, `Precio`, `Fecha_Entrada`, `Inf_Adicional`) VALUES"
                    + " ("+datoVehículo.numSerial+", '"+datoVehículo.modelo+
                    "', '"+datoVehículo.marca+"', '"+datoVehículo.tipo+"', "+
                    datoVehículo.precio+", '"+datoVehículo.fechaEntrada+"', '"+
                    datoVehículo.infoAdicional+"');");
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
}
