package mx.edu.tecnm.itcm.util;

import java.sql.*;
import java.text.SimpleDateFormat;

import mx.edu.tecnm.itcm.User;
import javax.swing.JOptionPane;
import mx.edu.tecnm.itcm.Project;

/**
 *
 * @author Manuel Avila
 */
public class SqlUtils {

    private static DBConnection dbConnection = new DBConnection();
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    private static String sqlQuery;

    public static void registerUser(String name, String lastName, String username, String email, String password) {
        Connection connection = null;
        User user = new User(name, lastName, username, email, password);
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO tbl_user(uName, uLastName, uUsername, uEmail, uPassword) VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void registerUser(User user) {
        Connection connection = null;
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO t_user(username, uName, uEmail, uPassword) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
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
        } catch (SQLException exception) {
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
            preparedStatement.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    public static boolean login(User user) {
        Connection connection = null;
        try {
            connection = DBConnection.connect();
            String SqlQuery = ("SELECT id, uName, uLastName, uUsername, uEmail, uPassword FROM tbl_user WHERE uUsername = ?");
            preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.setString(1, user.getUsername());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (user.getPassword().equals(resultSet.getString(6))) {
                    user.setId(resultSet.getInt(1));
                    user.setName(resultSet.getString(2));
                    preparedStatement.close();
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static void createProject(Project project) {
        Connection connection = null;
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO tbl_project(pName, pDesc, startDate, finishDate) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, utilDateToSqlDate(project.getStartDate()));
            preparedStatement.setDate(4, utilDateToSqlDate(project.getFinishDate()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void deleteProject() {
        //TODO:
    }

    private static java.sql.Date utilDateToSqlDate(java.util.Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleDateFormat.format(date);
        java.sql.Date convertedDate = java.sql.Date.valueOf(formattedDate);
        return convertedDate;
    }
}
