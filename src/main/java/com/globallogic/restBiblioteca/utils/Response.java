package com.globallogic.restBiblioteca.utils;

public class Response {
	private String codigo;
	private String mensaje;
	
	public Response(String errCode, String errMsg){
		this.codigo = errCode;
		this.mensaje = errMsg;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

}
