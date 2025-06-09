package com.dao;

import com.entity.LunwenjinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LunwenjinduVO;
import com.entity.view.LunwenjinduView;


/**
 * 论文进度
 * 
 * @author 
 * @email 
 * @date 2020-11-02 10:24:02
 */
public interface LunwenjinduDao extends BaseMapper<LunwenjinduEntity> {
	
	List<LunwenjinduVO> selectListVO(@Param("ew") Wrapper<LunwenjinduEntity> wrapper);
	
	LunwenjinduVO selectVO(@Param("ew") Wrapper<LunwenjinduEntity> wrapper);
	
	List<LunwenjinduView> selectListView(@Param("ew") Wrapper<LunwenjinduEntity> wrapper);

	List<LunwenjinduView> selectListView(Pagination page,@Param("ew") Wrapper<LunwenjinduEntity> wrapper);
	
	LunwenjinduView selectView(@Param("ew") Wrapper<LunwenjinduEntity> wrapper);
	
}
