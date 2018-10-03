package ac.aerolinea.backendTech.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name = "Cliente")
@NamedQueries({		
	@NamedQuery(name = "Cliente.findById", query = "SELECT cliente FROM Cliente cliente WHERE cliente.documentoIdentidad = :documentoIdentidad")
})
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	public String documentoIdentidad;
	
	@Column
	public String nombres;
	
	@Column
	public String apellidos;
	
	@Column
	public String fechaNacimiento;
	
}
