package DAO;

import java.sql.*;
import java.util.*;

public class VentaDAO extends AbstractDAO {

    /**
     * Crea un array de ventas con los datos de la tabla ventas de la base de
     * datos.
     *
     * @return array de ventas
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosVentas = new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.reparación");
            while (rs.next()) {
                datosVentas.add(new Venta(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVentas;
    }

    /**
     * Inserta los datos pasados como parámetro en la tabla ventas de la BD.
     * Además, antes de insertarlos comprueba que las claves foráneas tienen
     * valores correctos.
     *
     * @param datos
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        UsuarioDAO usudao = new UsuarioDAO();
        ClienteDAO cliendao = new ClienteDAO();
        ArrayList<Object> usuarios = usudao.recibirDatos(), clientes = cliendao.recibirDatos();
        boolean coincideCliente = false, coincideUsuario = false;

        try {
            for (Object dato : datos) {
                Venta datoVenta = (Venta) dato;

                for (Object usu : usuarios) {
                    Usuario usuario = (Usuario) usu;
                    if (usuario.DNI.equals(datoVenta.DNIUsuario) && "Ventas".equals(usuario.profesión)) {
                        coincideUsuario = true;
                    }
                }
                for (Object clien : clientes) {
                    Cliente cliente = (Cliente) clien;
                    if (cliente.DNI.equals(datoVenta.DNICliente)) {
                        coincideCliente = true;
                    }
                }

                if (coincideUsuario && coincideCliente) {
                    stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`venta` "
                            + "(`Num_Serial`, `DNI_Cliente`, `DNI_Usuario`, `Beneficios`, `Plazo`)"
                            + " VALUES (" + datoVenta.numSerial + ", '" + datoVenta.DNICliente
                            + "', '" + datoVenta.DNIUsuario + "', " + datoVenta.beneficios
                            + ", '" + datoVenta.plazo + "');");
                }

                coincideUsuario = false;
                coincideCliente = false;
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }

}
