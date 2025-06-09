package com.entity.view;

import com.entity.XueshengtitiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学生提题
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-11-02 10:24:02
 */
@TableName("xueshengtiti")
public class XueshengtitiView  extends XueshengtitiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueshengtitiView(){
	}
 
 	public XueshengtitiView(XueshengtitiEntity xueshengtitiEntity){
 	try {
			BeanUtils.copyProperties(this, xueshengtitiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
