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

import com.entity.ZhongqibaogaoEntity;
import com.entity.view.ZhongqibaogaoView;

import com.service.ZhongqibaogaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 中期报告
 * 后端接口
 * @author 
 * @email 
 * @date 2020-11-02 10:24:01
 */
@RestController
@RequestMapping("/zhongqibaogao")
public class ZhongqibaogaoController {
    @Autowired
    private ZhongqibaogaoService zhongqibaogaoService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhongqibaogaoEntity zhongqibaogao, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			zhongqibaogao.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			zhongqibaogao.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhongqibaogaoEntity> ew = new EntityWrapper<ZhongqibaogaoEntity>();
		PageUtils page = zhongqibaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongqibaogao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhongqibaogaoEntity zhongqibaogao, HttpServletRequest request){
        EntityWrapper<ZhongqibaogaoEntity> ew = new EntityWrapper<ZhongqibaogaoEntity>();
		PageUtils page = zhongqibaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongqibaogao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhongqibaogaoEntity zhongqibaogao){
       	EntityWrapper<ZhongqibaogaoEntity> ew = new EntityWrapper<ZhongqibaogaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhongqibaogao, "zhongqibaogao")); 
        return R.ok().put("data", zhongqibaogaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhongqibaogaoEntity zhongqibaogao){
        EntityWrapper< ZhongqibaogaoEntity> ew = new EntityWrapper< ZhongqibaogaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhongqibaogao, "zhongqibaogao")); 
		ZhongqibaogaoView zhongqibaogaoView =  zhongqibaogaoService.selectView(ew);
		return R.ok("查询中期报告成功").put("data", zhongqibaogaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        ZhongqibaogaoEntity zhongqibaogao = zhongqibaogaoService.selectById(id);
        return R.ok().put("data", zhongqibaogao);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        ZhongqibaogaoEntity zhongqibaogao = zhongqibaogaoService.selectById(id);
        return R.ok().put("data", zhongqibaogao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhongqibaogaoEntity zhongqibaogao, HttpServletRequest request){
    	zhongqibaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhongqibaogao);

        zhongqibaogaoService.insert(zhongqibaogao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhongqibaogaoEntity zhongqibaogao, HttpServletRequest request){
    	zhongqibaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhongqibaogao);

        zhongqibaogaoService.insert(zhongqibaogao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZhongqibaogaoEntity zhongqibaogao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhongqibaogao);
        zhongqibaogaoService.updateById(zhongqibaogao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhongqibaogaoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZhongqibaogaoEntity> wrapper = new EntityWrapper<ZhongqibaogaoEntity>();
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

		int count = zhongqibaogaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
