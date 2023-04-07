package com.neusoftwjj.crm.workbench.transaction.service.Impl;


import com.neusoftwjj.crm.commons.contants.Contants;
import com.neusoftwjj.crm.commons.utils.DateUtils;
import com.neusoftwjj.crm.commons.utils.UUIDUtils;
import com.neusoftwjj.crm.settings.model.User;
import com.neusoftwjj.crm.workbench.customer.mapper.CustomerMapper;
import com.neusoftwjj.crm.workbench.customer.model.Customer;
import com.neusoftwjj.crm.workbench.transaction.mapper.TranHistoryMapper;
import com.neusoftwjj.crm.workbench.transaction.mapper.TranMapper;
import com.neusoftwjj.crm.workbench.transaction.model.Tran;
import com.neusoftwjj.crm.workbench.transaction.model.TranHistory;
import com.neusoftwjj.crm.workbench.transaction.service.TranService;
import com.neusoftwjj.crm.workbench.vo.FunnelVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tranService")
public class TranServiceImpl implements TranService {

    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private TranMapper tranMapper;
    @Resource
    private TranHistoryMapper tranHistoryMapper;
    @Override
    public void saveCreateTran(Map<String, Object> map) {
        String customerName=(String) map.get("customerName");
        User user=(User)map.get(Contants.SESSION_USER);
        Customer customer=customerMapper.selectCustomerByName(customerName);
        //判断客户是否不存在
        if(customer==null){
            customer=new Customer();
            customer.setOwner(user.getId());
            customer.setName(customerName);
            customer.setId(UUIDUtils.getUUID());
            customer.setCreateBy(user.getId());
            customer.setCreateTime(DateUtils.formateDateTime(new Date()));
            customerMapper.insertCustomer(customer);
        }
        //保存创建的交易
        Tran tran=new Tran();
        tran.setStage((String) map.get("stage"));
        tran.setOwner((String)map.get("owner"));
        tran.setNextContactTime((String)map.get("nextContactTime"));
        tran.setName((String)map.get("name"));
        tran.setMoney((String)map.get("money"));
        tran.setId(UUIDUtils.getUUID());
        tran.setExpectedDate((String)map.get("expectedDate"));
        tran.setCustomerId(customer.getId());
        tran.setCreateTime(DateUtils.formateDateTime(new Date()));
        tran.setCreateBy(user.getId());
        tran.setContactSummary((String)map.get("contactSummary"));
        tran.setActivityId((String)map.get("activityId"));
        tran.setContactsId((String)map.get("contactsId"));
        tran.setDescription((String)map.get("description"));
        tran.setSource((String)map.get("source"));
        tran.setType((String)map.get("type"));
        tranMapper.insertTran(tran);
        //保存交易历史
        TranHistory tranHistory=new TranHistory();
        tranHistory.setTranId(tran.getId());
        tranHistory.setCreateBy(user.getId());
        tranHistory.setCreateTime(DateUtils.formateDateTime(new Date()));
        tranHistory.setExpectedDate(tran.getExpectedDate());
        tranHistory.setId(UUIDUtils.getUUID());
        tranHistory.setMoney(tran.getMoney());
        tranHistory.setStage(tran.getStage());
        tranHistoryMapper.insertTranHistory(tranHistory);

    }

    @Override
    public Tran queryTranForDetailById(String id) {
        return tranMapper.selectTranForDetailById(id);
    }

    @Override
    public List<FunnelVo> queryCountOfTranGroupByStage() {
        return tranMapper.selectCountOfTranGroupByStage();
    }

    @Override
    public List<Tran> queryTranByConditionForPage(Map<String, Object> map) {
        return tranMapper.selectTranByConditionForPage(map);
    }

    @Override
    public int queryCountOfTranByCondition(Map<String, Object> map) {
        return tranMapper.selectCountOfTranByCondition(map);
    }
}
