package com.itheima.crm.service;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.util.Page;

public interface CustomerService {
    Page<Customer> getCustomerByQueryVo(QueryVo vo);
    Customer getCustomerById(Long id);
    void updateCustomer(Customer customer);
}
