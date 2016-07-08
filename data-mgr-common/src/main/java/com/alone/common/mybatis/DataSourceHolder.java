package com.alone.common.mybatis;


import com.alone.common.dto.DataSourceType;

/**
 * 数据源选择器
 */
public class DataSourceHolder {
	private static final ThreadLocal<DataSourceType> holder = new ThreadLocal<DataSourceType>();

	public static void changeDs(DataSourceType ds) {
		holder.set(ds);
	}

	public static DataSourceType getDataSourceName() {
		return holder.get();
	}
}
