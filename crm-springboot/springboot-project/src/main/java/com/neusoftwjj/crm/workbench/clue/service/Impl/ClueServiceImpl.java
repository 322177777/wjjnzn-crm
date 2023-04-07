package com.neusoftwjj.crm.workbench.clue.service.Impl;


import com.neusoftwjj.crm.commons.contants.Contants;
import com.neusoftwjj.crm.commons.utils.DateUtils;
import com.neusoftwjj.crm.commons.utils.UUIDUtils;
import com.neusoftwjj.crm.settings.model.User;
import com.neusoftwjj.crm.workbench.clue.mapper.ClueActivityRelationMapper;
import com.neusoftwjj.crm.workbench.clue.mapper.ClueMapper;
import com.neusoftwjj.crm.workbench.clue.mapper.ClueRemarkMapper;
import com.neusoftwjj.crm.workbench.clue.model.Clue;
import com.neusoftwjj.crm.workbench.clue.model.ClueActivityRelation;
import com.neusoftwjj.crm.workbench.clue.model.ClueRemark;
import com.neusoftwjj.crm.workbench.clue.service.ClueService;
import com.neusoftwjj.crm.workbench.contacts.mapper.ContactsActivityRelationMapper;
import com.neusoftwjj.crm.workbench.contacts.mapper.ContactsMapper;
import com.neusoftwjj.crm.workbench.contacts.mapper.ContactsRemarkMapper;
import com.neusoftwjj.crm.workbench.contacts.model.Contacts;
import com.neusoftwjj.crm.workbench.contacts.model.ContactsActivityRelation;
import com.neusoftwjj.crm.workbench.contacts.model.ContactsRemark;
import com.neusoftwjj.crm.workbench.customer.mapper.CustomerMapper;
import com.neusoftwjj.crm.workbench.customer.mapper.CustomerRemarkMapper;
import com.neusoftwjj.crm.workbench.customer.model.Customer;
import com.neusoftwjj.crm.workbench.customer.model.CustomerRemark;
import com.neusoftwjj.crm.workbench.transaction.mapper.TranMapper;
import com.neusoftwjj.crm.workbench.transaction.mapper.TranRemarkMapper;
import com.neusoftwjj.crm.workbench.transaction.model.Tran;
import com.neusoftwjj.crm.workbench.transaction.model.TranRemark;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("clueService")
public class ClueServiceImpl implements ClueService {
    @Resource
    private ClueMapper clueMapper;
    @Resource
    private ClueRemarkMapper clueRemarkMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private ContactsMapper contactsMapper;
    @Resource
    private CustomerRemarkMapper customerRemarkMapper;
    @Resource
    private ContactsRemarkMapper contactsRemarkMapper;
    @Resource
    private ClueActivityRelationMapper clueActivityRelationMapper;
    @Resource
    private ContactsActivityRelationMapper contactsActivityRelationMapper;
    @Resource
    private TranMapper tranMapper;
    @Resource
    private TranRemarkMapper tranRemarkMapper;
    @Override
    public int saveCreateClue(Clue clue) {
        return clueMapper.insertClue(clue);
    }

    @Override
    public Clue queryClueForDetailById(String id) {
        return clueMapper.selectClueForDetailById(id);
    }

