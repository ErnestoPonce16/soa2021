package com.epec.demo.business;
import com.epec.demo.model.Cliente;
import java.util.List;

public interface IClienteBusiness {

    public List<Cliente> findAll();

    public void save(Cliente cliente);
}
