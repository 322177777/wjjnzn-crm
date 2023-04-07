package com.neusoftwjj.crm.workbench.controller;


import com.neusoftwjj.crm.commons.contants.Contants;
import com.neusoftwjj.crm.commons.domain.ReturnObject;
import com.neusoftwjj.crm.commons.utils.DateUtils;
import com.neusoftwjj.crm.commons.utils.UUIDUtils;
import com.neusoftwjj.crm.settings.model.User;
import com.neusoftwjj.crm.workbench.activity.model.ActivityRemark;
import com.neusoftwjj.crm.workbench.activity.service.ActivityRemarkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ActivityRemarkController {
    @Resource
    private ActivityRemarkService activityRemarkService;
    @PostMapping("/workbench/activity/saveActivityDetail.do")
    public @ResponseBody
    Object saveActivityDetail(ActivityRemark remark, HttpSession session){
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        ReturnObject returnObject=new ReturnObject();
        //封装参数
        remark.setId(UUIDUtils.getUUID());
        remark.setCreateTime(DateUtils.formateDateTime(new Date()));
        remark.setCreateBy(user.getId());
        remark.setEditFlag(Contants.REMARK_EDIT_FIAG_NO_EDITED);

        //调用service层方法
        try {
            int ret=activityRemarkService.saveCreateActivityRemark(remark);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setRetData(remark);
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
    @DeleteMapping("/workbench/activity/deleteActivityRemarkById.do")
    public @ResponseBody Object deleteActivityRemarkById(String id){
        ReturnObject returnObject=new ReturnObject();
        try {
            //调用service层方法
            int ret = activityRemarkService.deleteActivityRemarkById(id);
            if(ret>0){
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
        return  returnObject;
    }
    @PostMapping("workbench/activity/saveEditActivityRemark.do")
    public@ResponseBody Object saveEditActivityRemark(ActivityRemark remark, HttpSession session){
        ReturnObject returnObject=new ReturnObject();
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        remark.setEditFlag(Contants.REMARK_EDIT_FIAG_YES_EDITED);
        remark.setEditTime(DateUtils.formateDateTime(new Date()));
        remark.setEditBy(user.getId());
        try {
            //调用service层方法
            int ret = activityRemarkService.saveEditActivityRemark(remark);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setRetData(remark);
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
}
