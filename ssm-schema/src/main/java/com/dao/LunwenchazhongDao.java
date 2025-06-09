package com.dao;

import com.entity.LunwenchazhongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LunwenchazhongVO;
import com.entity.view.LunwenchazhongView;


/**
 * 论文查重
 * 
 * @author 
 * @email 
 * @date 2020-11-02 10:24:02
 */
public interface LunwenchazhongDao extends BaseMapper<LunwenchazhongEntity> {
	
	List<LunwenchazhongVO> selectListVO(@Param("ew") Wrapper<LunwenchazhongEntity> wrapper);
	
	LunwenchazhongVO selectVO(@Param("ew") Wrapper<LunwenchazhongEntity> wrapper);
	
	List<LunwenchazhongView> selectListView(@Param("ew") Wrapper<LunwenchazhongEntity> wrapper);

	List<LunwenchazhongView> selectListView(Pagination page,@Param("ew") Wrapper<LunwenchazhongEntity> wrapper);
	
	LunwenchazhongView selectView(@Param("ew") Wrapper<LunwenchazhongEntity> wrapper);
	
}
