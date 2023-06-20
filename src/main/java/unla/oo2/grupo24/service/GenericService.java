package unla.oo2.grupo24.service;

import java.util.List;

public interface GenericService<T> {
    
    public abstract boolean add(T object);

    public abstract List<T> getAll();

    public abstract T getById(long id);

    public abstract T modify(long id);

    public abstract boolean delete(long id);

}
