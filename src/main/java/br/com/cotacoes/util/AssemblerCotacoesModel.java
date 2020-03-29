package br.com.cotacoes.util;

import br.com.cotacoes.dto.CotacoesDTO;
import br.com.cotacoes.model.CotacoesModel;

public class AssemblerCotacoesModel {

	public static CotacoesModel assemblerFromDto(CotacoesDTO dto) {
		
		CotacoesModel model = new CotacoesModel();
		
		model.setCotacaoCompra(dto.getCotacaoCompra());
		model.setCotacaoVenda(dto.getCotacaoVenda());
		model.setDataHoraCotacao(dto.getDataHoraCotacao());
		model.setDataRequisicao(dto.getDataRequisicao());
		model.setDataCotacao(dto.getDataCotacao());
		
		return model;
	}
}
