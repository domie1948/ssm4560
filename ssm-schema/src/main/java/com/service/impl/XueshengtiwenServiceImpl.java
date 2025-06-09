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


import com.dao.XueshengtiwenDao;
import com.entity.XueshengtiwenEntity;
import com.service.XueshengtiwenService;
import com.entity.vo.XueshengtiwenVO;
import com.entity.view.XueshengtiwenView;

@Service("xueshengtiwenService")
public class XueshengtiwenServiceImpl extends ServiceImpl<XueshengtiwenDao, XueshengtiwenEntity> implements XueshengtiwenService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengtiwenEntity> page = this.selectPage(
                new Query<XueshengtiwenEntity>(params).getPage(),
                new EntityWrapper<XueshengtiwenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengtiwenEntity> wrapper) {
		  Page<XueshengtiwenView> page =new Query<XueshengtiwenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshengtiwenVO> selectListVO(Wrapper<XueshengtiwenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshengtiwenVO selectVO(Wrapper<XueshengtiwenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshengtiwenView> selectListView(Wrapper<XueshengtiwenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengtiwenView selectView(Wrapper<XueshengtiwenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
