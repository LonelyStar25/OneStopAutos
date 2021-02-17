package GUI.Ventas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import GUI.Proyecto.*;

public class VenderVehiculo1GUI extends AbstractGUI {

    public static int numSerie, precio;
    public static String marca, modelo, tipo;
    private DefaultTableModel dm;
    private VentasGUI menu;
    private JTable table;
    private JTextField text_Marca;
    private JTextField text_Modelo;
    private JTextField text_Tipo;

    public VenderVehiculo1GUI(VentasGUI menu) {
        this.menu = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public VenderVehiculo1GUI() {

    }

    private void initialize() {
        init(menu.getNombre());
        dm = crearVehículos();

        setTitle("Venta de vehículos");

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

        table = new JTable(dm);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableMouseClicked(e);
            }
        });
        table.setFont(new Font("SansSerif", Font.PLAIN, 12));
        table.setBackground(Color.yellow);
        table.getTableHeader().setBackground(Color.orange);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setLocation(10, 95);
        scrollPane.setSize(456, 265);

        table.setBounds(20, 70, 446, 305);
        panel.add(scrollPane);

        JLabel lbl_Marca = new JLabel("Marca");
        lbl_Marca.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Marca.setBounds(10, 15, 43, 14);
        panel.add(lbl_Marca);

        JLabel lbl_Modelo = new JLabel("Modelo");
        lbl_Modelo.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Modelo.setBounds(10, 55, 55, 14);
        panel.add(lbl_Modelo);

        text_Marca = new JTextField();
        text_Marca.setFont(new Font("SansSerif", Font.PLAIN, 14));
        text_Marca.setBounds(74, 12, 134, 20);
        panel.add(text_Marca);
        text_Marca.setColumns(10);

        text_Modelo = new JTextField();
        text_Modelo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        text_Modelo.setColumns(10);
        text_Modelo.setBounds(74, 52, 134, 20);
        panel.add(text_Modelo);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dm = buscarVehículos(text_Modelo.getText(), text_Marca.getText(), text_Tipo.getText());
                table.setModel(dm);
            }
        });
        btnBuscar.setBounds(336, 50, 89, 23);
        panel.add(btnBuscar);

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                siguiente();
            }
        });
        btnSiguiente.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnSiguiente.setBounds(332, 381, 134, 46);
        panel.add(btnSiguiente);

        JLabel lbl_Tipo = new JLabel("Tipo");
        lbl_Tipo.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Tipo.setBounds(252, 12, 30, 20);
        panel.add(lbl_Tipo);

        text_Tipo = new JTextField();
        text_Tipo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        text_Tipo.setColumns(10);
        text_Tipo.setBounds(292, 12, 134, 20);
        panel.add(text_Tipo);

        JButton btnReset = new JButton("Resetear");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                text_Tipo.setText("");
                text_Modelo.setText("");
                text_Marca.setText("");
                dm = crearVehículos();
                table.setModel(dm);
            }
        });
        btnReset.setBounds(236, 50, 89, 23);
        panel.add(btnReset);
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        menu.setVisible(true);
    }

    public void siguiente() {
        if (table.getSelectedRow() != -1) {
            int selectedRow = table.getSelectedRow();
            marca = dm.getValueAt(selectedRow, 2).toString();
            modelo = dm.getValueAt(selectedRow, 1).toString();
            tipo = dm.getValueAt(selectedRow, 3).toString();
            precio = Integer.parseInt(dm.getValueAt(selectedRow, 4).toString());
            VenderVehiculo2GUI propuestaSiguiente = new VenderVehiculo2GUI(this, menu);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un vehículo");
        }
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        numSerie = Integer.parseInt(dm.getValueAt(selectedRow, 0).toString());
        text_Marca.setText(dm.getValueAt(selectedRow, 2).toString());
        text_Modelo.setText(dm.getValueAt(selectedRow, 1).toString());
        text_Tipo.setText(dm.getValueAt(selectedRow, 3).toString());
    }

    public int getNumSerie() {
        return numSerie;
    }

    public static int getPrecio() {
        return precio;
    }

    public static String getMarca() {
        return marca;
    }

    public static String getModelo() {
        return modelo;
    }

    public static String getTipo() {
        return tipo;
    }
}
