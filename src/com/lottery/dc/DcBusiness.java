package com.lottery.dc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lottery.common.model.DcArrange;
import com.lottery.common.utils.DateUtil;
import com.lottery.common.utils.HttpUtil;

public class DcBusiness {
	private static final String W500_DC_URL = "http://trade.500.com/bjdc/";
	private static Logger log =Logger.getLogger(DcBusiness.class);
	public  static List<DcArrange> snatchDcMatch(){
		List<DcArrange> list=new ArrayList<DcArrange>();
		try {
			String html = HttpUtil.getUrl(W500_DC_URL);
			// 解析html
			Document doc = Jsoup.parse(html);
			Element table=doc.select("#vs_table").first();
			Elements trs=table.select("tbody[id]>tr");
			Element termEle = doc.select("#expect_select > option[selected]").first();
			String termData = termEle.val();
			String[] arr = termData.split("|");
			String term =arr[0];
		
			for (Element ele : trs) {
				String data=ele.val();
				JSONObject json=JSON.parseObject(data);
				
				String endTime=json.getString("endTime")+":00";
				DcArrange dc=new DcArrange();
				dc.setTerm(term);
				dc.setLineId(json.getString("index"));
				dc.setMatchName(json.getString("leagueName"));
				dc.setHome(json.getString("homeTeam"));
				dc.setGuest(json.getString("guestTeam"));
				dc.setShortHome(dc.getHome());
				dc.setShortGuest(dc.getGuest());
				dc.setRqs(json.getInteger("rangqiuNum"));
				dc.setEndTime(DateUtil.getDateTimeFormat(endTime));
				dc.setMatchDate(json.getString("scheduleDate"));
				dc.setMatchColor(json.getString("bgColor"));
				dc.setStatus(json.getString("disabled").equals("yes") ? 1 : 0);
				dc.setOddId(ele.attr("fid"));
				
				
				String homeIdStr=ele.child(3).select("a").first().attr("href");
				String guestIdStr=ele.child(5).select("a").first().attr("href");
				int homeId=Integer.parseInt(homeIdStr.replaceAll("500\\.com|\\D", ""));
				int guestId=Integer.parseInt(guestIdStr.replaceAll("500\\.com|\\D", ""));
				
				dc.setHomeId(homeId);
				dc.setGuestId(guestId);
				String startDatePart=json.getString("endTime").substring(0,11);
				Element startEle=ele.child(2);
				String startTimePart=startEle.attr("title").trim().substring(5);
				String startTime=startDatePart+startTimePart;
				dc.setMatchTime(DateUtil.formatDate(startTime,"yyyy-MM-dd HH:mm"));
				list.add(dc);
			}
		} catch (Exception e) {
			log.error("[对阵抓取]抓取单场比赛数据错误"+e.getMessage());
			e.printStackTrace();
		}
		return list;
		
		
		
	}
	public static void main(String[] args) {
		DcBusiness.snatchDcMatch();
	}
	
}
