package com.dao;

import com.entity.ZaixianxuantiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaixianxuantiVO;
import com.entity.view.ZaixianxuantiView;


/**
 * 在线选题
 * 
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
public interface ZaixianxuantiDao extends BaseMapper<ZaixianxuantiEntity> {
	
	List<ZaixianxuantiVO> selectListVO(@Param("ew") Wrapper<ZaixianxuantiEntity> wrapper);
	
	ZaixianxuantiVO selectVO(@Param("ew") Wrapper<ZaixianxuantiEntity> wrapper);
	
	List<ZaixianxuantiView> selectListView(@Param("ew") Wrapper<ZaixianxuantiEntity> wrapper);

	List<ZaixianxuantiView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianxuantiEntity> wrapper);
	
	ZaixianxuantiView selectView(@Param("ew") Wrapper<ZaixianxuantiEntity> wrapper);
	
}
