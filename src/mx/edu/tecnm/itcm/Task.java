package mx.edu.tecnm.itcm;

import java.util.Date;

/**
 * @author Manuel Avila
 */
public class Task {

    private int id;
    private String name;
    private Date startDate;
    private Date finishDate;
    private String description;
    private User user;
    private Project ownerProject;

    public Task() {
        this.name = "Task name";
        this.startDate = new Date();
        this.finishDate = new Date();
        this.description = description;
        this.user = user;
        this.ownerProject = project;
    }

    public Task(String name, Date startDate, Date finishDate, String description, User user, Project project) {
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.user = user;
        this.ownerProject = project;
    }

    public Task(int id, String name, Date startDate, Date finishDate, String description, User user, Project project) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.user = user;
        this.ownerProject = project;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getOwnerProject() {
        return ownerProject;
    }

    public void setOwnerProject(Project ownerProject) {
        this.ownerProject = ownerProject;
    }
    
    @Override
    public String toString(){
        return getName();
    }
}
