package org.wjw.java8;

/**
 * Created by SWGawain on 2017/5/12.
 */
public interface StudentFactory<S extends Student> {

    S create(String name ,int age);
}
