package mybatis.dao;

/**
 * Created by jiaranran on 2016/6/30.
 */
import mybatis.model.ItemsQueryVo;
import mybatis.model.ItemCustom ;
import java.util.*;
public interface ItemsMapperCustom {
    public List<ItemCustom> findItemList(ItemsQueryVo itemsQueryVo);
}
