package GUI.Proyecto;

import DAO.*;
import GUI.Mecanicos.*;
import GUI.Ventas.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame {

    private JFrame frame;
    private JTextField textUser;
    private JPasswordField textPassword;
    private UsuarioDAO usudao;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    LoginGUI window = new LoginGUI();
                    window.setVisible(true);
                } catch (Exception e) {
                }
            }
        });
    }

    public LoginGUI() {
        initialize();
        setLocationRelativeTo(null);
    }

    private void initialize() {
        usudao = new UsuarioDAO();

        frame = new JFrame();
        setTitle("Login");
        setBounds(100, 100, 435, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 140, 0));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblImagen = new JLabel("imagen");
        lblImagen.setIcon(new ImageIcon(".\\src\\GUI\\images\\myLogo_Login.png"));
        lblImagen.setBounds(149, 23, 122, 55);
        panel.add(lblImagen);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblUsuario.setBounds(100, 94, 58, 14);
        panel.add(lblUsuario);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblContraseña.setBounds(73, 130, 85, 14);
        panel.add(lblContraseña);

        textUser = new JTextField();
        textUser.setFont(new Font("SansSerif", Font.PLAIN, 14));
        textUser.setBounds(164, 93, 148, 20);
        panel.add(textUser);
        textUser.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                login();
            }
        });
        btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnLogin.setBounds(164, 179, 89, 23);
        panel.add(btnLogin);

        textPassword = new JPasswordField();
        textPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });
        textPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
        textPassword.setBounds(164, 129, 148, 20);
        panel.add(textPassword);
    }

    public void login() {
        if (usudao.comprobarUsuario(new UsuarioLogin(textUser.getText(), textPassword.getText()))) {
            Usuario user = (Usuario) usudao.buscarDato(textUser.getText()).get(0);

            switch (user.getProfesión().toLowerCase()) {
                case "ventas":
                    VentasGUI vGUI = new VentasGUI(user.getNombre());
                    this.setVisible(false);
                    break;
                case "mecánico":
                case "mecánico_jefe":
                    MecanicosGUI mGUI = new MecanicosGUI(user.getNombre());
                    this.setVisible(false);
                    break;
                case "jefe":
                    JOptionPane.showMessageDialog(null, "EN CONSTRUCCIÓN");
                    break;
                default:
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
        }
    }
}
