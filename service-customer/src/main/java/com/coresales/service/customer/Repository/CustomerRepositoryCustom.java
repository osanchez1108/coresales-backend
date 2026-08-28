package com.coresales.service.customer.Repository;

import com.coresales.service.customer.model.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> listarClientes();
    Customer buscarCliente(Long id);
/*    Customer crearCliente(Customer cliente);
    Customer actualizarCliente(Long id, Customer cliente);;
    void eliminarCliente(Long id);*/

}
