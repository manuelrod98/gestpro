package mx.edu.tecnm.itcm.util;

import java.sql.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Avila
 */
public class DBConnection {
    
    private static Connection connection = null;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/maindb", "root", 
            "password");
            JOptionPane.showMessageDialog(null, "Conexion establecida", "Conexion establecida correctamente", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException exception) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", exception.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        connection = null;
    }
}
