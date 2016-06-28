package mybatis.dao;

import mybatis.model.Items;
import mybatis.model.OrdersCustom;

import java.util.List;

public interface OrdersMapperCustom {
    public List<OrdersCustom> findOrderUser();
}