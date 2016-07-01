package mybatis.model;

public class Orderdail extends Items{
    private Items items;
    private Integer id;

    private Integer ordersId;

    private Integer itemsId;

    private Integer itemsMum;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getItemsMum() {
        return itemsMum;
    }

    public void setItemsMum(Integer itemsMum) {
        this.itemsMum = itemsMum;
    }
}