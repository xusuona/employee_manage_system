package cn.xusuona.mapper;

import cn.xusuona.pojo.Department;
import cn.xusuona.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    /**
     * 新增部门
     * @param department
     */
     void insertOne(@Param("department") Department department);

    /**
     * 根据Id查找部门
     * @param depId
     * @return
     */
     Department selectOneById(@Param("depId") int depId);

    /**
     * 根据部门名字查找部门
     * @param depName
     * @return
     */
     Department slectOnByName(@Param("depName") String depName);

    /**
     * 删除部门
     * @param depId
     */
    void deleteOneById(@Param("depId") int depId);

    /**
     * 更新部门
     * @param department
     */
    void updateOne(@Param("department") Department department);

    /**
     * 返回第几页的部门，几页的范围由limit和offset确认
     * @param limit
     * @param offset
     * @return
     */
     List<Department> selectDepByLimitAndOffset(@Param("limit") int limit, @Param("offset") int offset);

    /**
     * 查看该部门存在的所有员工
     * @param depName
     * @return
     */
     List<Employee> selectEmpInSelectedDep(@Param("depName") String depName);
}
