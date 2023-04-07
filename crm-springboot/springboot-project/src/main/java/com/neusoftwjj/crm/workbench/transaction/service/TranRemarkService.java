package com.neusoftwjj.crm.workbench.transaction.service;


import com.neusoftwjj.crm.workbench.transaction.model.TranRemark;

import java.util.List;

public interface TranRemarkService {
    List<TranRemark> queryTranRemarkForDetailByTranId(String tranId);
}
