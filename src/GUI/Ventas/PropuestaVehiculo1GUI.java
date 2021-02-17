package GUI.Ventas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import GUI.Proyecto.*;

public class PropuestaVehiculo1GUI extends AbstractGUI {

    private final VentasGUI menu;
    private String DNI, Nombre;
    private DefaultTableModel dm;
    private JTable table;
    private JTextField text_DNI;
    private JTextField text_Nombre;

    public PropuestaVehiculo1GUI(VentasGUI menu) {
        this.menu = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        dm=crearClientes();

        setTitle("Propuesta de vehículos");
        
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

        JLabel lbl_Nombre = new JLabel("Nombre");
        lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Nombre.setBounds(176, 43, 55, 14);
        panel.add(lbl_Nombre);

        text_DNI = new JTextField();
        text_DNI.setFont(new Font("SansSerif", Font.PLAIN, 14));
        text_DNI.setBounds(34, 40, 134, 20);
        panel.add(text_DNI);
        text_DNI.setColumns(10);

        text_Nombre = new JTextField();
        text_Nombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
        text_Nombre.setColumns(10);
        text_Nombre.setBounds(233, 40, 134, 20);
        panel.add(text_Nombre);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dm = buscarClientes(text_DNI.getText(), text_Nombre.getText());
                table.setModel(dm);
            }
        });
        btnBuscar.setBounds(377, 39, 89, 23);
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
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        menu.setVisible(true);
    }

    public void siguiente() {
        try {
            int selectedRow = table.getSelectedRow();
            DNI = dm.getValueAt(selectedRow, 0).toString();
            Nombre = dm.getValueAt(selectedRow, 1).toString();
            PropuestaVehiculo2GUI propuestaSiguiente = new PropuestaVehiculo2GUI(this, menu);
            propuestaSiguiente.guardarPropuesta1(DNI);
            this.setVisible(false);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Señala la persona a quien le vas a proponer el vehículo");
        }
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        text_DNI.setText(dm.getValueAt(selectedRow, 0).toString());
        text_Nombre.setText(dm.getValueAt(selectedRow, 1).toString());
    }
}
