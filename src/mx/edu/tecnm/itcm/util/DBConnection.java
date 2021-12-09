package mx.edu.tecnm.itcm.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Avila
 */
public class DBConnection {

    public static String url = "jdbc:mysql://localhost/maindb";
    public static String user = "root";
    public static String password = "SAdi6j8SgWJW(@f";
    public static String clase = "com.mysql.cj.jdbc.Driver";

    public static Connection connect() {
        Connection conexion = null;
        try {
            Class.forName(clase);
            conexion = (Connection) DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conexion establecida", "Conexion establecida correctamente",  JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "No se ha podido establecer una conexion con la base de datos",  JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
}
