package GUI.Ventas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import GUI.Proyecto.*;

public class VerVehiculosGUI extends AbstractGUI {

    private DefaultTableModel dm;
    private final VentasGUI menu;
    private JTable table;
    private JTextField text_Marca;
    private JTextField text_Modelo;
    private JTextField text_Precio;

    public VerVehiculosGUI(VentasGUI menu) {
        this.menu = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        dm = crearVehículos();

        setTitle("Lista de Vehículos");

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dm = buscarVehículos(text_Marca.getText(), text_Modelo.getText(), text_Precio.getText());
                table.setModel(dm);
            }
        });
        btnBuscar.setBounds(332, 371, 134, 25);
        panel.add(btnBuscar);

        JButton btnReset = new JButton("Resetear");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                text_Precio.setText("");
                text_Modelo.setText("");
                text_Marca.setText("");
                dm = crearVehículos();
                table.setModel(dm);
            }
        });
        btnReset.setBounds(332, 407, 134, 25);
        panel.add(btnReset);

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
        table.setFont(new Font("SansSerif", Font.PLAIN, 12));
        table.setBackground(Color.yellow);
        table.getTableHeader().setBackground(Color.orange);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableMouseClicked(e);
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setLocation(10, 104);
        scrollPane.setSize(456, 256);

        table.setBounds(20, 70, 446, 305);
        panel.add(scrollPane);

        JLabel lbl_Marca = new JLabel("Marca");
        lbl_Marca.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_Marca.setBounds(10, 55, 43, 14);
        panel.add(lbl_Marca);

        text_Marca = new JTextField();
        text_Marca.setBounds(63, 53, 120, 20);
        panel.add(text_Marca);
        text_Marca.setColumns(10);

        JLabel lbl_Modelo = new JLabel("Modelo");
        lbl_Modelo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_Modelo.setBounds(10, 13, 43, 14);
        panel.add(lbl_Modelo);

        text_Modelo = new JTextField();
        text_Modelo.setColumns(10);
        text_Modelo.setBounds(63, 11, 120, 20);
        panel.add(text_Modelo);

        text_Precio = new JTextField();
        text_Precio.setColumns(10);
        text_Precio.setBounds(287, 11, 120, 20);
        panel.add(text_Precio);

        JLabel lbl_Precio = new JLabel("Precio");
        lbl_Precio.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_Precio.setBounds(234, 13, 43, 14);
        panel.add(lbl_Precio);
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        menu.setVisible(true);
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        text_Modelo.setText(dm.getValueAt(selectedRow, 1).toString());
        text_Marca.setText(dm.getValueAt(selectedRow, 2).toString());
        text_Precio.setText(dm.getValueAt(selectedRow, 4).toString());
    }
}
