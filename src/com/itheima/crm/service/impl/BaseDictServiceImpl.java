package com.itheima.crm.service.impl;

import com.itheima.crm.dao.BaseDictDao;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    private BaseDictDao dao;
    @Override
    public List<BaseDict> getBaseDictBytypecode(String typeCode) {
        return dao.getBaseDictBytypecode(typeCode);
    }


}
