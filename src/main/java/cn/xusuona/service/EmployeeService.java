package cn.xusuona.service;

import cn.xusuona.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * 获取员工数量
     * @return
     */
    int getEmpCount();

    /**
     * 通过分页查询批量获取员工信息
     * @param offset 偏移量
     * @param limit 最大数量
     * @return
     */
    List<Employee> getEmptByLimitAndOffset(int offset, int limit);

    /**
     * 通过id查询带有部门信息的员工
     * @param empId 员工id
     * @return
     */
    Employee getEmptWithDeptById(int empId);

    /**
     * 通过名字查询员工
     * @param empName
     * @return
     */
    List<Employee> getEmpByName(String empName);

    /**
     * 通过id号查询员工
     * @param empId
     * @return
     */
    Employee getEmpById(int empId);

    /**
     * 更新员工信息
     * @param employee
     */
    void updateEmp(Employee employee);

    /**
     * 通过id删除员工
     * @param empId
     */
    void deleteEmpById(int empId);
}
