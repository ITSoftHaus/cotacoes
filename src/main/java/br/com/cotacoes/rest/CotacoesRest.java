package br.com.cotacoes.rest;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cotacoes.model.CotacoesModel;
import br.com.cotacoes.service.CotacoesService;
import br.com.cotacoes.util.DateParam;

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
	@Path("/listar/todas")
	public List<CotacoesModel> findAll() {
		return service.findAll();
	}
	
	@GET
	@Path("/listar/pordatacotacao/{dataCotacao}")
	public List<CotacoesModel> findByDataCotacao(@PathParam("dataCotacao") DateParam dataCotacao) {
		return service.findByDataCotacao(dataCotacao.getDate());
	}
	
	@GET
	@Path("/listar/pordatarequisicao/{dataRequisicao}")
	public List<CotacoesModel> findByDataRequisicao(@PathParam("dataRequisicao") DateParam dataRequisicao) {
		return service.findByDataCotacao(dataRequisicao.getDate());
	}
}
