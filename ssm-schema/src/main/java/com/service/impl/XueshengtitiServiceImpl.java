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


import com.dao.XueshengtitiDao;
import com.entity.XueshengtitiEntity;
import com.service.XueshengtitiService;
import com.entity.vo.XueshengtitiVO;
import com.entity.view.XueshengtitiView;

@Service("xueshengtitiService")
public class XueshengtitiServiceImpl extends ServiceImpl<XueshengtitiDao, XueshengtitiEntity> implements XueshengtitiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengtitiEntity> page = this.selectPage(
                new Query<XueshengtitiEntity>(params).getPage(),
                new EntityWrapper<XueshengtitiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengtitiEntity> wrapper) {
		  Page<XueshengtitiView> page =new Query<XueshengtitiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshengtitiVO> selectListVO(Wrapper<XueshengtitiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshengtitiVO selectVO(Wrapper<XueshengtitiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshengtitiView> selectListView(Wrapper<XueshengtitiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengtitiView selectView(Wrapper<XueshengtitiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
