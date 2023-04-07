package com.neusoftwjj.crm.workbench.clue.service.Impl;


import com.neusoftwjj.crm.workbench.clue.mapper.ClueActivityRelationMapper;
import com.neusoftwjj.crm.workbench.clue.model.ClueActivityRelation;
import com.neusoftwjj.crm.workbench.clue.service.ClueActivityRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("clueActivityRelationService")
public class ClueActivityRelationServiceImpl implements ClueActivityRelationService {
    @Resource
    private ClueActivityRelationMapper clueActivityRelationMapper;
    @Override
    public int saveCreateClueActivityRelationByList(List<ClueActivityRelation> relationList) {
        return clueActivityRelationMapper.insertClueActivityRelationByList(relationList);
    }

    @Override
    public int deleteClueActivityRelationByClueIdActivityId(ClueActivityRelation relation) {
        return clueActivityRelationMapper.deleteClueActivityRelationByClueActivityId(relation);
    }
}
