package mybatis.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by jiaranran on 2016/7/13.
 */
@Entity
@Table(name = "orders", schema = "", catalog = "mybatis")
public class OrdersEntity {
    private int id;
    private String number;
    private Timestamp createtime;
    private String note;
    private UserEntity userByUserId;
    private UserEntity userbyid;
    private Collection<OrderdetailEntity> orderdetailbyid;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = true, insertable = true, updatable = true, length = 32)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "createtime", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "note", nullable = false, insertable = true, updatable = true, length = 100)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (id != that.id) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getUserbyid() {
        return userbyid;
    }

    public void setUserbyid(UserEntity userbyid) {
        this.userbyid = userbyid;
    }

    @OneToMany(mappedBy = "orderbyid")
    public Collection<OrderdetailEntity> getOrderdetailbyid() {
        return orderdetailbyid;
    }

    public void setOrderdetailbyid(Collection<OrderdetailEntity> orderdetailbyid) {
        this.orderdetailbyid = orderdetailbyid;
    }
}
