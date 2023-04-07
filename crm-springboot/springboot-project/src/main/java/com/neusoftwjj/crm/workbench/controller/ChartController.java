package com.neusoftwjj.crm.workbench.controller;


import com.neusoftwjj.crm.workbench.transaction.service.TranService;
import com.neusoftwjj.crm.workbench.vo.FunnelVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ChartController {
    @Resource
    private TranService tranService;
    @GetMapping("/workbench/chart/transaction/index.do")
    public String index(){
        return "workbench/chart/transaction/index";
    }
    @GetMapping("/workbench/chart/transaction/queryCountOfTranGroup.do")
    public @ResponseBody
    Object queryCountOfTranGroup(){
        //调用service层方法
        List<FunnelVo> funnelVoList= tranService.queryCountOfTranGroupByStage();
        return funnelVoList;
    }


}
