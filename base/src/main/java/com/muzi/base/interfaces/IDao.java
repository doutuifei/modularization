package com.muzi.base.interfaces;

import java.util.List;

/**
 * Author: lipeng
 * Date: 2019/7/23
 * Email: lipeng@moyi365.com
 * Content:
 */
public interface IDao<T> {

    void insert(T... t);

    void delete(T... t);

    List<T> getAll();

}
