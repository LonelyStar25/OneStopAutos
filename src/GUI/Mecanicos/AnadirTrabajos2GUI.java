package GUI.Mecanicos;

import GUI.Ventas.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import GUI.Proyecto.*;

public class AnadirTrabajos2GUI extends AbstractGUI {

    private final String dniCliente;
    private DefaultTableModel dm;
    private final AnadirTrabajos1GUI menu;
    private JTable table;
    private JTextField textMarca;
    private JTextField textModelo;

    public AnadirTrabajos2GUI(AnadirTrabajos1GUI menu, String dniCliente) {
        this.menu = menu;
        this.dniCliente = dniCliente;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        dm = crearVehículos();

        setTitle("Añadir trabajo");

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

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        btnSeleccionar.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnSeleccionar.setBounds(332, 378, 134, 46);
        panel.add(btnSeleccionar);

        JLabel lbl_Marca = new JLabel("Marca");
        lbl_Marca.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_Marca.setBounds(10, 53, 46, 14);
        panel.add(lbl_Marca);

        textMarca = new JTextField();
        textMarca.setFont(new Font("SansSerif", Font.PLAIN, 12));
        textMarca.setBounds(66, 50, 120, 20);
        panel.add(textMarca);
        textMarca.setColumns(10);

        JLabel lbl_Modelo = new JLabel("Modelo");
        lbl_Modelo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_Modelo.setBounds(203, 53, 53, 14);
        panel.add(lbl_Modelo);

        textModelo = new JTextField();
        textModelo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        textModelo.setColumns(10);
        textModelo.setBounds(266, 50, 120, 20);
        panel.add(textModelo);

        JLabel lbl_Texto = new JLabel("Seleccione el vehículo");
        lbl_Texto.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
        lbl_Texto.setBounds(10, 11, 183, 25);
        panel.add(lbl_Texto);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dm = buscarVehículos(textMarca.getText(), textModelo.getText());
                table.setModel(dm);
            }
        });
        btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnBuscar.setBounds(387, 77, 79, 25);
        panel.add(btnBuscar);

        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                altaVehiculo();
            }
        });
        btnCrear.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnCrear.setBounds(172, 378, 134, 46);
        panel.add(btnCrear);
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        menu.setVisible(true);
    }

    public void altaVehiculo() {
        AltaVehiculoGUI alta = new AltaVehiculoGUI(this);
        this.setVisible(false);
    }

    public void seleccionar() {
        if (table.getSelectedRow() != -1) {
            AnadirTrabajos3GUI siguiente = new AnadirTrabajos3GUI(this, dniCliente);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un vehículo");
        }
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        textMarca.setText(dm.getValueAt(selectedRow, 1).toString());
        textModelo.setText(dm.getValueAt(selectedRow, 2).toString());
    }

    public String getNombre() {
        return menu.getNombre();
    }
}
