package com.itheima.crm.dao;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.util.Page;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomerList(QueryVo vo);
    Integer getCustomer(QueryVo vo);
    Customer getCustomerById(Long id);
    void updateCustomer(Customer customer);
}
