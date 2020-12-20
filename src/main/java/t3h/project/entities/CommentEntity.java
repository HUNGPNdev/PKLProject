package t3h.project.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cmt_id;
    @Column(columnDefinition = "TEXT")
    private String content;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "pro_id",nullable = false)
    private ProductEntity product_cmt;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity cmt_user;
    private Date create_at;

    public CommentEntity() {
    }

    public CommentEntity(long cmt_id, String content, boolean status,
                         ProductEntity product_cmt, UserEntity cmt_user, Date create_at) {
        this.cmt_id = cmt_id;
        this.content = content;
        this.status = status;
        this.product_cmt = product_cmt;
        this.cmt_user = cmt_user;
        this.create_at = create_at;
    }

    public long getCmt_id() {
        return cmt_id;
    }

    public void setCmt_id(long cmt_id) {
        this.cmt_id = cmt_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ProductEntity getProduct_cmt() {
        return product_cmt;
    }

    public void setProduct_cmt(ProductEntity product_cmt) {
        this.product_cmt = product_cmt;
    }

    public UserEntity getCmt_user() {
        return cmt_user;
    }

    public void setCmt_user(UserEntity cmt_user) {
        this.cmt_user = cmt_user;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
}
