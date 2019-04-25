package com.xzj;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月25日 下午4:54:13
 */
public class Test {
	public static void main(String[] args) {
		forEnum();
		System.out.println("------------------");
		useEnumInJava();
		System.out.println("------------------");
		testSwitchCase();
	}

	/**
	 * 循环枚举,输出ordinal属性；若枚举有内部属性，则也输出。(说的就是我定义的TYPE类型的枚举的typeName属性)
	 */
	private static void forEnum() {
		for (SeasonEnum simpleEnum : SeasonEnum.values()) {
			System.out.println(simpleEnum + "  ordinal  " + simpleEnum.ordinal());
		}
		System.out.println("");
		for (TypeEnum type : TypeEnum.values()) {
			System.out.println("type = " + type + "    type.name = " + type.name() + "   typeName = "
					+ type.getTypeName() + "   ordinal = " + type.ordinal());
		}
	}

	/**
	 * 在Java代码使用枚举
	 */
	private static void useEnumInJava() {
		String typeName = "f5";
		TypeEnum type = TypeEnum.fromTypeName(typeName);
		if (TypeEnum.BALANCE.equals(type)) {
			System.out.println("根据字符串获得的枚举类型实例跟枚举常量一致");
		} else {
			System.out.println("大师兄代码错误");
		}

	}
	
    private static void testSwitchCase() {
        String typeName = "f5";
        //这几行注释呢，你可以试着三选一，测试一下效果。
        //String typeName = "firewall";
        //String typeName = "secretMac";
        TypeEnum typeEnum = TypeEnum.fromTypeName(typeName);
        if (typeEnum == null) {
            return;
        }
        switch (typeEnum) {
            case FIREWALL:
                System.out.println("枚举名称(即默认自带的属性 name 的值)是：" + typeEnum.name());
                System.out.println("排序值(默认自带的属性 ordinal 的值)是：" + typeEnum.ordinal());
                System.out.println("枚举的自定义属性 typeName 的值是：" + typeEnum.getTypeName());
                break;
            case SECRET:
                System.out.println("枚举名称(即默认自带的属性 name 的值)是：" + typeEnum.name());
                System.out.println("排序值(默认自带的属性 ordinal 的值)是：" + typeEnum.ordinal());
                System.out.println("枚举的自定义属性 typeName 的值是：" + typeEnum.getTypeName());
                break;
            case BALANCE:
                System.out.println("枚举名称(即默认自带的属性 name 的值)是：" + typeEnum.name());
                System.out.println("排序值(默认自带的属性 ordinal 的值)是：" + typeEnum.ordinal());
                System.out.println("枚举的自定义属性 typeName 的值是：" + typeEnum.getTypeName());
                break;
            default:
                System.out.println("default");
        }
    }
}
