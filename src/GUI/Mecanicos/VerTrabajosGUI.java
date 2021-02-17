package GUI.Mecanicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import GUI.Proyecto.*;

public class VerTrabajosGUI extends AbstractGUI {

    private DefaultTableModel dm;
    private final MecanicosGUI menu;
    private JTable table;

    public VerTrabajosGUI(MecanicosGUI menu) {
        this.menu = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        dm=crearReparaciones();
        
        setTitle("Ver lista de Trabajos");
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                volver();
            }
        });
        btnVolver.setFont(new Font("SansSerif", Font.BOLD, 22));
        btnVolver.setBounds(157, 344, 189, 70);
        panel.add(btnVolver);

        table = new JTable(dm);
        table.setFont(new Font("SansSerif", Font.PLAIN, 12));
        table.setBackground(Color.yellow);
        table.getTableHeader().setBackground(Color.orange);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setLocation(10, 57);
        scrollPane.setSize(456, 256);

        table.setBounds(20, 70, 446, 305);
        panel.add(scrollPane);
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        menu.setVisible(true);
    }
}
