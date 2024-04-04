package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.Dept;


public interface DBService {

	List<Dept> list();

	int insert(Dept dto);

	int deleteByDeptno(int deptno);

	int update(Dept dto);

	Dept selectByDeptno(int deptno);



}