import cn.xusuona.mapper.EmployeeMapper;
import cn.xusuona.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:dispatcher-servlet.xml"})
public class EmployeeMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    Employee employee;

    @Test
    public void testGetEmpCount()
    {
        System.out.println("员工总人数为：" + employeeMapper.countEmpNum());
    }

    @Test
    public void testSelectOneById()
    {
        System.out.println(employeeMapper.selectOneById(1));
    }

    @Test
    public void testInsertOne()
    {
        employee.setDepartmentId(1);
        employee.setEmpName("爱新觉罗");
        employee.setEmpEmail("huangtaiji@163.com");
        employee.setEmpGender('男');

        employeeMapper.insertOne(employee);
        System.out.println("插入成功");
    }

    @Test
    public void testDeleteOneById()
    {
        employeeMapper.deleteOneById(3);
        System.out.println("删除成功");
    }

    @Test
    public void testSelectEmptByLimitAndOffset()
    {
        List<Employee> employeeList = employeeMapper.selectEmptByLimitAndOffset(1,0);
        System.out.println(employeeList.size());
        for(Employee emp : employeeList)
        {
            System.out.println(emp);
        }
    }

    @Test
    public void testSelectEmptWithDeptById()
    {
        System.out.println(employeeMapper.selectEmptWithDeptById(1));
    }

}
