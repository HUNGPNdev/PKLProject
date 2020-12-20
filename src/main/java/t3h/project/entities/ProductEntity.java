package t3h.project.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pro_id;
    private String pro_name;
    private String slug;
    private Double price;
    @Column(columnDefinition = "TEXT")
    private String details;
    private String guarantee;
    private String part;
    private String support;
    private String image;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "cata_id", nullable = false)
    private CategoryEntity category;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product_cmt")
    private List<CommentEntity> pro_comment;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pro_id")
    private List<OrderEntity> pro_order;

    private Date create_at;
    private Date update_at;
    private String create_by;
    private String update_by;

    public ProductEntity() {
    }

    public ProductEntity(long pro_id, String pro_name, String slug, Double price,
                         String details, String guarantee, String part, String support,
                         String image, boolean status, CategoryEntity category) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.slug = slug;
        this.price = price;
        this.details = details;
        this.guarantee = guarantee;
        this.part = part;
        this.support = support;
        this.image = image;
        this.status = status;
        this.category = category;
    }

    public ProductEntity(long pro_id, String pro_name, String slug, Double price, String details,
                         String guarantee, String part, String support, String image, boolean status,
                         CategoryEntity category, List<CommentEntity> pro_comment,
                         List<OrderEntity> pro_order, Date create_at, Date update_at, String create_by,
                         String update_by) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.slug = slug;
        this.price = price;
        this.details = details;
        this.guarantee = guarantee;
        this.part = part;
        this.support = support;
        this.image = image;
        this.status = status;
        this.category = category;
        this.pro_comment = pro_comment;
        this.pro_order = pro_order;
        this.create_at = create_at;
        this.update_at = update_at;
        this.create_by = create_by;
        this.update_by = update_by;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "pro_id=" + pro_id +
                ", pro_name='" + pro_name + '\'' +
                ", slug='" + slug + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", guarantee='" + guarantee + '\'' +
                ", part='" + part + '\'' +
                ", support='" + support + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                '}';
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPro_id() {
        return pro_id;
    }

    public void setPro_id(long pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<CommentEntity> getPro_comment() {
        return pro_comment;
    }

    public void setPro_comment(List<CommentEntity> pro_comment) {
        this.pro_comment = pro_comment;
    }

    public List<OrderEntity> getPro_order() {
        return pro_order;
    }

    public void setPro_order(List<OrderEntity> pro_order) {
        this.pro_order = pro_order;
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
