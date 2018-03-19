package com.kfit.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.kfit.demo.bean.Demo;



/**
 * 解决no found问题：
 * ------------------------
 * 1、使用@Mapper注解. --- 未来是需要每一个Mapper接口类都需要添加。
 * 2、使用统一的方式，统一注入，使用@MapperScan，是在App.java类进行配置。
 * 
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年8月16日
 */
///@Mapper : 已经使用@MapperScan进行包路径的指定.
public interface DemoMapper {
	
	/**
	 * 这里的话，
	 * 1、使用 @Insert声明一条添加数据的SQL语句;
	 * 2、使用 #{}进行变量的绑定。
	 * @param demo
	 * @return
	 */
	@Insert("insert into demo(name) values(#{name})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	public int save(Demo demo);
	
	/**
	 * 修改语句.
	 * @param demo
	 * @return
	 */
	@Update("update demo set name=#{name} where id=#{id}")
	public int update(Demo demo);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@Delete("delete from demo where id=#{id}")
	public int delete(int id);
	
	
	
	@Select("select *from demo where id=#{id}")
	public Demo selectById(int id);

}
