package mybatis.model;

/**
 * Created by jiaranran on 2016/6/30.
 */
import mybatis.model.ItemsQueryVo;
import mybatis.model.ItemCustom ;
import mybatis.model.Items  ;

import java.util.List;

public class ItemsQueryVo {
    private ItemCustom itemCustom;
    private Items items;
    private List<ItemCustom> list;
    public List<ItemCustom> getList() {
        return list;
    }

    public void setList(List<ItemCustom> list) {
        this.list = list;
    }

    public ItemCustom getItemCustom() {
        return itemCustom;
    }

    public void setItemCustom(ItemCustom itemCustom) {
        this.itemCustom = itemCustom;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}