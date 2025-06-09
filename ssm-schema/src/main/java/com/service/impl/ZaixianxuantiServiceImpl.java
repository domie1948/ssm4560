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


import com.dao.ZaixianxuantiDao;
import com.entity.ZaixianxuantiEntity;
import com.service.ZaixianxuantiService;
import com.entity.vo.ZaixianxuantiVO;
import com.entity.view.ZaixianxuantiView;

@Service("zaixianxuantiService")
public class ZaixianxuantiServiceImpl extends ServiceImpl<ZaixianxuantiDao, ZaixianxuantiEntity> implements ZaixianxuantiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianxuantiEntity> page = this.selectPage(
                new Query<ZaixianxuantiEntity>(params).getPage(),
                new EntityWrapper<ZaixianxuantiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianxuantiEntity> wrapper) {
		  Page<ZaixianxuantiView> page =new Query<ZaixianxuantiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZaixianxuantiVO> selectListVO(Wrapper<ZaixianxuantiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixianxuantiVO selectVO(Wrapper<ZaixianxuantiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixianxuantiView> selectListView(Wrapper<ZaixianxuantiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianxuantiView selectView(Wrapper<ZaixianxuantiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
