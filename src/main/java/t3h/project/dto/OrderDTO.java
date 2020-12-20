package t3h.project.dto;

public class OrderDTO {
    private Long od_id;
    private Long pro_id;
    private int count;
    private double price;
    private String image;
    private String pro_name;
    private String user_name;

    public OrderDTO() {
    }

    public OrderDTO(Long od_id ,int count, double price, String image, String pro_name) {
        this.od_id = od_id;
        this.count = count;
        this.price = price;
        this.image = image;
        this.pro_name = pro_name;
    }

    public OrderDTO(Long od_id ,int count, double price, String image, String pro_name, String user_name) {
        this.od_id = od_id;
        this.count = count;
        this.price = price;
        this.image = image;
        this.pro_name = pro_name;
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "od_id=" + od_id +
                ", pro_id=" + pro_id +
                ", count=" + count +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", pro_name='" + pro_name + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Long getOd_id() {
        return od_id;
    }

    public void setOd_id(Long od_id) {
        this.od_id = od_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
