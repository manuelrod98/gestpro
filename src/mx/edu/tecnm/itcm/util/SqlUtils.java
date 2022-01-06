package mx.edu.tecnm.itcm.util;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

import mx.edu.tecnm.itcm.User;
import mx.edu.tecnm.itcm.Project;
import mx.edu.tecnm.itcm.Task;

/**
 *
 * @author Manuel Avila
 */
public class SqlUtils {

    private static CallableStatement callableStatement;
    private static PreparedStatement preparedStatement;
    private static ResultSetMetaData resultSetMetaData;
    private static Statement statement;
    private static ResultSet resultSet;
    private static Connection connection;

    public static void signUp(User user) {
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO user(name, lastName, username, email, password) VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean signIn(User user) {
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
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
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static void createProject(Project project) {
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO project(project_name, startDate, finishDate, description) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, utilDateToSqlDate(project.getStartDate()));
            preparedStatement.setDate(4, utilDateToSqlDate(project.getFinishDate()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void createTask(Task task) {
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO task(task_name, startDate, finishDate, description, user_id, project_id)VALUES(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, task.getName());
            preparedStatement.setDate(2, utilDateToSqlDate(task.getStartDate()));
            preparedStatement.setDate(3, utilDateToSqlDate(task.getFinishDate()));
            preparedStatement.setString(4, task.getDescription());
            preparedStatement.setInt(5, task.getUser().getId());
            preparedStatement.setInt(6, task.getOwnerProject().getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static java.sql.Date utilDateToSqlDate(java.util.Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleDateFormat.format(date);
        java.sql.Date convertedDate = java.sql.Date.valueOf(formattedDate);
        return convertedDate;
    }

    public static ArrayList<User> getUserList() {
        Connection connection = DBConnection.connect();
        ArrayList<User> userList = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM user");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("lastName"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"));
                userList.add(user);
            }
            resultSet.close();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
        return userList;
    }

    public static ArrayList<Project> getProjectList() {
        Connection connection = DBConnection.connect();
        ArrayList<Project> projectList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM project");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project(resultSet.getInt("id"), resultSet.getString("project_name"), resultSet.getDate("startDate"), resultSet.getDate("finishDate"), resultSet.getString("description"));
                projectList.add(project);
            }
            resultSet.close();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
        return projectList;
    }
}
