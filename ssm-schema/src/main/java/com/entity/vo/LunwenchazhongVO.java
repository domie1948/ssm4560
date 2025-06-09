package com.entity.vo;

import com.entity.LunwenchazhongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 论文查重
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2020-11-02 10:24:02
 */
public class LunwenchazhongVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 网址
	 */
	
	private String wangzhi;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：网址
	 */
	 
	public void setWangzhi(String wangzhi) {
		this.wangzhi = wangzhi;
	}
	
	/**
	 * 获取：网址
	 */
	public String getWangzhi() {
		return wangzhi;
	}
			
}
