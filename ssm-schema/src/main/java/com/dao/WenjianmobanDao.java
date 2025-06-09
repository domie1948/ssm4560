package com.dao;

import com.entity.WenjianmobanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WenjianmobanVO;
import com.entity.view.WenjianmobanView;


/**
 * 文件模板
 * 
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
public interface WenjianmobanDao extends BaseMapper<WenjianmobanEntity> {
	
	List<WenjianmobanVO> selectListVO(@Param("ew") Wrapper<WenjianmobanEntity> wrapper);
	
	WenjianmobanVO selectVO(@Param("ew") Wrapper<WenjianmobanEntity> wrapper);
	
	List<WenjianmobanView> selectListView(@Param("ew") Wrapper<WenjianmobanEntity> wrapper);

	List<WenjianmobanView> selectListView(Pagination page,@Param("ew") Wrapper<WenjianmobanEntity> wrapper);
	
	WenjianmobanView selectView(@Param("ew") Wrapper<WenjianmobanEntity> wrapper);
	
}
