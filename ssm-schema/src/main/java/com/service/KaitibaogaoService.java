package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KaitibaogaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KaitibaogaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KaitibaogaoView;


/**
 * 开题报告
 *
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
public interface KaitibaogaoService extends IService<KaitibaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaitibaogaoVO> selectListVO(Wrapper<KaitibaogaoEntity> wrapper);
   	
   	KaitibaogaoVO selectVO(@Param("ew") Wrapper<KaitibaogaoEntity> wrapper);
   	
   	List<KaitibaogaoView> selectListView(Wrapper<KaitibaogaoEntity> wrapper);
   	
   	KaitibaogaoView selectView(@Param("ew") Wrapper<KaitibaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaitibaogaoEntity> wrapper);
   	
}

