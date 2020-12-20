package t3h.project.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_details")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;
    private long quantity;
    private double total_price;
    private boolean status;
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity order_user;


    @ManyToOne
    @JoinColumn(name = "pro_id", nullable = false)
    private ProductEntity pro_id;

    private Date create_at;

    public OrderEntity() {
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "order_id=" + order_id +
                ", quantity=" + quantity +
                ", total_price=" + total_price +
                ", status=" + status +
                ", image='" + image + '\'' +
                ", order_user=" + order_user +
                ", pro_id=" + pro_id +
                ", create_at=" + create_at +
                '}';
    }

    public OrderEntity(long quantity, double total_price, UserEntity order_user, ProductEntity pro_id, Date create_at) {
        this.quantity = quantity;
        this.total_price = total_price;
        this.order_user = order_user;
        this.pro_id = pro_id;
        this.create_at = create_at;
    }

    public OrderEntity(long quantity, double total_price, String image, UserEntity order_user, ProductEntity pro_id, Date create_at) {
        this.quantity = quantity;
        this.total_price = total_price;
        this.image = image;
        this.order_user = order_user;
        this.pro_id = pro_id;
        this.create_at = create_at;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductEntity getPro_id() {
        return pro_id;
    }

    public void setPro_id(ProductEntity pro_id) {
        this.pro_id = pro_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UserEntity getOrder_user() {
        return order_user;
    }

    public void setOrder_user(UserEntity order_user) {
        this.order_user = order_user;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
}
