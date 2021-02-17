package GUI.Ventas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import DAO.*;
import GUI.Proyecto.*;

public class VerPropuestasGUI extends AbstractGUI {

    private String DNI;
    private DefaultTableModel dm;
    private final VentasGUI menu;
    private JTable table;
    private JTextField text_DNI;
    private PropuestaDAO propuesdao;
    private ClienteDAO cliendao;
    private VehículoDAO vehidao;

    public VerPropuestasGUI(VentasGUI menu) {
        this.menu = menu;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        propuesdao = new PropuestaDAO();
        cliendao = new ClienteDAO();
        vehidao = new VehículoDAO();
        dm = crearPropuestas();

        setTitle("Ver Propuestas");

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
        table.setBackground(new Color(255, 255, 0));
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

        JLabel lbl_DNI = new JLabel("DNI");
        lbl_DNI.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
        lbl_DNI.setBounds(41, 13, 46, 14);
        panel.add(lbl_DNI);

        text_DNI = new JTextField();
        text_DNI.setFont(new Font("SansSerif", Font.PLAIN, 12));
        text_DNI.setBounds(73, 9, 120, 20);
        panel.add(text_DNI);
        text_DNI.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dm = buscarPropuestas(text_DNI.getText());
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
                text_DNI.setText("");
                dm = crearPropuestas();
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
        DNI = dm.getValueAt(selectedRow, 0).toString();
        text_DNI.setText(dm.getValueAt(selectedRow, 0).toString());
    }
}
