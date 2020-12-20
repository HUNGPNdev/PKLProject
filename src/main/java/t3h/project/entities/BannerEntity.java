package t3h.project.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "banner")
public class BannerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    private boolean status;
    private Date create_at;
    private Date update_at;
    private String create_by;
    private String update_by;

    public BannerEntity() {
    }

    public BannerEntity(long id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
    public BannerEntity(long id,  boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
    public BannerEntity(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public BannerEntity(long id, String name, boolean status,
                        Date create_at, Date update_at, String create_by, String update_by) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.create_by = create_by;
        this.update_by = update_by;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }
}
