package com.neusoftwjj.crm.workbench.transaction.mapper;


import com.neusoftwjj.crm.workbench.transaction.model.Tran;
import com.neusoftwjj.crm.workbench.vo.FunnelVo;

import java.util.List;
import java.util.Map;

public interface TranMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Sat Sep 17 17:03:24 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Sat Sep 17 17:03:24 CST 2022
     */
    int insert(Tran record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Sat Sep 17 17:03:24 CST 2022
     */
    int insertSelective(Tran record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Sat Sep 17 17:03:24 CST 2022
     */
    Tran selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Sat Sep 17 17:03:24 CST 2022
     */
    int updateByPrimaryKeySelective(Tran record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Sat Sep 17 17:03:24 CST 2022
     */
    int updateByPrimaryKey(Tran record);
    /**
     *保存创建的交易
     */
    int insertTran(Tran tran);
    /**
     * 根据id查询交易明细信息
     */
    Tran selectTranForDetailById(String id);
    /**
     * 查询交易表中各个阶段的数据量
     */
    List<FunnelVo> selectCountOfTranGroupByStage();
    /**
     *查询交易信息
     */
    List<Tran> selectTranByConditionForPage(Map<String ,Object> map);
    /**
     * 总条数
     */
    int selectCountOfTranByCondition(Map<String, Object> map);
}