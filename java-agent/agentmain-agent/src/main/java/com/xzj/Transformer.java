/*
 *       Copyright© (2020) ICBC Co., Ltd.
 *
 *       This file is part of did-http-service.
 *
 *       did-http-service is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU Lesser General Public License as published by
 *       the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       did-http-service is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU Lesser General Public License for more details.
 *
 *       You should have received a copy of the GNU Lesser General Public License
 *       along with did-http-service.  If not, see <https://www.gnu.org/licenses/>.
 */


package com.xzj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;


/**
 * @Author: xuzj01@sdc.icbc.com.cn
 * @Description:
 * @File: Transformer
 * @Version: 1.0.0
 * @Date: 2020/1/8 10:52
 */

public class Transformer implements ClassFileTransformer {

    public static final String classNumberReturns2 = "TransClass.class.2.2";

    public static byte[] getBytesFromFile(String fileName) {
        try {
            // precondition
            File file = new File(fileName);
            InputStream is = new FileInputStream(file);
            long length = file.length();
            byte[] bytes = new byte[(int) length];

            // Read in the bytes
            int offset = 0;
            int numRead = 0;
            while (offset <bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset < bytes.length) {
                throw new IOException("Could not completely read file "
                        + file.getName());
            }
            is.close();
            return bytes;
        } catch (Exception e) {
            System.out.println("error occurs in _ClassTransformer!"
                    + e.getClass().getName());
            return null;
        }
    }




    /**
     * 参数：
     * loader - 定义要转换的类加载器；如果是引导加载器，则为 null
     * className - 完全限定类内部形式的类名称和 The Java Virtual Machine Specification 中定义的接口名称。例如，"java/util/List"。
     * classBeingRedefined - 如果是被重定义或重转换触发，则为重定义或重转换的类；如果是类加载，则为 null
     * protectionDomain - 要定义或重定义的类的保护域
     * classfileBuffer - 类文件格式的输入字节缓冲区（不得修改）
     * 返回：
     * 一个格式良好的类文件缓冲区（转换的结果），如果未执行转换,则返回 null。
     * 抛出：
     * IllegalClassFormatException - 如果输入不表示一个格式良好的类文件
     */

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!className.equals("com/xzj/TransClass")) {
            System.out.println(className);
            return null;
        }
        return getBytesFromFile(classNumberReturns2);
    }
}
