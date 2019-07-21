package com.muzi.annotation;

import com.muzi.annotation.enums.ThreadMode;

/**
 * Author: lipeng
 * Date: 2019/7/14
 * Email: lipeng@moyi365.com
 * Content:
 */
public class RegisterApplicationPackage implements Comparable<RegisterApplicationPackage> {

    private String clazz;

    private int priority;

    private long delay;

    private ThreadMode mode;

    public RegisterApplicationPackage() {
    }

    public RegisterApplicationPackage(String clazz, int priority, long delay, ThreadMode mode) {
        this.clazz = clazz;
        this.priority = priority;
        this.delay = delay;
        this.mode = mode;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public ThreadMode getMode() {
        return mode;
    }

    public void setMode(ThreadMode mode) {
        this.mode = mode;
    }

    @Override
    public int compareTo(RegisterApplicationPackage o) {
        if (o == null) {
            return -1;
        }
        return o.priority - this.priority;
    }
}
