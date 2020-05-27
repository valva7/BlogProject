package com.project.song.home.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.song.home.serviceImpl.serviceImp;

@Service
public class service implements serviceImp {

	@Autowired
	SqlSession sqlSession;
	
	public service() {
	}
	
	@Override
	public String oneTest() {
		return sqlSession.selectOne("menuMapper.getUser");
	}
	
	@Override
	public Map<String, String> loginCheck(Map<String, String> param) {
		return sqlSession.selectOne("userMapper.loginCheck", param);	
	}
	
//	@Override
//	public List loginCheck(Map<String, String> param) {
//		return sqlSession.selectList("userMapper.loginCheck", param);	
//	}
	
	@Override
	public String getMenuList() {
		return sqlSession.selectOne("menuMapper.getMenuList");
	}
}
