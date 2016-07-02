package mybatis.service;

import mybatis.model.ItemCustom;
import mybatis.model.Items;
import mybatis.model.ItemsQueryVo;

import java.util.List;

/**
 * Created by jiaranran on 2016/7/1.
 */
public interface ItemServiceI {
    ItemCustom selectByPrimaryKey(Integer id);
    List<ItemCustom> findItemList(ItemsQueryVo itemsQueryVo);
    int updateByPrimaryKeySelective(Integer id,ItemCustom record);
    int deleteByPrimaryKeySelective(Integer id);
}
