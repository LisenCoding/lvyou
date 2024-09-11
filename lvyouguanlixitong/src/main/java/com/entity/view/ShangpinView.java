package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShangpinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 美食
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shangpin")
public class ShangpinView extends ShangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 美食类型的值
	*/
	@ColumnInfo(comment="美食类型的字典表值",type="varchar(200)")
	private String shangpinValue;




	public ShangpinView() {

	}

	public ShangpinView(ShangpinEntity shangpinEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 美食类型的值
	*/
	public String getShangpinValue() {
		return shangpinValue;
	}
	/**
	* 设置： 美食类型的值
	*/
	public void setShangpinValue(String shangpinValue) {
		this.shangpinValue = shangpinValue;
	}




	@Override
	public String toString() {
		return "ShangpinView{" +
			", shangpinValue=" + shangpinValue +
			"} " + super.toString();
	}
}
