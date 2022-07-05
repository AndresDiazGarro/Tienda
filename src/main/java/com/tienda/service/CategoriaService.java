package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> getCategorias(boolean activo);

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria);//Realiza el trabajo de Create and Edit
    //Por medio del Id del objeto para saber si es necesario actualizarlo o crearlo del todo

    public void delete(Categoria categoria);
}
