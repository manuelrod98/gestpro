package mx.edu.tecnm.itcm.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.Box.*;
import java.awt.event.*;

import mx.edu.tecnm.itcm.util.SqlUtils;

/**
 *
 * @author Manuel Avila
 */
public class SignUp extends JFrame {

    /**
     * Creates new form SignUp
     */
    public SignUp() {
        initComponents();
    }

    private void initComponents() {
        fillerNorth = new Filler(new Dimension(0, 5), new Dimension(0, 10), new Dimension(0, 15));
        fillerSouth = new Filler(new Dimension(0, 5), new Dimension(0, 10), new Dimension(0, 15));
        fillerEast = new Filler(new Dimension(5, 0), new Dimension(10, 0), new Dimension(15, 0));
        fillerWest = new Filler(new Dimension(5, 0), new Dimension(10, 0), new Dimension(15, 0));
        panelCenter = new JPanel();
        labelName = new JLabel();
        textFieldName = new JTextField();
        labelLastName = new JLabel();
        textFieldLastName = new JTextField();
        labelUsername = new JLabel();
        textFieldUsername = new JTextField();
        labelEmail = new JLabel();
        textFieldEmail = new JTextField();
        labelPassword = new JLabel();
        passwordFieldPassword = new JPasswordField();
        labelConfirmPassword = new JLabel();
        passwordFieldConfirmPassword = new JPasswordField();
        labelRole = new JLabel();
        comboBoxRole = new JComboBox<>();
        buttonSignUp = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");
        setPreferredSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().add(fillerNorth, BorderLayout.NORTH);
        getContentPane().add(fillerSouth, BorderLayout.SOUTH);
        getContentPane().add(fillerEast, BorderLayout.EAST);
        getContentPane().add(fillerWest, BorderLayout.WEST);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEADING);
        flowLayout.setAlignOnBaseline(true);
        panelCenter.setPreferredSize(new Dimension(340, 410));
        panelCenter.setLayout(flowLayout);

        labelName.setText("Name *:");
        panelCenter.add(labelName);

        textFieldName.setPreferredSize(new Dimension(270, 30));
        panelCenter.add(textFieldName);

        labelLastName.setText("Last Name *:");
        panelCenter.add(labelLastName);

        textFieldLastName.setPreferredSize(new Dimension(270, 30));
        panelCenter.add(textFieldLastName);

        labelUsername.setText("Username *:");
        panelCenter.add(labelUsername);

        textFieldUsername.setPreferredSize(new Dimension(270, 30));
        panelCenter.add(textFieldUsername);

        labelEmail.setText("E-mail*:");
        panelCenter.add(labelEmail);

        textFieldEmail.setPreferredSize(new Dimension(270, 30));
        panelCenter.add(textFieldEmail);

        labelPassword.setText("Password*:");
        panelCenter.add(labelPassword);

        passwordFieldPassword.setPreferredSize(new Dimension(270, 30));
        panelCenter.add(passwordFieldPassword);

        labelConfirmPassword.setText("Confirm password*:");
        panelCenter.add(labelConfirmPassword);

        passwordFieldConfirmPassword.setPreferredSize(new Dimension(270, 30));
        panelCenter.add(passwordFieldConfirmPassword);

        labelRole.setText("Role *:");
        panelCenter.add(labelRole);

        comboBoxRole.setMaximumRowCount(10);
        comboBoxRole.setModel(new DefaultComboBoxModel<>(
                new String[] { "Select a role...", "Project Manager", "Developer" }));
        comboBoxRole.setPreferredSize(new Dimension(200, 25));
        panelCenter.add(comboBoxRole);

        buttonSignUp.setText("Sign up");
        buttonSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSignUpActionPerformed(evt);
            }
        });
        panelCenter.add(buttonSignUp);

        getContentPane().add(panelCenter, BorderLayout.CENTER);

        pack();
    }

    private void buttonSignUpActionPerformed(ActionEvent evt) {
        if (textFieldUsername.getText().equals("")
                || textFieldEmail.getText().equals("")
                || passwordFieldPassword.getPassword().equals("")
                || passwordFieldConfirmPassword.getPassword().equals("")
                || textFieldName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
        } else {
            if (passwordFieldPassword.getPassword() == passwordFieldConfirmPassword.getPassword()) {
                SqlUtils.guardar(textFieldUsername.getText(), textFieldName.getText(), textFieldEmail.getText(),
                        passwordFieldPassword.getText());
                JOptionPane.showMessageDialog(this, "Usuario creado correctamente", "Usuario creado",
                        JOptionPane.PLAIN_MESSAGE);
                this.setVisible(false);
                SignIn logInFrame = new SignIn();
                logInFrame.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "Verifique la contraseña", "Ha ocurrido un error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    private JButton buttonSignUp;
    private JComboBox<String> comboBoxRole;
    private Filler fillerNorth;
    private Filler fillerSouth;
    private Filler fillerEast;
    private Filler fillerWest;
    private JLabel labelConfirmPassword;
    private JLabel labelEmail;
    private JLabel labelLastName;
    private JLabel labelName;
    private JLabel labelPassword;
    private JLabel labelRole;
    private JLabel labelUsername;
    private JPanel panelCenter;
    private JPasswordField passwordFieldConfirmPassword;
    private JPasswordField passwordFieldPassword;
    private JTextField textFieldEmail;
    private JTextField textFieldLastName;
    private JTextField textFieldName;
    private JTextField textFieldUsername;
}
