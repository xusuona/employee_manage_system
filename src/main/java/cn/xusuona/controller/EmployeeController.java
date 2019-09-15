package cn.xusuona.controller;

import cn.xusuona.pojo.Employee;
import cn.xusuona.service.impl.EmployeeServiceImpl;
import cn.xusuona.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/hrms/emp")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;


    @RequestMapping(value = "/deleteEmp/{empId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deleteEmp(@PathVariable("empId") int empId)
    {
        try {
            if(empId > 0)
            {
                employeeService.deleteEmpById(empId);
            }
            return JsonMsg.success();
        }
        catch (Exception e)
        {
            return JsonMsg.fail().addInfo("emp_del_error", "员工删除失败");
        }
    }

    @RequestMapping(value = "/updateEmp", method = RequestMethod.PUT)
    @ResponseBody
    public JsonMsg updateEmp(Employee employee)
    {
        try {
            employeeService.updateEmp(employee);
            return JsonMsg.success();
        }catch (Exception e)
        {
            return JsonMsg.fail().addInfo("emp_update_error", "员工更新失败");
        }

    }

    @RequestMapping(value = "/getEmpList", method = RequestMethod.GET)
    public ModelAndView getEmp(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo)
    {
        ModelAndView mv = new ModelAndView();
        int limit = 5;
        int offset = (pageNo-1) * limit;
        List<Employee> employeeList = employeeService.getEmptByLimitAndOffset(offset, limit);
        System.out.println("检测是否有输出");
        for(Employee emp : employeeList)
        {
            System.out.println(emp);
        }
        int totalItems = employeeService.getEmpCount();
        int temp = totalItems / limit;
        int totalPage = (totalItems % limit == 0) ? temp : temp+1;
        int curPage = pageNo;
        mv.addObject("employees", employeeList)
                .addObject("totalItems",totalItems)
                .addObject("totalPage",totalPage)
                .addObject("curPage",curPage);
        mv.setViewName("employeePage");
        return mv;
    }

}
