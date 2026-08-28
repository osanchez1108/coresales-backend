package com.coresales.service.customer.Repository;

import com.coresales.service.customer.model.Customer;
import jakarta.persistence.*;

import java.util.List;

public class CustomerRepositoryCustomImpl  implements  CustomerRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public CustomerRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> listarClientes() {
        StoredProcedureQuery query =entityManager.createStoredProcedureQuery("usp_Cliente_Listar", Customer.class);
        query.execute();
        return  query.getResultList();
    }

    @Override
    public Customer buscarCliente(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Cliente_ObtenerPorId",Customer.class);
        query.registerStoredProcedureParameter("ClienteId", Long.class, ParameterMode.IN);
        query.setParameter("ClienteId", id);
        query.execute();
        List<Customer> listaClientes = query.getResultList();
        return  listaClientes.isEmpty() ? null : listaClientes.get(0);
    }

/*    @Override
    public Customer crearCliente(Customer cliente) {

    }

    @Override
    public Customer actualizarCliente(Long id, Customer cliente) {

    }

    @Override
    public void eliminarCliente(Long id) {

    }*/
}
