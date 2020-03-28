package br.com.cotacoes.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class DateParam {
	private final Date date;

	public DateParam(String data) throws WebApplicationException {
		
		if (data.isEmpty()) {
			this.date = null;
			return;
		}
		
		final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			this.date = dateFormat.parse(data);
		} catch (ParseException e) {
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
					.entity("Parse to Date não pode ser feito: " + e.getMessage()).build());
		}
	}

	public Date getDate() {
		return date;
	}
}
