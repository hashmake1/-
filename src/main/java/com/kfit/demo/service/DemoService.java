package com.kfit.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfit.demo.bean.Demo;
import com.kfit.demo.mapper.DemoMapper;

@Service
public class DemoService {

	@Autowired
	private DemoMapper demoMapper;
	
	/**
	 * 需要开启事务.使用注解的方式.
	 * @param demo
	 * @return
	 */
	@Transactional
	public int save(Demo demo){
		return demoMapper.save(demo);
	}
	
	@Transactional
	public int update(Demo demo){
		return demoMapper.update(demo);
	}
	
	@Transactional
	public int delete(int id){
		return demoMapper.delete(id);
	}

	public Demo selectById(int id){
		return demoMapper.selectById(id);
	}
	
	
}
