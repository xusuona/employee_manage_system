package cn.xusuona.mapper;

import cn.xusuona.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 通过ID删除员工
     * @param empId
     */
    void deleteOneById(@Param("empId") int empId);

    /**
     * 更新员工
     * @param employee
     */
    void updateOne(@Param("employee") Employee employee);

    /**
     * 通过ID查找员工
     * @param empId
     * @return Employee
     */
    Employee selectOneById(@Param("empId") int empId);

    /**
     * 通过名字查找员工
     * @param empName
     * @return Employee
     */
    Employee selectOneByName(@Param("empName") String empName);

    /**
     * 通过Id查找带有部门信息的员工
     * @param empId
     * @return
     */
    List<Employee> selectEmptWithDeptById(@Param("empId") int empId);

    /**
     * 通过分页限制返回员工列表
     * @param limit
     * @param offset
     * @return
     */
    List<Employee> selectEmptByLimitAndOffset(@Param("limit") int limit, @Param("offset") int offset);


}
