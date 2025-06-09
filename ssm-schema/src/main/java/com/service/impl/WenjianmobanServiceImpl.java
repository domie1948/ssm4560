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


import com.dao.WenjianmobanDao;
import com.entity.WenjianmobanEntity;
import com.service.WenjianmobanService;
import com.entity.vo.WenjianmobanVO;
import com.entity.view.WenjianmobanView;

@Service("wenjianmobanService")
public class WenjianmobanServiceImpl extends ServiceImpl<WenjianmobanDao, WenjianmobanEntity> implements WenjianmobanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenjianmobanEntity> page = this.selectPage(
                new Query<WenjianmobanEntity>(params).getPage(),
                new EntityWrapper<WenjianmobanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenjianmobanEntity> wrapper) {
		  Page<WenjianmobanView> page =new Query<WenjianmobanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WenjianmobanVO> selectListVO(Wrapper<WenjianmobanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WenjianmobanVO selectVO(Wrapper<WenjianmobanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WenjianmobanView> selectListView(Wrapper<WenjianmobanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenjianmobanView selectView(Wrapper<WenjianmobanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
