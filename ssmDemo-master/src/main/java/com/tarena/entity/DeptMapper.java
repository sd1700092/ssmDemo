package com.tarena.entity;

import java.util.List;
import java.util.Map;

/**
 * Mapper接口，类似于Dao，但是语法有限定
 * 不能有重载
 * Mapper定义实体对象Dept的CRUD操作
 * Created by SkyOne on 2016/10/8.
 */
public interface DeptMapper {
    void addDept(Dept dept);
    void deleteDept(Dept dept);
    void updateDept(Dept dept);
    Dept findDeptById(Integer deptno);
    List<Dept> findAllDept();
    List<Dept> findDeptByLoc(String loc);
    List<Map<String, Object>> findAllDname(String loc);
}
