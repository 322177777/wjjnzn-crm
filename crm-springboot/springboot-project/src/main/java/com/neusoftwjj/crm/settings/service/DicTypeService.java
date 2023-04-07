package com.neusoftwjj.crm.settings.service;



import com.neusoftwjj.crm.settings.model.DicType;

import java.util.List;

public interface DicTypeService {
    List<DicType> queryAllDicType();
    int addDicType(DicType dicType);
    DicType queryDicTypeByCode(String code);
    int editDicTypeByCode(DicType dicType);
    int deleteDicType(String[] codes);
}
