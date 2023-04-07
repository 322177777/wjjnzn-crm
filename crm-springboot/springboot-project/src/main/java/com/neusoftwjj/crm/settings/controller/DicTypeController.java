package com.neusoftwjj.crm.settings.controller;


import com.neusoftwjj.crm.commons.contants.Contants;
import com.neusoftwjj.crm.commons.domain.ReturnObject;
import com.neusoftwjj.crm.settings.model.DicType;
import com.neusoftwjj.crm.settings.service.DicTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DicTypeController {
    @Resource
    private DicTypeService dicTypeService;

    @GetMapping("/settings/dictionary/index.do")
    public String index() {
        return "settings/dictionary/index";
    }

    @GetMapping("/settings/dictionary/type/typeIndex.do")
    public ModelAndView typeIndex() {
        ModelAndView mv = new ModelAndView();
        //调用service层方法
        List<DicType> dicTypeList = dicTypeService.queryAllDicType();
        //将数据添加到request中
        mv.addObject("dicTypeList", dicTypeList);
        mv.setViewName("settings/dictionary/type/index");
        return mv;
    }

    //跳转创建页面
    @GetMapping("/settings/dictionary/type/toSaveType.do")
    public String toSaveType() {
        return "settings/dictionary/type/save";
    }

    //创建字典类型
    @PostMapping("/settings/dictionary/type/saveDicType.do")
    @ResponseBody
    public Object saveDicType(DicType dicType) {
        ReturnObject returnObject = new ReturnObject();
        //调用service层方法,添加数据
        try {
            int ret = dicTypeService.addDicType(dicType);
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

    //跳转修改页面
    @GetMapping("/settings/dictionary/type/toEditType.do")
    public ModelAndView toEditType(String code) {
        ModelAndView mv = new ModelAndView();
        //调用service层方法,查找数据
        DicType dicType = dicTypeService.queryDicTypeByCode(code);
        //添加数据到request中
        mv.addObject("dicType", dicType);
        mv.setViewName("settings/dictionary/type/edit");
        return mv;
    }

    //更新字典类型
    @PutMapping("/settings/dictionary/type/editDicType.do")
    @ResponseBody
    public Object editDicType(DicType dicType) {
        ReturnObject returnObject = new ReturnObject();
        //调用service层方法,更新字典类型
        try {
            int ret = dicTypeService.editDicTypeByCode(dicType);
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

    //删除字典类型
    @DeleteMapping("/settings/dictionary/type/deleteDicTypeByCodes.do")
    @ResponseBody
    public Object deleteDicTypeByCodes(String[] code) {
        System.out.println("codes="+code);
        ReturnObject returnObject = new ReturnObject();
        //调用service层方法,删除字典类型
        try {
            int ret = dicTypeService.deleteDicType(code);
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
