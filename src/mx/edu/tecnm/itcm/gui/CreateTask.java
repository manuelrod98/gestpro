package mx.edu.tecnm.itcm.gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.edu.tecnm.itcm.Project;
import mx.edu.tecnm.itcm.Task;
import mx.edu.tecnm.itcm.User;
import mx.edu.tecnm.itcm.util.SqlUtils;

/**
 *
 * @author Manuel Avila
 */
public class CreateTask extends javax.swing.JFrame {

    /**
     * Creates new form CreateTask
     */
    public CreateTask() {
        initComponents();
        fillUserList();
        fillProjectList();
    }

    private void fillUserList() {
        comboBoxChooseUser.removeAllItems();
        ArrayList<User> userList = SqlUtils.getUserList();
        for (int i = 0; i < userList.size(); i++) {
            comboBoxChooseUser.addItem(new User(userList.get(i).getId(), userList.get(i).getName(), userList.get(i).getLastName()));
        }
    }

    private void fillProjectList() {
        comboBoxSelectProject.removeAllItems();
        ArrayList<Project> projectList = SqlUtils.getProjectList();
        for (int i = 0; i < projectList.size(); i++) {
            comboBoxSelectProject.addItem(new Project(projectList.get(i).getId(), projectList.get(i).getName()));
        }
    }

    private void initComponents() {

        panelCenter = new javax.swing.JPanel();
        labelTaskName = new javax.swing.JLabel();
        textFieldTaskName = new javax.swing.JTextField();
        labelStartDate = new javax.swing.JLabel();
        dateChooserStartDate = new com.toedter.calendar.JDateChooser();
        labelFinishDate = new javax.swing.JLabel();
        dateChooserFinishDate = new com.toedter.calendar.JDateChooser();
        labelChooseUser = new javax.swing.JLabel();
        comboBoxChooseUser = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        comboBoxSelectProject = new javax.swing.JComboBox<>();
        labelDescription = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        textAreaDescription = new javax.swing.JTextArea();
        buttonOK = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 50));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 50));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create task");
        setMinimumSize(new java.awt.Dimension(600, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        panelCenter.setPreferredSize(new java.awt.Dimension(390, 390));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        panelCenter.setLayout(flowLayout1);

        labelTaskName.setText("Task name:");
        panelCenter.add(labelTaskName);

        textFieldTaskName.setPreferredSize(new java.awt.Dimension(200, 28));
        panelCenter.add(textFieldTaskName);

        labelStartDate.setText("Start date:");
        panelCenter.add(labelStartDate);

        dateChooserStartDate.setPreferredSize(new java.awt.Dimension(150, 27));
        panelCenter.add(dateChooserStartDate);

        labelFinishDate.setText("Finish date:");
        panelCenter.add(labelFinishDate);

        dateChooserFinishDate.setPreferredSize(new java.awt.Dimension(150, 27));
        panelCenter.add(dateChooserFinishDate);

        labelChooseUser.setText("Choose user:");
        panelCenter.add(labelChooseUser);

        comboBoxChooseUser.setPreferredSize(new java.awt.Dimension(200, 25));
        panelCenter.add(comboBoxChooseUser);

        jLabel1.setText("Select project");
        panelCenter.add(jLabel1);

        comboBoxSelectProject.setPreferredSize(new java.awt.Dimension(200, 24));
        panelCenter.add(comboBoxSelectProject);

        labelDescription.setText("Description:");
        panelCenter.add(labelDescription);

        scrollPane.setPreferredSize(new java.awt.Dimension(400, 200));

        textAreaDescription.setColumns(20);
        textAreaDescription.setRows(5);
        textAreaDescription.setPreferredSize(new java.awt.Dimension(400, 200));
        scrollPane.setViewportView(textAreaDescription);

        panelCenter.add(scrollPane);

        buttonOK.setText("OK");
        buttonOK.setPreferredSize(new java.awt.Dimension(70, 25));
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });
        panelCenter.add(buttonOK);

        buttonCancel.setText("Cancel");
        buttonCancel.setPreferredSize(new java.awt.Dimension(70, 25));
        panelCenter.add(buttonCancel);

        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);
        getContentPane().add(filler1, java.awt.BorderLayout.LINE_START);
        getContentPane().add(filler2, java.awt.BorderLayout.LINE_END);
        getContentPane().add(filler3, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(filler4, java.awt.BorderLayout.PAGE_END);

        pack();
    }

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        Task task = new Task(textFieldTaskName.getText(), dateChooserStartDate.getDate(), dateChooserFinishDate.getDate(), textAreaDescription.getText(), comboBoxChooseUser.getItemAt(comboBoxChooseUser.getSelectedIndex()), comboBoxSelectProject.getItemAt(comboBoxSelectProject.getSelectedIndex()));
        if (thereAreEmptyFields()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Hay campos vacios", JOptionPane.ERROR_MESSAGE);
        } else {
            SqlUtils.createTask(task);
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Tarea creada correctamente", "Tarea creada",
                    JOptionPane.PLAIN_MESSAGE);
            Home home = new Home();
            home.setVisible(true);
        }
    }

    private boolean thereAreEmptyFields() {
        return textFieldTaskName.getText().equals("")
                || dateChooserStartDate.getDate() == null
                || dateChooserFinishDate.getDate() == null
                || comboBoxChooseUser.getSelectedItem() == null
                || textAreaDescription.getText().equals("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreateTask().setVisible(true);
            }
        });
    }

    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox<User> comboBoxChooseUser;
    private javax.swing.JComboBox<Project> comboBoxSelectProject;
    private com.toedter.calendar.JDateChooser dateChooserFinishDate;
    private com.toedter.calendar.JDateChooser dateChooserStartDate;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelChooseUser;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelFinishDate;
    private javax.swing.JLabel labelStartDate;
    private javax.swing.JLabel labelTaskName;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textAreaDescription;
    private javax.swing.JTextField textFieldTaskName;
}
