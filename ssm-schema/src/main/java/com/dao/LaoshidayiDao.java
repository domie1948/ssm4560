package com.dao;

import com.entity.LaoshidayiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LaoshidayiVO;
import com.entity.view.LaoshidayiView;


/**
 * 老师答疑
 * 
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
public interface LaoshidayiDao extends BaseMapper<LaoshidayiEntity> {
	
	List<LaoshidayiVO> selectListVO(@Param("ew") Wrapper<LaoshidayiEntity> wrapper);
	
	LaoshidayiVO selectVO(@Param("ew") Wrapper<LaoshidayiEntity> wrapper);
	
	List<LaoshidayiView> selectListView(@Param("ew") Wrapper<LaoshidayiEntity> wrapper);

	List<LaoshidayiView> selectListView(Pagination page,@Param("ew") Wrapper<LaoshidayiEntity> wrapper);
	
	LaoshidayiView selectView(@Param("ew") Wrapper<LaoshidayiEntity> wrapper);
	
}
