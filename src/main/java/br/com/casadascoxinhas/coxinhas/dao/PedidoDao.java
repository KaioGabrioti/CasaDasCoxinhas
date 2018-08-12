package br.com.casadascoxinhas.coxinhas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadascoxinhas.coxinhas.model.Pedido;

/**
 * Created by Gabrioti on 12/08/2018.
 */
@Repository
public class PedidoDao {

    @PersistenceContext
    private EntityManager manager;


    public Pedido findOne(Integer id) {
        return manager.find(Pedido.class, id);
    }

    public void save(Pedido pedido) {
        manager.persist(pedido);
    }

    public List<Pedido> findAll() {
        return manager.createQuery("select p from Pedido p", Pedido.class).getResultList();
    }

    public void delete(Integer id) {
        manager.remove(findOne(id));
    }
}
