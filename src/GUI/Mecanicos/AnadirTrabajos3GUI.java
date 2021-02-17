package GUI.Mecanicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DAO.*;
import GUI.Proyecto.*;

public class AnadirTrabajos3GUI extends AbstractGUI {

    private final String dniCliente;
    private final AnadirTrabajos2GUI menu;
    private JTextField textProblema;
    private JTextField textPiezas;
    private JTextField textTiempo;
    private ReparaciónDAO repdao;

    public AnadirTrabajos3GUI(AnadirTrabajos2GUI menu, String dniCliente) {
        this.menu = menu;
        this.dniCliente = dniCliente;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        repdao = new ReparaciónDAO();

        setTitle("Añadir trabajo");

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

        JLabel lbl_Problema = new JLabel("Problema");
        lbl_Problema.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Problema.setBounds(108, 44, 73, 14);
        panel.add(lbl_Problema);

        JLabel lbl_Tiempo = new JLabel("Tiempo Estimado");
        lbl_Tiempo.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Tiempo.setBounds(110, 243, 128, 14);
        panel.add(lbl_Tiempo);

        JButton btnAnyadir = new JButton("AÑADIR");
        btnAnyadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                guardar();
            }
        });
        btnAnyadir.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnAnyadir.setBounds(332, 381, 134, 46);
        panel.add(btnAnyadir);

        JLabel lbl_Piezas = new JLabel("Piezas");
        lbl_Piezas.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Piezas.setBounds(110, 146, 73, 14);
        panel.add(lbl_Piezas);

        textProblema = new JTextField();
        textProblema.setBounds(118, 66, 224, 46);
        panel.add(textProblema);
        textProblema.setColumns(10);

        textPiezas = new JTextField();
        textPiezas.setColumns(10);
        textPiezas.setBounds(118, 169, 224, 46);
        panel.add(textPiezas);

        textTiempo = new JTextField();
        textTiempo.setColumns(10);
        textTiempo.setBounds(118, 268, 224, 46);
        panel.add(textTiempo);
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        menu.setVisible(true);
    }

    public void guardar() {
        if (!textProblema.getText().equals("") && !textTiempo.getText().equals("")
                && !textPiezas.getText().equals("")) {
            repdao.subirDato(new Reparación((int) (Math.random() * 1000),
                    dniCliente, "DNI Ejemplo", textProblema.getText(), 0,
                    textTiempo.getText(), textPiezas.getText()));
            this.setVisible(false);
            this.dispose();
            MecanicosGUI mecanicos = new MecanicosGUI(this);
            mecanicos.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Rellena todos los campos");
        }
    }
}
