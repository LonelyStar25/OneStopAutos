package GUI.Mecanicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import GUI.Proyecto.*;

public class ComenzarTrabajo1GUI extends AbstractGUI {

    private final MecanicosGUI menu;
    private String NumIncidencia;
    private DefaultTableModel dm;
    private JTable table;

    public ComenzarTrabajo1GUI(MecanicosGUI menu) {
        this.menu = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        dm=crearReparaciones();

        setTitle("Comenzar un trabajo");
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                volver();
            }
        });
        btnVolver.setFont(new Font("SansSerif", Font.BOLD, 20));
        btnVolver.setBounds(10, 344, 175, 62);
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
        table.setFont(new Font("SansSerif", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setLocation(10, 38);
        scrollPane.setSize(456, 265);

        table.setBounds(20, 70, 446, 305);
        panel.add(scrollPane);

        JButton btnComenzar = new JButton("Comenzar");
        btnComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                siguientePaso();
            }
        });
        btnComenzar.setFont(new Font("SansSerif", Font.BOLD, 20));
        btnComenzar.setBounds(291, 344, 175, 62);
        panel.add(btnComenzar);
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        menu.setVisible(true);
    }

    public void siguientePaso() {
        try {
            int selectedRow = table.getSelectedRow();
            NumIncidencia = dm.getValueAt(selectedRow, 0).toString();
            ComenzarTrabajo2GUI siguiente = new ComenzarTrabajo2GUI(this, menu, NumIncidencia);
            this.setVisible(false);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException aiooe) {
            JOptionPane.showMessageDialog(null, "Señala la reparación a realizar");
        }
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        NumIncidencia = dm.getValueAt(selectedRow, 0).toString();
    }
}
