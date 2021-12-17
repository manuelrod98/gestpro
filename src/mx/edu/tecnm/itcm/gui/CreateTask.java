package mx.edu.tecnm.itcm.gui;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

/**
 *
 * @author Manuel Avila
 */
public class CreateTask extends JFrame {

    /**
     * Creates new form CreateTask
     */
    public CreateTask() {
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create task");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE));

        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateTask().setVisible(true);
            }
        });
    }
}
