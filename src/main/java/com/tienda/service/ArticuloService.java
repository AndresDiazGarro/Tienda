package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    public List<Articulo> getArticulos(boolean activo);

    public Articulo getArticulo(Articulo articulo);

    public void save(Articulo articulo);//Realiza el trabajo de Create and Edit
    //Por medio del Id del objeto para saber si es necesario actualizarlo o crearlo del todo

    public void delete(Articulo articulo);
}
