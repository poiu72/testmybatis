package mybatis.model;

import javax.persistence.*;

/**
 * Created by jiaranran on 2016/7/13.
 */
@Entity
@Table(name = "orderdetail", schema = "", catalog = "mybatis")
public class OrderdetailEntity {
    private int id;
    private int itemsMum;
    private OrdersEntity ordersByOrdersId;
    private ItemsEntity orderdetailid;
    private OrdersEntity orderbyid;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "items_mum", nullable = false, insertable = true, updatable = true)
    public int getItemsMum() {
        return itemsMum;
    }

    public void setItemsMum(int itemsMum) {
        this.itemsMum = itemsMum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderdetailEntity that = (OrderdetailEntity) o;

        if (id != that.id) return false;
        if (itemsMum != that.itemsMum) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + itemsMum;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    public OrdersEntity getOrdersByOrdersId() {
        return ordersByOrdersId;
    }

    public void setOrdersByOrdersId(OrdersEntity ordersByOrdersId) {
        this.ordersByOrdersId = ordersByOrdersId;
    }

    @OneToOne(mappedBy = "itembyid")
    public ItemsEntity getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(ItemsEntity orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    public OrdersEntity getOrderbyid() {
        return orderbyid;
    }

    public void setOrderbyid(OrdersEntity orderbyid) {
        this.orderbyid = orderbyid;
    }
}
