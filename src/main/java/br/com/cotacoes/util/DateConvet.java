package br.com.cotacoes.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class DateConvet {
	
	private final Date date;

	public DateConvet(String data) throws WebApplicationException {
		
		if (data.isEmpty()) {
			this.date = null;
			return;
		}
		
		System.out.println("DateParam String: " + data);
		
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			this.date = dateFormat.parse(data);
			System.out.println("DateParam data: " + this.date.toString());
		} catch (ParseException e) {
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
					.entity("DateParam: Parse to Date não pode ser feito: " + e.getMessage()).build());
		}
	}

	public Date getDate() {
		return date;
	}
}
