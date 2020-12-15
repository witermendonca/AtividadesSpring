package com.lojaDomEletron.lojaDomEletron.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lojaDomEletron.lojaDomEletron.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);

	public List<Produto> findAllByMarcaContainingIgnoreCase(String marca);

	public List<Produto> findByPrecoBetween(BigDecimal precoIn, BigDecimal precoFim);

	public List<Produto> findByCategoriaProdutoIdAndPrecoLessThanEqual(long categoriaId, BigDecimal preco);

	@Query(value = "select * from tb_produto inner join tb_categoria on tb_categoria.id = tb_produto.categoria_produto_id inner join tb_tipo_eletro on tb_categoria.tipo_eletro_id = tb_tipo_eletro.id\r\n"
	  + "where tb_tipo_eletro.descricao like :descricao% and tb_produto.preco <= :valor", nativeQuery = true)
	public List<Produto> findByDesPreco(@Param("descricao") String descricao, @Param("valor") BigDecimal valor);

	@Query(value = "select * from tb_produto inner join tb_categoria on tb_categoria.id = tb_produto.categoria_produto_id inner join tb_tipo_eletro on tb_categoria.tipo_eletro_id = tb_tipo_eletro.id\r\n"
			+ "where tb_tipo_eletro.id =  :id and tb_produto.preco <= :valor", nativeQuery = true)
	public List<Produto> findByIdPreco(@Param("id") long id, @Param("valor") BigDecimal valor);
}
