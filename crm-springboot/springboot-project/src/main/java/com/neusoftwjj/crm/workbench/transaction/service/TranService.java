package com.neusoftwjj.crm.workbench.transaction.service;

import com.neusoftwjj.crm.workbench.transaction.model.Tran;
import com.neusoftwjj.crm.workbench.vo.FunnelVo;

import java.util.List;
import java.util.Map;

public interface TranService {
    void saveCreateTran(Map<String ,Object> map);
    Tran queryTranForDetailById(String id);

    List<FunnelVo> queryCountOfTranGroupByStage();
    //查询交易信息
    List<Tran> queryTranByConditionForPage(Map<String,Object> map);
    //查询总条数
    int queryCountOfTranByCondition(Map<String,Object> map);
}
