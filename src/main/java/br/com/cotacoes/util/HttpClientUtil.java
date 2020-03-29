package br.com.cotacoes.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cotacoes.dto.CotacoesListValue;

@ApplicationScoped
public class HttpClientUtil {

	private final String URL = "olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata";
	private final String PATH_COTACAO_DIA = "/CotacaoDolarDia(dataCotacao=@dataCotacao)";
	private final String PATH_COTACAO_PERIODO = "/CotacaoDolarPeriodo(dataInicial=@dataInicial,dataFinalCotacao=@dataFinalCotacao)";
	private final ObjectMapper MAPPER = new ObjectMapper();

	public CotacoesListValue getCotacaoDia(String dataCotacao) {
		String data = "'"+dataCotacao+"'";
		CotacoesListValue values = httpClientConect(data, null, PATH_COTACAO_DIA);
		return values;
	}
	
	public CotacoesListValue getCotacaoDia(String dataCotacaoInicio, String dataCotacaoFim) {
		String dataInicio = "'"+dataCotacaoInicio+"'";
		String dataFim = "'"+dataCotacaoFim+"'";
		CotacoesListValue values = httpClientConect(dataInicio, dataFim, PATH_COTACAO_PERIODO);
		return values;
	}

	private CotacoesListValue httpClientConect(String dataCotacaoInicio, 
			String dataCotacaoFim, String path) {
		
		System.out.println("LOG httpClientConect DataInicio: " + dataCotacaoInicio + "  DataFim: " + dataCotacaoFim);
		
		HttpClient httpclient = HttpClients.createDefault();
		CotacoesListValue values = null;
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		if(dataCotacaoInicio != null && dataCotacaoFim != null) {
			params.add(new BasicNameValuePair("@dataInicial", dataCotacaoInicio));
			params.add(new BasicNameValuePair("@dataFinalCotacao", dataCotacaoFim));
		} else {
			params.add(new BasicNameValuePair("@dataCotacao", dataCotacaoInicio));
		}
		
		try {
			URI uri = new URIBuilder()
					.setScheme("https")
					.setHost(URL)
					.setPath(PATH_COTACAO_DIA)
					.addParameters(params)
					.addParameter("format", "json")
					.addParameter("top", "100")
					.build();
			
			System.out.println("LOG httpClientConect URL " + uri);
			
			HttpGet httpget = new HttpGet(uri);
			HttpResponse response = httpclient.execute(httpget);
			StatusLine status = response.getStatusLine();
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity);
			
			System.out.println("LOG httpClientConect STATUS " + uri);
			
			if (status.getStatusCode() == HttpStatus.SC_OK) {
				MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				values = MAPPER.readValue(content.toString(), CotacoesListValue.class);				
			}
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return values;
	}
}
