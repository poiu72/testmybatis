package mybatis.dao;

import mybatis.model.Orders;
import mybatis.model.OrdersCustom;

import java.util.List;

public interface OrdersMapperCustom {
    public List<OrdersCustom> findOrderUser();
    public List<Orders> findOrderUserresultMap();
    public List<Orders>  findOrderOderdetailresultMap();
    List<OrdersCustom> findUserItemsresultMap();
    List<OrdersCustom>findUserItemsresultMap2();
    public List<Orders> findUserOrderLazy();
}