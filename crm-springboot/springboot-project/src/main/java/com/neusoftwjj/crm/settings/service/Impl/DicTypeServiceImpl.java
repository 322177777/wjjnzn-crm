package com.neusoftwjj.crm.settings.service.Impl;

import com.neusoftwjj.crm.settings.mapper.DicTypeMapper;
import com.neusoftwjj.crm.settings.model.DicType;
import com.neusoftwjj.crm.settings.service.DicTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("dicTypeService")
public class DicTypeServiceImpl implements DicTypeService {
    @Resource
    private DicTypeMapper dicTypeMapper;

    @Override
    public List<DicType> queryAllDicType() {
        return dicTypeMapper.selectAllDicType();
    }

    @Override
    public int addDicType(DicType dicType) {
        return dicTypeMapper.insertDicType(dicType);
    }

    @Override
    public DicType queryDicTypeByCode(String code) {
        return dicTypeMapper.selectDicTypeByCode(code);
    }

    @Override
    public int editDicTypeByCode(DicType dicType) {
        return dicTypeMapper.updateDicTypeByCode(dicType);
    }

    @Override
    public int deleteDicType(String[] codes) {
        return dicTypeMapper.deleteDicType(codes);
    }
}
