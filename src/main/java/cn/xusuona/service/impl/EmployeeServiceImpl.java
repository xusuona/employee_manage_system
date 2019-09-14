package cn.xusuona.service.impl;

import cn.xusuona.mapper.EmployeeMapper;
import cn.xusuona.pojo.Employee;
import cn.xusuona.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:dispatcher-servlet.xml"})
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public int getEmpCount() {
        return employeeMapper.countEmpNum();
    }

    public List<Employee> getEmptByLimitAndOffset(int offset, int limit) {
        return employeeMapper.selectEmptByLimitAndOffset(offset, limit);
    }

    public Employee getEmptWithDeptById(int empId) {
        return employeeMapper.selectEmptWithDeptById(empId);
    }

    public List<Employee> getEmpByName(String empName) {
        return employeeMapper.selectOneByName(empName);
    }

    public Employee getEmpById(int empId) {
        return employeeMapper.selectOneById(empId);
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateOne(employee);
    }

    public void deleteEmpById(int empId) {
        employeeMapper.deleteOneById(empId);
    }
}
