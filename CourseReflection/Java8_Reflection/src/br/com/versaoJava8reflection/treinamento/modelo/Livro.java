package br.com.versaoJava8reflection.treinamento.modelo;

public class Livro {

	private String nome;
	private int quantidade;
	private int numeropagina;
	private String tipo;

	
	public Livro() {
	}

	public Livro(String nome, int quantidade, int numeropagina, String tipo) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.numeropagina = numeropagina;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public int getNumeropagina() {
		return numeropagina;
	}

	public String getTipo() {
		return tipo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "[Livro: " + this.getNome() + ", Tipo: " + this.getTipo() + " ]" ;
	}
}
