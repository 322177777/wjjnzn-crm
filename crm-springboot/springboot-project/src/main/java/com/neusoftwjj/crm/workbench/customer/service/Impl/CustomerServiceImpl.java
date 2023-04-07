package com.neusoftwjj.crm.workbench.customer.service.Impl;


import com.neusoftwjj.crm.workbench.customer.mapper.CustomerMapper;
import com.neusoftwjj.crm.workbench.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;
    @Override
    public List<String> queryCustomerNameByName(String customerName) {
        return customerMapper.selectCustomerNameByName(customerName);
    }
}
