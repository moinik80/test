//interface with basic method

package by.jd2.library.services;

import java.io.Serializable;

public interface IService<T> {

    void add(T t);

    void update(T t);

    T get(Class<T> clazz, Serializable id);

    void delete(T t);

    void refresh(T t);
}
