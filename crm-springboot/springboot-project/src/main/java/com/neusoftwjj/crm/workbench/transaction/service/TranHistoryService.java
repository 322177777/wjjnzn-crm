package com.neusoftwjj.crm.workbench.transaction.service;


import com.neusoftwjj.crm.workbench.transaction.model.TranHistory;

import java.util.List;

public interface TranHistoryService {
    List<TranHistory> queryTranHistoryForDetailByTranId(String tranId);
}
