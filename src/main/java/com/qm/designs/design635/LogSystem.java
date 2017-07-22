package com.qm.designs.design635;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 
 * 给你一些日志,每个日志包含一个惟一的id和时间戳。
 * 
 * 时间戳是一个字符串,如下格式:Year:Month:Day:Hour:Minute:Second ,例如,2017:01:01:23:59:59。
 * 所有的数字都是0填充的十进制数字
 * 
 * 设计一个日志存储系统实现以下功能: void Put(int id, string timestamp):
 * 考虑到一个日志的惟一id和时间戳,将日志存储在你的存储系统。
 * 
 * int[] Retrieve(String start, String end, String granularity):
 * 返回的id日志时间戳的范围内从开始到结束。 返回的id日志时间戳的范围内从开始到结束。开始和结束都有相同的格式和时间戳。然而,粒度意味着水平的时间考虑。
 * 例如,开始=“2017:01:01:23:59:59”,结束=“2017:01:02:23:59:59”,粒度=“天”,
 * 这意味着我们需要找到范围内的记录从2017年1月1日到2017年1月2日。
 * 
 * Example 1: put(1, "2017:01:01:23:59:59"); put(2, "2017:01:01:22:59:59");
 * put(3, "2016:01:01:00:00:00");
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return
 * [1,2,3], because you need to return all logs within 2016 and 2017.
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return
 * [1,2], because you need to return all logs start from 2016:01:01:01 to
 * 2017:01:01:23, where log 3 is left outside the range.
 * 
 * 注意: 会有最多300的Put 或Retrieve。 年(2000、2017)不等。小时不等(00,23)。 输出检索没有顺序要求。
 * 
 * 
 * 1.结构为Map<Integer,Long> 2.排序Map 3.格式化字符串
 * 
 * @author wodvpn
 *
 */
public class LogSystem {

	public static class Entry<K, V> {
		private K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
		
		
	}


	private TreeSet<Entry<Integer, Long>> ts = null;

	
	private static final String DATE_PATTERN = "yyyy:MM:dd:hh:mm:ss";
	
	
	private static final String SECOND_PATTERN = "yyyy:MM:dd:hh:mm:ss";
	private static final String MINUTE_PATTERN = "yyyy:MM:dd:hh:mm:00";
	private static final String HOUR_PATTERN = "yyyy:MM:dd:hh:00:00";
	private static final String DAY_PATTERN = "yyyy:MM:dd:00:00:00";
	private static final String MONTH_PATTERN = "yyyy:MM:00:00:00:00";
	private static final String YEAR_PATTERN = "yyyy:00:00:00:00:00";
	private SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
	private Map<String,SimpleDateFormat> timeToPattern;

	public LogSystem() {
		Comparator<Entry<Integer, Long>> comparator = new Comparator<Entry<Integer, Long>>() {
			@Override
			public int compare(Entry<Integer, Long> e1, Entry<Integer, Long> e2) {
				return e1.value.compareTo(e2.value);
			}
		};
		ts = new TreeSet<Entry<Integer, Long>>(comparator);
		timeToPattern = new HashMap<String,SimpleDateFormat>();
		timeToPattern.put("Year", new SimpleDateFormat(YEAR_PATTERN));
		timeToPattern.put("Month", new SimpleDateFormat(MONTH_PATTERN));
		timeToPattern.put("Day", new SimpleDateFormat(DAY_PATTERN));
		timeToPattern.put("Hour", new SimpleDateFormat(HOUR_PATTERN));
		timeToPattern.put("Minute", new SimpleDateFormat(MINUTE_PATTERN));
		timeToPattern.put("Second", new SimpleDateFormat(SECOND_PATTERN));
	}

	public void put(int id, String timestamp) {
		Date date = null;
		try {
			date = sdf.parse(timestamp);
		} catch (ParseException e) {
			throw new RuntimeException("输入格式错误");
		}
		ts.add(new Entry<Integer, Long>(id, date.getTime()));

	}

	public List<Integer> retrieve(String s, String e, String gra) {
		SimpleDateFormat format = timeToPattern.get(gra);
		Long start = null;
		Long end = null;
		try{
			Date startTime = format.parse(s);
			Date endTime = format.parse(s);
			start = startTime.getTime();
			end = endTime.getTime();
		}catch(Exception exception){
			throw new RuntimeException("字符串转换为日期异常");
		}
		
		return null;
	}
	
	private int findGreaterOrEqualsThanTarget(Entry<Integer,Long> [] array,Long target,int start,int end){
		if(start < end){
			return -1;
		}
		int mid = start + (end - start)/2;
		if(array[mid].value < target){
			return findGreaterOrEqualsThanTarget(array,target,mid+1,end);
		}
		return 0;
	}


	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-00 00:00:00");
		Date date = new Date();
		String str = sdf.format(date);
		System.out.println(str);
	}
	
	@Test
	public void test1() {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(1);
		ts.add(2);
		ts.add(3);
		Integer [] array = new Integer[ts.size()];
		ts.toArray(array);
		System.out.println(Arrays.toString(array));
	}
}

/**
 * Your LogSystem object will be instantiated and called as such: LogSystem obj
 * = new LogSystem(); obj.put(id,timestamp); List<Integer> param_2 =
 * obj.retrieve(s,e,gra);
 */