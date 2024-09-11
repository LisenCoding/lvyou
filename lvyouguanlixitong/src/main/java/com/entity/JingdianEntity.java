package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 景点
 *
 * @author 
 * @email
 */
@TableName("jingdian")
public class JingdianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JingdianEntity() {

	}

	public JingdianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 景点名称
     */
    @ColumnInfo(comment="景点名称",type="varchar(200)")
    @TableField(value = "jingdian_name")

    private String jingdianName;


    /**
     * 景点编号
     */
    @ColumnInfo(comment="景点编号",type="varchar(200)")
    @TableField(value = "jingdian_uuid_number")

    private String jingdianUuidNumber;


    /**
     * 景点照片
     */
    @ColumnInfo(comment="景点照片",type="varchar(200)")
    @TableField(value = "jingdian_photo")

    private String jingdianPhoto;


    /**
     * 景点地点
     */
    @ColumnInfo(comment="景点地点",type="varchar(200)")
    @TableField(value = "jingdian_address")

    private String jingdianAddress;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 景点视频
     */
    @ColumnInfo(comment="景点视频",type="varchar(200)")
    @TableField(value = "jingdian_video")

    private String jingdianVideo;


    /**
     * 景点类型
     */
    @ColumnInfo(comment="景点类型",type="int(11)")
    @TableField(value = "jingdian_types")

    private Integer jingdianTypes;


    /**
     * 景点门票
     */
    @ColumnInfo(comment="景点门票",type="int(11)")
    @TableField(value = "jingdian_kucun_number")

    private Integer jingdianKucunNumber;


    /**
     * 现价/积分
     */
    @ColumnInfo(comment="现价/积分",type="decimal(10,2)")
    @TableField(value = "jingdian_new_money")

    private Double jingdianNewMoney;


    /**
     * 景点介绍
     */
    @ColumnInfo(comment="景点介绍",type="longtext")
    @TableField(value = "jingdian_content")

    private String jingdianContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jingdian_delete")

    private Integer jingdianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：景点名称
	 */
    public String getJingdianName() {
        return jingdianName;
    }
    /**
	 * 设置：景点名称
	 */

    public void setJingdianName(String jingdianName) {
        this.jingdianName = jingdianName;
    }
    /**
	 * 获取：景点编号
	 */
    public String getJingdianUuidNumber() {
        return jingdianUuidNumber;
    }
    /**
	 * 设置：景点编号
	 */

    public void setJingdianUuidNumber(String jingdianUuidNumber) {
        this.jingdianUuidNumber = jingdianUuidNumber;
    }
    /**
	 * 获取：景点照片
	 */
    public String getJingdianPhoto() {
        return jingdianPhoto;
    }
    /**
	 * 设置：景点照片
	 */

    public void setJingdianPhoto(String jingdianPhoto) {
        this.jingdianPhoto = jingdianPhoto;
    }
    /**
	 * 获取：景点地点
	 */
    public String getJingdianAddress() {
        return jingdianAddress;
    }
    /**
	 * 设置：景点地点
	 */

    public void setJingdianAddress(String jingdianAddress) {
        this.jingdianAddress = jingdianAddress;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：景点视频
	 */
    public String getJingdianVideo() {
        return jingdianVideo;
    }
    /**
	 * 设置：景点视频
	 */

    public void setJingdianVideo(String jingdianVideo) {
        this.jingdianVideo = jingdianVideo;
    }
    /**
	 * 获取：景点类型
	 */
    public Integer getJingdianTypes() {
        return jingdianTypes;
    }
    /**
	 * 设置：景点类型
	 */

    public void setJingdianTypes(Integer jingdianTypes) {
        this.jingdianTypes = jingdianTypes;
    }
    /**
	 * 获取：景点门票
	 */
    public Integer getJingdianKucunNumber() {
        return jingdianKucunNumber;
    }
    /**
	 * 设置：景点门票
	 */

    public void setJingdianKucunNumber(Integer jingdianKucunNumber) {
        this.jingdianKucunNumber = jingdianKucunNumber;
    }
    /**
	 * 获取：现价/积分
	 */
    public Double getJingdianNewMoney() {
        return jingdianNewMoney;
    }
    /**
	 * 设置：现价/积分
	 */

    public void setJingdianNewMoney(Double jingdianNewMoney) {
        this.jingdianNewMoney = jingdianNewMoney;
    }
    /**
	 * 获取：景点介绍
	 */
    public String getJingdianContent() {
        return jingdianContent;
    }
    /**
	 * 设置：景点介绍
	 */

    public void setJingdianContent(String jingdianContent) {
        this.jingdianContent = jingdianContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJingdianDelete() {
        return jingdianDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJingdianDelete(Integer jingdianDelete) {
        this.jingdianDelete = jingdianDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jingdian{" +
            ", id=" + id +
            ", jingdianName=" + jingdianName +
            ", jingdianUuidNumber=" + jingdianUuidNumber +
            ", jingdianPhoto=" + jingdianPhoto +
            ", jingdianAddress=" + jingdianAddress +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", jingdianVideo=" + jingdianVideo +
            ", jingdianTypes=" + jingdianTypes +
            ", jingdianKucunNumber=" + jingdianKucunNumber +
            ", jingdianNewMoney=" + jingdianNewMoney +
            ", jingdianContent=" + jingdianContent +
            ", jingdianDelete=" + jingdianDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
