package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaoshidayiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LaoshidayiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LaoshidayiView;


/**
 * 老师答疑
 *
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
public interface LaoshidayiService extends IService<LaoshidayiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaoshidayiVO> selectListVO(Wrapper<LaoshidayiEntity> wrapper);
   	
   	LaoshidayiVO selectVO(@Param("ew") Wrapper<LaoshidayiEntity> wrapper);
   	
   	List<LaoshidayiView> selectListView(Wrapper<LaoshidayiEntity> wrapper);
   	
   	LaoshidayiView selectView(@Param("ew") Wrapper<LaoshidayiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaoshidayiEntity> wrapper);
   	
}

