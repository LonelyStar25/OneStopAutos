package GUI.Ventas;

import GUI.Mecanicos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DAO.*;
import GUI.Proyecto.*;

public class AltaClienteGUI extends AbstractGUI {

    private AnadirTrabajos1GUI menuAnadir;
    private VentasGUI menuVentas;
    private JTextField text_Nombre;
    private JTextField text_Apellidos;
    private JTextField text_DNI;
    private JTextField text_Domicilio;
    private JTextField text_Telefono;
    private JTextField text_Correo;
    private ClienteDAO cliendao;

    public AltaClienteGUI(VentasGUI menu) {
        this.menuVentas = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public AltaClienteGUI(AnadirTrabajos1GUI menuAnadir) {
        this.menuAnadir = menuAnadir;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        if (menuAnadir != null) {
            init(menuAnadir.getNombre());
        } else if (menuVentas != null) {
            init(menuVentas.getNombre());
        }
        cliendao = new ClienteDAO();

        setTitle("Alta de Cliente");

        JLabel lbl_Nombre = new JLabel("*Nombre:");
        lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl_Nombre.setBounds(22, 39, 140, 14);
        panel.add(lbl_Nombre);

        text_Nombre = new JTextField();
        text_Nombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_Nombre.setBounds(22, 64, 184, 20);
        panel.add(text_Nombre);
        text_Nombre.setColumns(10);

        JLabel lbl_Apellidos = new JLabel("*Apellidos:");
        lbl_Apellidos.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl_Apellidos.setBounds(259, 39, 140, 14);
        panel.add(lbl_Apellidos);

        text_Apellidos = new JTextField();
        text_Apellidos.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_Apellidos.setColumns(10);
        text_Apellidos.setBounds(259, 64, 184, 20);
        panel.add(text_Apellidos);

        text_DNI = new JTextField();
        text_DNI.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_DNI.setColumns(10);
        text_DNI.setBounds(22, 153, 184, 20);
        panel.add(text_DNI);

        JLabel lbl_DNI = new JLabel("*DNI:");
        lbl_DNI.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl_DNI.setBounds(22, 128, 140, 14);
        panel.add(lbl_DNI);

        text_Domicilio = new JTextField();
        text_Domicilio.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_Domicilio.setColumns(10);
        text_Domicilio.setBounds(259, 153, 184, 20);
        panel.add(text_Domicilio);

        JLabel lbl_Domicilio = new JLabel("*Domicilio:");
        lbl_Domicilio.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl_Domicilio.setBounds(259, 128, 140, 14);
        panel.add(lbl_Domicilio);

        text_Telefono = new JTextField();
        text_Telefono.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_Telefono.setColumns(10);
        text_Telefono.setBounds(22, 251, 184, 20);
        panel.add(text_Telefono);

        JLabel lblTelefono = new JLabel("*Teléfono:");
        lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblTelefono.setBounds(22, 226, 140, 14);
        panel.add(lblTelefono);

        text_Correo = new JTextField();
        text_Correo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_Correo.setColumns(10);
        text_Correo.setBounds(259, 251, 184, 20);
        panel.add(text_Correo);

        JLabel lbl_Correo = new JLabel("Correo Electrónico:");
        lbl_Correo.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl_Correo.setBounds(259, 226, 140, 14);
        panel.add(lbl_Correo);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                volver();
            }
        });
        btnVolver.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnVolver.setBounds(54, 367, 107, 42);
        panel.add(btnVolver);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aceptar();
            }
        });
        btnAceptar.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnAceptar.setBounds(292, 367, 107, 42);
        panel.add(btnAceptar);
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        if (menuAnadir!=null) {
            menuAnadir.setVisible(true);
        } else if (menuVentas!=null) {
            menuVentas.setVisible(true);
        }
    }

    public void aceptar() {
        try {
            if ((text_DNI.getText().equals("")) || (text_Nombre.getText().equals(""))
                    || (text_Apellidos.getText().equals("")) || (text_Telefono.getText().equals(""))
                    || (text_Domicilio.getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Te faltan campos por rellenar");
            } else {
                String correo = null;
                if (!text_Correo.getText().equals("")) {
                    correo = text_Correo.getText();
                    if (!correo.contains("@")) {
                        JOptionPane.showMessageDialog(null, "Correo electrónico mal escrito");
                        return;
                    }
                }
                if (text_Telefono.getText().length() < 9) {
                    JOptionPane.showMessageDialog(null, "Número de teléfono mal escrito");
                } else {
                    cliendao.subirDato(new Cliente(text_DNI.getText(), text_Nombre.getText(),
                            text_Apellidos.getText(), text_Telefono.getText(),
                            text_Domicilio.getText(), correo));
                    this.setVisible(false);
                    this.dispose();
                    if (menuAnadir!=null) {
                        menuAnadir.setVisible(true);
                    } else if(menuVentas!=null){
                        menuVentas.setVisible(true);
                    }
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Número de teléfono mal escrito");
        }
    }
}
