package mx.edu.tecnm.itcm;

/**
 *
 * @author Manuel Avila
 */
@Deprecated
public class Team {

    private int id;
    private String name;
    private User[] members;

    public Team() {
    }

    public Team(int id, String name, User[] members, Task[] taskList) {
        this.id = id;
        this.name = name;
        this.members = members;
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

    public User[] getMembers() {
        return members;
    }

    public void setMembers(User[] members) {
        this.members = members;
    }
}
