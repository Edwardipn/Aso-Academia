/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Pizzeria.Pizzeria.dao;

import com.Pizzeria.Pizzeria.model.Articulo;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloDao extends CrudRepository<Articulo,String> {
    
}
