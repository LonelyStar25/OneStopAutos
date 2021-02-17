package DAO;

import java.util.*;

public class Pruebas {

    public static void main(String[] args) {
        UsuarioDAO usudao= new UsuarioDAO();
        VehículoDAO vehidao=new VehículoDAO();
        //MecánicoDAO mecdao=new MecánicoDAO();
        ArrayList<Object> datos=new ArrayList<>();
        
        /*System.out.println(usudao.comprobarUsuario(new UsuarioLogin("elmakina", "PaNdA")));
        datos=usudao.recibirDatos();
        for(Object usuario:datos){
            Usuario user=(Usuario)usuario;
            System.out.println(user);
        }*/
        /*vehículos=vehidao.recibirDatos();
        for(Object vehículo:vehículos){
            Vehículo vehi =(Vehículo)vehículo;
            System.out.println(vehi);
        }*/
        /*Usuario usu=new Usuario("77774484F", "LonelyStar", "LonelyStarRulz", "Carmen",
                "Córdoba", "Número aquí", 5000, "Correo aquí", "Mecánico");
        datos.add(usu);
        usudao.subirDatos(datos);*/
        //datos=usudao.buscarDato("77774484F");
        //System.out.println(datos.get(0));
        //System.out.println(usudao.comprobarUsuario(new UsuarioLogin("LonelyStar", "LonelyStarRulz")));
        /*Usuario usu=new Usuario("57383294H", "1234", "1234", "Pruebas",
                "aaaaaaaa", "Ugh", 1270, "Ugh 2", "Jefe");
        datos.add(usu);
        usudao.subirDatos(datos);*/
        //System.out.println((Usuario)usudao.buscarDato("usuario").get(0));
    }
    
}
