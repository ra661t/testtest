package com.example.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.DBDao;
import com.example.dto.Dept;

@Service("myService")   //주의 
public class DBOracleService implements DBService {  //alt+shift+t로 인터페이스 생성
	@Autowired
	DBDao dao;
	
	@Autowired
	SqlSessionTemplate  session;
	
	@Override
	public List<Dept>list(){
		return dao.list(session);
	}
	@Override
	public int insert(Dept dto){
		
		return dao.insert(session, dto);
	}

	@Override
	public int update(Dept dto){
		return dao.update(session, dto);
	}
	@Override
	public int deleteByDeptno(int deptno) {
		// TODO Auto-generated method stub
		return dao.deleteByDeptno(session, deptno);
	}
	public Dept selectByDeptno(int deptno) {
		// TODO Auto-generated method stub
		return dao.selectByDeptno(session, deptno);
	}
	
	

	

}
