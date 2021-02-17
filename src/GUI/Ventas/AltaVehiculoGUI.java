package GUI.Ventas;

import GUI.Mecanicos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DAO.*;
import GUI.Proyecto.*;

public class AltaVehiculoGUI extends AbstractGUI {

    private VentasGUI menuVentas;
    public AnadirTrabajos2GUI menuAnadir;
    private JTextField text_NumSerie;
    private JTextField text_Modelo;
    private JTextField text_Marca;
    private JTextField text_Precio;
    private JTextField text_FechaDeEntrada;
    private JTextField text_InfAdicional;
    private JComboBox comboTipo;
    private VehículoDAO vehidao;

    public AltaVehiculoGUI(VentasGUI menu) {
        this.menuVentas = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public AltaVehiculoGUI(AnadirTrabajos2GUI menuAnadir) {
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
        vehidao = new VehículoDAO();

        setTitle("Añadir trabajo");

        JLabel lbl_NumSerie = new JLabel("*Num. Serie:");
        lbl_NumSerie.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl_NumSerie.setBounds(22, 39, 140, 14);
        panel.add(lbl_NumSerie);

        text_NumSerie = new JTextField();
        text_NumSerie.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_NumSerie.setBounds(22, 64, 184, 20);
        panel.add(text_NumSerie);
        text_NumSerie.setColumns(10);

        JLabel lbl_Modelo = new JLabel("*Modelo:");
        lbl_Modelo.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl_Modelo.setBounds(259, 39, 140, 14);
        panel.add(lbl_Modelo);

        text_Modelo = new JTextField();
        text_Modelo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_Modelo.setColumns(10);
        text_Modelo.setBounds(259, 64, 184, 20);
        panel.add(text_Modelo);

        text_Marca = new JTextField();
        text_Marca.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_Marca.setColumns(10);
        text_Marca.setBounds(20, 130, 184, 20);
        panel.add(text_Marca);

        JLabel lbl_Marca = new JLabel("*Marca:");
        lbl_Marca.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl_Marca.setBounds(20, 105, 140, 14);
        panel.add(lbl_Marca);

        JLabel lbl_Tipo = new JLabel("*Tipo:");
        lbl_Tipo.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl_Tipo.setBounds(257, 105, 140, 14);
        panel.add(lbl_Tipo);

        text_Precio = new JTextField();
        text_Precio.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_Precio.setColumns(10);
        text_Precio.setBounds(22, 191, 184, 20);
        panel.add(text_Precio);

        JLabel lblPrecio = new JLabel("*Precio:");
        lblPrecio.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblPrecio.setBounds(22, 166, 140, 14);
        panel.add(lblPrecio);

        text_FechaDeEntrada = new JTextField();
        text_FechaDeEntrada.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_FechaDeEntrada.setColumns(10);
        text_FechaDeEntrada.setBounds(259, 191, 184, 20);
        panel.add(text_FechaDeEntrada);

        JLabel lbl_FechEntrada = new JLabel("*Fecha Entrada:");
        lbl_FechEntrada.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl_FechEntrada.setBounds(259, 166, 140, 14);
        panel.add(lbl_FechEntrada);

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

        JLabel lbl_InfAdicional = new JLabel("Información Adicional:");
        lbl_InfAdicional.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl_InfAdicional.setBounds(22, 232, 140, 14);
        panel.add(lbl_InfAdicional);

        text_InfAdicional = new JTextField();
        text_InfAdicional.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_InfAdicional.setColumns(10);
        text_InfAdicional.setBounds(22, 257, 184, 20);
        panel.add(text_InfAdicional);

        comboTipo = new JComboBox(new String[]{"Coche", "Moto"});
        comboTipo.setBounds(259, 130, 184, 22);
        panel.add(comboTipo);
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        if (menuAnadir != null) {
            menuAnadir.setVisible(true);
        } else if (menuVentas != null) {
            menuVentas.setVisible(true);
        }
    }

    public void aceptar() {
        try {
            if ((text_Marca.getText().equals("")) || (text_NumSerie.getText().equals(""))
                    || (text_Modelo.getText().equals("")) || (text_Precio.getText().equals(""))
                    || (text_NumSerie.getText().equals("")) || (text_FechaDeEntrada.getText().equals(""))
                    || (comboTipo.getSelectedItem().equals(""))) {
                JOptionPane.showMessageDialog(null, "Te faltan campos por rellenar");
            } else {
                String info=null;
                if (!text_InfAdicional.getText().equals("")) {
                    info=text_InfAdicional.getText();
                }
                vehidao.subirDato(new Vehículo(Integer.parseInt(text_NumSerie.getText()),
                text_Modelo.getText(), text_Marca.getText(), comboTipo.getSelectedItem().toString(),
                Integer.parseInt(text_Precio.getText()), text_FechaDeEntrada.getText(), info));
                this.setVisible(false);
                this.dispose();
                if (menuAnadir != null) {
                    menuAnadir.setVisible(true);
                } else if (menuVentas != null) {
                    menuVentas.setVisible(true);
                }
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "¿Has escrito letras en vez de números?");
        }
    }
}
