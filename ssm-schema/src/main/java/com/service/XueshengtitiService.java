package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshengtitiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshengtitiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengtitiView;


/**
 * 学生提题
 *
 * @author 
 * @email 
 * @date 2020-11-02 10:24:02
 */
public interface XueshengtitiService extends IService<XueshengtitiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengtitiVO> selectListVO(Wrapper<XueshengtitiEntity> wrapper);
   	
   	XueshengtitiVO selectVO(@Param("ew") Wrapper<XueshengtitiEntity> wrapper);
   	
   	List<XueshengtitiView> selectListView(Wrapper<XueshengtitiEntity> wrapper);
   	
   	XueshengtitiView selectView(@Param("ew") Wrapper<XueshengtitiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengtitiEntity> wrapper);
   	
}

