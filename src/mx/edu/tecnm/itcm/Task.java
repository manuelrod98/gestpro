package mx.edu.tecnm.itcm;

import mx.edu.tecnm.itcm.util.Priority;
import mx.edu.tecnm.itcm.util.Status;
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
    private Project ownerProject;
    private User user;
    private Priority priority;
    private Status status;

    public Task() {
    }

    public Task(String name, String description, Date startDate, Date finishDate,  User user, Project project) {
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.user = user;
        this.ownerProject = project;
    }

    public Project getOwnerProject() {
        return ownerProject;
    }

    public void setOwnerProject(Project ownerProject) {
        this.ownerProject = ownerProject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
