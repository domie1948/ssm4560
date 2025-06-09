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

import com.entity.LunwenchazhongEntity;
import com.entity.view.LunwenchazhongView;

import com.service.LunwenchazhongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 论文查重
 * 后端接口
 * @author 
 * @email 
 * @date 2020-11-02 10:24:02
 */
@RestController
@RequestMapping("/lunwenchazhong")
public class LunwenchazhongController {
    @Autowired
    private LunwenchazhongService lunwenchazhongService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LunwenchazhongEntity lunwenchazhong, HttpServletRequest request){

        EntityWrapper<LunwenchazhongEntity> ew = new EntityWrapper<LunwenchazhongEntity>();
		PageUtils page = lunwenchazhongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lunwenchazhong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LunwenchazhongEntity lunwenchazhong, HttpServletRequest request){
        EntityWrapper<LunwenchazhongEntity> ew = new EntityWrapper<LunwenchazhongEntity>();
		PageUtils page = lunwenchazhongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lunwenchazhong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LunwenchazhongEntity lunwenchazhong){
       	EntityWrapper<LunwenchazhongEntity> ew = new EntityWrapper<LunwenchazhongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lunwenchazhong, "lunwenchazhong")); 
        return R.ok().put("data", lunwenchazhongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LunwenchazhongEntity lunwenchazhong){
        EntityWrapper< LunwenchazhongEntity> ew = new EntityWrapper< LunwenchazhongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lunwenchazhong, "lunwenchazhong")); 
		LunwenchazhongView lunwenchazhongView =  lunwenchazhongService.selectView(ew);
		return R.ok("查询论文查重成功").put("data", lunwenchazhongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        LunwenchazhongEntity lunwenchazhong = lunwenchazhongService.selectById(id);
        return R.ok().put("data", lunwenchazhong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        LunwenchazhongEntity lunwenchazhong = lunwenchazhongService.selectById(id);
        return R.ok().put("data", lunwenchazhong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LunwenchazhongEntity lunwenchazhong, HttpServletRequest request){
    	lunwenchazhong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lunwenchazhong);

        lunwenchazhongService.insert(lunwenchazhong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LunwenchazhongEntity lunwenchazhong, HttpServletRequest request){
    	lunwenchazhong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lunwenchazhong);

        lunwenchazhongService.insert(lunwenchazhong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LunwenchazhongEntity lunwenchazhong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lunwenchazhong);
        lunwenchazhongService.updateById(lunwenchazhong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lunwenchazhongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<LunwenchazhongEntity> wrapper = new EntityWrapper<LunwenchazhongEntity>();
		if(map.get("remindstart")!=null && !map.get("remindstart").toString().equals("")) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null && !map.get("remindend").toString().equals("")) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = lunwenchazhongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
