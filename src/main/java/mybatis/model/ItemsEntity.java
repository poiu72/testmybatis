package mybatis.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by jiaranran on 2016/7/13.
 */
@Entity
@Table(name = "items", schema = "", catalog = "mybatis")
public class ItemsEntity {
    private int id;
    private String name;
    private Float price;
    private String detail;
    private String pic;
    private Timestamp createtime;
    private OrderdetailEntity itembyid;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "detail", nullable = false, insertable = true, updatable = true, length = 65535)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "pic", nullable = false, insertable = true, updatable = true, length = 512)
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Basic
    @Column(name = "createtime", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemsEntity that = (ItemsEntity) o;

        if (id != that.id) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pic != null ? !pic.equals(that.pic) : that.pic != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "items_id", nullable = false)
    public OrderdetailEntity getItembyid() {
        return itembyid;
    }

    public void setItembyid(OrderdetailEntity itembyid) {
        this.itembyid = itembyid;
    }
}
