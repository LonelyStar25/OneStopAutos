package GUI.Mecanicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DAO.*;
import GUI.Proyecto.*;

public class ComenzarTrabajo2GUI extends AbstractGUI {

    private final ComenzarTrabajo1GUI volverComenzar;
    private final String NumIncidencia;
    private final MecanicosGUI menu;
    private ReparaciónDAO repdao;

    public ComenzarTrabajo2GUI(ComenzarTrabajo1GUI propuestaNombre, MecanicosGUI menu, String NumIncidencia) {
        this.volverComenzar = propuestaNombre;
        this.menu = menu;
        this.NumIncidencia = NumIncidencia;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initialize() {
        init(menu.getNombre());
        repdao=new ReparaciónDAO();
        
        setTitle("Comenzar un trabajo");
        
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

        JButton btnTerminado = new JButton("Terminar");
        btnTerminado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                terminado();
            }
        });
        btnTerminado.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnTerminado.setBounds(332, 381, 134, 46);
        panel.add(btnTerminado);

        JLabel lbl_Suerte = new JLabel("Mucha suerte en la reparación");
        lbl_Suerte.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbl_Suerte.setBounds(10, 11, 313, 29);
        panel.add(lbl_Suerte);

        JButton btnLlamar = new JButton("Llamar al cliente");
        btnLlamar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                llamar();
            }
        });
        btnLlamar.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnLlamar.setBounds(173, 381, 134, 46);
        panel.add(btnLlamar);
    }

    public void volver() {
        this.setVisible(false);
        this.dispose();
        volverComenzar.setVisible(true);
    }

    public void terminado() {
        int boton = JOptionPane.showConfirmDialog(null, "Confirmar la finalización", "Finalizar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (boton == JOptionPane.YES_OPTION) {
            //repdao.eliminarDato(new Reparación(Integer.parseInt(NumIncidencia)));

            this.setVisible(false);
            this.dispose();
            volverComenzar.setVisible(true);
        }
    }

    public void llamar() {
        int boton = JOptionPane.showConfirmDialog(null, "¿Desea llamar al cliente?", "Llamar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (boton == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Llamando...");
        }
    }
}
