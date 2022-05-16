package mx.edu.tecnm.itcm.gui;

import javax.swing.JOptionPane;
import mx.edu.tecnm.itcm.User;
import mx.edu.tecnm.itcm.util.SqlUtils;

/**
 *
 * @author Manuel Avila
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    public SignUp() {
        initComponents();
    }

    private void initComponents() {
        fillerFirst = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        fillerLast = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        fillerAfter = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(40, 10), new java.awt.Dimension(10, 10));
        fillerBefore = new javax.swing.Box.Filler(new java.awt.Dimension(40, 10), new java.awt.Dimension(20, 10), new java.awt.Dimension(40, 10));
        panelCenter = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        labelLastName = new javax.swing.JLabel();
        textFieldLastName = new javax.swing.JTextField();
        labelUsername = new javax.swing.JLabel();
        textFieldUsername = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        textFieldEmail = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        passwordFieldPassword = new javax.swing.JPasswordField();
        labelConfirmPassword = new javax.swing.JLabel();
        passwordFieldConfirmPassword = new javax.swing.JPasswordField();
        labelRole = new javax.swing.JLabel();
        comboBoxRole = new javax.swing.JComboBox<>();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(250, 10), new java.awt.Dimension(250, 10), new java.awt.Dimension(250, 10));
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0));
        buttonSignUp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");
        setPreferredSize(new java.awt.Dimension(440, 500));
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));
        getContentPane().add(fillerFirst, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(fillerLast, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(fillerAfter, java.awt.BorderLayout.LINE_END);
        getContentPane().add(fillerBefore, java.awt.BorderLayout.WEST);

        panelCenter.setPreferredSize(new java.awt.Dimension(400, 600));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEADING);
        flowLayout1.setAlignOnBaseline(true);
        panelCenter.setLayout(flowLayout1);

        labelName.setText("Name *:");
        labelName.setPreferredSize(new java.awt.Dimension(50, 14));
        panelCenter.add(labelName);

        textFieldName.setPreferredSize(new java.awt.Dimension(300, 30));
        panelCenter.add(textFieldName);

        labelLastName.setText("Last Name *:");
        labelLastName.setMaximumSize(new java.awt.Dimension(80, 14));
        labelLastName.setPreferredSize(new java.awt.Dimension(70, 14));
        panelCenter.add(labelLastName);

        textFieldLastName.setPreferredSize(new java.awt.Dimension(300, 30));
        panelCenter.add(textFieldLastName);

        labelUsername.setText("Username *:");
        labelUsername.setPreferredSize(new java.awt.Dimension(70, 14));
        panelCenter.add(labelUsername);

        textFieldUsername.setPreferredSize(new java.awt.Dimension(300, 30));
        panelCenter.add(textFieldUsername);

        labelEmail.setText("E-mail *:");
        labelEmail.setPreferredSize(new java.awt.Dimension(50, 14));
        panelCenter.add(labelEmail);

        textFieldEmail.setPreferredSize(new java.awt.Dimension(300, 30));
        panelCenter.add(textFieldEmail);

        labelPassword.setText("Password *:");
        labelPassword.setPreferredSize(new java.awt.Dimension(70, 14));
        panelCenter.add(labelPassword);

        passwordFieldPassword.setPreferredSize(new java.awt.Dimension(300, 30));
        panelCenter.add(passwordFieldPassword);

        labelConfirmPassword.setText("Confirm password *:");
        labelConfirmPassword.setPreferredSize(new java.awt.Dimension(110, 14));
        panelCenter.add(labelConfirmPassword);

        passwordFieldConfirmPassword.setPreferredSize(new java.awt.Dimension(300, 30));
        panelCenter.add(passwordFieldConfirmPassword);

        labelRole.setText("Role *:");
        labelRole.setPreferredSize(new java.awt.Dimension(40, 14));
        panelCenter.add(labelRole);

        comboBoxRole.setMaximumRowCount(10);
        comboBoxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a role...", "Project Manager", "Developer" }));
        comboBoxRole.setPreferredSize(new java.awt.Dimension(150, 25));
        panelCenter.add(comboBoxRole);
        panelCenter.add(filler2);
        panelCenter.add(filler1);

        buttonSignUp.setText("Sign up");
        buttonSignUp.setMargin(new java.awt.Insets(2, 2, 2, 2));
        buttonSignUp.setPreferredSize(new java.awt.Dimension(80, 25));
        buttonSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSignUpActionPerformed(evt);
            }
        });
        panelCenter.add(buttonSignUp);

        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);

        pack();
    }
    private void buttonSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSignUpActionPerformed
        User user = new User(textFieldName.getText(), textFieldLastName.getText(), textFieldUsername.getText(), textFieldEmail.getText(),
                        passwordFieldPassword.getText()); 
        if (thereAreEmptyFields()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
        } else {
            if (matchPasword()) {
                SqlUtils.signUp(user);
                JOptionPane.showMessageDialog(this, "Usuario creado correctamente", "Usuario creado",
                        JOptionPane.PLAIN_MESSAGE);
                this.setVisible(false);
                SignIn logInFrame = new SignIn();
                logInFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Ha ocurrido un error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean thereAreEmptyFields() {
        return textFieldUsername.getText().equals("")
                || textFieldEmail.getText().equals("")
                || passwordFieldPassword.getPassword().equals("")
                || passwordFieldConfirmPassword.getPassword().equals("")
                || textFieldName.getText().equals("");
    }
    
    private boolean matchPasword(){
        return passwordFieldPassword.getText().equals(passwordFieldConfirmPassword.getText());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    private javax.swing.JButton buttonSignUp;
    private javax.swing.JComboBox<String> comboBoxRole;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler fillerAfter;
    private javax.swing.Box.Filler fillerBefore;
    private javax.swing.Box.Filler fillerFirst;
    private javax.swing.Box.Filler fillerLast;
    private javax.swing.JLabel labelConfirmPassword;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelLastName;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelRole;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPasswordField passwordFieldConfirmPassword;
    private javax.swing.JPasswordField passwordFieldPassword;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldLastName;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldUsername;
}
