package com.neusoftwjj.crm.workbench.activity.service;

import com.neusoftwjj.crm.workbench.activity.model.ActivityRemark;

import java.util.List;

public interface ActivityRemarkService {
    List<ActivityRemark> queryActivityRemarkForDetailByActivityId(String activityId);
    int saveCreateActivityRemark(ActivityRemark remark);
    int deleteActivityRemarkById(String id);
    int saveEditActivityRemark(ActivityRemark remark);
}
