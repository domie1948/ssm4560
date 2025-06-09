package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LunwenjinduEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LunwenjinduVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LunwenjinduView;


/**
 * 论文进度
 *
 * @author 
 * @email 
 * @date 2020-11-02 10:24:02
 */
public interface LunwenjinduService extends IService<LunwenjinduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LunwenjinduVO> selectListVO(Wrapper<LunwenjinduEntity> wrapper);
   	
   	LunwenjinduVO selectVO(@Param("ew") Wrapper<LunwenjinduEntity> wrapper);
   	
   	List<LunwenjinduView> selectListView(Wrapper<LunwenjinduEntity> wrapper);
   	
   	LunwenjinduView selectView(@Param("ew") Wrapper<LunwenjinduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LunwenjinduEntity> wrapper);
   	
}

