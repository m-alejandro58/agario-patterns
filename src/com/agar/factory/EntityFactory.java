package com.agar.factory;

/*
 * Factory Method
 *
 * Define el contrato para todas las fábricas.
 */
public interface EntityFactory<T> {

    T create();

}