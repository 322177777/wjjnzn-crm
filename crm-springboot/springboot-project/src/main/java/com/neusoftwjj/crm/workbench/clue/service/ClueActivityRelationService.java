package com.neusoftwjj.crm.workbench.clue.service;

import com.neusoftwjj.crm.workbench.clue.model.ClueActivityRelation;

import java.util.List;

public interface ClueActivityRelationService {
    int saveCreateClueActivityRelationByList(List<ClueActivityRelation> relationList) ;

    int deleteClueActivityRelationByClueIdActivityId(ClueActivityRelation relation);
}
