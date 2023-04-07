package com.neusoftwjj.crm.workbench.clue.mapper;

import com.neusoftwjj.crm.workbench.clue.model.Clue;

import java.util.List;
import java.util.Map;

public interface ClueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Sat Sep 10 15:42:06 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Sat Sep 10 15:42:06 CST 2022
     */
    int insert(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Sat Sep 10 15:42:06 CST 2022
     */
    int insertSelective(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Sat Sep 10 15:42:06 CST 2022
     */
    Clue selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Sat Sep 10 15:42:06 CST 2022
     */
    int updateByPrimaryKeySelective(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbggenerated Sat Sep 10 15:42:06 CST 2022
     */
    int updateByPrimaryKey(Clue record);
    /**
    *保存创建的线索
     */
    int insertClue(Clue clue);

    /**
     * 根据Id查询线索信息
     * @param id
     * @return
     */
    Clue selectClueForDetailById(String id);
    /**
     *根据id查询线索的信息
     */
    Clue selectClueForConvertById(String id);
    /**
     * 根据id删除线索
     */
    int deleteClueById(String id);
    /**
     * 根据条件分页查询线索的列表
     */
    List<Clue> selectClueByConditionForPage(Map<String, Object> map);

    /**
     * 根据条件分页查询线索的总条数
     */
    int selectCountOfClueByCondition(Map<String, Object> map);
    /**
     * 批量删除
     */
    int deleteClueByIds(String[] ids);
}