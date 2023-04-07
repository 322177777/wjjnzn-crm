package com.neusoftwjj.crm.settings.service;

import com.neusoftwjj.crm.settings.model.DicValue;

import java.util.List;

public interface DicValueService {
    List<DicValue> queryDicValueByTypeCode(String typeCode);
    List<DicValue> queryAllDicValue();
    DicValue queryDicValueById(String id);
    //添加数据
    int addDicValue(DicValue dicValue);

    int updateDicValue(DicValue dicValue);

    int deleteDicValue(String[] ids);

}
