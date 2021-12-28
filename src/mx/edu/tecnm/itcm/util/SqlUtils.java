package mx.edu.tecnm.itcm.util;

import datechooser.beans.DateChooserPanel;
import java.sql.*;

import mx.edu.tecnm.itcm.User;
import javax.swing.JOptionPane;
import mx.edu.tecnm.itcm.Project;

/**
 *
 * @author Manuel Avila
 */
public class SqlUtils {

    public static DBConnection databaseConnection = new DBConnection();
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;
    public static String sqlQuery;
    public static int resultIndex = 0;

    public static void registerUser(String name, String lastName, String username, String email, String password) {
        int resultado = 0;
        Connection connection = null;
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO tbl_user(uName, uLastName, username, uEmail, uPassword) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);
            resultado = preparedStatement.executeUpdate();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
//        return resultado;
    }

    public static void registerUser(User user) {
        int resultado = 0;
        Connection connection = null;
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO t_user(username, uName, uEmail, uPassword) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            resultado = preparedStatement.executeUpdate();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String searchUser(String username) {
        String busqueda_usuario = null;
        Connection connection = null;
        try {
            connection = DBConnection.connect();
            String sentencia_buscar = ("SELECT uEmail, uName FROM t_user WHERE username = '" + username + "'");
            preparedStatement = connection.prepareStatement(sentencia_buscar);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                busqueda_usuario = (name);
            }
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
        return busqueda_usuario;
    }

    public static int saveTask(String name, Date startDate, Date finishDate, String description) {
        int result = 0;
        Connection connection = null;
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO task(name, startDate, finishDate, description) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);
            preparedStatement.setString(4, description);
            result = preparedStatement.executeUpdate();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    public boolean buscarUsuarioRegistrado(User user) {
        boolean isFinded = false;
        Connection connection = null;
        try {
            connection = DBConnection.connect();
            String SqlQuery = ("SELECT username, name, email, password FROM user WHERE username = '" + user.getUsername() + "' && password = '" + user.getPassword() + "'");
            preparedStatement = connection.prepareStatement(SqlQuery);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isFinded = true;
            } else {
                isFinded = false;
            }
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
        return isFinded;
    }

    public static void cretaeProject(Project project) {
        int resultado = 0;
        Connection connection = null;
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO tbl_project(pName, startDate, finishDate, description) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, project.getName());
            preparedStatement.setDate(2, (java.sql.Date) project.getStartDate());
            preparedStatement.setDate(3, (java.sql.Date) project.getFinishDate());
            preparedStatement.setString(4, project.getDescription());
            resultado = preparedStatement.executeUpdate();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void deleteProject() {
        //TODO:
    }

    public static Date convertDate(DateChooserPanel dateChooser) {
        Date date = (Date) dateChooser.getCurrent().getTime();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        return fecha;
    }
}
