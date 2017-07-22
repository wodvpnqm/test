package com.qm.jdk.nio.buffer;

import java.nio.ByteBuffer;

import com.alibaba.fastjson.JSON;

public class TestBuffer {

	public static void main(String[] args) throws Exception {
		ByteBuffer buf = ByteBuffer.allocate(48);
		System.out.println(JSON.toJSONString(buf));
	}

}
