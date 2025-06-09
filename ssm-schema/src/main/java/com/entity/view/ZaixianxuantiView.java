package com.entity.view;

import com.entity.ZaixianxuantiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 在线选题
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
@TableName("zaixianxuanti")
public class ZaixianxuantiView  extends ZaixianxuantiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZaixianxuantiView(){
	}
 
 	public ZaixianxuantiView(ZaixianxuantiEntity zaixianxuantiEntity){
 	try {
			BeanUtils.copyProperties(this, zaixianxuantiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
