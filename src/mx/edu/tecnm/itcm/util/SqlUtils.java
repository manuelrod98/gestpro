package mx.edu.tecnm.itcm.util;

import java.sql.*;

import mx.edu.tecnm.itcm.User;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Avila
 */
public class SqlUtils {

    public static DBConnection databaseConnection = new DBConnection();

    public static PreparedStatement preparedStatement;
    public static ResultSet result;
    public static String sqlQuery;
    public static int resultIndex = 0;
    public static PreparedStatement tamaño_busc;

    public String busqueda_usuarios = null;
    public String busqueda_desc = null;
    public boolean busqueda_disp;
//    public int tamaño_tabla_grup = 0;

    public static int guardar(String username, String name, String email, String password) {
        int resultado = 0;
        Connection conexion = null;

        try {
            conexion = DBConnection.connect();
            preparedStatement = conexion.prepareStatement("INSERT INTO t_user(username, uName, uEmail, uPassword) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);

            resultado = preparedStatement.executeUpdate();

        } catch (Exception ex) {
//            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex, "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }

    public static int registerUser(User user) {
        int resultado = 0;
        Connection conexion = null;

        try {
            conexion = DBConnection.connect();
            preparedStatement = conexion.prepareStatement("INSERT INTO t_user(username, uName, uEmail, uPassword) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());

            resultado = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public static String searchUser(String username) {
        String busqueda_usuario = null;
        Connection connection = null;
        try {
            connection = DBConnection.connect();
            String sentencia_buscar = ("SELECT uEmail, uName FROM t_user WHERE username = '" + username + "'");
            preparedStatement = connection.prepareStatement(sentencia_buscar);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                String email = result.getString("email");
                String name = result.getString("name");
                busqueda_usuario = (name);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_usuario;
    }

    public static int saveTask(String name, Date startDate, Date finishDate, String description) {
        int result = 0;
        Connection conexion = null;

        try {
            conexion = DBConnection.connect();
            preparedStatement = conexion.prepareStatement("INSERT INTO task(name, startDate, finishDate, description) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);
            preparedStatement.setString(4, description);

            result = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

//    public int guardarGrupo(String usuarios, String desc, boolean disp, int id) {
//        int resultado = 0;
//        Connection conexion = null;
//
//        try {
//            conexion = DatabaseConnection.connect();
//            sentencia_preparada = conexion.prepareStatement("INSERT INTO grupo(usuarios, descipcion, disponible, id) VALUES(?,?,?,?)");
//
//            sentencia_preparada.setString(1, usuarios);
//            sentencia_preparada.setString(2, desc);
//            sentencia_preparada.setBoolean(3, disp);
//            sentencia_preparada.setInt(4, id);
//            tamaño_busc = conexion.prepareStatement(" select count(*) from grupo");
//            tamaño_tabla_grup = tamaño_busc.getUpdateCount();
//            resultado = sentencia_preparada.executeUpdate();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return resultado;
//    }
    public String buscarUsuarioRegistrado(User user) {
        String busqueda_usuarioR = null;
        Connection connection = null;
        try {
            connection = DBConnection.connect();
            String sentencia_buscarUR = ("SELECT username, name, email, password FROM user WHERE username = '" + user.getUsername() + "' && password = '" + user.getPassword() + "'");
            preparedStatement = connection.prepareStatement(sentencia_buscarUR);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                busqueda_usuarioR = "Usuario encontrado";
            } else {
                busqueda_usuarioR = "Usuario no encontrado";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return busqueda_usuarioR;
    }

    // public void buscarGrupo(int id) {
    //     Connection conexion = null;
    //     try {
    //         conexion = DatabaseConnection.connect();
    //         String sentencia_buscar = ("SELECT usuarios,descipcion,disponible FROM grupo WHERE id = '" + id + "'");
    //         preparedStatement = conexion.prepareStatement(sentencia_buscar);
    //         result = preparedStatement.executeQuery();
    //         if (result.next()) {
    //             String usu = result.getString("usuarios");
    //             String desc = result.getString("descipcion");
    //             boolean disp = result.getBoolean("disponible");
    //             busqueda_usuarios = (usu);
    //             busqueda_desc = (desc);
    //             busqueda_disp = (disp);
    //         }
    //         conexion.close();
    //     } catch (Exception e) {
    //         System.out.println(e);
    //     }
    // }
//    public int getTamañoTablaGrupo() {
//        return tamaño_tabla_grup;
//    }
//    public void actualizarTamañoGrupo() {
//
//        Connection conexion = null;
//
//        try {
//            conexion = DatabaseConnection.connect();
//            String sentencia_buscar = ("SELECT usuarios,descipcion,disponible FROM grupo");
//            preparedStatement = conexion.prepareStatement(sentencia_buscar);
//            result = preparedStatement.executeQuery();
//            while (result.next()) {
//                tamaño_tabla_grup++;
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    public static void cretaeProject() {
        //TODO:
    }

    public static void deleteProject() {
        //TODO:
    }
}
