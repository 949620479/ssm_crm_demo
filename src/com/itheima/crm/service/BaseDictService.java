package com.itheima.crm.service;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.util.Page;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> getBaseDictBytypecode(String typeCode);

}
