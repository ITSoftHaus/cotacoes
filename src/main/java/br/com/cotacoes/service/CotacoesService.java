package br.com.cotacoes.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.com.cotacoes.dto.CotacoesDTO;
import br.com.cotacoes.dto.CotacoesListValue;
import br.com.cotacoes.model.CotacoesModel;
import br.com.cotacoes.repository.CotacoesRepository;
import br.com.cotacoes.util.AssemblerCotacoesModel;
import br.com.cotacoes.util.HttpClientUtil;

@ApplicationScoped
public class CotacoesService {
	
	@Inject
	CotacoesRepository repo;
	
	@Inject
	HttpClientUtil clientUtil;
	
	public List<CotacoesModel> getAndSaveCotacaoDia(String dataCotacao) {		
		CotacoesListValue value = clientUtil.getCotacaoDia(dataCotacao);		
		value.getValue().forEach((cotacao) -> {
			CotacoesDTO dto = cotacao;
			dto.setDataCotacao(dataCotacao);
			dto.setDataRequisicao(dataCotacao);
			CotacoesModel model = AssemblerCotacoesModel.assemblerFromDto(dto);
			repo.save(model);
		});		
		return repo.findByCotacaoData(dataCotacao);
	}
	
	public List<CotacoesModel> getAndSaveCotacaoPeriodo(String dataCotacaoInicio, String dataCotacaoFim) {		
		CotacoesListValue value = clientUtil.getCotacaoDia(dataCotacaoInicio, dataCotacaoFim);		
		value.getValue().forEach((cotacao) -> {
			CotacoesDTO dto = cotacao;
			dto.setDataCotacao(dataCotacaoInicio);
			dto.setDataRequisicao(dataCotacaoFim);
			CotacoesModel model = AssemblerCotacoesModel.assemblerFromDto(dto);
			repo.save(model);
		});
		
		return repo.findByCotacaoPeriodo(dataCotacaoInicio, dataCotacaoFim);
	}
	
	public Response save(CotacoesModel cotacoes) {
		return repo.save(cotacoes);
	}
	
	public List<CotacoesModel> findAll() {
		return repo.findAll();
	}
	
	public List<CotacoesModel> findByCotacaoData(String dataCotacao) {		
		return repo.findByCotacaoData(dataCotacao);
	}
	
	public List<CotacoesModel> findByDataRequisicao(String dataRequisicao) {
		return repo.findByDataRequisicao(dataRequisicao);
	}
}
