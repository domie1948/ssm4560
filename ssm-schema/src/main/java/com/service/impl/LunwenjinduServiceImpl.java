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


import com.dao.LunwenjinduDao;
import com.entity.LunwenjinduEntity;
import com.service.LunwenjinduService;
import com.entity.vo.LunwenjinduVO;
import com.entity.view.LunwenjinduView;

@Service("lunwenjinduService")
public class LunwenjinduServiceImpl extends ServiceImpl<LunwenjinduDao, LunwenjinduEntity> implements LunwenjinduService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LunwenjinduEntity> page = this.selectPage(
                new Query<LunwenjinduEntity>(params).getPage(),
                new EntityWrapper<LunwenjinduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LunwenjinduEntity> wrapper) {
		  Page<LunwenjinduView> page =new Query<LunwenjinduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LunwenjinduVO> selectListVO(Wrapper<LunwenjinduEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LunwenjinduVO selectVO(Wrapper<LunwenjinduEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LunwenjinduView> selectListView(Wrapper<LunwenjinduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LunwenjinduView selectView(Wrapper<LunwenjinduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
