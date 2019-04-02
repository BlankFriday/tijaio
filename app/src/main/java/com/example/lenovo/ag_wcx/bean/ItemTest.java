package com.example.lenovo.ag_wcx.bean;

public class ItemTest {

    private int img;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "ItemTest{" +
                "img=" + img +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

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

    public ItemTest(int img, String name, int age) {

        this.img = img;
        this.name = name;
        this.age = age;
    }
}
