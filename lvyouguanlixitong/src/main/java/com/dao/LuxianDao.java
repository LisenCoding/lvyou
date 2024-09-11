package com.dao;

import com.entity.LuxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LuxianView;

/**
 * 路线推荐 Dao 接口
 *
 * @author 
 */
public interface LuxianDao extends BaseMapper<LuxianEntity> {

   List<LuxianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
