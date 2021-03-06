package ac.aerolinea.backendTech.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name = "Vuelo")
@NamedQueries({	
	@NamedQuery(name = "Vuelo.findAll", query = "SELECT vuelo from Vuelo vuelo"),
	@NamedQuery(name = "Vuelo.findById", query = "SELECT vuelo FROM Vuelo vuelo WHERE vuelo.id = :id")
})
public class VueloEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
			
	@Column
	public String origen; 
	
	@Column
	public String destino;
	
	@Column
	public double costo;
	
	@Column
	public int asientosDisponibles;	
	
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(int asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	public Long getId() {
		return id;
	}	
	
	
}
