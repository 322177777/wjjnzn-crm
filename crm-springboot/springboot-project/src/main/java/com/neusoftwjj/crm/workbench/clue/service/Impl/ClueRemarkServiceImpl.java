package com.neusoftwjj.crm.workbench.clue.service.Impl;


import com.neusoftwjj.crm.workbench.clue.mapper.ClueRemarkMapper;
import com.neusoftwjj.crm.workbench.clue.model.ClueRemark;
import com.neusoftwjj.crm.workbench.clue.service.ClueRemarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("clueRemarkService")
public class ClueRemarkServiceImpl implements ClueRemarkService {
    @Resource
    private ClueRemarkMapper clueRemarkMapper;
    @Override
    public List<ClueRemark> queryClueRemarkForDetailByClueId(String clueId) {
        return clueRemarkMapper.selectClueRemarkForDetailByClueId(clueId);
    }

    @Override
    public int saveClueRemark(ClueRemark clueRemark) {
        return clueRemarkMapper.insertClueRemark(clueRemark);
    }

    @Override
    public int deleteClueRemark(String id) {
        return clueRemarkMapper.deleteClueRemarkById(id);
    }

    @Override
    public int saveEditClueRemark(ClueRemark clueRemark) {
        return clueRemarkMapper.updateClueRemark(clueRemark);
    }
}
