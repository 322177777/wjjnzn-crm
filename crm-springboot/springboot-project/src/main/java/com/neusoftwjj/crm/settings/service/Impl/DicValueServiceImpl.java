package com.neusoftwjj.crm.settings.service.Impl;


import com.neusoftwjj.crm.settings.mapper.DicValueMapper;
import com.neusoftwjj.crm.settings.model.DicValue;
import com.neusoftwjj.crm.settings.service.DicValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("dicValueService")
public class DicValueServiceImpl implements DicValueService {
    @Resource
    private DicValueMapper dicValueMapper;
    @Override
    public List<DicValue> queryDicValueByTypeCode(String typeCode) {
        return dicValueMapper.selectDicValueByTypeCode(typeCode);
    }

    @Override
    public List<DicValue> queryAllDicValue() {
        return dicValueMapper.selectAllDicValue();
    }

    @Override
    public DicValue queryDicValueById(String id) {
        return dicValueMapper.selectDicValueById(id);
    }

    @Override
    public int addDicValue(DicValue dicValue) {
        return dicValueMapper.insertDicValue(dicValue);
    }

    @Override
    public int updateDicValue(DicValue dicValue) {
        return dicValueMapper.updateDicValueById(dicValue);
    }

    @Override
    public int deleteDicValue(String[] ids) {
        return dicValueMapper.deleteDicValueByIds(ids);
    }
}
