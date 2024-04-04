package com.example.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.example.dto.Dept;

public interface DBDao {

	List<Dept> list(SqlSessionTemplate session);

	int insert(SqlSessionTemplate session, Dept dto);

	int deleteByDeptno(SqlSessionTemplate session, int deptno);

	int update(SqlSessionTemplate session, Dept dto);

	Dept selectByDeptno(SqlSessionTemplate session, int deptno);

}