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
     * 插入新员工
     * @param employee
     */
    void insertOne(@Param("employee") Employee employee);

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
    List<Employee> selectOneByName(@Param("empName") String empName);

    /**
     * 通过Id查找带有部门信息的员工
     * @param empId
     * @return
     */
    Employee selectEmptWithDeptById(@Param("empId") int empId);

    /**
     * 通过分页限制返回员工列表
     * @param limit 记录行的最大数目
     * @param offset 记录行的偏移量
     * 例：select * from table limit 5,10; 则返回记录行6-15
     * @return
     */
    List<Employee> selectEmptByLimitAndOffset(@Param("limit") int limit, @Param("offset") int offset);

    int countEmpNum();
}
