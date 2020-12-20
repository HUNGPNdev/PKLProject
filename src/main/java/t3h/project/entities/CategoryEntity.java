package t3h.project.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cata_id;
    @Column(nullable = false)
    private String cata_name;
    private String slug;
    private boolean status;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
    private List<ProductEntity>  prolist;
    private Date create_at;
    private Date update_at;
    private String create_by;
    private String update_by;

    public CategoryEntity() {
    }

    public CategoryEntity(String cata_name, String slug, boolean status) {
        this.cata_name = cata_name;
        this.slug = slug;
        this.status = status;
    }

    public CategoryEntity(long cata_id, String cata_name, String slug,
                          boolean status, Date create_at, Date update_at, String create_by, String update_by) {
        this.cata_id = cata_id;
        this.cata_name = cata_name;
        this.slug = slug;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.create_by = create_by;
        this.update_by = update_by;
    }

    public long getCata_id() {
        return cata_id;
    }

    public void setCata_id(long cata_id) {
        this.cata_id = cata_id;
    }

    public String getCata_name() {
        return cata_name;
    }

    public void setCata_name(String cata_name) {
        this.cata_name = cata_name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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
