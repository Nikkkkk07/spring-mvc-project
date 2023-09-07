package com.example.WebservicesEmployee;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVCController {
	@Autowired
	RestTemplate rt;
	final String url="http://localhost:8080/api/v1/employees";
	

	@RequestMapping("/home")
	public ModelAndView processHome()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping("/showAll")
	public ModelAndView processFetchAll()
	{
		List<Employee> obj=Arrays.asList(rt.getForObject(url, Employee[].class));
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList", obj);
		mv.setViewName("employeeDetails");
		return mv;
	}
	@RequestMapping("/trial")
	public ModelAndView processTrial()
	{
		Employee t1=new Employee();
		t1.setEmployeeId(101);
		t1.setEmployeeName("Ronit");
		
		Employee t2=new Employee();
		t2.setEmployeeId(102);
		t2.setEmployeeName("Rohit");
	
			List<Employee> obj=Arrays.asList(t1,t2);
		ModelAndView mv=new ModelAndView();
		mv.addObject("list1", obj);
		mv.setViewName("temp");
		return mv;
}
	
	@PostMapping("/insertEmployee")
	public ModelAndView processInsertEmployee(@ModelAttribute Employee t)
	{
		System.out.println("Insert a Employee");
//		System.out.println(t.toString());
		System.out.println(t);
		Employee obj=rt.postForObject(url,t, Employee.class);
		
//		System.out.println(obj.toString());
		//t.setId(obj.getId());
		ModelAndView mv=new ModelAndView();
		mv.addObject("employee", obj);
		mv.setViewName("Sucess");
		return mv;
	}
	@GetMapping("/deleteById")
	public ModelAndView processDeleteEmployee(@RequestParam("id") int id)
	{
		System.out.println("Delete a Employee");
//		System.out.println(t.toString());
		rt.delete(url+"/"+id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
	
}


