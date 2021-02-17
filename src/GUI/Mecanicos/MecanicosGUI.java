package GUI.Mecanicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import GUI.Proyecto.*;

public class MecanicosGUI extends AbstractGUI {

    private String profesion;
    private String nombre;

    public MecanicosGUI(LoginGUI login) {
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public MecanicosGUI(AnadirTrabajos3GUI anadir) {
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public MecanicosGUI(String nombre) {
        this.nombre = nombre;
        initialize();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void initialize() {
        init(nombre);
        
        setTitle("Menú Principal");

        JLabel lbl_Bienvenida = new JLabel("Bienvenid@ ^^ ¡Que tengas un buen dia!");
        lbl_Bienvenida.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbl_Bienvenida.setBounds(10, 11, 313, 29);
        panel.add(lbl_Bienvenida);

        JLabel lbl_Comenzar = new JLabel("COMENZAR un TRABAJO");
        lbl_Comenzar.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
        lbl_Comenzar.setBounds(10, 82, 179, 14);
        panel.add(lbl_Comenzar);

        JButton btnComenzar = new JButton("Comenzar");
        btnComenzar.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnComenzar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                comenzarTrabajos();
            }
        });
        btnComenzar.setBounds(33, 107, 124, 46);
        panel.add(btnComenzar);

        JLabel lbl_Ver = new JLabel("MIS TRABAJOS");
        lbl_Ver.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
        lbl_Ver.setBounds(308, 82, 110, 14);
        panel.add(lbl_Ver);

        JButton btnVer = new JButton("Ver");
        btnVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                verTrabajos();
            }
        });
        btnVer.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnVer.setBounds(296, 107, 124, 46);
        panel.add(btnVer);

        if (user.getProfesión().toLowerCase().equals("mecánico_jefe")) {
            JButton btnAnadir = new JButton("Añadir");
            btnAnadir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    anadirTrabajo();
                }
            });
            btnAnadir.setFont(new Font("SansSerif", Font.PLAIN, 16));
            btnAnadir.setBounds(166, 240, 124, 46);
            panel.add(btnAnadir);

            JLabel lbl_Anyadir = new JLabel("AÑADIR un TRABAJO");
            lbl_Anyadir.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
            lbl_Anyadir.setBounds(154, 215, 147, 14);
            panel.add(lbl_Anyadir);
        }
    }

    public void comenzarTrabajos() {
        ComenzarTrabajo1GUI comenzar = new ComenzarTrabajo1GUI(this);
        this.setVisible(false);
    }

    public void verTrabajos() {
        VerTrabajosGUI ver = new VerTrabajosGUI(this);
        this.setVisible(false);
    }

    public void anadirTrabajo() {
        AnadirTrabajos1GUI anadir = new AnadirTrabajos1GUI(this, user.getProfesión());
        this.setVisible(false);
    }

    public String getProfesion() {
        return profesion;
    }

    public String getNombre() {
        return nombre;
    }
}
