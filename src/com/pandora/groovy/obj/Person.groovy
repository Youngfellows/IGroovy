package com.pandora.groovy.obj

/**
 * 1、Groovy中默认都是public的
 */
class Person implements Action, DefaultAction {
    /**
     * 名字
     */
    String name

    /**
     * 年龄
     */
    Integer age

    /**
     * 定义方法
     * @param years
     * @return
     */
    def increaseAge(Integer years) {
        this.age += years
    }

    @Override
    void eat() {
        println "吃米饭..."
    }

    @Override
    void drink() {
        println '喝王老吉...'
    }

    @Override
    void play() {
        println '玩毛线...'
    }

    @Override
    void walk() {
        println '走路...'
    }

    /**
     * 一个方法找不到时调用它代替
     * @param name
     * @param args
     * @return
     */
    @Override
    Object invokeMethod(String name, Object args) {
        return "the method is ${name}, the params is ${args}"
    }

    /**
     * 一个方法找不到时调用它代替
     * @param name
     * @param args
     * @return
     */
    def methodMissing(String name, def args) {
        return "the method ${name} is missing..."
    }
}
