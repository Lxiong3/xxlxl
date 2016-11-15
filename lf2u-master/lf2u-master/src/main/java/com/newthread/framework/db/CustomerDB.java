package com.newthread.framework.db;

import com.newthread.framework.entity.Customer;
import com.newthread.framework.util.StringUtil;

import java.util.HashMap;
import java.util.Map;


public class CustomerDB {

    public static Map<String, Customer> map = new HashMap<>();




    static {

        Customer c1 = new Customer("1","Virgil","1405 W Palatine Rd, Hoffman Estates","457457","23526","hwete@example.com");
        Customer c2 = new Customer("2","Tom","American","2342346","234234","eryjujj@example.com");
        Customer c3 = new Customer("3","kitty","China","234234","45226","asdfhklsj@example.com");

        map.put(c1.getCid(),c1);
        map.put(c2.getCid(),c3);
        map.put(c3.getCid(),c2);

    }

    public static void addCustomer(Customer customer){
        map.put(customer.getCid(),customer);
    }
    public static Customer getCustomer(String id){
        return map.get(id);
    }

}
