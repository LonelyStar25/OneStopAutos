package GUI.Ventas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import GUI.Proyecto.*;

public class VenderVehiculo2GUI extends AbstractGUI {

    public static String dni, nombre, apellidos;
    public static int telefono;
    private DefaultTableModel dm;
    private VentasGUI menu;
    private VenderVehiculo1GUI ventaNombre;
    private JTable table;
    private JTextField text_DNI;

    public VenderVehiculo2GUI(VenderVehiculo1GUI ventaNombre, VentasGUI menu) {
        this.menu = menu;
        this.ventaNombre = ventaNombre;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public VenderVehiculo2GUI() {

    }

    private void initialize() {
        init(menu.getNombre());
        dm = crearClientes();

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

        JLabel lbl_DNI = new JLabel("DNI");
        lbl_DNI.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_DNI.setBounds(8, 43, 24, 14);
        panel.add(lbl_DNI);

        text_DNI = new JTextField();
        text_DNI.setFont(new Font("SansSerif", Font.PLAIN, 14));
        text_DNI.setBounds(42, 40, 155, 20);
        panel.add(text_DNI);
        text_DNI.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dm = buscarClientes(text_DNI.getText());
                table.setModel(dm);
            }
        });
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnBuscar.setBounds(377, 39, 89, 23);
        panel.add(btnBuscar);

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                resumenVenta();
            }
        });
        btnSiguiente.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnSiguiente.setBounds(332, 381, 134, 46);
        panel.add(btnSiguiente);

        JButton btnResetear = new JButton("Resetear");
        btnResetear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                text_DNI.setText("");
                dm = crearClientes();
                table.setModel(dm);
            }
        });
        btnResetear.setBounds(278, 39, 89, 23);
        panel.add(btnResetear);
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        ventaNombre.setVisible(true);
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        dni = dm.getValueAt(selectedRow, 0).toString();
        text_DNI.setText(dm.getValueAt(selectedRow, 0).toString());
    }

    public void resumenVenta() {
        if (table.getSelectedRow() != -1) {
            int selectedRow = table.getSelectedRow();
            nombre = dm.getValueAt(selectedRow, 1).toString();
            apellidos = dm.getValueAt(selectedRow, 2).toString();
            telefono = Integer.parseInt(dm.getValueAt(selectedRow, 3).toString());
            ResumenVentaGUI resumen = new ResumenVentaGUI(this, menu);
            this.setVisible(false);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un cliente");
        }
    }

    public String getDni() {
        return dni;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getApellidos() {
        return apellidos;
    }

    public static int getTelefono() {
        return telefono;
    }
}
