package com.neusoftwjj.crm.workbench.clue.service;

import com.neusoftwjj.crm.workbench.clue.model.ClueRemark;

import java.util.List;

public interface ClueRemarkService {
    List<ClueRemark> queryClueRemarkForDetailByClueId(String clueId);
    int saveClueRemark(ClueRemark clueRemark);
    int deleteClueRemark(String id);
    int saveEditClueRemark(ClueRemark clueRemark);
}
