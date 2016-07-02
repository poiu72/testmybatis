package mybatis.dao;

/**
 * Created by jiaranran on 2016/6/30.
 */

import mybatis.model.ItemCustom;
import mybatis.model.ItemsQueryVo;

import java.util.List;
public interface ItemsMapperCustom {
    public List<ItemCustom> findItemList(ItemsQueryVo itemsQueryVo);
}
