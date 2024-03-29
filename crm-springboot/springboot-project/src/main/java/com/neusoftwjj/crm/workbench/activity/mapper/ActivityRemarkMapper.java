package com.neusoftwjj.crm.workbench.activity.mapper;


import com.neusoftwjj.crm.workbench.activity.model.ActivityRemark;

import java.util.List;

public interface ActivityRemarkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 08 20:54:21 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 08 20:54:21 CST 2022
     */
    int insert(ActivityRemark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 08 20:54:21 CST 2022
     */
    int insertSelective(ActivityRemark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 08 20:54:21 CST 2022
     */
    ActivityRemark selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 08 20:54:21 CST 2022
     */
    int updateByPrimaryKeySelective(ActivityRemark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 08 20:54:21 CST 2022
     */
    int updateByPrimaryKey(ActivityRemark record);
    /**
     * 根据activityId查询市场活动备注下的所有明细信息
     *
     */
    List<ActivityRemark> selectActivityRemarkForDetailByActivityId(String activityId);
    /**
     * 添加市场活动备注
     */
    int insertActivityRemark(ActivityRemark remark);
    /**
     * 根据id删除市场活动备注
     */
    int deleteActivityRemarkById(String id);
    /**
     * 修改市场活动备注
     */
    int updateActivityRemark(ActivityRemark remark);
}