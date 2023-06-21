package com.example.madrasa;

public class Student {
    private String name;
    private String age;
    private String s_class;
    private String sabaq;
    private String sabqi;
    private String manzil;
    public Student(String name, String age, String s_class, String sabaq, String sabqi, String manzil) {
        this.name = name;
        this.age = age;
        this.s_class = s_class;
        this.sabaq = sabaq;
        this.sabqi = sabqi;
        this.manzil = manzil;
    }

    public String getName() {
        return name;
    }



    public String getAge() {
        return age;
    }



    public String getS_Class() {
        return s_class;
    }



    public String getSabaq() {
        return sabaq;
    }



    public String getSabaqi() {
        return sabqi;
    }



    public String getManzil() {
        return manzil;
    }



    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", Class=" + s_class + ", sabaq=" + sabaq + ", sabaqi=" + sabqi + ", manzil=" + manzil +"]";
    }

}