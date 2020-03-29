package br.com.cotacoes.rest;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.cotacoes.model.CotacoesModel;
import br.com.cotacoes.service.CotacoesService;

@Path("/cotacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CotacoesRest {

	@Inject
	CotacoesService service;

	@POST
	@Transactional
	public List<CotacoesModel> salvar(CotacoesModel cotacoes) {
		service.save(cotacoes);
		return findAll();
	}

	@GET
	@Path("/cotacaodia/{dataCotacao}")
	public List<CotacoesModel> getCotacaoDia(@PathParam String dataCotacao) {
		return service.getAndSaveCotacaoDia(dataCotacao);
	}

	@GET
	@Path("/cotacaoperiodo/{dataCotacaoInicio}/{dataCotacaoFim}")
	public List<CotacoesModel> getCotacaoPeriodo(@PathParam String dataCotacaoInicio,
			@PathParam("dataCotacaoFim") String dataCotacaoFim) {
		return service.getAndSaveCotacaoPeriodo(dataCotacaoInicio, dataCotacaoFim);
	}

	@GET
	@Path("/listar/todas")
	public List<CotacoesModel> findAll() {
		return service.findAll();
	}

	@GET
	@Path("/listar/pordatacotacao/{dataCotacao}")
	public List<CotacoesModel> findByCotacaoData(@PathParam String dataCotacao) {
		return service.findByCotacaoData(dataCotacao);
	}

	@GET
	@Path("/listar/pordatarequisicao/{dataRequisicao}")
	public List<CotacoesModel> findByDataRequisicao(@PathParam String dataRequisicao) {
		return service.findByDataRequisicao(dataRequisicao);
	}
}
