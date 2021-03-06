package mx.edu.tecnm.itcm.gui;

import javax.swing.JOptionPane;
import mx.edu.tecnm.itcm.Project;
import mx.edu.tecnm.itcm.util.SqlUtils;

/**
 *
 * @author Manuel Avila
 */
public class CreateProject extends javax.swing.JFrame {

    /**
     * Creates new form CreateProject
     */
    public CreateProject() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelProjectName = new javax.swing.JLabel();
        textFieldProjectName = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0));
        labelStartDate = new javax.swing.JLabel();
        dateChooserStartDate = new com.toedter.calendar.JDateChooser();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(100, 0));
        labelFinishDate = new javax.swing.JLabel();
        dateChooserFinishDate = new com.toedter.calendar.JDateChooser();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(100, 0));
        labelDescription = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        textAreaDescription = new javax.swing.JTextArea();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(175, 0), new java.awt.Dimension(100, 0));
        buttonOK = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 450));
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        jPanel1.setPreferredSize(new java.awt.Dimension(520, 420));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        labelProjectName.setText("Project name:");
        jPanel1.add(labelProjectName);

        textFieldProjectName.setPreferredSize(new java.awt.Dimension(290, 27));
        jPanel1.add(textFieldProjectName);
        jPanel1.add(filler1);

        labelStartDate.setText("Start date:");
        jPanel1.add(labelStartDate);

        dateChooserStartDate.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel1.add(dateChooserStartDate);
        jPanel1.add(filler3);

        labelFinishDate.setText("Finish date:");
        jPanel1.add(labelFinishDate);

        dateChooserFinishDate.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel1.add(dateChooserFinishDate);
        jPanel1.add(filler2);

        labelDescription.setText("Description: ");
        jPanel1.add(labelDescription);

        scrollPane.setPreferredSize(new java.awt.Dimension(500, 250));

        textAreaDescription.setColumns(20);
        textAreaDescription.setRows(5);
        textAreaDescription.setPreferredSize(new java.awt.Dimension(300, 150));
        scrollPane.setViewportView(textAreaDescription);

        jPanel1.add(scrollPane);
        jPanel1.add(filler4);

        buttonOK.setText("OK");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });
        jPanel1.add(buttonOK);

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        this.setVisible(false);
        Home home = new Home();
        home.setVisible(true);
    }

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        if (thereAreEmptyFields()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Hay campos vacios", JOptionPane.ERROR_MESSAGE);
        } else {
            SqlUtils.createProject(new Project(textFieldProjectName.getText(), dateChooserStartDate.getDate(), dateChooserFinishDate.getDate(), textAreaDescription.getText()));
            JOptionPane.showMessageDialog(this, "Proyecto creado correctamente", "Proyecto creado",
                    JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            Home home = new Home();
            home.setVisible(true);
        }
    }

    private boolean thereAreEmptyFields() {
        return textFieldProjectName.getText().equals("") || textAreaDescription.getText().equals("")
                || dateChooserStartDate.getDate() == null || dateChooserFinishDate.getDate() == null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreateProject().setVisible(true);
            }
        });
    }

    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonOK;
    private com.toedter.calendar.JDateChooser dateChooserFinishDate;
    private com.toedter.calendar.JDateChooser dateChooserStartDate;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelFinishDate;
    private javax.swing.JLabel labelProjectName;
    private javax.swing.JLabel labelStartDate;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textAreaDescription;
    private javax.swing.JTextField textFieldProjectName;
}
