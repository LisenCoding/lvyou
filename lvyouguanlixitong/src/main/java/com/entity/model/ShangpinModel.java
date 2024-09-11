package com.entity.model;

import com.entity.ShangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 美食
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShangpinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 美食名称
     */
    private String shangpinName;


    /**
     * 美食编号
     */
    private String shangpinUuidNumber;


    /**
     * 美食照片
     */
    private String shangpinPhoto;


    /**
     * 美食地点
     */
    private String shangpinAddress;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 美食类型
     */
    private Integer shangpinTypes;


    /**
     * 美食库存
     */
    private Integer shangpinKucunNumber;


    /**
     * 金额
     */
    private Double shangpinNewMoney;


    /**
     * 美食热度
     */
    private Integer shangpinClicknum;


    /**
     * 美食介绍
     */
    private String shangpinContent;


    /**
     * 逻辑删除
     */
    private Integer shangpinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：美食名称
	 */
    public String getShangpinName() {
        return shangpinName;
    }


    /**
	 * 设置：美食名称
	 */
    public void setShangpinName(String shangpinName) {
        this.shangpinName = shangpinName;
    }
    /**
	 * 获取：美食编号
	 */
    public String getShangpinUuidNumber() {
        return shangpinUuidNumber;
    }


    /**
	 * 设置：美食编号
	 */
    public void setShangpinUuidNumber(String shangpinUuidNumber) {
        this.shangpinUuidNumber = shangpinUuidNumber;
    }
    /**
	 * 获取：美食照片
	 */
    public String getShangpinPhoto() {
        return shangpinPhoto;
    }


    /**
	 * 设置：美食照片
	 */
    public void setShangpinPhoto(String shangpinPhoto) {
        this.shangpinPhoto = shangpinPhoto;
    }
    /**
	 * 获取：美食地点
	 */
    public String getShangpinAddress() {
        return shangpinAddress;
    }


    /**
	 * 设置：美食地点
	 */
    public void setShangpinAddress(String shangpinAddress) {
        this.shangpinAddress = shangpinAddress;
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
	 * 获取：美食类型
	 */
    public Integer getShangpinTypes() {
        return shangpinTypes;
    }


    /**
	 * 设置：美食类型
	 */
    public void setShangpinTypes(Integer shangpinTypes) {
        this.shangpinTypes = shangpinTypes;
    }
    /**
	 * 获取：美食库存
	 */
    public Integer getShangpinKucunNumber() {
        return shangpinKucunNumber;
    }


    /**
	 * 设置：美食库存
	 */
    public void setShangpinKucunNumber(Integer shangpinKucunNumber) {
        this.shangpinKucunNumber = shangpinKucunNumber;
    }
    /**
	 * 获取：金额
	 */
    public Double getShangpinNewMoney() {
        return shangpinNewMoney;
    }


    /**
	 * 设置：金额
	 */
    public void setShangpinNewMoney(Double shangpinNewMoney) {
        this.shangpinNewMoney = shangpinNewMoney;
    }
    /**
	 * 获取：美食热度
	 */
    public Integer getShangpinClicknum() {
        return shangpinClicknum;
    }


    /**
	 * 设置：美食热度
	 */
    public void setShangpinClicknum(Integer shangpinClicknum) {
        this.shangpinClicknum = shangpinClicknum;
    }
    /**
	 * 获取：美食介绍
	 */
    public String getShangpinContent() {
        return shangpinContent;
    }


    /**
	 * 设置：美食介绍
	 */
    public void setShangpinContent(String shangpinContent) {
        this.shangpinContent = shangpinContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShangpinDelete() {
        return shangpinDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setShangpinDelete(Integer shangpinDelete) {
        this.shangpinDelete = shangpinDelete;
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
