package t3h.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int user_id;
    private Long pro_id;
    private int quantity;

    public CartEntity(int user_id, Long pro_id, int quantity) {
        this.user_id = user_id;
        this.pro_id = pro_id;
        this.quantity = quantity;
    }

    public CartEntity(int id, int user_id, Long pro_id, int quantity) {
        this.id = id;
        this.user_id = user_id;
        this.pro_id = pro_id;
        this.quantity = quantity;
    }

    public CartEntity() {
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", pro_id=" + pro_id +
                ", quantity=" + quantity +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }
}
