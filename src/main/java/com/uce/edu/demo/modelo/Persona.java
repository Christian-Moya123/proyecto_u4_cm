package com.uce.edu.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="persona")//debe estar escrito con el nombre de la tabla
//Primera forma para usar varios named query
@NamedQuery(name="Persona.buscarPorCedula" , query="SELECT p FROM Persona p where p.cedula = :datoCedula")//es to es para usar type query
@NamedQuery(name="Persona.buscarPorNombreApellido",query="SELECT p FROM Persona p where p.nombre = :datoNombre AND p.apellido = :datoApellido ")

/*//segfunda forma para usar varios named query
@NamedQueries({@NamedQuery(name="Persona.buscarPorNombreApellido",query="SELECT p FROM Persona p where p.nombre = :datoNombre AND p.apellido = :datoApellido "),
			   @NamedQuery(name="Persona.buscarPorCedula" , query="SELECT p FROM Persona p where p.cedula = :datoCedula")})
*/



//Native Query
@NamedNativeQuery(name ="Persona.buscarPorCedulaNative" , query= "SELECT * FROM persona WHERE pers_cedula = :datoCedula  ", resultClass = Persona.class)


public class Persona {
	//nunca usar atributus con primitivas
	
	@Id
	@Column(name="pers_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_gerneration")
	@SequenceGenerator(name = "name_gerneration",sequenceName = "pers_id_seq", allocationSize = 1)//este si tienen que tener el nombre de mi secuencia en SQL
	private Integer id; 
	
	@Column(name="pers_nombre")
	private String nombre;
	
	@Column(name="pers_apellido")
	private String apellido;
	
	@Column(name="pers_genero")
	private String genero;
	
	@Column(name="pers_cedula")
	private String cedula;
	
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero
				+ ", cedula=" + cedula + "]";
	}
	//set y get
	
	
	public String getGenero() {
		return genero;
	}
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

}
