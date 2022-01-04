package mx.edu.tecnm.itcm;

import mx.edu.tecnm.itcm.util.Role;

/**
 *
 * @author Manuel Avila
 */
public class User {

    private int id;
    private String name;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Role role;

    public User() {
    }

    public User(String name, String lastName, String username, String email, String password, Role role) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(String name, String lastName, String username, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = Role.DEVELOPER;
    }

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return getName() + getLastName();
    }
}
