package GUI.Ventas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DAO.*;
import GUI.Proyecto.*;

public class ResumenVentaGUI extends AbstractGUI {

    private VenderVehiculo2GUI ventaVehiculo;
    private final VentasGUI menu;
    private JTextField textPlazo; 
    private VentaDAO vendao;
    private VehículoDAO vehidao;
    private UsuarioDAO usudao;

    public ResumenVentaGUI(VenderVehiculo2GUI ventaVehiculo, VentasGUI menu) {
        this.ventaVehiculo = ventaVehiculo;
        this.menu = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        vehidao=new VehículoDAO();
        vendao=new VentaDAO();
        usudao=new UsuarioDAO();
        
        setTitle("Resumen de Venta");
        VenderVehiculo1GUI infVehiculo = new VenderVehiculo1GUI();
        VenderVehiculo2GUI infCliente = new VenderVehiculo2GUI();
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                volver();
            }
        });
        btnVolver.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnVolver.setBounds(10, 381, 134, 46);
        panel.add(btnVolver);

        JLabel lbl_DNI = new JLabel("DNI");
        lbl_DNI.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_DNI.setBounds(10, 82, 24, 14);
        panel.add(lbl_DNI);

        JLabel lbl_Nombre = new JLabel("Nombre");
        lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Nombre.setBounds(10, 149, 55, 14);
        panel.add(lbl_Nombre);

        JButton btnVender = new JButton("VENDER");
        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                guardar();
            }
        });
        btnVender.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnVender.setBounds(332, 381, 134, 46);
        panel.add(btnVender);

        JLabel lbldni = new JLabel("insert_text");
        lbldni.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
        lbldni.setBounds(69, 97, 88, 18);
        panel.add(lbldni);

        JLabel lblnombre = new JLabel("insert_text");
        lblnombre.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
        lblnombre.setBounds(69, 165, 88, 18);
        panel.add(lblnombre);

        JLabel lbl_Apellidos = new JLabel("Apellidos");
        lbl_Apellidos.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Apellidos.setBounds(10, 209, 78, 14);
        panel.add(lbl_Apellidos);

        JLabel lblapellidos = new JLabel("insert_text");
        lblapellidos.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
        lblapellidos.setBounds(69, 227, 151, 18);
        panel.add(lblapellidos);

        JLabel lbltelefono = new JLabel("insert_text");
        lbltelefono.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
        lbltelefono.setBounds(69, 289, 88, 18);
        panel.add(lbltelefono);

        JLabel lbl_Telefono = new JLabel("Teléfono");
        lbl_Telefono.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Telefono.setBounds(11, 271, 78, 14);
        panel.add(lbl_Telefono);

        JLabel lbl_Cliente = new JLabel("Cliente");
        lbl_Cliente.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
        lbl_Cliente.setBounds(35, 24, 66, 24);
        panel.add(lbl_Cliente);

        JLabel lblprecio = new JLabel("insert_text");
        lblprecio.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
        lblprecio.setBounds(353, 289, 88, 18);
        panel.add(lblprecio);

        JLabel lbl_Telefono_1 = new JLabel("Precio");
        lbl_Telefono_1.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Telefono_1.setBounds(319, 271, 78, 14);
        panel.add(lbl_Telefono_1);

        JLabel lbltipo = new JLabel("insert_text");
        lbltipo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
        lbltipo.setBounds(353, 227, 88, 18);
        panel.add(lbltipo);

        JLabel lbl_Apellidos_1 = new JLabel("Tipo");
        lbl_Apellidos_1.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Apellidos_1.setBounds(318, 209, 78, 14);
        panel.add(lbl_Apellidos_1);

        JLabel lblmodelo = new JLabel("insert_text");
        lblmodelo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
        lblmodelo.setBounds(353, 165, 88, 18);
        panel.add(lblmodelo);

        JLabel lbl_Nombre_1 = new JLabel("Modelo");
        lbl_Nombre_1.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Nombre_1.setBounds(318, 149, 55, 14);
        panel.add(lbl_Nombre_1);

        JLabel lblmarca = new JLabel("insert_text");
        lblmarca.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
        lblmarca.setBounds(353, 97, 88, 18);
        panel.add(lblmarca);

        JLabel lbl_DNI_1 = new JLabel("Marca");
        lbl_DNI_1.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_DNI_1.setBounds(318, 82, 55, 14);
        panel.add(lbl_DNI_1);

        JLabel lbl_Cliente_1 = new JLabel("Cliente");
        lbl_Cliente_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
        lbl_Cliente_1.setBounds(353, 24, 66, 24);
        panel.add(lbl_Cliente_1);

        JLabel lbl_Plazo = new JLabel("Plazo");
        lbl_Plazo.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Plazo.setBounds(154, 332, 78, 14);
        panel.add(lbl_Plazo);

        textPlazo = new JTextField();
        textPlazo.setBounds(169, 354, 155, 20);
        panel.add(textPlazo);
        textPlazo.setColumns(10);

        lblmarca.setText(infVehiculo.getMarca());
        lblmodelo.setText(infVehiculo.getModelo());
        lbltipo.setText(infVehiculo.getTipo());
        lblprecio.setText(Integer.toString(infVehiculo.getPrecio()));

        lbldni.setText(infCliente.getDni());
        lblnombre.setText(infCliente.getNombre());
        lblapellidos.setText(infCliente.getApellidos());
        lbltelefono.setText(Integer.toString(infCliente.getTelefono()));
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        ventaVehiculo.setVisible(true);
    }

    public void guardar() {
        VenderVehiculo1GUI apartado1 = new VenderVehiculo1GUI();
        VenderVehiculo2GUI apartado2 = new VenderVehiculo2GUI();
        Usuario user=(Usuario)usudao.buscarDato(menu.getNombre()).get(0);
        Vehículo vehi=(Vehículo)vehidao.buscarDato(apartado1.getNumSerie()+"").get(0);
        vendao.subirDato(new Venta(vehi.getNumSerial(), apartado2.getDni(), user.getDNI(), vehi.getPrecio(), textPlazo.getText()));
        this.setVisible(false);
        this.dispose();
        menu.setVisible(true);
    }
}
