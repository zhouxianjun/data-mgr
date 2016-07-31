package com.alone.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1000846308236576343L;

	//当前页
	@Getter
	@Setter
	private int pageNum;

	@Getter
	@Setter
	private int pageSize;
	//总记录数
	@Getter
	private int count;

	@Setter
	private List<T> items;

	@Setter
	@Getter
	private Map<String, String> query;
	
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getItems() {
		if(items == null)
			items = new ArrayList<T>();
		return items;
	}
	public int getTotalPage() {
		int totalPage = count / pageSize;
		if (totalPage == 0 || count % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}

	/**
	 * 获取当前记录索引
	 * @return
	 */
	public int getCurrentIndex() {
		int currentIndex = (getPageNum() - 1) * getPageSize();
		if (currentIndex < 0)
			currentIndex = 0;
		return currentIndex;
	}
}
