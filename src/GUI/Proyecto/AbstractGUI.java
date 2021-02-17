package GUI.Proyecto;

import DAO.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

public abstract class AbstractGUI extends JFrame {

    public JFrame frame;
    public JPanel panel;
    public Usuario user;

    public void init(String nombreUsuario) {
        UsuarioDAO usudao = new UsuarioDAO();
        user = (Usuario) usudao.buscarDato(nombreUsuario).get(0);

        frame = new JFrame();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 667, 482);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel jpanel = new JPanel();
        jpanel.setBackground(new Color(0, 139, 139));
        jpanel.setBounds(0, 0, 176, 443);
        getContentPane().add(jpanel);
        jpanel.setLayout(null);

        JLabel lblImagen = new JLabel("Imagen");
        lblImagen.setIcon(new ImageIcon(".\\src\\GUI\\images\\myLogo_Login.png"));
        lblImagen.setBounds(26, 48, 122, 55);
        jpanel.add(lblImagen);

        JLabel lblNombreDelEmpleado = new JLabel("Nombre del empleado");
        lblNombreDelEmpleado.setText(user.getNombre());
        lblNombreDelEmpleado.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNombreDelEmpleado.setBounds(10, 126, 162, 25);
        jpanel.add(lblNombreDelEmpleado);

        JLabel lblOcupacion = new JLabel("Ocupación");
        lblOcupacion.setText(user.getProfesión());
        lblOcupacion.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblOcupacion.setBounds(10, 406, 162, 25);
        jpanel.add(lblOcupacion);

        lblNombreDelEmpleado.setHorizontalAlignment(JLabel.CENTER);
        lblOcupacion.setHorizontalAlignment(JLabel.CENTER);

        this.panel = new JPanel();
        this.panel.setBackground(new Color(255, 140, 0));
        this.panel.setBounds(175, 0, 476, 443);
        getContentPane().add(this.panel);
        this.panel.setLayout(null);
    }

    private DefaultTableModel tablaClientes(ArrayList<Object> clientes) {
        DefaultTableModel dm = new DefaultTableModel();

        for (String column : new String[]{"DNI", "Nombre", "Apellidos", "Teléfono", "Domicilio"}) {
            dm.addColumn(column);
        }
        for (Object obj : clientes) {
            Cliente clien = (Cliente) obj;
            dm.addRow(new Object[]{clien.getDNI(), clien.getNombre(), clien.getApellidos(),
                clien.getTeléfono(), clien.getDomicilio()});
        }
        return dm;
    }

    public DefaultTableModel crearClientes() {
        return tablaClientes(new ClienteDAO().recibirDatos());
    }

    public DefaultTableModel buscarClientes(String... datos) {
        return tablaClientes(new ClienteDAO().buscarDatos(datos));
    }
    
    private DefaultTableModel tablaVehículos(ArrayList<Object> vehículos){
        DefaultTableModel dm = new DefaultTableModel();
        
        for (String column : new String[]{"Número Serie", "Modelo", "Marca", "Tipo", "Precio", "Fecha Entrada"}) {
            dm.addColumn(column);
        }
        for (Object obj : vehículos) {
            Vehículo vehi = (Vehículo) obj;
            dm.addRow(new Object[]{vehi.getNumSerial(), vehi.getModelo(), vehi.getMarca(),
                vehi.getTipo(), vehi.getPrecio(), vehi.getFechaEntrada()});
        }
        return dm;
    }
    
    public DefaultTableModel crearVehículos() {
        return tablaVehículos(new VehículoDAO().recibirDatos());
    }

    public DefaultTableModel buscarVehículos(String... datos) {
        return tablaVehículos(new VehículoDAO().buscarDatos(datos));
    }
    
    private DefaultTableModel tablaReparaciones(ArrayList<Object> reparaciones){
        DefaultTableModel dm = new DefaultTableModel();
        ClienteDAO cliendao=new ClienteDAO();
        
        for (String column : new String[]{"Número Incidencia", "Problema", "Tiempo Estimado", "Piezas", "Teléfono"}) {
            dm.addColumn(column);
        }
        for (Object item : reparaciones) {
            Reparación rep = (Reparación) item;
            Cliente clien = (Cliente) cliendao.buscarDato(rep.getDNICliente()).get(0);
            dm.addRow(new Object[]{rep.getNumIncidencia(), rep.getProblema(), rep.getTiempoEstimado(),
                rep.getPiezas(), clien.getTeléfono()});
        }
        return dm;
    }
    
    public DefaultTableModel crearReparaciones() {
        return tablaReparaciones(new ReparaciónDAO().recibirDatos());
    }

    public DefaultTableModel buscarReparaciones(String... datos) {
        return tablaReparaciones(new ReparaciónDAO().buscarDatos(datos));
    }
    
    private DefaultTableModel tablaPropuestas(ArrayList<Object> propuestas){
        DefaultTableModel dm = new DefaultTableModel();
        ClienteDAO cliendao=new ClienteDAO();
        VehículoDAO vehidao=new VehículoDAO();
        
        for (String column : new String[]{"DNI", "Nombre", "Marca", "Modelo", "Tipo", "Fecha de entrada"}) {
            dm.addColumn(column);
        }
        for (Object obj : propuestas) {
            Propuesta prop=(Propuesta)obj;
            Cliente clien=(Cliente)cliendao.buscarDato(prop.getDNICliente()).get(0);
            Vehículo vehi=(Vehículo)vehidao.buscarDato(prop.getNumSerial()+"").get(0);
            dm.addRow(new Object[]{prop.getDNICliente(), clien.getNombre(), vehi.getMarca(),
            vehi.getModelo(), vehi.getTipo(), vehi.getFechaEntrada()});
        }
        return dm;
    }
    
    public DefaultTableModel crearPropuestas() {
        return tablaPropuestas(new PropuestaDAO().recibirDatos());
    }

    public DefaultTableModel buscarPropuestas(String... datos) {
        return tablaPropuestas(new PropuestaDAO().buscarDatos(datos));
    }
}
