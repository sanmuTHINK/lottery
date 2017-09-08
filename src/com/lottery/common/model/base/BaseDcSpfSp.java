package com.lottery.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseDcSpfSp<M extends BaseDcSpfSp<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}

	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setTerm(java.lang.String term) {
		set("term", term);
		return (M)this;
	}

	public java.lang.String getTerm() {
		return getStr("term");
	}

	public M setHomeSp(java.math.BigDecimal HomeSp) {
		set("HomeSp", HomeSp);
		return (M)this;
	}

	public java.math.BigDecimal getHomeSp() {
		return get("HomeSp");
	}

	public M setGuestSp(java.math.BigDecimal GuestSp) {
		set("GuestSp", GuestSp);
		return (M)this;
	}

	public java.math.BigDecimal getGuestSp() {
		return get("GuestSp");
	}

	public M setDrawSp(java.math.BigDecimal DrawSp) {
		set("DrawSp", DrawSp);
		return (M)this;
	}

	public java.math.BigDecimal getDrawSp() {
		return get("DrawSp");
	}

	public M setLastUpDate(java.util.Date LastUpDate) {
		set("LastUpDate", LastUpDate);
		return (M)this;
	}

	public java.util.Date getLastUpDate() {
		return get("LastUpDate");
	}

	public M setLineId(java.lang.String lineId) {
		set("lineId", lineId);
		return (M)this;
	}

	public java.lang.String getLineId() {
		return getStr("lineId");
	}

	public M setMatchId(java.lang.Integer matchId) {
		set("matchId", matchId);
		return (M)this;
	}

	public java.lang.Integer getMatchId() {
		return getInt("matchId");
	}

}
