package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LunwenchazhongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LunwenchazhongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LunwenchazhongView;


/**
 * 论文查重
 *
 * @author 
 * @email 
 * @date 2020-11-02 10:24:02
 */
public interface LunwenchazhongService extends IService<LunwenchazhongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LunwenchazhongVO> selectListVO(Wrapper<LunwenchazhongEntity> wrapper);
   	
   	LunwenchazhongVO selectVO(@Param("ew") Wrapper<LunwenchazhongEntity> wrapper);
   	
   	List<LunwenchazhongView> selectListView(Wrapper<LunwenchazhongEntity> wrapper);
   	
   	LunwenchazhongView selectView(@Param("ew") Wrapper<LunwenchazhongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LunwenchazhongEntity> wrapper);
   	
}

