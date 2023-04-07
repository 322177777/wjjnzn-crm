package com.neusoftwjj.crm.workbench.transaction.service.Impl;


import com.neusoftwjj.crm.workbench.transaction.mapper.TranHistoryMapper;
import com.neusoftwjj.crm.workbench.transaction.model.TranHistory;
import com.neusoftwjj.crm.workbench.transaction.service.TranHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tranHistoryService")
public class TranHistoryServiceImpl implements TranHistoryService {
    @Resource
    private TranHistoryMapper tranHistoryMapper;

    @Override
    public List<TranHistory> queryTranHistoryForDetailByTranId(String tranId) {
        return tranHistoryMapper.selectTranHistoryForDetailByTranId(tranId);
    }
}
