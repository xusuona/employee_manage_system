import cn.xusuona.mapper.DepartmentMapper;
import cn.xusuona.mapper.EmployeeMapper;
import cn.xusuona.pojo.Department;
import cn.xusuona.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:dispatcher-servlet.xml"})
public class DepartmentMapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    Department department;

    @Test
    public void testInsertOne()
    {
        department.setDepLeader("高晓松");
        department.setDepName("售后部");
        departmentMapper.insertOne(department);
    }

    @Test
    public void testSelectEmpInSelectedDep()
    {
        List<Employee> employeeList = departmentMapper.selectEmpInSelectedDep("研发部");
        for(Employee emp : employeeList)
        {
            System.out.println(emp);
        }
    }
}
