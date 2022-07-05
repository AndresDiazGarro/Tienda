package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;

public interface ClienteService {

    public List<Cliente> getClientes();

    public Cliente getCliente(Cliente cliente);

    public void save(Cliente cliente);//Realiza el trabajo de Create and Edit
    //Por medio del Id del objeto para saber si es necesario actualizarlo o crearlo del todo

    public void delete(Cliente cliente);
}
