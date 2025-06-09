package com.entity.view;

import com.entity.LunwenchazhongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 论文查重
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-11-02 10:24:02
 */
@TableName("lunwenchazhong")
public class LunwenchazhongView  extends LunwenchazhongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LunwenchazhongView(){
	}
 
 	public LunwenchazhongView(LunwenchazhongEntity lunwenchazhongEntity){
 	try {
			BeanUtils.copyProperties(this, lunwenchazhongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
