package mybatis.dao;

import mybatis.model.Orderdail;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderdailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderdail record);

    int insertSelective(Orderdail record);

    Orderdail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderdail record);

    int updateByPrimaryKey(Orderdail record);
}