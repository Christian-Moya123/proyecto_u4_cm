package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Persona;
import com.uce.edu.demo.repository.IPersonaJpaRepository;


@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService{
	
	@Autowired
	private IPersonaJpaRepository iPersonaJpaRepository; 

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorId(id);
	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.insertar(persona);
		
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.actualizar(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.eliminar(id);
	}
	
	
	@Override
	public List<Persona> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarTodos();
	}
	
	
	
	
	
	
	

	@Override
	public Persona buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedula(cedula);
	}

	@Override
	public List<Persona> buscarApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorApellido(apellido);
	}

	@Override
	public List<Persona> buscarGenero(String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorGenero(genero);
	}

	@Override
	public List<Persona> buscarNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorNombre(nombre);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.actualizarPorApellido(genero, apellido);
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.eliminarPorGenero(genero);
	}

	@Override
	public Persona buscarPorCedulaType(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaType(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaNamed(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamedTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaNamedTyped(cedula);
	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorNombreApellido(nombre, apellido);
	}

	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaNative(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaNamedNative(cedula);
	}

	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaCriteriaApi(cedula);
	}

	@Override
	public List<Persona> buscarPorDinamicamnteCriteriaApi(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorDinamicamnteCriteriaApi(nombre, apellido, genero);
	}

	@Override
	public List<Persona> buscarPorDinamicamentePredicadosCriteriaApi(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorDinamicamentePredicadosCriteriaApi(nombre, apellido, genero);
	}

	



}
