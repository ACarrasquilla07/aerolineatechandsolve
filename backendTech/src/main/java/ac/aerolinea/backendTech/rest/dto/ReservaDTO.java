package ac.aerolinea.backendTech.rest.dto;

public class ReservaDTO {
	String idCliente;
	String codigoVuelo;

	public ReservaDTO() {
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

}
