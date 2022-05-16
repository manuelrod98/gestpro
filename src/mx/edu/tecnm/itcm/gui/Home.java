package mx.edu.tecnm.itcm.gui;

import java.sql.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.edu.tecnm.itcm.util.DBConnection;

/**
 *
 * @author Manuel Avila
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        scrollPaneProjects = new javax.swing.JScrollPane();
        tableProjects = new javax.swing.JTable();
        scrollPaneTasks = new javax.swing.JScrollPane();
        tableTasks = new javax.swing.JTable();
        scrollPaneUsers = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        buttonGenerateReport = new javax.swing.JButton();
        buttonRefreshProjects = new javax.swing.JButton();
        buttonRefreshTasks = new javax.swing.JButton();
        buttonRefreshUsers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        scrollPane.setPreferredSize(new java.awt.Dimension(600, 600));

        panel.setPreferredSize(new java.awt.Dimension(600, 600));

        scrollPaneProjects.setPreferredSize(new java.awt.Dimension(452, 189));

        tableProjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Start Date", "Finish Date", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneProjects.setViewportView(tableProjects);

        panel.add(scrollPaneProjects);

        scrollPaneTasks.setPreferredSize(new java.awt.Dimension(452, 189));

        tableTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Description", "Start Date", "Finish Date", "Assidgned user", "Owner project"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneTasks.setViewportView(tableTasks);

        panel.add(scrollPaneTasks);

        scrollPaneUsers.setPreferredSize(new java.awt.Dimension(452, 189));

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Last Name", "Username", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneUsers.setViewportView(tableUsers);

        panel.add(scrollPaneUsers);

        buttonGenerateReport.setText("Generate report");
        buttonGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateReportActionPerformed(evt);
            }
        });
        panel.add(buttonGenerateReport);

        buttonRefreshProjects.setText("Refresh projects");
        buttonRefreshProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshProjectsActionPerformed(evt);
            }
        });
        panel.add(buttonRefreshProjects);

        buttonRefreshTasks.setText("Refresh tasks");
        buttonRefreshTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshTasksActionPerformed(evt);
            }
        });
        panel.add(buttonRefreshTasks);

        buttonRefreshUsers.setText("Refresh users");
        buttonRefreshUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshUsersActionPerformed(evt);
            }
        });
        panel.add(buttonRefreshUsers);

        scrollPane.setViewportView(panel);

        getContentPane().add(scrollPane, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateReportActionPerformed
        Document document = new Document();
        try {
            String route = System.getProperty("user.home");
            PdfWriter.getInstance(document, new FileOutputStream(route + "/Desktop/Reporte.pdf"));
            document.open();
        } catch (DocumentException | FileNotFoundException e) {

        }
    }//GEN-LAST:event_buttonGenerateReportActionPerformed

    private void buttonRefreshProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshProjectsActionPerformed
        try {
            DefaultTableModel model = new DefaultTableModel();
            tableProjects.setModel(model);
            PreparedStatement ps;
            ResultSet rs;
            DBConnection dbConn = new DBConnection();
            Connection conn = dbConn.connect();
            ps = conn.prepareStatement("SELECT * FROM project");
            rs = ps.executeQuery();
            ResultSetMetaData rSMD = rs.getMetaData();
            int colCant = rSMD.getColumnCount();
            Object[] rows = new Object[colCant];
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Description");
            model.addColumn("Start Date");
            model.addColumn("Finish Date");
            while (rs.next()) {
                for (int i = 0; i < colCant; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ha ocurrido un error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buttonRefreshProjectsActionPerformed

    private void buttonRefreshTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshTasksActionPerformed
        try {
            DefaultTableModel model = new DefaultTableModel();
            tableTasks.setModel(model);
            PreparedStatement ps;
            ResultSet rs;
            DBConnection dbConn = new DBConnection();
            Connection conn = dbConn.connect();
            ps = conn.prepareStatement("SELECT * FROM task");
            rs = ps.executeQuery();
            ResultSetMetaData rSMD = rs.getMetaData();
            int colCant = rSMD.getColumnCount();
            Object[] rows = new Object[colCant];
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Description");
            model.addColumn("Start Date");
            model.addColumn("Finish Date");
            model.addColumn("Assigned user");
            model.addColumn("Owner project");
            while (rs.next()) {
                for (int i = 0; i < colCant; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ha ocurrido un error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buttonRefreshTasksActionPerformed

    private void buttonRefreshUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshUsersActionPerformed
        try {
            DefaultTableModel model = new DefaultTableModel();
            tableUsers.setModel(model);
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = DBConnection.connect();
            ps = conn.prepareStatement("SELECT * FROM user");
            rs = ps.executeQuery();
            ResultSetMetaData rSMD = rs.getMetaData();
            int colCant = rSMD.getColumnCount();
            Object[] rows = new Object[colCant];
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Last Name");
            model.addColumn("Username");
            model.addColumn("Email");
            while (rs.next()) {
                for (int i = 0; i < colCant; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ha ocurrido un error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buttonRefreshUsersActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGenerateReport;
    private javax.swing.JButton buttonRefreshProjects;
    private javax.swing.JButton buttonRefreshTasks;
    private javax.swing.JButton buttonRefreshUsers;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollPaneProjects;
    private javax.swing.JScrollPane scrollPaneTasks;
    private javax.swing.JScrollPane scrollPaneUsers;
    private javax.swing.JTable tableProjects;
    private javax.swing.JTable tableTasks;
    private javax.swing.JTable tableUsers;
    // End of variables declaration//GEN-END:variables
}
