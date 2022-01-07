package mx.edu.tecnm.itcm;

import java.util.Date;

/**
 *
 * @author Manuel Avila
 */
public class Project {

    private int id;
    private String name;
    private Date startDate;
    private Date finishDate;
    private String description;

    public Project() {

    }

    public Project(String name, Date startDate, Date finishDate, String description) {
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
    }

    public Project(int id, String name, Date startDate, Date finishDate, String description) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(int id, String name) {
        this.id = id;
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

    @Override
    public String toString() {
        return getName();
    }
}
