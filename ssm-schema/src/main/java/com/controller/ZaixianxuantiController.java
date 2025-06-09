package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZaixianxuantiEntity;
import com.entity.view.ZaixianxuantiView;

import com.service.ZaixianxuantiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 在线选题
 * 后端接口
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
@RestController
@RequestMapping("/zaixianxuanti")
public class ZaixianxuantiController {
    @Autowired
    private ZaixianxuantiService zaixianxuantiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaixianxuantiEntity zaixianxuanti, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			zaixianxuanti.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZaixianxuantiEntity> ew = new EntityWrapper<ZaixianxuantiEntity>();
		PageUtils page = zaixianxuantiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianxuanti), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaixianxuantiEntity zaixianxuanti, HttpServletRequest request){
        EntityWrapper<ZaixianxuantiEntity> ew = new EntityWrapper<ZaixianxuantiEntity>();
		PageUtils page = zaixianxuantiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianxuanti), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZaixianxuantiEntity zaixianxuanti){
       	EntityWrapper<ZaixianxuantiEntity> ew = new EntityWrapper<ZaixianxuantiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaixianxuanti, "zaixianxuanti")); 
        return R.ok().put("data", zaixianxuantiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZaixianxuantiEntity zaixianxuanti){
        EntityWrapper< ZaixianxuantiEntity> ew = new EntityWrapper< ZaixianxuantiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaixianxuanti, "zaixianxuanti")); 
		ZaixianxuantiView zaixianxuantiView =  zaixianxuantiService.selectView(ew);
		return R.ok("查询在线选题成功").put("data", zaixianxuantiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        ZaixianxuantiEntity zaixianxuanti = zaixianxuantiService.selectById(id);
        return R.ok().put("data", zaixianxuanti);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        ZaixianxuantiEntity zaixianxuanti = zaixianxuantiService.selectById(id);
        return R.ok().put("data", zaixianxuanti);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZaixianxuantiEntity zaixianxuanti, HttpServletRequest request){
    	zaixianxuanti.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianxuanti);

        zaixianxuantiService.insert(zaixianxuanti);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZaixianxuantiEntity zaixianxuanti, HttpServletRequest request){
    	zaixianxuanti.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianxuanti);

        zaixianxuantiService.insert(zaixianxuanti);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZaixianxuantiEntity zaixianxuanti, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaixianxuanti);
        zaixianxuantiService.updateById(zaixianxuanti);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaixianxuantiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null && !map.get("remindstart").toString().equals("")) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null && !map.get("remindend").toString().equals("")) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZaixianxuantiEntity> wrapper = new EntityWrapper<ZaixianxuantiEntity>();
		if(map.get("remindstart")!=null && !map.get("remindstart").toString().equals("")) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null && !map.get("remindend").toString().equals("")) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zaixianxuantiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
