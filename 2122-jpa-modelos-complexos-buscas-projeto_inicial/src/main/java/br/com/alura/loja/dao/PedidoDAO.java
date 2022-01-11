package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.RelatoriodeVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO {

    private EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        this.em.persist(pedido);
    }

    public void atualizar(Pedido pedido) {
        this.em.merge(pedido);
    }

    public void remover(Pedido pedido) {
        pedido = em.merge(pedido);
        this.em.remove(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return em.find(Pedido.class, id);
    }

    public BigDecimal valorTotalVendido(){
    String jqpl = "SELECT SUM(p.valorTotal) FROM Pedido p";
    return  em.createQuery(jqpl,BigDecimal.class).getSingleResult();
    }

    public List<RelatoriodeVendasVo> relatioriodeVenda(){

        String jpql = "SELECT new br.com.alura.loja.modelo.RelatoriodeVendasVo(produto.nome, " +
                "SUM(item.quantidade), " +
                "MAX(pedido.data)) " +
                "FROM Pedido pedido " +
                "JOIN pedido.itens item " +
                "JOIN item.produto produto " +
                "GROUP BY produto.nome " +
                "ORDER BY item.quantidade DESC";

        return em.createQuery(jpql,RelatoriodeVendasVo.class)
                .getResultList();

    }

}
