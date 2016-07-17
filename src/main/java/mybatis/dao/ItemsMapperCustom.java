package mybatis.dao;

/**
 * Created by jiaranran on 2016/6/30.
 */

import mybatis.model.ItemCustom;
import mybatis.model.ItemsQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemsMapperCustom {
    public List<ItemCustom> findItemList(ItemsQueryVo itemsQueryVo);
}
