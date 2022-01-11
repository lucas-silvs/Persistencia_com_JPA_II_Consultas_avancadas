package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.*;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {

    public static void main(String[] args) {

        popularBancoDeDados();



        EntityManager em = JPAUtil.getEntityManager();









        PedidoDAO pedidoDAO = new PedidoDAO(em);
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);


        em.getTransaction().begin();

        Produto produto = produtoDao.buscarPorId(1l);


        Cliente cliente = clienteDAO.buscarPorId(1l);

        Pedido pedido = new Pedido(cliente);

        pedidoDAO.cadastrar(pedido);
        ItemPedido itemPedido = new ItemPedido(10, pedido, produto);


        pedido.adicionarItem(itemPedido);

        em.getTransaction().commit();

        BigDecimal totalVendido = pedidoDAO.valorTotalVendido();

        List<RelatoriodeVendasVo> relatorio = pedidoDAO.relatioriodeVenda();
        relatorio.forEach(relatoriodeVendasVo -> System.out.println(relatoriodeVendasVo.toString()));
        System.out.println(totalVendido);
        em.close();



    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );

        Cliente cliente = new Cliente("Moço","23423533433");


        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        clienteDAO.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }
}
