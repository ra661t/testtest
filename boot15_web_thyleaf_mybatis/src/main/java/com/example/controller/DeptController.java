package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.Dept;
import com.example.service.DBService;

@Controller
public class DeptController {
	@Autowired
	DBService service;	
	
	@RequestMapping("/list")
	@CrossOrigin////////////////////////////
	public String getDeptList(Model m) {
		
		List<Dept> allData = service.list();
		m.addAttribute("allData", allData);	
		System.out.println("list================="+ allData);
		return "list"; //list.html
	}
	@RequestMapping("/insertForm")
	@CrossOrigin////////////////////////////
	public String aaa() {
		return "addForm"; //addForm.html
	}
	
	@RequestMapping("/insert")
	@CrossOrigin////////////////////////////
	public String insert(Dept dept) {
		System.out.println("insert>>" + dept);
		service.insert(dept);
		return "redirect:list";
	}
	@RequestMapping("/deptUpdateForm")
	@CrossOrigin////////////////////////////
	public ModelAndView updateForm(@RequestParam int deptno) {
		System.out.println("deptUpdateForm>>" + deptno);
		Dept dept= service.selectByDeptno(deptno);
		ModelAndView mav= new ModelAndView();
		mav.addObject("dept", dept);
		mav.setViewName("update");//update.html		
		return mav;
	}
	@RequestMapping("/update")
	@CrossOrigin////////////////////////////
	public String update(Dept dto) {
		System.out.println("deptUpdate>>" + dto);
		int n = service.update(dto);		
		return "redirect:list";
	}
	@RequestMapping("/deptDelete")
	@CrossOrigin////////////////////////////
	public String delete(@RequestParam int deptno) {
		System.out.println("deptDelete>>>>"+ deptno);
		int n = service.deleteByDeptno(deptno);	
		return "redirect:list";
	}
	@RequestMapping("/deptRetrive")
	@CrossOrigin////////////////////////////
	public String retrive(@RequestParam int deptno, Model m) {
		System.out.println("deptRetrive>>>>"+ deptno);
		Dept dept = service.selectByDeptno(deptno);	
		m.addAttribute("dept", dept);
		return "retrive";
	}
	
	
	
}
