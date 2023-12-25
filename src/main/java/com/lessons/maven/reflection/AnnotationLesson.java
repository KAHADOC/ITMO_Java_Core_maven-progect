package com.lessons.maven.reflection;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationLesson {

    public static void main(String[] args) {

        Class<Text> textClass = Text.class;
        // получим все аннотации класса
        Annotation[] annotations = textClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        // проверим наличие аннотации
        if (textClass.isAnnotationPresent(ClassConfig.class)){
            System.out.println("ClassConfig");
            // получим ссылку на аннотацию
            ClassConfig classConfig = textClass.getDeclaredAnnotation(ClassConfig.class);
            // получим значения prefix и version
            System.out.println(classConfig.prefix());
            System.out.println(classConfig.version());
        }

        // получим аннотации полей класса
        Field[] fields = textClass.getDeclaredFields();
        for (Field field: fields){
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            System.out.println(Arrays.toString(fieldAnnotations));
            if (field.isAnnotationPresent(Required.class)){
                System.out.println("поле с Required");
            }
        }

        // ДЗ к понедельнику
        // выбрать наиболее важные (интересные) на Ваш взгляд! методы
        // Class
        // Field
        // Method
        // Modifier

        // 1. написать рефлексивный статический static toString(Object o)
        // вывести информацию по полям объекта, используя рефлексию:
        // название поля: значение поля
//        примитивы / строки
    //        age: 67
    //        login: qwe
//        User user
//        user : @hashCode
//        int[] data
//        data: @hashCode
        // isArray() / isEnum() / isPrimitive() для дз

        // 2. если класс аннотирован аннотацией ConfigClass,
        // создать объект данного класса (использовать рефлексию!)
        // если поле отмечено аннотацией @Required - установить значение
        // данного поля (значение любое!)
        // значение поля установить через сеттер!!!
        // stringData / setStringData
        // age / setAge
        // field.getName()
        // field.getType()
        // у созданного объекта вызвать метод public String toString(),
        // используя рефлексию

    }

}