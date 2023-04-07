package com.neusoftwjj.crm.workbench.controller;


import com.neusoftwjj.crm.commons.contants.Contants;
import com.neusoftwjj.crm.commons.domain.ReturnObject;
import com.neusoftwjj.crm.commons.utils.DateUtils;
import com.neusoftwjj.crm.commons.utils.UUIDUtils;
import com.neusoftwjj.crm.settings.model.DicValue;
import com.neusoftwjj.crm.settings.model.User;
import com.neusoftwjj.crm.settings.service.DicValueService;
import com.neusoftwjj.crm.settings.service.UserService;
import com.neusoftwjj.crm.workbench.activity.model.Activity;
import com.neusoftwjj.crm.workbench.activity.service.ActivityService;
import com.neusoftwjj.crm.workbench.clue.model.Clue;
import com.neusoftwjj.crm.workbench.clue.model.ClueActivityRelation;
import com.neusoftwjj.crm.workbench.clue.model.ClueRemark;
import com.neusoftwjj.crm.workbench.clue.service.ClueActivityRelationService;
import com.neusoftwjj.crm.workbench.clue.service.ClueRemarkService;
import com.neusoftwjj.crm.workbench.clue.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ClueController {
    @Resource
    private UserService userService;
    @Resource
    private DicValueService dicValueService;
    @Resource
    private ClueService clueService;
    @Resource
    private ActivityService activityService;
    @Resource
    private ClueRemarkService clueRemarkService;
    @Resource
    private ClueActivityRelationService clueActivityRelationService;

    @GetMapping("/workbench/clue/index.do")
    public String index(HttpServletRequest request){
        System.out.println("进入........");
        //调用service层方法
        List<User> userList=userService.queryAllUsers();
        List<DicValue> appellationList=dicValueService.queryDicValueByTypeCode("appellation");
        List<DicValue> clueStateList=dicValueService.queryDicValueByTypeCode("clueState");
        List<DicValue> sourceList=dicValueService.queryDicValueByTypeCode("source");
        //把数据存入request中
        request.setAttribute("userList",userList);
        request.setAttribute("appellationList",appellationList);
        request.setAttribute("clueStateList",clueStateList);
        request.setAttribute("sourceList",sourceList);
        System.out.println("request = " + request);
        //请求转发
        return "workbench/clue/index";
    }

    @PostMapping("/workbench/clue/saveCreateClue.do")
    public @ResponseBody
    Object saveCreateClue(Clue clue, HttpSession session){
        User user =(User)session.getAttribute(Contants.SESSION_USER);
        ReturnObject returnObject=new ReturnObject();
        //封装参数
        clue.setId(UUIDUtils.getUUID());
        clue.setCreateTime(DateUtils.formateDateTime(new Date()));
        clue.setCreateBy(user.getId());
        try {
            //调用service层方法
            int ret = clueService.saveCreateClue(clue);
            if (ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);

            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统繁忙,请稍后重试...");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙,请稍后重试...");
        }
        return returnObject;
    }
    @GetMapping("/workbench/clue/detailClue.do")
    public String detailClue(HttpServletRequest request,String id){
        //调用service层方法
        Clue clue=clueService.queryClueForDetailById(id);
        List<ClueRemark> remarkList=clueRemarkService.queryClueRemarkForDetailByClueId(id);
        List<Activity> activityList=activityService.queryActivityForDetailByClueId(id);
        //将数据保存至request中
        request.setAttribute("clue",clue);
        request.setAttribute("remarkList",remarkList);
        request.setAttribute("activityList",activityList);
        //请求转发
        return "workbench/clue/detail";

    }
    @GetMapping("/workbench/clue/queryActivityForDetailByNameClueId.do")
    public@ResponseBody Object queryActivityForDetailByNameClueId(String activityName,String clueId){
        //封装参数
        Map<String,Object> map=new HashMap<>();
        map.put("activityName",activityName);
        map.put("clueId",clueId);
        //调用service层方法
        List<Activity> activityList=activityService.queryActivityForDetailByNameClueId(map);
        //根据查询结果,返回响应信息
        return activityList;
    }
    @PostMapping("/workbench/clue/saveClueActivityRelationByList.do")
    public @ResponseBody
    Object saveClueActivityRelationByList(String[] activityId,String clueId){
        List<ClueActivityRelation> relationList=new ArrayList<>();
        List<Activity> activityList=new ArrayList<>();
        ReturnObject returnObject=new ReturnObject();
        ClueActivityRelation car=null;
        //封装参数
        for (String ai:activityId){
            car=new ClueActivityRelation();
            car.setId(UUIDUtils.getUUID());
            car.setClueId(clueId);
            car.setActivityId(ai);
            relationList.add(car);
        }

        //调用service层方法
        try {
            int ret=clueActivityRelationService.saveCreateClueActivityRelationByList(relationList);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                activityList=activityService.queryActivityForDetailByIds(activityId);
                returnObject.setRetData(activityList);
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统繁忙,请稍后重试...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙,请稍后重试...");
        }
        return returnObject;
    }
    @DeleteMapping("/workbench/clue/deleteBundByClueIdActivityId.do")
    public@ResponseBody
    Object deleteBundByClueIdActivityId(String activityId,String clueId){
        ClueActivityRelation clueActivityRelation=new ClueActivityRelation();
        ReturnObject returnObject=new ReturnObject();
        //封装参数
        clueActivityRelation.setActivityId(activityId);
        clueActivityRelation.setClueId(clueId);
        //调用service层方法,删除关联信息
        try {
            int ret= clueActivityRelationService.deleteClueActivityRelationByClueIdActivityId(clueActivityRelation);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);

            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统繁忙,请稍后重试...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙,请稍后重试...");
        }
        return returnObject;
    }
    @GetMapping("/workbench/clue/toConvert.do")
    public String toConvert(String id,HttpServletRequest request){
        //调用service层方法,查询线索的明细信息
        Clue clue=clueService.queryClueForDetailById(id);
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");
        //把数据保存在request中
        request.setAttribute("clue",clue);
        request.setAttribute("stageList",stageList);
        //请求转发
        return "workbench/clue/convert";
    }
    @GetMapping("/workbench/clue/queryActivityForConvertByNameClueId.do")
    public @ResponseBody
    Object queryActivityForConvertByNameClueId(String activityName,String clueId){
        //封装参数
        Map<String ,Object>map=new HashMap<>();
        map.put("activityName",activityName);
        map.put("clueId",clueId);
        //调用service层方法，查询数据
        List<Activity> activityList=activityService.queryActivityForConvertByNameClueId(map);
        return activityList;
    }
    @PostMapping("/workbench/clue/convertClue.do")
    public@ResponseBody Object convertClue(String clueId,String money,String name,String expectedDate,String stage,String activityId,String isCreateTran,HttpSession session ){
        //封装参数
        Map<String,Object> map=new HashMap<>();
        map.put("clueId",clueId);
        map.put("money",money);
        map.put("name",name);
        map.put("expectedDate",expectedDate);
        map.put("stage",stage);
        map.put("activityId",activityId);
        map.put("isCreateTran",isCreateTran);
        map.put(Contants.SESSION_USER,session.getAttribute(Contants.SESSION_USER));
        ReturnObject returnObject=new ReturnObject();
        try {
            //调用service层方法
            clueService.saveConvertClue(map);
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙,请稍后重试...");
        }
        return returnObject;
    }
    /**
     * 分页查询
     */
    @GetMapping("/workbench/clue/queryClueByConditionForPage.do")
    @ResponseBody
    public Object queryClueByConditionForPage(String fullname, String owner, String company, String phone,
                                              String mphone, String state, String source,
                                              @RequestParam(value = "pageNo", required = false) int pageNo,
                                              @RequestParam(value = "pageSize", required = false) int pageSize){
        //封装参数
        Map<String, Object> map = new HashMap<>();
        map.put("fullname",fullname);
        map.put("owner",owner);
        map.put("company",company);
        map.put("phone",phone);
        map.put("mphone",mphone);
        map.put("state",state);
        map.put("source",source);
        map.put("beginNo", (pageNo - 1) * pageSize);
        map.put("pageSize", pageSize);
        //调用service层方法,查询数据
        List<Clue> clueList = clueService.queryClueByConditionForPage(map);
        int totalRows = clueService.queryCountOfClueByCondition(map);
        //根据查询结果,生成响应信息
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("clueList", clueList);
        retMap.put("totalRows", totalRows);
        return retMap;
    }
    //删除
    @DeleteMapping("/workbench/clue/deleteClueByIds.do")
    @ResponseBody
    public Object deleteClueByIds(String[] id){
        ReturnObject returnObject = new ReturnObject();
        //调用service层方法
        try {
            int ret = clueService.deleteClueByIds(id);
            if (ret > 0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统繁忙,请稍后重试...");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙,请稍后重试...");
        }
        return returnObject;
    }
}
