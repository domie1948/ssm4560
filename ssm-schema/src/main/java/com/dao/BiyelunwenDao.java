package com.dao;

import com.entity.BiyelunwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BiyelunwenVO;
import com.entity.view.BiyelunwenView;


/**
 * 毕业论文
 * 
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
public interface BiyelunwenDao extends BaseMapper<BiyelunwenEntity> {
	
	List<BiyelunwenVO> selectListVO(@Param("ew") Wrapper<BiyelunwenEntity> wrapper);
	
	BiyelunwenVO selectVO(@Param("ew") Wrapper<BiyelunwenEntity> wrapper);
	
	List<BiyelunwenView> selectListView(@Param("ew") Wrapper<BiyelunwenEntity> wrapper);

	List<BiyelunwenView> selectListView(Pagination page,@Param("ew") Wrapper<BiyelunwenEntity> wrapper);
	
	BiyelunwenView selectView(@Param("ew") Wrapper<BiyelunwenEntity> wrapper);
	
}
