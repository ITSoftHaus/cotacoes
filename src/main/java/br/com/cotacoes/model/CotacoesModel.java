package br.com.cotacoes.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cotacoes")
@NamedQueries({
		@NamedQuery(name = "CotacoesModel.findAll", query = "Select c from CotacoesModel c Order by dataCotacao"),
		@NamedQuery(name = "CotacoesModel.findByDataCotacao", 
		            query = "Select c from CotacoesModel c WHERE c.dataCotacao = :dataCotacao Order by dataCotacao",
		            hints = @QueryHint(name = "org.hibernate.cacheable", value = "true")),
		@NamedQuery(name = "CotacoesModel.findByDataRequisicao", 
                    query = "Select c from CotacoesModel c WHERE c.dataRequisicao = :dataRequisicao Order by dataRequisicao",
                    hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
})
@SequenceGenerator(name = "cotacoesidseq", sequenceName = "cotacoes_id_seq", allocationSize = 1, initialValue = 10)
@Cacheable
public class CotacoesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cotacoesidseq")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_requisicao")
	private Date dataRequisicao;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cotacao")
	private Date dataCotacao;

	@Column(name = "cotacao_compra")
	private BigDecimal cotacaoCompra;

	@Column(name = "cotacao_venda")
	private BigDecimal cotacaoVenda;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora_cotacao")
	private Date dataHoraCotacao;

	public Long getId() {
		return id;
	}

	public Date getDataRequisicao() {
		return dataRequisicao;
	}

	public void setDataRequisicao(Date dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}

	public Date getDataCotacao() {
		return dataCotacao;
	}

	public void setDataCotacao(Date dataCotacao) {
		this.dataCotacao = dataCotacao;
	}

	public BigDecimal getCotacaoCompra() {
		return cotacaoCompra;
	}

	public void setCotacaoCompra(BigDecimal cotacaoCompra) {
		this.cotacaoCompra = cotacaoCompra;
	}

	public BigDecimal getCotacaoVenda() {
		return cotacaoVenda;
	}

	public void setCotacaoVenda(BigDecimal cotacaoVenda) {
		this.cotacaoVenda = cotacaoVenda;
	}

	public Date getDataHoraCotacao() {
		return dataHoraCotacao;
	}

	public void setDataHoraCotacao(Date dataHoraCotacao) {
		this.dataHoraCotacao = dataHoraCotacao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cotacaoCompra == null) ? 0 : cotacaoCompra.hashCode());
		result = prime * result + ((cotacaoVenda == null) ? 0 : cotacaoVenda.hashCode());
		result = prime * result + ((dataCotacao == null) ? 0 : dataCotacao.hashCode());
		result = prime * result + ((dataHoraCotacao == null) ? 0 : dataHoraCotacao.hashCode());
		result = prime * result + ((dataRequisicao == null) ? 0 : dataRequisicao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacoesModel other = (CotacoesModel) obj;
		if (cotacaoCompra == null) {
			if (other.cotacaoCompra != null)
				return false;
		} else if (!cotacaoCompra.equals(other.cotacaoCompra))
			return false;
		if (cotacaoVenda == null) {
			if (other.cotacaoVenda != null)
				return false;
		} else if (!cotacaoVenda.equals(other.cotacaoVenda))
			return false;
		if (dataCotacao == null) {
			if (other.dataCotacao != null)
				return false;
		} else if (!dataCotacao.equals(other.dataCotacao))
			return false;
		if (dataHoraCotacao == null) {
			if (other.dataHoraCotacao != null)
				return false;
		} else if (!dataHoraCotacao.equals(other.dataHoraCotacao))
			return false;
		if (dataRequisicao == null) {
			if (other.dataRequisicao != null)
				return false;
		} else if (!dataRequisicao.equals(other.dataRequisicao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
