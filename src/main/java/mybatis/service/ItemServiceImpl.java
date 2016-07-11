package mybatis.service;

import mybatis.dao.ItemsMapper;

import mybatis.dao.ItemsMapperCustom;
import mybatis.exception.CustomException;
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
@Service("itemService")
public class ItemServiceImpl implements ItemServiceI{

    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    public ItemsMapper getItemsMapper() {
        return itemsMapper;
    }

    public void setItemsMapper(ItemsMapper itemsMapper) {
        this.itemsMapper = itemsMapper;
    }

    public ItemsMapperCustom getItemsMapperCustom() {
        return itemsMapperCustom;
    }

    public void setItemsMapperCustom(ItemsMapperCustom itemsMapperCustom) {
        this.itemsMapperCustom = itemsMapperCustom;
    }
    @Override
    public ItemCustom selectByPrimaryKey(Integer id){
        Items items=itemsMapper.selectByPrimaryKey(id);
        /*跟业务相关的异常最好在service层抛出*/
        if(items==null){
            new CustomException("修改的商品信息不存在");
        }
        ItemCustom itemCustom = null;
        if (items!=null){
            itemCustom=new ItemCustom();
            BeanUtils.copyProperties(items,itemCustom);
        }
        return itemCustom;
    }
    @Override
    public List<ItemCustom> findItemList(ItemsQueryVo itemsQueryVo){
        return  itemsMapperCustom.findItemList( itemsQueryVo);
    }
    @Override
    public int updateByPrimaryKeySelective(Integer id,ItemCustom itemCustom) {
        itemCustom.setId(id);
        return itemsMapper.updateByPrimaryKeySelective(itemCustom);
    }
    @Override
    public int deleteByPrimaryKeySelective(Integer id){
        return itemsMapper.deleteByPrimaryKey(id);
    }
}
