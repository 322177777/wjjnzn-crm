package com.neusoftwjj.crm.settings.controller;


import com.neusoftwjj.crm.commons.contants.Contants;
import com.neusoftwjj.crm.commons.domain.ReturnObject;
import com.neusoftwjj.crm.commons.utils.UUIDUtils;
import com.neusoftwjj.crm.settings.model.DicType;
import com.neusoftwjj.crm.settings.model.DicValue;
import com.neusoftwjj.crm.settings.service.DicTypeService;
import com.neusoftwjj.crm.settings.service.DicValueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class DicValueController {
    @Resource
    private DicValueService dicValueService;
    @Resource
    private DicTypeService dicTypeService;

    @GetMapping("/settings/dictionary/value/valueIndex.do")
    public ModelAndView valueIndex() {
        ModelAndView mv = new ModelAndView();
        //调用service层方法
        List<DicValue> dicValueList = dicValueService.queryAllDicValue();
        mv.addObject("dicValueList", dicValueList);
        mv.setViewName("settings/dictionary/value/index");
        return mv;
    }

    //跳转创建页面
    @GetMapping("/settings/dictionary/value/toSave.do")
    public String toSave(HttpServletRequest request) {
        //调用Type的service层方法,实现查询字典类型编码
        List<DicType> dicTypeList = dicTypeService.queryAllDicType();
        request.setAttribute("dicTypeList", dicTypeList);
        return "settings/dictionary/value/save";
    }

    //添加字典值
    @PostMapping("/settings/dictionary/value/saveDicValue.do")
    @ResponseBody
    public Object saveDicValue(DicValue dicValue) {
        ReturnObject returnObject = new ReturnObject();
        dicValue.setId(UUIDUtils.getUUID());
        //调用service层方法
        try{
            int ret = dicValueService.addDicValue(dicValue);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
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
    @GetMapping("/settings/dictionary/value/toEditValue.do")
    public ModelAndView toEditValue(String id){
        ModelAndView mv = new ModelAndView();
        //调用service层方法
        DicValue dicValue = dicValueService.queryDicValueById(id);
        //添加数据到request中
        mv.addObject("dicValue", dicValue);
        mv.setViewName("settings/dictionary/value/edit");
        return mv;
    }
    @PutMapping("/settings/dictionary/value/editDicValue.do")
    @ResponseBody
    public Object editDicValue(DicValue dicValue){
        ReturnObject returnObject = new ReturnObject();
        //调用service层方法,更新字典类型
        try {
            int ret = dicValueService.updateDicValue(dicValue);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setCode("系统繁忙,请稍后重试...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setCode("系统繁忙,请稍后重试...");
        }
        return returnObject;
    }
    @DeleteMapping("/settings/dictionary/value/deleteDicValueByIds.do")
    @ResponseBody
    public Object deleteDicValueByIds(String[] id){
        ReturnObject returnObject = new ReturnObject();
        //调用service层方法,删除字典类型
        try {
            int ret = dicValueService.deleteDicValue(id);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
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
}
