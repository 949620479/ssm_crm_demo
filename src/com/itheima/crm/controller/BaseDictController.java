package com.itheima.crm.controller;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Constants;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BaseDictController {

    @Autowired
    private BaseDictService service;
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/customer/list")
    public String getBaseDictController(Model model,QueryVo vo){
        List<BaseDict> sourcelist = service.getBaseDictBytypecode(Constants.CON_cust_source);
        List<BaseDict> industrylist = service.getBaseDictBytypecode(Constants.CON_cust_industry);
        List<BaseDict> levellist = service.getBaseDictBytypecode(Constants.CON_cust_level);
        model.addAttribute("fromType",sourcelist);
        model.addAttribute("industryType",industrylist);
        model.addAttribute("levelType",levellist);
        Page<Customer> page = customerService.getCustomerByQueryVo(vo);
        System.out.println(page);
        model.addAttribute("page",page);
        //数据回显
        model.addAttribute("custName",vo.getCustName());
        model.addAttribute("custSource",vo.getCustSource());
        model.addAttribute("custIndustry",vo.getCustIndustry());
        return "customer";
    }

    @RequestMapping(value="customer/edit",method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerById(Long id){
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping(value = "customer/update",method = RequestMethod.POST)
    @ResponseBody
    public Customer updayeCustomer(Customer customer){
        customerService.updateCustomer(customer);
        return customer;
    }
}
