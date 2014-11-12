package br.com.walmart.webservices;

public class Database {
	
	private static String nome = "none";
	
	private static String malha = "none";

	public static String getMalha() {
		return malha;
	}

	public static void setMalha(String nome, String malha2) {
		Database.nome = nome;
		Database.malha = malha2;
	}

	public static String getNome() {
		return nome;
	}

}
