package br.com.cotacoes.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CotacoesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private BigDecimal cotacaoCompra;
	
	@JsonProperty
	private BigDecimal cotacaoVenda;
	
	@JsonProperty
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataHoraCotacao;
	
	private String dataRequisicao;
	
	private String dataCotacao;
	
	public CotacoesDTO() {
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

	public String getDataRequisicao() {
		return dataRequisicao;
	}

	public void setDataRequisicao(String dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}

	public String getDataCotacao() {
		return dataCotacao;
	}

	public void setDataCotacao(String dataCotacao) {
		this.dataCotacao = dataCotacao;
	}
	
	
}
