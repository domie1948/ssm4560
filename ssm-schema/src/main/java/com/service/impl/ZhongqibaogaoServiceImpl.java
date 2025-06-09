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


import com.dao.ZhongqibaogaoDao;
import com.entity.ZhongqibaogaoEntity;
import com.service.ZhongqibaogaoService;
import com.entity.vo.ZhongqibaogaoVO;
import com.entity.view.ZhongqibaogaoView;

@Service("zhongqibaogaoService")
public class ZhongqibaogaoServiceImpl extends ServiceImpl<ZhongqibaogaoDao, ZhongqibaogaoEntity> implements ZhongqibaogaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhongqibaogaoEntity> page = this.selectPage(
                new Query<ZhongqibaogaoEntity>(params).getPage(),
                new EntityWrapper<ZhongqibaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhongqibaogaoEntity> wrapper) {
		  Page<ZhongqibaogaoView> page =new Query<ZhongqibaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhongqibaogaoVO> selectListVO(Wrapper<ZhongqibaogaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhongqibaogaoVO selectVO(Wrapper<ZhongqibaogaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhongqibaogaoView> selectListView(Wrapper<ZhongqibaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhongqibaogaoView selectView(Wrapper<ZhongqibaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
