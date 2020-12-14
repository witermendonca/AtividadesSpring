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

	@Query(value = "select * from tb_produto where preco >= :valorIn and preco <= :valorFim", nativeQuery = true)

	public List<Produto> RangePreco(@Param("valorIn") BigDecimal valorIn, @Param("valorFim") BigDecimal valorFim);

	//@Query(value = "select tb_produto.id,tb_produto.marca,tb_produto.nome,tb_produto.preco,tb_produto.quantidade,categoria_produto_id from tb_produto inner join tb_categoria on tb_categoria.id = tb_produto.categoria_produto_id where tb_categoria.tipo_eletro_id = :tipoId and  tb_produto.preco <= :valor  ", nativeQuery = true)

	@Query(value = "select * from tb_produto where preco <= :valor and categoria_produto_id = :tipoId ", nativeQuery = true)
	
	public List<Produto> RangeTipoPreco(@Param("tipoId") long tipoId, @Param("valor") BigDecimal valor);
}
