package com.epec.demo.business;

import com.epec.demo.model.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClienteBusiness implements IClienteBusiness{
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        em.persist(cliente);
    }
}
