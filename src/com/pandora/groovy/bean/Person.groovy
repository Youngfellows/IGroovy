package com.pandora.groovy.bean

/**
 * 定义对象Peson
 */
class Person implements Serializable{
    /**
     * 名字
     */
    String name

    /**
     * 年龄
     */
    int age

    /**
     * 工作
     */
    String job

    Person(String name, int age, String job) {
        this.name = name
        this.age = age
        this.job = job
    }

    Person() {

    }

    int getAge() {
        return age
    }

    void setAge(int age) {
        this.age = age
    }

    String getJob() {
        return job
    }

    void setJob(String job) {
        this.job = job
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name=" + name +
                ", age=" + age +
                ", job=" + job +
                '}';
    }
}