package com.lessons.maven.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionLesson {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
         /*
        Рефлексия в Java — это механизм, с помощью которого можно вносить изменения
        и получать информацию о классах, интерфейсах, полях и методах
        во время выполнения, при этом не зная имен этих классов, методов и полей.
        Кроме того, Reflection API дает возможность создавать новые экземпляры классов,
        вызывать методы, а также получать или устанавливать значения полей.
        */

        // Все классы в языке являются объектами типа Class (примитивы тоже являются объектами типа Class).
        Class<String> stringClass = String.class; // ссылка на класс String
        System.out.println(stringClass);
        Class<Integer> intClass = int.class; // ссылка на int
        System.out.println(intClass);

        Text text = new Text("qwerty");
        text.setText("Все классы в языке являются объектами");

        Class<Text> textClass = Text.class;
        System.out.println(textClass);

        // ввиду полиморфизма фактический класс объекта text - не обязательно Text, это может быть любой подкласс
        Class<? extends Text> textClass2 = text.getClass();
        System.out.println(textClass2);

        // вызвав методы объектов типа Class получим название класса, название пакета
        System.out.println(textClass.getPackageName());
        System.out.println(textClass.getName());
        System.out.println(textClass.getSimpleName());

        // получим интерфейсы, которые имплементирует класс
        Class<?>[] interfaces = textClass.getInterfaces(); // только интерфейсы самого класса (интерфейсы родителя не учитываются)
        System.out.println(Arrays.toString(interfaces));
        // получим родительский класс
        System.out.println(textClass.getSuperclass()); // Message
        System.out.println(textClass.getSuperclass().getSuperclass()); // Object
        System.out.println(textClass.getSuperclass().getSuperclass().getSuperclass()); // null
        // получим интерфейсы родительского класса
        System.out.println(Arrays.toString(textClass.getSuperclass().getInterfaces())); // Comparable

        // доступ к компонентам класса
        textClass = Text.class;

        // доступ к полям класса
        // возвращает все публичные поля класса (включая родительские)
        Field[] fields = textClass.getFields();
        // при переборе по каждому методу можно узнать
        // какие у него параметры, модификатор, тип возвращаемого значения и тд
        System.out.println(Arrays.toString(fields));

        // возвращает все поля класса (включая private и protected)
        Field[] declaredFields = textClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        // доступ к методам
        // возвращает все публичные методы класса (включая родительские)
        Method[] methods = textClass.getMethods();
        System.out.println(Arrays.toString(methods));

        // возвращает все методы класса (включая private и protected)
        Method[] declaredMethods = textClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        // доступ к конструкторам
        Constructor<?>[] declaredConstructors = textClass
                .getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        // создадим объект, используя рефлексию

        // получим конструктор
        // необходимо знать, последовательность аргументов и их типы
        Constructor<Text> tmConstructor = textClass
                .getDeclaredConstructor(String.class);
        // создадим объект, используя конструктор
        Text reflectMessage = tmConstructor
                .newInstance("Reflect Message");

        // получим доступ к полю private String text;
        Field field = textClass
                .getDeclaredField("text"); // text - название поля
        System.out.println(field.getType()); // получим ссылку на тип поля java.lang.String
        System.out.println(field.getName());
        field.setAccessible(true); // установим возможность работать с private полями
        // возвращает значение поля для конкретного объекта, если позволяет модификатор доступа,
        // в противном случае - IllegalAccessException
        System.out.println(field.get(reflectMessage)); // получим значение поля объекта reflectMessage
        // устанавливает значение поля для конкретного объекта, если позволяет модификатор доступа,
        // в противном случае - IllegalAccessException
        field.set(reflectMessage, "Значение поля установлено через рефлексию"); // установим значение поля объекта reflectMessage
        System.out.println(field.get(reflectMessage)); // получим значение поля объекта reflectMessage
        System.out.println(reflectMessage.getText());

        // получим доступ к методу private void printInfo(String prefix);
        // необходимо знать, последовательность аргументов и их типы
        Method method = textClass.getDeclaredMethod("setText", String.class);
        method.setAccessible(true); // установим возможность работать с private методами
        method.invoke(reflectMessage, "!!!"); // вызовем метод, передадим аргументы

        for (Method m: declaredMethods) {
            System.out.println(Arrays.toString(m.getGenericParameterTypes()));
            System.out.println(m.getGenericReturnType());
        }

        // https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html
        boolean isPrivate = Modifier.isPrivate(field.getModifiers());
        System.out.println("'text' is private " + isPrivate);

        // Правила инкапсуляции, наличие геттеров и сеттеров, конструктор без параметров
        // Для дз
        System.out.println(field.getName());
    }
}