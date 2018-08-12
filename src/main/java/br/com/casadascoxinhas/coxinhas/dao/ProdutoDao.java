package br.com.casadascoxinhas.coxinhas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadascoxinhas.coxinhas.model.Produto;

/**
 * Created by Gabrioti on 12/08/2018.
 */
@Repository
public class ProdutoDao {

    @PersistenceContext
    private EntityManager manager;

    public Produto findOne(Integer id) {

        return manager.find(Produto.class, id);
    }

    public void save(Produto produto) {
        manager.merge(produto);
    }

    public List<Produto> findAll() {
        return manager.createQuery("select pr from Produto pr", Produto.class).getResultList();
    }

    public void delete(Integer id) {
        manager.remove(findOne(id));
    }
}
