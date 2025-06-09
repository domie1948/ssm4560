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

import com.entity.BiyelunwenEntity;
import com.entity.view.BiyelunwenView;

import com.service.BiyelunwenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 毕业论文
 * 后端接口
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
@RestController
@RequestMapping("/biyelunwen")
public class BiyelunwenController {
    @Autowired
    private BiyelunwenService biyelunwenService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BiyelunwenEntity biyelunwen, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			biyelunwen.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			biyelunwen.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BiyelunwenEntity> ew = new EntityWrapper<BiyelunwenEntity>();
		PageUtils page = biyelunwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, biyelunwen), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BiyelunwenEntity biyelunwen, HttpServletRequest request){
        EntityWrapper<BiyelunwenEntity> ew = new EntityWrapper<BiyelunwenEntity>();
		PageUtils page = biyelunwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, biyelunwen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BiyelunwenEntity biyelunwen){
       	EntityWrapper<BiyelunwenEntity> ew = new EntityWrapper<BiyelunwenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( biyelunwen, "biyelunwen")); 
        return R.ok().put("data", biyelunwenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BiyelunwenEntity biyelunwen){
        EntityWrapper< BiyelunwenEntity> ew = new EntityWrapper< BiyelunwenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( biyelunwen, "biyelunwen")); 
		BiyelunwenView biyelunwenView =  biyelunwenService.selectView(ew);
		return R.ok("查询毕业论文成功").put("data", biyelunwenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        BiyelunwenEntity biyelunwen = biyelunwenService.selectById(id);
        return R.ok().put("data", biyelunwen);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        BiyelunwenEntity biyelunwen = biyelunwenService.selectById(id);
        return R.ok().put("data", biyelunwen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BiyelunwenEntity biyelunwen, HttpServletRequest request){
    	biyelunwen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(biyelunwen);

        biyelunwenService.insert(biyelunwen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BiyelunwenEntity biyelunwen, HttpServletRequest request){
    	biyelunwen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(biyelunwen);

        biyelunwenService.insert(biyelunwen);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BiyelunwenEntity biyelunwen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(biyelunwen);
        biyelunwenService.updateById(biyelunwen);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        biyelunwenService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<BiyelunwenEntity> wrapper = new EntityWrapper<BiyelunwenEntity>();
		if(map.get("remindstart")!=null && !map.get("remindstart").toString().equals("")) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null && !map.get("remindend").toString().equals("")) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xueshengxuehao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = biyelunwenService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
