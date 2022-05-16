package mx.edu.tecnm.itcm.gui;

import javax.swing.JOptionPane;
import mx.edu.tecnm.itcm.User;
import mx.edu.tecnm.itcm.util.SqlUtils;

/**
 *
 * @author Manuel Avila
 */
public class SignIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public SignIn() {
        initComponents();
    }

    private void initComponents() {
        fillerWest = new javax.swing.Box.Filler(new java.awt.Dimension(45, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        fillerEast = new javax.swing.Box.Filler(new java.awt.Dimension(45, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 25), new java.awt.Dimension(0, 25), new java.awt.Dimension(32767, 25));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 25), new java.awt.Dimension(0, 25), new java.awt.Dimension(32767, 25));
        panelCenter = new javax.swing.JPanel();
        labelEmail = new javax.swing.JLabel();
        textFieldEmail = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        passwordFieldPassword = new javax.swing.JPasswordField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(125, 0), new java.awt.Dimension(125, 0), new java.awt.Dimension(250, 0));
        buttonLogin = new javax.swing.JButton();
        panelLast = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(95, 0), new java.awt.Dimension(20, 32767));
        labelCreateAccount = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(95, 0), new java.awt.Dimension(20, 32767));
        buttonCreateAccount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign In");
        setMinimumSize(new java.awt.Dimension(290, 290));
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));
        getContentPane().add(fillerWest, java.awt.BorderLayout.WEST);
        getContentPane().add(fillerEast, java.awt.BorderLayout.EAST);
        getContentPane().add(filler4, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(filler5, java.awt.BorderLayout.PAGE_END);

        panelCenter.setMinimumSize(new java.awt.Dimension(290, 90));
        panelCenter.setPreferredSize(new java.awt.Dimension(290, 90));
        panelCenter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        labelEmail.setText("E-mail:");
        labelEmail.setPreferredSize(new java.awt.Dimension(43, 14));
        panelCenter.add(labelEmail);

        textFieldEmail.setPreferredSize(new java.awt.Dimension(300, 30));
        panelCenter.add(textFieldEmail);

        labelPassword.setText("Password:");
        labelPassword.setPreferredSize(new java.awt.Dimension(70, 14));
        panelCenter.add(labelPassword);

        passwordFieldPassword.setPreferredSize(new java.awt.Dimension(300, 30));
        panelCenter.add(passwordFieldPassword);
        panelCenter.add(filler1);

        buttonLogin.setText("Sign in");
        buttonLogin.setPreferredSize(new java.awt.Dimension(80, 25));
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        panelCenter.add(buttonLogin);

        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);

        panelLast.setPreferredSize(new java.awt.Dimension(212, 70));
        panelLast.add(filler3);

        labelCreateAccount.setText("No tienes una cuenta?");
        panelLast.add(labelCreateAccount);
        panelLast.add(filler2);

        buttonCreateAccount.setText("Create account");
        buttonCreateAccount.setPreferredSize(new java.awt.Dimension(117, 25));
        buttonCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateAccountActionPerformed(evt);
            }
        });
        panelLast.add(buttonCreateAccount);

        getContentPane().add(panelLast, java.awt.BorderLayout.PAGE_END);

        pack();
    }

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        User user = new User();
        if (!textFieldEmail.getText().equals("") && !passwordFieldPassword.getText().equals("")) {
            user.setUsername(textFieldEmail.getText());
            user.setPassword(passwordFieldPassword.getText());
            if (SqlUtils.signIn(user)) {
                Home home = new Home();
                home.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error al iniciar sesion", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Rellene todos los campos", "Hay campos vacios", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buttonCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateAccountActionPerformed
        SignUp signUpFrame = new SignUp();
        signUpFrame.setVisible(true);
        setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    private javax.swing.JButton buttonCreateAccount;
    private javax.swing.JButton buttonLogin;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler fillerEast;
    private javax.swing.Box.Filler fillerWest;
    private javax.swing.JLabel labelCreateAccount;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLast;
    private javax.swing.JPasswordField passwordFieldPassword;
    private javax.swing.JTextField textFieldEmail;
}
