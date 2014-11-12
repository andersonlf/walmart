package br.com.walmart.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("logistica")
public class Logistica {

	@Context
	private UriInfo context;

	public Logistica() {
	}

	@GET
	@Path("/melhorcaminho/{origem}/{detino}/{autonomia}/{valor}")
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML)
	public String calcularMelhorCaminho(@PathParam("origem") String origem, 
			@PathParam("destino") String destino,
			@PathParam("autonomia") double autonomia,
			@PathParam("valor") double valor) {
		
		// TODO M incluir logs  
		// TODO F calcular melhor caminho
		
		return null;
	}

}