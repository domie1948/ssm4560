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


import com.dao.LunwenchazhongDao;
import com.entity.LunwenchazhongEntity;
import com.service.LunwenchazhongService;
import com.entity.vo.LunwenchazhongVO;
import com.entity.view.LunwenchazhongView;

@Service("lunwenchazhongService")
public class LunwenchazhongServiceImpl extends ServiceImpl<LunwenchazhongDao, LunwenchazhongEntity> implements LunwenchazhongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LunwenchazhongEntity> page = this.selectPage(
                new Query<LunwenchazhongEntity>(params).getPage(),
                new EntityWrapper<LunwenchazhongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LunwenchazhongEntity> wrapper) {
		  Page<LunwenchazhongView> page =new Query<LunwenchazhongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LunwenchazhongVO> selectListVO(Wrapper<LunwenchazhongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LunwenchazhongVO selectVO(Wrapper<LunwenchazhongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LunwenchazhongView> selectListView(Wrapper<LunwenchazhongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LunwenchazhongView selectView(Wrapper<LunwenchazhongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
