package mybatis.dao;

import mybatis.model.Orders;
import mybatis.model.OrdersCustom;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdersMapperCustom {
    public List<OrdersCustom> findOrderUser();
    public List<Orders> findOrderUserresultMap();
    public List<Orders>  findOrderOderdetailresultMap();
    List<OrdersCustom> findUserItemsresultMap();
    List<OrdersCustom>findUserItemsresultMap2();
    public List<Orders> findUserOrderLazy();
}