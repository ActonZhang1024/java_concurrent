package pers.zhang.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author zhang
 * @date 2020/1/17 - 15:38
 */
public class AtomicIntegerFieldUpdaterTest {
    public static void main(String[] args) {
        //创建原子更新器，并设置需要更新的对象和属性
        AtomicIntegerFieldUpdater<User> aifu = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

        //设置tom为10岁
        User user = new User("tom", 10);
        //tom长了一岁，但是仍输出旧的年龄
        System.out.println(aifu.getAndIncrement(user));
        //输出tom现在的年龄
        System.out.println(aifu.get(user));

    }

    public static class User{
        public volatile String name;
        public volatile int age;

        public User(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}

