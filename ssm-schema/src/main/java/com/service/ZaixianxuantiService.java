package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaixianxuantiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaixianxuantiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaixianxuantiView;


/**
 * 在线选题
 *
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
public interface ZaixianxuantiService extends IService<ZaixianxuantiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianxuantiVO> selectListVO(Wrapper<ZaixianxuantiEntity> wrapper);
   	
   	ZaixianxuantiVO selectVO(@Param("ew") Wrapper<ZaixianxuantiEntity> wrapper);
   	
   	List<ZaixianxuantiView> selectListView(Wrapper<ZaixianxuantiEntity> wrapper);
   	
   	ZaixianxuantiView selectView(@Param("ew") Wrapper<ZaixianxuantiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianxuantiEntity> wrapper);
   	
}

