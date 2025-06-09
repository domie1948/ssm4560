package com.dao;

import com.entity.XueshengtitiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengtitiVO;
import com.entity.view.XueshengtitiView;


/**
 * 学生提题
 * 
 * @author 
 * @email 
 * @date 2020-11-02 10:24:02
 */
public interface XueshengtitiDao extends BaseMapper<XueshengtitiEntity> {
	
	List<XueshengtitiVO> selectListVO(@Param("ew") Wrapper<XueshengtitiEntity> wrapper);
	
	XueshengtitiVO selectVO(@Param("ew") Wrapper<XueshengtitiEntity> wrapper);
	
	List<XueshengtitiView> selectListView(@Param("ew") Wrapper<XueshengtitiEntity> wrapper);

	List<XueshengtitiView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengtitiEntity> wrapper);
	
	XueshengtitiView selectView(@Param("ew") Wrapper<XueshengtitiEntity> wrapper);
	
}
