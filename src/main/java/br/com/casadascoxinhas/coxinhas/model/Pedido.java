package br.com.casadascoxinhas.coxinhas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Gabrioti on 12/08/2018.
 */
@Entity
public class Pedido {

    @Id
    @GeneratedValue
    private Integer id;
	private Integer quantidade;
    @NotBlank
    private Produto produto;
    private Calendar dataEntrega;
    @NotBlank
    private Cliente cliente;
    private Preco preco;
    
    
    
    /**
     * @deprecated hibernate only
     */

    public Pedido(Integer Id, Integer quantidade, Produto produto, Calendar dataEntrega, Cliente cliente, Preco preco) {
    	this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
		this.dataEntrega = dataEntrega;
		this.cliente = cliente;
		this.preco = preco;
	}
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Preco getPreco() {
		return preco;
	}
	
	public void setPreco(Preco preco) {
		this.preco = preco;
	}
}
