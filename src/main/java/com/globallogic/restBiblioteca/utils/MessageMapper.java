package com.globallogic.restBiblioteca.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class MessageMapper {
	private static Map<String, String> CODE_ERROR_MAP;
	
	public MessageMapper(){
		super();
		CODE_ERROR_MAP = new HashMap<String, String>();
		CODE_ERROR_MAP.put("1001", "Código de libro no encontrado");
	}
	
	public String getMessageByCode(String code){
		return(CODE_ERROR_MAP.get(code));
	}
	public Response getResponseFor(String errCode) {
		Response response = new Response(errCode, getMessageByCode(errCode));
		return response;
	}
	
}
