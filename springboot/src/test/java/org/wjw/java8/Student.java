package org.wjw.java8;

/**
 * Created by SWGawain on 2017/5/12.
 */
public class Student {

    public final String haha(){
        return "aa";
    }

    public final String haha(String a){
        return a+"haha";
    }


    private String name ;
    private int age ;

    public Student(){

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void print(){
        System.out.println("String:name,int:age");
    }
//
//    public static void print(Student student){
//        System.out.println("String:name,int:age");
//        System.out.println("name:"+student.name);
//        System.out.println("age:"+student.age);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
