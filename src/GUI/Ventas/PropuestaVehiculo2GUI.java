package GUI.Ventas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import DAO.*;
import GUI.Proyecto.*;

public class PropuestaVehiculo2GUI extends AbstractGUI {

    private final PropuestaVehiculo1GUI propuestaNombre;
    private String DNI;
    private final VentasGUI menu;
    private DefaultTableModel dm;
    private JTable table;
    private JTextField text_Marca;
    private JTextField text_Modelo;
    private JTextField text_Tipo;
    private PropuestaDAO propuesdao;

    public PropuestaVehiculo2GUI(PropuestaVehiculo1GUI propuestaNombre, VentasGUI menu) {
        this.propuestaNombre = propuestaNombre;
        this.menu = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        propuesdao = new PropuestaDAO();
        dm=crearVehículos();

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
        table.setFont(new Font("SansSerif", Font.PLAIN, 12));
        table.setBackground(Color.yellow);
        table.getTableHeader().setBackground(Color.orange);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setLocation(10, 95);
        scrollPane.setSize(456, 265);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableMouseClicked(e);
            }
        });
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
                proponerOtro();
            }
        });
        btnSiguiente.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnSiguiente.setBounds(332, 381, 134, 46);
        panel.add(btnSiguiente);

        JLabel lbl_Tipo = new JLabel("Tipo");
        lbl_Tipo.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Tipo.setBounds(253, 12, 55, 20);
        panel.add(lbl_Tipo);

        text_Tipo = new JTextField();
        text_Tipo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        text_Tipo.setColumns(10);
        text_Tipo.setBounds(292, 12, 134, 20);
        panel.add(text_Tipo);

        JButton btnReset = new JButton("Resetear");
        btnReset.setBounds(237, 50, 89, 23);
        panel.add(btnReset);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                text_Tipo.setText("");
                text_Modelo.setText("");
                text_Marca.setText("");
                dm=crearVehículos();
                table.setModel(dm);
            }
        });
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        propuestaNombre.setVisible(true);
    }

    public void proponerOtro() {
        int boton = JOptionPane.showConfirmDialog(null, "¿Desea proponer otro vehículo?", "Finalizar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        try {
            propuesdao.subirDato(new Propuesta(DNI, (int) dm.getValueAt(table.getSelectedRow(), 0)));
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Señala el vehículo que le vas a proponer a la persona");
        }
        if (boton == JOptionPane.NO_OPTION) {
            this.setVisible(false);
            this.dispose();
            menu.setVisible(true);
        }
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        text_Marca.setText(dm.getValueAt(selectedRow, 2).toString());
        text_Modelo.setText(dm.getValueAt(selectedRow, 1).toString());
        text_Tipo.setText(dm.getValueAt(selectedRow, 3).toString());
    }

    public void guardarPropuesta1(String DNI) {
        this.DNI = DNI;
    }
}
