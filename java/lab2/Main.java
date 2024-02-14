package lab2;

import java.lang.reflect.*;
import java.util.NoSuchElementException;

public class Main {
    public static void main(){

        try {
            Class test = TestClass.class;

            Method[] methods = test.getDeclaredMethods();
            Object object = test.getConstructor().newInstance();

            for (Method method: methods) {
                if (!Modifier.isPublic(method.getModifiers())) {
                    if (Modifier.isPrivate(method.getModifiers())) {
                        method.setAccessible(true);
                    }
                    MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                    if (annotation != null) {
                        for (int i = 0; i < annotation.value(); i++) {
                            method.invoke(object, "Sam");
                        }
                        System.out.println();
                    }
                }
            }
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException exception) {
            exception.printStackTrace();
        }
    }
}