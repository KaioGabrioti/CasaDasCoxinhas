package br.com.casadascoxinhas.coxinhas.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Gabrioti on 12/08/2018.
 */
@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String nome;
    

    /**
     * @deprecated hibernate only
     */
    public Produto(Integer id, String nome) {
    	this.id = id;
    	this.nome = nome;
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
