package com.itheima.crm.service.impl;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao dao;
    @Override
    public Page<Customer> getCustomerByQueryVo(QueryVo vo) {
        //当前页数
        //一页显示的条数
        //每页的起始条号数
        //总条数
        if(vo.getPage()==null){
            vo.setPage(1);
        }
        if(vo.getRows()==null){
            vo.setRows(10);
        }
        vo.setStart((vo.getPage()-1)*vo.getRows());
        //显示的数据
        List<Customer> customerList = dao.getCustomerList(vo);

        //设置分页信息
        Page<Customer> page = new Page<>();
        page.setRows(customerList);
        page.setPage(vo.getPage());
        page.setSize(vo.getRows());
        //总记录数
        page.setTotal(dao.getCustomer(vo));
        return page;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return dao.getCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        dao.updateCustomer(customer);
    }
}
