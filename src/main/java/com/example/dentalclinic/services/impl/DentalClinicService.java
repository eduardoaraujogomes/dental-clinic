package com.example.dentalclinic.services.impl;

import java.util.List;

public interface DentalClinicService<T> {
    T save(T t);
    List<T> searchAll();
    T update(Integer id, T t);
    T searchById(Integer id);
    void delete(Integer id);
}
