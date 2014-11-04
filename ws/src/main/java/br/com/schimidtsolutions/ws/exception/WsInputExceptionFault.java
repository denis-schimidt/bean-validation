package br.com.schimidtsolutions.ws.exception;

import javax.xml.ws.WebFault;

@WebFault(name = "WsInputExceptionFault")
public class WsInputExceptionFault extends RuntimeException {
	private static final long serialVersionUID = -2625375659771828656L;

	private InputParameterException faultInfo;

    public WsInputExceptionFault(String message, InputParameterException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public WsInputExceptionFault(String message, InputParameterException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public InputParameterException getFaultInfo() {
        return faultInfo;
    }
}
