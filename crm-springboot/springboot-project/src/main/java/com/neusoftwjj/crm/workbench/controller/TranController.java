package com.neusoftwjj.crm.workbench.controller;


import com.neusoftwjj.crm.commons.contants.Contants;
import com.neusoftwjj.crm.commons.domain.ReturnObject;
import com.neusoftwjj.crm.settings.model.DicValue;
import com.neusoftwjj.crm.settings.model.User;
import com.neusoftwjj.crm.settings.service.DicValueService;
import com.neusoftwjj.crm.settings.service.UserService;
import com.neusoftwjj.crm.workbench.activity.model.Activity;
import com.neusoftwjj.crm.workbench.activity.service.ActivityService;
import com.neusoftwjj.crm.workbench.contacts.model.Contacts;
import com.neusoftwjj.crm.workbench.contacts.service.ContactsService;
import com.neusoftwjj.crm.workbench.customer.service.CustomerService;
import com.neusoftwjj.crm.workbench.transaction.model.Tran;
import com.neusoftwjj.crm.workbench.transaction.model.TranHistory;
import com.neusoftwjj.crm.workbench.transaction.model.TranRemark;
import com.neusoftwjj.crm.workbench.transaction.service.TranHistoryService;
import com.neusoftwjj.crm.workbench.transaction.service.TranRemarkService;
import com.neusoftwjj.crm.workbench.transaction.service.TranService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class TranController {
    @Resource
    private ContactsService contactsService;
    @Resource
    private ActivityService activityService;
    @Resource
    private DicValueService dicValueService;
    @Resource
    private UserService userService;
    @Resource
    private CustomerService customerService;
    @Resource
    private TranService tranService;
    @Resource
    private TranRemarkService tranRemarkService;
    @Resource
    private TranHistoryService tranHistoryService;

    @GetMapping("/workbench/transaction/index.do")
    public String index(HttpServletRequest request){
        //调用service层方法
        List<DicValue> transactionTypeList=dicValueService.queryDicValueByTypeCode("transactionType");
        List<DicValue> sourceList=dicValueService.queryDicValueByTypeCode("source");
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");
        //把数据保存在request中
        request.setAttribute("transactionTypeList",transactionTypeList);
        request.setAttribute("sourceList",sourceList);
        request.setAttribute("stageList",stageList);
        //请求转发
        return "workbench/transaction/index";
    }
    @GetMapping("/workbench/transaction/saveTran.do")
    public String saveTran(HttpServletRequest request){
        //调用service层方法
        //查询市场活动源
        List<Activity> activityList = activityService.queryAllActivitys();
        //查询联系人
        List<Contacts> contactsList = contactsService.queryContactsAll();

        List<User> userList=userService.queryAllUsers();
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");
        List<DicValue> transactionTypeList=dicValueService.queryDicValueByTypeCode("transactionType");
        List<DicValue> sourceList=dicValueService.queryDicValueByTypeCode("source");
        //把数据保存在request中
        request.setAttribute("contactsList",contactsList);
        request.setAttribute("activityList",activityList);
        request.setAttribute("userList",userList);
        request.setAttribute("stageList",stageList);
        request.setAttribute("transactionTypeList",transactionTypeList);
        request.setAttribute("sourceList",sourceList);
        //请求转发
        return "workbench/transaction/save";
    }
    @GetMapping("/workbench/transaction/getPossibilityByStage.do")
    public@ResponseBody
    Object getPossibilityByStage(String stageValue){
        //解析properties文件
        ResourceBundle bundle= ResourceBundle.getBundle("application");
        String possibility=bundle.getString(stageValue);
        //返回显示信息
        return possibility;
    }
    @GetMapping("/workbench/transaction/queryCustomerNameByName.do")
    public@ResponseBody
    Object queryCustomerNameByName(String customerName){
        //调用service层方法
        List<String> nameList=customerService.queryCustomerNameByName(customerName);
        return nameList;
    }
    @PostMapping("/workbench/transaction/saveCreateTran.do")
    public@ResponseBody
    Object saveCreateTran(@RequestParam Map<String ,Object> map, HttpSession session){
        ReturnObject returnObject=new ReturnObject();
        //封装参数
        map.put(Contants.SESSION_USER,session.getAttribute(Contants.SESSION_USER));
        try {
            //调用service,保存创建的交易
            tranService.saveCreateTran(map);
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙,请稍后重试...");
        }
        return returnObject;
    }
    @GetMapping("/workbench/transaction/queryTranRemarkForDetail.do")
    public String queryTranRemarkForDetail(String id,HttpServletRequest request) {
        //调用service层方法
        Tran tran=tranService.queryTranForDetailById(id);
        List<TranRemark> tranRemarkList=tranRemarkService.queryTranRemarkForDetailByTranId(id);
        List<TranHistory> tranHistoryList=tranHistoryService.queryTranHistoryForDetailByTranId(id);
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");
        //根据tran的阶段解析配置文件得到可能性
        ResourceBundle bundle=ResourceBundle.getBundle("application");
        String possibility=bundle.getString(tran.getStage().trim());
        tran.setPossibility(possibility);
        //将数据保存在request中
        request.setAttribute("tran",tran);
        request.setAttribute("tranRemarkList",tranRemarkList);
        request.setAttribute("tranHistoryList",tranHistoryList);
        request.setAttribute("stageList",stageList);
        //请求转发
        return "workbench/transaction/detail";
    }
    //分页查询
    @GetMapping("/workbench/transaction/queryTranByConditionForPage.do")
    @ResponseBody
    public Object queryTranByConditionForPage(String owner,String name,String customerId,
                                              String stage,String type,String source, String contactsId,
                                              @RequestParam(value = "pageNo", required = false) int pageNo,
                                              @RequestParam(value = "pageSize", required = false) int pageSize){
        //封装参数
        Map<String, Object> map = new HashMap<>();
        map.put("owner",owner);
        map.put("name",name);
        map.put("customerId",customerId);
        map.put("stage",stage);
        map.put("type",type);
        map.put("source",source);
        map.put("contactsId",contactsId);
        map.put("beginNo", (pageNo - 1) * pageSize);
        map.put("pageSize", pageSize);
        //调用service层方法
        List<Tran> tranList = tranService.queryTranByConditionForPage(map);
        int totalRows = tranService.queryCountOfTranByCondition(map);
        //根据查询结果,生成响应信息
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("tranList", tranList);
        retMap.put("totalRows", totalRows);
        return retMap;
    }
}
