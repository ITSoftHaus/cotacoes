package br.com.cotacoes.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class DateConvertUs {

	private final Date date;

	public DateConvertUs(String data) throws WebApplicationException {
		
		if (data.isEmpty()) {
			this.date = null;
			return;
		}
		
		final DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		
		try {
			this.date = dateFormat.parse(data);
		} catch (ParseException e) {
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
					.entity("DateConvertUS: Parse to Date não pode ser feito: " + e.getMessage()).build());
		}
	}

	public Date getDate() {
		return date;
	}
}
