package br.edu.utfpr.cm.tsi.pi.sistemaru.model;

public enum TipoTransacao {

	CREDITO("CR�DITO"), DEBITO("D�BITO");

	private String tipo;

	private TipoTransacao(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}