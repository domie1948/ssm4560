package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WenjianmobanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WenjianmobanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WenjianmobanView;


/**
 * 文件模板
 *
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
public interface WenjianmobanService extends IService<WenjianmobanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenjianmobanVO> selectListVO(Wrapper<WenjianmobanEntity> wrapper);
   	
   	WenjianmobanVO selectVO(@Param("ew") Wrapper<WenjianmobanEntity> wrapper);
   	
   	List<WenjianmobanView> selectListView(Wrapper<WenjianmobanEntity> wrapper);
   	
   	WenjianmobanView selectView(@Param("ew") Wrapper<WenjianmobanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenjianmobanEntity> wrapper);
   	
}

