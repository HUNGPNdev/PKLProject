package t3h.project.dto;

public class ProCartDTO {
    private Long pro_id;
    private String pro_name;
    private Double price;
    private String image;
    private int count;

    public ProCartDTO(Long pro_id, String pro_name, Double price, String image, int count) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.price = price;
        this.image = image;
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProCartDTO() {
    }

    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ProCartDTO{" +
                "pro_id=" + pro_id +
                ", pro_name='" + pro_name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", count=" + count +
                '}';
    }
}
