package br.com.schimidtsolutions.ws.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputParameterException", propOrder = { "message" })
public class InputParameterException {
	private String message;

	public InputParameterException() {
	}

	public InputParameterException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String value) {
		message = value;
	}
}
