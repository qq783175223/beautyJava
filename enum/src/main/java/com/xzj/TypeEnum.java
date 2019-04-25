package com.xzj;

/**
 * 
 * 常用类型(带参数的枚举常量，这个只是在书上不常见，实际使用还是很多的，看懂这个，使用就不是问题啦。)
 * 
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月25日 下午4:50:53
 */
public enum TypeEnum {
	FIREWALL("firewall"), SECRET("secretMac"), BALANCE("f5");

	private String typeName;

	TypeEnum(String typeName) {
        this.typeName = typeName;
    }

	/**
	 * 根据类型的名称，返回类型的枚举实例。
	 *
	 * @param typeName 类型名称
	 */
	public static TypeEnum fromTypeName(String typeName) {
		for (TypeEnum type : TypeEnum.values()) {
			if (type.getTypeName().equals(typeName)) {
				return type;
			}
		}
		return null;
	}

	public String getTypeName() {
		return this.typeName;
	}
}
