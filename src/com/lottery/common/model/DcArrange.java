package com.lottery.common.model;

import com.lottery.common.model.base.BaseDcArrange;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class DcArrange extends BaseDcArrange<DcArrange> {
	private String intTime;

	public String getIntTime() {
		return getMatchDate().replace("-", "");
	}
}
