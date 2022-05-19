package mx.edu.tecnm.itcm;

public class Team {
    private String name;
    private User[] users;
    private Project[] projects;

    public Team(String name, User[] users, Project[] projects) {
        this.name = name;
        this.users = users;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Project[] getProjects() {
        return projects;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }

    public void addUser(User user) {
        User[] newUsers = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            newUsers[i] = users[i];
        }
        newUsers[users.length] = user;
        users = newUsers;
    }

    public void addProject(Project project) {
        Project[] newProjects = new Project[projects.length + 1];
        for (int i = 0; i < projects.length; i++) {
            newProjects[i] = projects[i];
        }
        newProjects[projects.length] = project;
        projects = newProjects;
    }

    public void removeUser(User user) {
        User[] newUsers = new User[users.length - 1];
        int j = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != user) {
                newUsers[j] = users[i];
                j++;
            }
        }
        users = newUsers;
    }

    public void removeProject(Project project) {
        Project[] newProjects = new Project[projects.length - 1];
        int j = 0;
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != project) {
                newProjects[j] = projects[i];
                j++;
            }
        }
        projects = newProjects;
    }

    public void addUser(int index, User user) {
        User[] newUsers = new User[users.length + 1];
        for (int i = 0; i < index; i++) {
            newUsers[i] = users[i];
        }
        newUsers[index] = user;
        for (int i = index; i < users.length; i++) {
            newUsers[i + 1] = users[i];
        }
        users = newUsers;
    }

    public void addProject(int index, Project project) {
        Project[] newProjects = new Project[projects.length + 1];
        for (int i = 0; i < index; i++) {
            newProjects[i] = projects[i];
        }
        newProjects[index] = project;
        for (int i = index; i < projects.length; i++) {
            newProjects[i + 1] = projects[i];
        }
        projects = newProjects;
    }

    public void removeUser(int index) {
        User[] newUsers = new User[users.length - 1];
        for (int i = 0; i < index; i++) {
            newUsers[i] = users[i];
        }
        for (int i = index; i < users.length - 1; i++) {
            newUsers[i] = users[i + 1];
        }
        users = newUsers;
    }

    public void removeProject(int index) {
        Project[] newProjects = new Project[projects.length - 1];
        for (int i = 0; i < index; i++) {
            newProjects[i] = projects[i];
        }
        for (int i = index; i < projects.length - 1; i++) {
            newProjects[i] = projects[i + 1];
        }
        projects = newProjects;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", users=" + users +
                ", projects=" + projects +
                '}';
    }
}