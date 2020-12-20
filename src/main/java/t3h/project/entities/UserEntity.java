package t3h.project.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String username;
    private String email;
    private String name;
    private String password;
    private String address;
    private String image;
    private boolean gender;
    private Date birthday;
    private boolean status;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cmt_user")
    private List<CommentEntity> userComment;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order_user")
    private List<OrderEntity> userOrder;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

    private Date create_at;
    private Date update_at;

    public UserEntity() {
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", roles=" + roles +
                '}';
    }

    public UserEntity(long user_id, String username, String email, String name, String password, List<Role> roles) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public UserEntity(String username, String email, String name, String password, List<Role> roles) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public UserEntity(String username, String email, String name, String password) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public UserEntity(long user_id, String username, String email, String password, String address, String image,
                      boolean gender, Date birthday, boolean status, List<Role> roles) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.image = image;
        this.gender = gender;
        this.birthday = birthday;
        this.status = status;
        this.roles = roles;
    }

    public UserEntity(long user_id, String username, String email, String password, String address,
                      String image, boolean gender, Date birthday, boolean status,
                      List<CommentEntity> userComment, List<OrderEntity> userOrder, Date create_at, Date update_at) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.image = image;
        this.gender = gender;
        this.birthday = birthday;
        this.status = status;
        this.userComment = userComment;
        this.userOrder = userOrder;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<CommentEntity> getUserComment() {
        return userComment;
    }

    public void setUserComment(List<CommentEntity> userComment) {
        this.userComment = userComment;
    }

    public List<OrderEntity> getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(List<OrderEntity> userOrder) {
        this.userOrder = userOrder;
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
}
