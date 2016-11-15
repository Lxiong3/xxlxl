package com.newthread.framework.db;

import com.newthread.framework.entity.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrderDB {

    // customer_id Order
    public static Map<String, List<Order>> map = new HashMap<>();

/*    static {


        Order.OrderedByBean byBean = null;

        List<Order.OrderDetailBean> order_detail = new ArrayList<>();

        //order_detail.add(new Order.OrderDetailBean("1","123123@193.com","1235523"));

        Order o1 = new Order("123", 66.57, 2.00, 128.57, "open", "20161000", "20161011", "", byBean, "10 West 31st ST, Chicago IL 60616", "Room SB-214", order_detail);
        Order o2 = new Order("456", 10.57, 5.00, 15.57, "open", "20161020", "20161021", "", byBean, "10 West 31st ST, Chicago IL 60616", "Room SB-214", order_detail);

        List<Order> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);


        map.put(o1.getOid(), o1);
        map.put(o2.getOid(), o2);
    }*/

    public static String createOrder(String customerId, List<Order> order) {

        List<Order> list = map.get(customerId);

        if (list != null) {
            for (Order order1 : order) {
                list.add(order1);
            }
        } else {
            map.put(customerId, order);
        }
        return null;
    }


    public static List<Order> getAllOrder() {


        List<Order> list = new ArrayList<>();


        for (Map.Entry<String, List<Order>> en : map.entrySet()) {
            for (Order o : en.getValue()) {
                list.add(o);
            }
        }


        return list;


    }

    public static List<Order> getorder(String cid) {
        return map.get(cid);
    }
}
