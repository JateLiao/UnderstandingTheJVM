package com.lsj.understandingthejvm.part3.chapter7;

import java.io.InputStream;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.understandingthejvm.part3.chapter7
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2018/9/1620:04
 */
public class ClassLoaderTest {
    /**
     * 类加载器  学习篇.
     */
    
    /**
     * main method.
     **/
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.indexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (null == inputStream) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read();
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return super.loadClass(name, resolve);
            }
        };
        
        Object obj = classLoader.loadClass("com.lsj.understandingthejvm.part3.chapter7.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass().toString());
        System.out.println(obj instanceof com.lsj.understandingthejvm.part3.chapter7.ClassLoaderTest);
    }
}
