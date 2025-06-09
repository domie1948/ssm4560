package com.dao;

import com.entity.ZhongqibaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhongqibaogaoVO;
import com.entity.view.ZhongqibaogaoView;


/**
 * 中期报告
 * 
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
public interface ZhongqibaogaoDao extends BaseMapper<ZhongqibaogaoEntity> {
	
	List<ZhongqibaogaoVO> selectListVO(@Param("ew") Wrapper<ZhongqibaogaoEntity> wrapper);
	
	ZhongqibaogaoVO selectVO(@Param("ew") Wrapper<ZhongqibaogaoEntity> wrapper);
	
	List<ZhongqibaogaoView> selectListView(@Param("ew") Wrapper<ZhongqibaogaoEntity> wrapper);

	List<ZhongqibaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<ZhongqibaogaoEntity> wrapper);
	
	ZhongqibaogaoView selectView(@Param("ew") Wrapper<ZhongqibaogaoEntity> wrapper);
	
}
