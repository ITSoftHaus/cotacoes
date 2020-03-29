package br.com.cotacoes.dto;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CotacoesListValue implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private List<CotacoesDTO> value;
	
	public CotacoesListValue() {
	}

	public List<CotacoesDTO> getValue() {
		return value;
	}

	public void setValue(List<CotacoesDTO> value) {
		this.value = value;
	}	
}
