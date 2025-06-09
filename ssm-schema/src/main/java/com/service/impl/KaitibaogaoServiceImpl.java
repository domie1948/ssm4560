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


import com.dao.KaitibaogaoDao;
import com.entity.KaitibaogaoEntity;
import com.service.KaitibaogaoService;
import com.entity.vo.KaitibaogaoVO;
import com.entity.view.KaitibaogaoView;

@Service("kaitibaogaoService")
public class KaitibaogaoServiceImpl extends ServiceImpl<KaitibaogaoDao, KaitibaogaoEntity> implements KaitibaogaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaitibaogaoEntity> page = this.selectPage(
                new Query<KaitibaogaoEntity>(params).getPage(),
                new EntityWrapper<KaitibaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaitibaogaoEntity> wrapper) {
		  Page<KaitibaogaoView> page =new Query<KaitibaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KaitibaogaoVO> selectListVO(Wrapper<KaitibaogaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaitibaogaoVO selectVO(Wrapper<KaitibaogaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaitibaogaoView> selectListView(Wrapper<KaitibaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaitibaogaoView selectView(Wrapper<KaitibaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
