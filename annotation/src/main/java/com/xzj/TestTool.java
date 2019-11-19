package com.xzj;

import java.lang.reflect.Method;

/**
 * Create by xuzhijun.online on 2019/11/19.
 */
public class TestTool {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        NoBug testobj = new NoBug();

        Class clazz = testobj.getClass();

        Method[] method = clazz.getDeclaredMethods();
        //用来记录测试产生的 log 信息
        StringBuilder log = new StringBuilder();
        // 记录异常的次数
        int errornum = 0;

        for (Method m : method) {
            // 只有被 @Jiecha 标注过的方法才进行测试
            if (m.isAnnotationPresent(Jiecha.class)) {
                try {
                    m.setAccessible(true);
                    m.invoke(testobj, null);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    //e.printStackTrace();
                    errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    //记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }


        log.append(clazz.getSimpleName());
        log.append(" has  ");
        log.append(errornum);
        log.append(" error.");

        // 生成测试报告
        System.out.println(log.toString());

    }
}