    @Override
    public void saveConvertClue(Map<String, Object> map) {
        String clueId=(String)map.get("clueId");
        User user=(User) map.get(Contants.SESSION_USER);
        String isCreateTran=(String) map.get("isCreateTran");
        //根据id查询线索的信息
        Clue clue=clueMapper.selectClueForConvertById(clueId);
        //把该线索中的有关公司的信息转换到客户表中
        Customer c=new Customer();
        c.setAddress(clue.getAddress());
        c.setContactSummary(clue.getContactSummary());
        c.setCreateBy(user.getId());
        c.setCreateTime(DateUtils.formateDateTime(new Date()));
        c.setDescription(clue.getDescription());
        c.setId(UUIDUtils.getUUID());
        c.setNextContactTime(clue.getNextContactTime());
        c.setName(clue.getCompany());
        c.setOwner(user.getId());
        c.setPhone(clue.getPhone());
        c.setWebsite(clue.getWebsite());
        customerMapper.insertCustomer(c);
        //把该线索中有关个人的信息转换到联系人表中
        Contacts co=new Contacts();
        co.setAddress(clue.getAddress());
        co.setAppellation(clue.getAppellation());
        co.setContactSummary(clue.getContactSummary());
        co.setCreateTime(DateUtils.formateDateTime(new Date()));
        co.setCreateBy(user.getId());
        co.setDescription(clue.getDescription());
        co.setEmail(clue.getEmail());
        co.setFullname(clue.getFullname());
        co.setNextContactTime(clue.getNextContactTime());
        co.setId(UUIDUtils.getUUID());
        co.setJob(clue.getJob());
        co.setOwner(user.getId());
        co.setMphone(clue.getMphone());
        co.setCustomerId(c.getId());
        co.setSource(clue.getSource());
        contactsMapper.insertContacts(co);

        //根据clueId查询线索的所有备注
        List<ClueRemark> clueRemarkList=clueRemarkMapper.selectClueRemarkByClueId(clueId);

        //如果有线索备注，把该线索下所有的备注转换到客户备注表里;把客户备注转换到联系人备注
        if(clueRemarkList!=null&&clueRemarkList.size()>0){
            //遍历clueRemarkList，只存客户备注
            CustomerRemark cur=null;
            ContactsRemark cot=null;
            List<CustomerRemark> curList=new ArrayList<>();
            List<ContactsRemark> cotList=new ArrayList<>();
            for (ClueRemark cr:clueRemarkList){
                //客户备注
                cur=new CustomerRemark();
                cur.setCreateBy(cr.getCreateBy());
                cur.setCreateTime(cr.getCreateTime());
                cur.setCustomerId(c.getId());
                cur.setId(UUIDUtils.getUUID());
                cur.setEditBy(cr.getEditBy());
                cur.setEditFlag(cr.getEditFlag());
                cur.setEditTime(cr.getEditTime());
                cur.setNoteContent(cr.getNoteContent());
                curList.add(cur);
                //联系人备注
                cot=new ContactsRemark();
                cot.setContactsId(co.getId());
                cot.setId(UUIDUtils.getUUID());
                cot.setCreateBy(cr.getCreateBy());
                cot.setCreateTime(cr.getCreateTime());
                cot.setEditBy(cr.getEditBy());
                cot.setEditFlag(cr.getEditFlag());
                cot.setNoteContent(cr.getNoteContent());
                cot.setEditTime(cr.getEditTime());
                cotList.add(cot);


            }
            customerRemarkMapper.insertCustomerRemarkByList(curList);
            contactsRemarkMapper.insertContactsRemarkByList(cotList);
        }

        //根据clueId查询市场活动和线索的关联关系
        List<ClueActivityRelation> carList=clueActivityRelationMapper.selectClueActivityRelationByClueId(clueId);

        //如果有市场活动和线索的关联关系,把关联关系转换入联系人市场活动和线索的关联关系表
        if (carList!=null&&carList.size()>0){
            ContactsActivityRelation coar=null;
            List<ContactsActivityRelation> coarList=new ArrayList<>();
            for (ClueActivityRelation car:carList){
                coar=new ContactsActivityRelation();
                coar.setActivityId(car.getActivityId());
                coar.setContactsId(co.getId());
                coar.setId(UUIDUtils.getUUID());
                coarList.add(coar);
            }
            contactsActivityRelationMapper.insertContactsActivityRelationByList(coarList);
        }
        //如果需要创建交易,交易表添加记录
        if("true".equals(isCreateTran)){
            Tran tran=new Tran();
            tran.setActivityId((String) map.get("activityId"));
            tran.setContactsId(co.getId());
            tran.setCreateBy(user.getId());
            tran.setCreateTime(DateUtils.formateDateTime(new Date()));
            tran.setCustomerId(c.getId());
            tran.setExpectedDate((String) map.get("expectedDate"));
            tran.setId(UUIDUtils.getUUID());
            tran.setType("97d1128f70294f0aac49e996ced28c8a");
            tran.setSource(clue.getSource());
            tran.setDescription(clue.getDescription());
            tran.setContactSummary(clue.getContactSummary());
            tran.setNextContactTime(clue.getNextContactTime());
            tran.setMoney((String) map.get("money"));
            tran.setName((String) map.get("name"));
            tran.setOwner(user.getId());
            tran.setStage((String) map.get("stage"));
            tranMapper.insertTran(tran);
            //把该线索下所有的备注转换到交易备注表里
            if (clueRemarkList!=null&&clueRemarkList.size()>0){
                TranRemark tr=null;
                List<TranRemark> trList=new ArrayList<>();
                for (ClueRemark cr:clueRemarkList){
                    tr=new TranRemark();
                    tr.setCreateBy(cr.getCreateBy());
                    tr.setCreateTime(cr.getCreateTime());
                    tr.setEditBy(cr.getEditBy());
                    tr.setId(UUIDUtils.getUUID());
                    tr.setEditFlag(cr.getEditFlag());
                    tr.setEditTime(cr.getEditTime());
                    tr.setNoteContent(cr.getNoteContent());
                    tr.setTranId(tran.getId());
                    trList.add(tr);

                }
                tranRemarkMapper.insertTranRemarkByList(trList);
            }
        }

        //删除线索下的所有备注
        clueRemarkMapper.deleteClueRemarkByClueId(clueId);
        //删除线索和市场活动的关联关系
        clueActivityRelationMapper.deleteClueActivityRelationByClueId(clueId);
        //删除该线索
        clueMapper.deleteClueById(clueId);
    }

    @Override
    public List<Clue> queryClueByConditionForPage(Map<String, Object> map) {
        return clueMapper.selectClueByConditionForPage(map);
    }

    @Override
    public int queryCountOfClueByCondition(Map<String, Object> map) {
        return clueMapper.selectCountOfClueByCondition(map);
    }

    @Override
    public int deleteClueByIds(String[] ids) {
        return clueMapper.deleteClueByIds(ids);
    }
}
