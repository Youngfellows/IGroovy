package com.pandora.groovy.obj

/**
 * 类似于java中的抽象类
 */
trait DefaultAction {
    /**
     * 走路
     */
    abstract void walk()

    /**
     * 方法的默认实现
     */
    void driving() {
        println '开拖拉机...'
    }
}