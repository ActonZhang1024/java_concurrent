package pers.zhang.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhang
 * @date 2020/1/17 - 15:21
 */
public class AtomicReferenceTest {
    public static void main(String[] args) {
        AtomicReference<User> arf = new AtomicReference<User>();

        User user = new User("tom", 18);
        arf.set(user);//传入引用
        User updateUser = new User("TOM", 88);
        arf.compareAndSet(user, updateUser);//比较，如果一致，就更新。
        System.out.println(arf.get().getName());
        System.out.println(arf.get().getAge());

    }
}

class User{
    private String name;
    private int age;

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