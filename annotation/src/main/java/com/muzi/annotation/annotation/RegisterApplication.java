package com.muzi.annotation.annotation;

import com.muzi.annotation.enums.ThreadMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: lipeng
 * Date: 2019/7/14
 * Email: lipeng@moyi365.com
 * Content:
 * TODO: thread delay unused
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface RegisterApplication {

    /**
     * priority
     *
     * @return
     */
    int priority() default 0;

    /**
     * thread
     *
     * @return
     */
    ThreadMode thread() default ThreadMode.Main;

    /**
     * delay:milliseconds
     *
     * @return
     */
    long delay() default 0;

}
