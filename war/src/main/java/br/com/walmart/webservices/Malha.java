package br.com.walmart.webservices;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("malha")
public class Malha {

	private String malha = "none";

	@Context
	private UriInfo context;

	public Malha() {
	}

	@POST
	public void put(@FormParam("nome") String nome, @FormParam("malha") String malha) {
		this.malha = malha;
		System.out.println("PUT");
		System.out.println("NOME: " + nome + " MALHA: " + malha);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		return this.malha;
	}

}