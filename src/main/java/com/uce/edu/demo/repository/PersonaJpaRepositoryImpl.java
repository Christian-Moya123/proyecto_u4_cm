package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Persona;



@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		 this.entityManager.persist(persona);
		
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona persona = this.buscarPorId(id);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		//SELECT * FROM persona where pers_cedula='Alex2'
		//javaxpersisten
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p where p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		
		return (Persona) jpqlQuery.getSingleResult();//ME DA UN OBJETO DE TIPO PERSONA
	}
	
	
	@Override
	public List<Persona> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createQuery("SELECT p From Persona p", Persona.class);
		
		return myQuery.getResultList();
	}
	
	
	
	public Persona buscarPorCedulaType(String cedula) {
		TypedQuery<Persona> myTypedQuery = this.entityManager.createQuery("SELECT p FROM Persona p where p.cedula = :datoCedula", Persona.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
		
	}
	
	
	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return  (Persona) myQuery.getSingleResult();
	}
	
	
	public Persona buscarPorCedulaNamedTyped(String cedula) {
		TypedQuery<Persona> myTypedQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula", Persona.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}
	

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p where p.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido", Persona.class);
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p where p.genero = :datoGenero");
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p where p.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		// update persona set pers_genero='masculino' where pers_apellido='Toran'
		Query myQuery =this.entityManager.createQuery("UPDATE Persona p SET p.genero = :datoGenero WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoApellido", apellido);
		
		return myQuery.executeUpdate();
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		//delete persona where pers_apellido='Alex2'
		Query myQuery =this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero = :datoGenero ");
		myQuery.setParameter("datoGenero", genero);
		
		
		return myQuery.executeUpdate();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//NATIVE QUERY
	//Query
	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM persona WHERE pers_cedula = :datoCedula ", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	//NAMED NATIVE QUERY
	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	//CRITERIA API
	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		//SELECT * FROM persona WHERE pers_cedula = :datoCedula
		//creamos una instancia de la interfaz CriteriaBuilder paraa construir el SQL
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		
		//Especificamos un retorno de mi SQL
		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);
		
		//Aqui empezamos a contuir el SQL
		//Root FROM
		Root<Persona> personaFrom = myQuery.from(Persona.class);
		//myQuery.select(personaFrom);//SELECT P FROM Persona
		//LAs condiciones whereen criteria API se los conoce como predicados
		//Predicate p1 = myBuilder.equal("p.cedula", "daoCedula");
		Predicate p1 = myBuilder.equal(personaFrom.get("cedula"), cedula);//p.cedula = : daroCedula
		
		CriteriaQuery<Persona> myQueryCompleto = myQuery.select(personaFrom).where(p1);
		
		
		TypedQuery<Persona> myQueryFinal =  this.entityManager.createQuery(myQueryCompleto);
		return  myQueryFinal.getSingleResult();
	}

	//CRITERIA API dinmica
	@Override
	public List<Persona> buscarPorDinamicamnteCriteriaApi(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

        Root<Persona> myTabla = myQuery.from(Persona.class);

        Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
        Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
        Predicate predicadoGenero = myCriteria.equal(myTabla.get("genero"), genero);

        Predicate miPredicadoFinal = null;

        if (genero.equals("masculino")) {
            miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
        } else {
            miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
        }

        myQuery.select(myTabla).where(miPredicadoFinal);
        TypedQuery<Persona> myQueryFinal = this.entityManager
                .createQuery(myQuery);

        return myQueryFinal.getResultList();
	}


	@Override
	public List<Persona> buscarPorDinamicamentePredicadosCriteriaApi(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

        Root<Persona> myTabla = myQuery.from(Persona.class);

        Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
        Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
        Predicate predicadoGenero = myCriteria.equal(myTabla.get("genero"), genero);

        Predicate miPredicadoFinal = null;

        //AND Y OR EN UNA MISMA SENTENCIA sql
        if (genero.equals("masculino")) {
            miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
            myCriteria.and(miPredicadoFinal,predicadoGenero);
        } else {
            miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
            myCriteria.and(miPredicadoFinal,predicadoGenero);
        }

        myQuery.select(myTabla).where(miPredicadoFinal);
        TypedQuery<Persona> myQueryFinal = this.entityManager
                .createQuery(myQuery);

        return myQueryFinal.getResultList();
	}

	

	
	



}
