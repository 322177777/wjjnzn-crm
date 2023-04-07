package com.neusoftwjj.crm.workbench.transaction.service.Impl;


import com.neusoftwjj.crm.workbench.transaction.mapper.TranRemarkMapper;
import com.neusoftwjj.crm.workbench.transaction.model.TranRemark;
import com.neusoftwjj.crm.workbench.transaction.service.TranRemarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tranRemarkService")
public class TranRemarkServiceImpl implements TranRemarkService {
    @Resource
    private TranRemarkMapper tranRemarkMapper;

    @Override
    public List<TranRemark> queryTranRemarkForDetailByTranId(String tranId) {
        return tranRemarkMapper.selectTranRemarkForDetailByTranId(tranId);
    }
}
