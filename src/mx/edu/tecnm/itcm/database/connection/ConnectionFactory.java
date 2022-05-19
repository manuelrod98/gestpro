package mx.edu.tecnm.itcm.databse.connection;

import javax.swing.JOptionPane;
import java.sql.*;

public class ConnectionFactory {
    public static Connection getConnection(String user, String password) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmain", user, password);
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmain",
                    "root", "password");
            JOptionPane.showMessageDialog(null,
                    "Conexión exitosa", "Conexión",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
