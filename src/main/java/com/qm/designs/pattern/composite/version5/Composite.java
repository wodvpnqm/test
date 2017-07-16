package com.qm.designs.pattern.composite.version5;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
	public String getName() {
		return this.name;
	}

	public void addChild(Component child) {
		// 延迟初始化
		if (childComponents == null) {
			childComponents = new ArrayList<Component>();
		}
		childComponents.add(child);

		// 先判断组件路径是否为空，如果为空，说明本组件是根组件
		if (this.getComponentPath() == null || this.getComponentPath().trim().length() == 0) {
			// 把本组件的name设置到组件路径中
			this.setComponentPath(this.name);
		}
		// 判断要加入的组件在路径上是否出现过
		// 先判断是否是根组件
		if (this.getComponentPath().startsWith(child.getName() + ".")) {
			// 说明是根组件，重复添加了
			throw new java.lang.IllegalArgumentException("在本通路上，组件 '" + child.getName() + "' 已被添加过了");
		} else {
			if (this.getComponentPath().indexOf("." + child.getName()) < 0) {
				// 表示没有出现过,那么可以加入
				// 计算组件的路径
				String componentPath = this.getComponentPath() + "." + child.getName();
				// 设置子组件的路径
				child.setComponentPath(componentPath);
			} else {
				throw new java.lang.IllegalArgumentException("在本通路上，组件 '" + child.getName() + "' 已被添加过了");
			}
		}
	}

	/*---------------以下是原有的实现，没有变化------------------*/
	private List<Component> childComponents = null;
	private String name = "";

	public Composite(String name) {
		this.name = name;
	}

	public void printStruct(String preStr) {
		System.out.println(preStr + "+" + this.name);
		if (this.childComponents != null) {
			preStr += " ";
			for (Component c : childComponents) {
				c.printStruct(preStr);
			}
		}
	}
}