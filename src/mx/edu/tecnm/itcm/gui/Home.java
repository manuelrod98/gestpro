package mx.edu.tecnm.itcm.gui;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.edu.tecnm.itcm.util.DBConnection;

/**
 *
 * @author Manuel Avila
 */
public class Home extends JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    private void initComponents() {
        scrollPane = new JScrollPane();
        panel = new JPanel();
        scrollPaneProjects = new JScrollPane();
        tableProjects = new JTable();
        scrollPaneTasks = new JScrollPane();
        tableTasks = new JTable();
        scrollPaneUsers = new JScrollPane();
        tableUsers = new JTable();
        buttonGenerateReport = new JButton();
        buttonRefreshProjects = new JButton();
        buttonRefreshTasks = new JButton();
        buttonRefreshUsers = new JButton();
        menuBar = new JMenuBar();
        menuFile = new JMenu();
        menuEdit = new JMenu();
        menuView = new JMenu();
        menuHelp = new JMenu();
        menuAccount = new JMenu();
        menuItemSignOut = new JMenuItem();
        menuItemExit = new JMenuItem();
        menuItemAbout = new JMenuItem();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    }

    private void buttonGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {
        Document document = new Document();
        try {
            String route = System.getProperty("user.home");
            PdfWriter.getInstance(document, new FileOutputStream(route + "/Desktop/Reporte.pdf"));
            document.open();
        } catch (DocumentException | FileNotFoundException e) {

        }
    }

    private void buttonRefreshProjectsActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void buttonRefreshTasksActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void buttonRefreshUsersActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    private JButton buttonGenerateReport;
    private JButton buttonRefreshProjects;
    private JButton buttonRefreshTasks;
    private JButton buttonRefreshUsers;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JScrollPane scrollPaneProjects;
    private JScrollPane scrollPaneTasks;
    private JScrollPane scrollPaneUsers;
    private JTable tableProjects;
    private JTable tableTasks;
    private JTable tableUsers;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenu menuView;
    private JMenu menuHelp;
    private JMenu menuAccount;
    private JMenuItem menuItemAbout;
    private JMenuItem menuItemSignOut;
    private JMenuItem menuItemExit;
    private JScrollPane scrollPane;
}
