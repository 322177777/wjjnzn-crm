package com.neusoftwjj.crm.workbench.controller;


import com.neusoftwjj.crm.commons.contants.Contants;
import com.neusoftwjj.crm.commons.domain.ReturnObject;
import com.neusoftwjj.crm.commons.utils.DateUtils;
import com.neusoftwjj.crm.commons.utils.UUIDUtils;
import com.neusoftwjj.crm.settings.model.User;
import com.neusoftwjj.crm.workbench.clue.model.ClueRemark;
import com.neusoftwjj.crm.workbench.clue.service.ClueRemarkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ClueRemarkController {
    @Resource
    private ClueRemarkService clueRemarkService;
    @PostMapping("/workbench/clue/saveClueDetail.do")
    @ResponseBody
    public Object saveClueDetail(ClueRemark clueRemark, HttpSession session){
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        ReturnObject returnObject=new ReturnObject();
        //封装参数
        clueRemark.setId(UUIDUtils.getUUID());
        clueRemark.setCreateBy(user.getId());
        clueRemark.setCreateTime(DateUtils.formateDateTime(new Date()));
        clueRemark.setEditFlag(Contants.REMARK_EDIT_FIAG_NO_EDITED);
        //调用service方法
        try {
            int ret = clueRemarkService.saveClueRemark(clueRemark);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setRetData(clueRemark);
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
    //删除
    @DeleteMapping("/workbench/clue/deleteClueRemarkById.do")
    @ResponseBody
    public Object deleteClueRemarkById(String id){
        ReturnObject returnObject=new ReturnObject();
        try {
            //调用service层方法
            int ret = clueRemarkService.deleteClueRemark(id);
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
    //更新
    @PutMapping("/workbench/clue/saveEditClueRemark.do")
    @ResponseBody
    public Object saveEditClueRemark(ClueRemark clueRemark,HttpSession session){
        ReturnObject returnObject=new ReturnObject();
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        clueRemark.setEditFlag(Contants.REMARK_EDIT_FIAG_YES_EDITED);
        clueRemark.setEditBy(user.getId());
        clueRemark.setEditTime(DateUtils.formateDateTime(new Date()));
        try {
            //调用service层方法
            int ret = clueRemarkService.saveEditClueRemark(clueRemark);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setRetData(clueRemark);
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
