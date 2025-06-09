package com.entity.view;

import com.entity.LaoshidayiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 老师答疑
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
@TableName("laoshidayi")
public class LaoshidayiView  extends LaoshidayiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LaoshidayiView(){
	}
 
 	public LaoshidayiView(LaoshidayiEntity laoshidayiEntity){
 	try {
			BeanUtils.copyProperties(this, laoshidayiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
