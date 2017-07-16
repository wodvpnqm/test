package com.qm.designs.pattern.composite.version4;

import java.util.List;

public abstract class Component {
	/**
	 * 记录父组件对象
	 */
	private Component parent = null;

	/**
	 * 获取一个组件的父组件对象
	 * 
	 * @return 一个组件的父组件对象
	 */
	public Component getParent() {
		return parent;
	}

	/**
	 * 设置一个组件的父组件对象
	 * 
	 * @param parent
	 *            一个组件的父组件对象
	 */
	public void setParent(Component parent) {
		this.parent = parent;
	}

	/**
	 * 返回某个组件的子组件对象
	 * 
	 * @return 某个组件的子组件对象
	 */
	public List<Component> getChildren() {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	/*-------------------以下是原有的定义----------------------*/
	public abstract void printStruct(String preStr);

	public void addChild(Component child) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	public void removeChild(Component child) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	public Component getChildren(int index) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}
}