/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tn.brainstormers.services;

import java.util.List;

/**
 *
 * @author sami
 */
public interface IService<T> {

    void create(T t);

    List<T> read();
    //void update(T t);
    //void delete(T t);
}
