package com.coresales.service.customer.service;

import com.coresales.service.customer.Repository.CustomerRepository;
import com.coresales.service.customer.model.Customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository clienteRepository;

    public CustomerServiceImpl(CustomerRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> listar() {
        return new ArrayList<>(clienteRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Customer obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Customer crear(Customer cliente) {
        if (clienteRepository.existsByNumeroDocumento(cliente.getNumeroDocumento())) {
            throw new IllegalArgumentException("Ya existe un cliente con el número de documento indicado");
        }
        if (cliente.getActivo() == null) {
            cliente.setActivo(true);
        }
        //Customer guardado = clienteRepository.save(cliente);
        return clienteRepository.save(cliente);
    }

    @Override
    public Customer actualizar(Long id, Customer cliente) {
        Customer clienteBusqueda = obtenerPorId(id);
        if (!cliente.getNumeroDocumento().equals(clienteBusqueda.getNumeroDocumento())
                && clienteRepository.existsByNumeroDocumento(cliente.getNumeroDocumento())){
                throw new IllegalArgumentException("El número de documento ya pertenece a otro cliente");
        }
        Customer actualizado = clienteRepository.save(cliente);
        return actualizado;
    }

    @Override
    public void eliminar(Long id) {
        //Customer cliente = obtenerPorId(id);
        clienteRepository.deleteById(id);
    }
}
