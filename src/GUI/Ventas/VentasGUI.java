package GUI.Ventas;

import GUI.Proyecto.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentasGUI extends AbstractGUI {

    private String nombre;

    public VentasGUI(LoginGUI login) {
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public VentasGUI(String nombre) {
        this.nombre = nombre;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(nombre);
        
        setTitle("Menú Principal");
        
        JLabel lbl_Bienvenida = new JLabel("Bienvenid@ ^^ ¿Qué deseas realizar?");
        lbl_Bienvenida.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbl_Bienvenida.setBounds(10, 11, 289, 29);
        panel.add(lbl_Bienvenida);

        JLabel lbl_AltaCliente = new JLabel("REGISTRAR algún CLIENTE");
        lbl_AltaCliente.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_AltaCliente.setBounds(17, 110, 169, 14);
        panel.add(lbl_AltaCliente);

        JButton btnAltaCliente = new JButton("Registrar");
        btnAltaCliente.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnAltaCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                altaClientes();
            }
        });
        btnAltaCliente.setBounds(40, 135, 89, 23);
        panel.add(btnAltaCliente);

        JButton btnVerVehiculo = new JButton("Ver");
        btnVerVehiculo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnVerVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                verVehiculos();
            }
        });
        btnVerVehiculo.setBounds(328, 217, 89, 23);
        panel.add(btnVerVehiculo);

        JLabel lbl_VerVehiculos = new JLabel("Ver TODOS los VEHÍCULOS");
        lbl_VerVehiculos.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_VerVehiculos.setBounds(292, 192, 160, 14);
        panel.add(lbl_VerVehiculos);

        JLabel lbl_VenderVehiculo = new JLabel("VENDER algún VEHÍCULO");
        lbl_VenderVehiculo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_VenderVehiculo.setBounds(10, 297, 154, 14);
        panel.add(lbl_VenderVehiculo);

        JButton btnVender = new JButton("Vender");
        btnVender.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                venderVehiculo();
            }
        });
        btnVender.setBounds(40, 322, 89, 23);
        panel.add(btnVender);

        JLabel lbl_ProponerVehiculo = new JLabel("PROPONER algún VEHÍCULO");
        lbl_ProponerVehiculo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_ProponerVehiculo.setBounds(283, 297, 169, 14);
        panel.add(lbl_ProponerVehiculo);

        JButton btnProponer = new JButton("Proponer");
        btnProponer.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnProponer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                proponerVehiculo();
            }
        });
        btnProponer.setBounds(328, 322, 89, 23);
        panel.add(btnProponer);

        JLabel lbl_ComprobarPropuestas = new JLabel("COMPROBAR las PROPUESTAS");
        lbl_ComprobarPropuestas.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_ComprobarPropuestas.setBounds(141, 384, 187, 14);
        panel.add(lbl_ComprobarPropuestas);

        JButton btnComprobar = new JButton("Comprobar");
        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                verPropuestas();
            }
        });
        btnComprobar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnComprobar.setBounds(184, 409, 107, 23);
        panel.add(btnComprobar);

        JLabel lbl_VerClientes = new JLabel("Ver TODOS los CLIENTES");
        lbl_VerClientes.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_VerClientes.setBounds(298, 110, 154, 14);
        panel.add(lbl_VerClientes);

        JButton btnVerCliente = new JButton("Ver");
        btnVerCliente.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnVerCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                verClientes();
            }
        });
        btnVerCliente.setBounds(328, 135, 89, 23);
        panel.add(btnVerCliente);

        JLabel lbl_AltaVehiculo = new JLabel("REGISTRAR algún VEHÍCULO");
        lbl_AltaVehiculo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_AltaVehiculo.setBounds(10, 192, 181, 14);
        panel.add(lbl_AltaVehiculo);

        JButton btnAltaCliente_1 = new JButton("Registrar");
        btnAltaCliente_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                altaVehiculos();
            }
        });
        btnAltaCliente_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnAltaCliente_1.setBounds(40, 217, 89, 23);
        panel.add(btnAltaCliente_1);
    }

    public void altaClientes() {
        AltaClienteGUI alta = new AltaClienteGUI(this);
        this.setVisible(false);
    }

    public void altaVehiculos() {
        AltaVehiculoGUI alta = new AltaVehiculoGUI(this);
        this.setVisible(false);
    }

    public void verVehiculos() {
        VerVehiculosGUI verVehiculos = new VerVehiculosGUI(this);
        this.setVisible(false);
    }

    public void verClientes() {
        VerClientesGUI verClientes = new VerClientesGUI(this);
        this.setVisible(false);
    }

    public void proponerVehiculo() {
        PropuestaVehiculo1GUI proponer = new PropuestaVehiculo1GUI(this);
        this.setVisible(false);
    }

    public void verPropuestas() {
        VerPropuestasGUI verPropuestas = new VerPropuestasGUI(this);
        this.setVisible(false);
    }

    public void venderVehiculo() {
        VenderVehiculo1GUI vender = new VenderVehiculo1GUI(this);
        this.setVisible(false);
    }

    public String getNombre() {
        return nombre;
    }
}
