package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhongqibaogaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhongqibaogaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhongqibaogaoView;


/**
 * 中期报告
 *
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
public interface ZhongqibaogaoService extends IService<ZhongqibaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhongqibaogaoVO> selectListVO(Wrapper<ZhongqibaogaoEntity> wrapper);
   	
   	ZhongqibaogaoVO selectVO(@Param("ew") Wrapper<ZhongqibaogaoEntity> wrapper);
   	
   	List<ZhongqibaogaoView> selectListView(Wrapper<ZhongqibaogaoEntity> wrapper);
   	
   	ZhongqibaogaoView selectView(@Param("ew") Wrapper<ZhongqibaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhongqibaogaoEntity> wrapper);
   	
}

