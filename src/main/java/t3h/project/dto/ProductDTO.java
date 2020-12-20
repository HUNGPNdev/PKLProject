package t3h.project.dto;

public class ProductDTO {
    private Long pro_id;
    private String pro_name;
    private Double price;
    private String details;
    private String guarantee;
    private String part;
    private String support;
    private String image;
    private boolean status;
    private Long cata_id;
    private String cate_name;

    public ProductDTO() {
    }

    public ProductDTO(Long pro_id, String pro_name, Double price) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.price = price;
    }

    public ProductDTO(String pro_name, Double price, String details, String guarantee, String part, String support, boolean status, Long cata_id) {
        this.pro_name = pro_name;
        this.price = price;
        this.details = details;
        this.guarantee = guarantee;
        this.part = part;
        this.support = support;
        this.status = status;
        this.cata_id = cata_id;
    }

    public ProductDTO(Long pro_id, String pro_name, Double price, String details, String guarantee, String part,
                      String support, String image, boolean status, Long cata_id, String cate_name) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.price = price;
        this.details = details;
        this.guarantee = guarantee;
        this.part = part;
        this.support = support;
        this.image = image;
        this.status = status;
        this.cata_id = cata_id;
        this.cate_name = cate_name;
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

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
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

    public Long getCata_id() {
        return cata_id;
    }

    public void setCata_id(Long cata_id) {
        this.cata_id = cata_id;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "pro_name='" + pro_name + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", guarantee='" + guarantee + '\'' +
                ", part='" + part + '\'' +
                ", support='" + support + '\'' +
                ", status=" + status +
                ", cata_id=" + cata_id +
                '}';
    }
}
