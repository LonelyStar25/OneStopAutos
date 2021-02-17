package GUI.Ventas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import GUI.Proyecto.*;

public class VerClientesGUI extends AbstractGUI {

    private DefaultTableModel dm;
    private final VentasGUI menu;
    private JTable table;
    private JTextField textFieldNombre;
    private JTextField textFieldApellidos;
    private JTextField textFieldTeléfono;
    private JTextField textFieldDomicilio;

    public VerClientesGUI(VentasGUI menu) {
        this.menu = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        dm = crearClientes();

        setTitle("Lista de Clientes");

        JButton btnVolver = new JButton("Volver");
        btnVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                volver();
            }
        });
        btnVolver.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnVolver.setBounds(10, 378, 134, 46);
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
        scrollPane.setLocation(10, 104);
        scrollPane.setSize(456, 256);

        table.setBounds(20, 70, 446, 305);
        panel.add(scrollPane);

        JLabel lbl_Nombre = new JLabel("Nombre");
        lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_Nombre.setBounds(10, 11, 46, 14);
        panel.add(lbl_Nombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
        textFieldNombre.setBounds(73, 9, 120, 20);
        panel.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JLabel lbl_Apellidos = new JLabel("Apellidos");
        lbl_Apellidos.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_Apellidos.setBounds(10, 51, 53, 14);
        panel.add(lbl_Apellidos);

        textFieldApellidos = new JTextField();
        textFieldApellidos.setFont(new Font("SansSerif", Font.PLAIN, 12));
        textFieldApellidos.setColumns(10);
        textFieldApellidos.setBounds(73, 49, 120, 20);
        panel.add(textFieldApellidos);

        textFieldTeléfono = new JTextField();
        textFieldTeléfono.setFont(new Font("SansSerif", Font.PLAIN, 12));
        textFieldTeléfono.setColumns(10);
        textFieldTeléfono.setBounds(297, 11, 120, 20);
        panel.add(textFieldTeléfono);

        JLabel lbl_Telefono = new JLabel("Teléfono");
        lbl_Telefono.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_Telefono.setBounds(234, 13, 53, 14);
        panel.add(lbl_Telefono);

        JLabel lbl_Domicilio = new JLabel("Domicilio");
        lbl_Domicilio.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_Domicilio.setBounds(234, 51, 53, 14);
        panel.add(lbl_Domicilio);

        textFieldDomicilio = new JTextField();
        textFieldDomicilio.setFont(new Font("SansSerif", Font.PLAIN, 12));
        textFieldDomicilio.setColumns(10);
        textFieldDomicilio.setBounds(297, 49, 120, 20);
        panel.add(textFieldDomicilio);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dm = buscarClientes(textFieldNombre.getText(), textFieldApellidos.getText(),
                        textFieldTeléfono.getText(), textFieldDomicilio.getText());
                table.setModel(dm);
            }
        });
        btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnBuscar.setBounds(332, 371, 134, 25);
        panel.add(btnBuscar);

        JButton btnResetear = new JButton("Resetear");
        btnResetear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                textFieldNombre.setText("");
                textFieldApellidos.setText("");
                textFieldTeléfono.setText("");
                textFieldDomicilio.setText("");
                dm = crearClientes();
                table.setModel(dm);
            }
        });
        btnResetear.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnResetear.setBounds(332, 407, 134, 25);
        panel.add(btnResetear);
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        menu.setVisible(true);
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        textFieldNombre.setText(dm.getValueAt(selectedRow, 1).toString());
        textFieldApellidos.setText(dm.getValueAt(selectedRow, 2).toString());
        textFieldTeléfono.setText(dm.getValueAt(selectedRow, 3).toString());
        textFieldDomicilio.setText(dm.getValueAt(selectedRow, 4).toString());
    }
}
