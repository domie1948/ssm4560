package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.LaoshidayiDao;
import com.entity.LaoshidayiEntity;
import com.service.LaoshidayiService;
import com.entity.vo.LaoshidayiVO;
import com.entity.view.LaoshidayiView;

@Service("laoshidayiService")
public class LaoshidayiServiceImpl extends ServiceImpl<LaoshidayiDao, LaoshidayiEntity> implements LaoshidayiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaoshidayiEntity> page = this.selectPage(
                new Query<LaoshidayiEntity>(params).getPage(),
                new EntityWrapper<LaoshidayiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaoshidayiEntity> wrapper) {
		  Page<LaoshidayiView> page =new Query<LaoshidayiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LaoshidayiVO> selectListVO(Wrapper<LaoshidayiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LaoshidayiVO selectVO(Wrapper<LaoshidayiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LaoshidayiView> selectListView(Wrapper<LaoshidayiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaoshidayiView selectView(Wrapper<LaoshidayiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
