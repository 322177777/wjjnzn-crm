package com.neusoftwjj.crm.workbench.clue.service;

import com.neusoftwjj.crm.workbench.clue.model.Clue;

import java.util.List;
import java.util.Map;

public interface ClueService {
    int saveCreateClue(Clue clue);
    Clue queryClueForDetailById(String id);
    void saveConvertClue(Map<String ,Object>map);
    /*分页查询*/
    List<Clue> queryClueByConditionForPage(Map<String, Object> map);
    /*总条数*/
    int queryCountOfClueByCondition(Map<String, Object> map);
    int deleteClueByIds(String[] ids);
}
