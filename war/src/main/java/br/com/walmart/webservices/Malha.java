package br.com.walmart.webservices;

import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("malha")
public class Malha {

	@Context
	private UriInfo context;

	public Malha() {
	}

	@PUT
	public void put(@FormParam("nome") String nome, @FormParam("malha") String malha) {
		// TODO M incluir logs  
		// TODO F persistir malha 
	}

}