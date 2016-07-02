package mybatis.service;

import mybatis.dao.ItemsMapper;
import mybatis.dao.ItemsMapperCustom;
import mybatis.model.ItemCustom;
import mybatis.model.Items;
import mybatis.model.ItemsQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiaranran on 2016/7/1.
 */
@Service("ItemServiceI")
public class ItemServiceImpl implements ItemServiceI{
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    public ItemCustom selectByPrimaryKey(Integer id){
        Items items=itemsMapper.selectByPrimaryKey(id);
        ItemCustom itemCustom=new ItemCustom();
        BeanUtils.copyProperties(items,itemCustom);
        return itemCustom;
    }
    public List<ItemCustom> findItemList(ItemsQueryVo itemsQueryVo){
        return  itemsMapperCustom.findItemList( itemsQueryVo);
    }
    public int updateByPrimaryKeySelective(Integer id,ItemCustom itemCustom) {
        itemCustom.setId(id);
        return itemsMapper.updateByPrimaryKeySelective(itemCustom);
    }
}
