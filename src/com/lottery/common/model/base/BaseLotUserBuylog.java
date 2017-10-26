package com.lottery.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.alibaba.fastjson.annotation.JSONField;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseLotUserBuylog<M extends BaseLotUserBuylog<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer Id) {
		set("Id", Id);
		return (M)this;
	}

	public java.lang.Integer getId() {
		return getInt("Id");
	}

	public M setUserId(java.lang.Integer userId) {
		set("userId", userId);
		return (M)this;
	}

	public java.lang.Integer getUserId() {
		return getInt("userId");
	}

	public M setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
		return (M)this;
	}
	@JSONField(format="yyyy/MM/dd")
	public java.util.Date getCreateTime() {
		return get("createTime");
	}

	public M setStartTime(java.util.Date startTime) {
		set("startTime", startTime);
		return (M)this;
	}
	@JSONField(format="yyyy/MM/dd")
	public java.util.Date getStartTime() {
		return get("startTime");
	}

	public M setEndTime(java.util.Date endTime) {
		set("endTime", endTime);
		return (M)this;
	}
	@JSONField(format="yyyy/MM/dd")
	public java.util.Date getEndTime() {
		return get("endTime");
	}

	public M setRemark(java.lang.String remark) {
		set("remark", remark);
		return (M)this;
	}

	public java.lang.String getRemark() {
		return getStr("remark");
	}

}
