package com.example.lenovo.ag_wcx.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Item {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private int img;
    @Property
    private String name;
    @Property
    private int age;
    @Generated(hash = 194673058)
    public Item(Long id, int img, String name, int age) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 1470900980)
    public Item() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getImg() {
        return this.img;
    }
    public void setImg(int img) {
        this.img = img;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
