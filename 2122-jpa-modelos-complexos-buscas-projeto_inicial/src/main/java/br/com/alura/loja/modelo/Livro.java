package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import java.math.BigDecimal;
@Entity
public class Livro extends  Produto{

    private String autor;
    private  Integer numPaginas;

    public Livro() {
    }

    public Livro(String autor, Integer numPaginas) {
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    public Livro(String nome, String descricao, BigDecimal preco, Categoria categoria, String autor, Integer numPaginas) {
        super(nome, descricao, preco, categoria);
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }
}
