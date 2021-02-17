package GUI.Mecanicos;

import GUI.Ventas.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import GUI.Proyecto.*;

public class AnadirTrabajos1GUI extends AbstractGUI {

    private DefaultTableModel dm;
    private final MecanicosGUI menu;
    private JTable table;
    private JTextField textNombre;
    private JTextField textApellidos;

    public AnadirTrabajos1GUI(MecanicosGUI menu, String profesion) {
        this.menu = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        dm = crearClientes();

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
        scrollPane.setLocation(10, 113);
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

        JLabel lbl_Nombre = new JLabel("Nombre");
        lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_Nombre.setBounds(10, 53, 46, 14);
        panel.add(lbl_Nombre);

        textNombre = new JTextField();
        textNombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
        textNombre.setBounds(66, 50, 120, 20);
        panel.add(textNombre);
        textNombre.setColumns(10);

        JLabel lbl_Apellidos = new JLabel("Apellidos");
        lbl_Apellidos.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_Apellidos.setBounds(203, 53, 53, 14);
        panel.add(lbl_Apellidos);

        textApellidos = new JTextField();
        textApellidos.setFont(new Font("SansSerif", Font.PLAIN, 12));
        textApellidos.setColumns(10);
        textApellidos.setBounds(266, 50, 120, 20);
        panel.add(textApellidos);

        JLabel lbl_Texto = new JLabel("Seleccione al cliente");
        lbl_Texto.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
        lbl_Texto.setBounds(10, 11, 183, 25);
        panel.add(lbl_Texto);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dm = buscarClientes(textNombre.getText(), textApellidos.getText());
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
                altaCliente();
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

    public void altaCliente() {
        AltaClienteGUI alta = new AltaClienteGUI(this);
        this.setVisible(false);
    }

    public void seleccionar() {
        if (table.getSelectedRow() != -1) {
            AnadirTrabajos2GUI siguiente = new AnadirTrabajos2GUI(this, dm.getValueAt(table.getSelectedRow(), 0).toString());
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un cliente");
        }
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        textNombre.setText(dm.getValueAt(selectedRow, 1).toString());
        textApellidos.setText(dm.getValueAt(selectedRow, 2).toString());
    }

    public String getNombre() {
        return menu.getNombre();
    }
}
