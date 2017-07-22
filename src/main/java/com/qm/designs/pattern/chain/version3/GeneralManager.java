package com.qm.designs.pattern.chain.version3;

public class GeneralManager extends Handler {
	public String handleFeeRequest(String user, double fee) {
		String str = "";
		// 总经理的权限很大，只要请求到了这里，他都可以处理
		if (fee >= 1000) {
			// 为了测试，简单点，只同意小李的
			if ("小李".equals(user)) {
				str = "总经理同意" + user + "聚餐费用" + fee + "元的请求";
			} else {
				// 其它人一律不同意
				str = "总经理不同意" + user + "聚餐费用" + fee + "元的请求";
			}
			return str;
		} else {
			// 如果还有后继的处理对象，继续传递
			if (this.successor != null) {
				return successor.handleFeeRequest(user, fee);
			}
		}
		return str;
	}

	@Override
	public boolean handlePreFeeRequest(String user, double requestFee) {
		// 总经理的权限很大，只要请求到了这里，他都可以处理
		if (requestFee >= 1000) {
			// 为了测试，简单点，只同意小李的
			if ("小李".equals(user)) {
				System.out.println("总经理同意" + user + "聚餐费用" + requestFee + "元的请求");
			} else {
				// 其它人一律不同意
				System.out.println("总经理不同意" + user + "聚餐费用" + requestFee + "元的请求");
			}
		} else {
			// 如果还有后继的处理对象，继续传递
			if (this.successor != null) {
				return successor.handlePreFeeRequest(user, requestFee);
			}
		}
		return false;
	}
}