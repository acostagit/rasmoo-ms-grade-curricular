package com.rasmoo.cliente.escola.gradecurricular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import com.rasmoo.cliente.escola.gradecurricular.exception.MateriaException;
import com.rasmoo.cliente.escola.gradecurricular.repository.IMateriaRepository;

@Service
public class MateriaService implements IMateriaService {

	@Autowired 
	private IMateriaRepository materiaRepository; 
	
	@Override
	public Boolean atualizar(MateriaEntity materia) {
try {
	Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(materia.getId());
	
	if(materiaOptional.isPresent()) {
		//buscamos pela materia que queremos atualizar		
		MateriaEntity materiaAtualizada = materiaOptional.get();
		
		materiaAtualizada.setNome(materia.getNome());
		materiaAtualizada.setCodigo(materia.getCodigo());
		materiaAtualizada.setHoras(materia.getHoras());
		materiaAtualizada.setFrequencia(materia.getFrequencia());
		
		//Salvamos as alteraçoes
		this.materiaRepository.save(materiaAtualizada);
		
		return true;	
	}
	return false;
} catch (Exception e) {
	return false;
}
				
	}

	@Override
	public Boolean excluir(@PathVariable Long id) {
		try {
			this.consultar(id);
			this.materiaRepository.deleteById(id);
			return true;
		} catch (MateriaException m) {
			throw m;		
		} catch (Exception e) {
			 throw e;
		}
	}

	@Override
	public MateriaEntity consultar(Long id) {
		try {
			Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(id);
			if(materiaOptional.isPresent()) {
				return  materiaOptional.get();
			}
			throw new MateriaException("Matéria não encontrada", HttpStatus.NOT_FOUND);
		} catch (MateriaException m) {
			throw m;
		} catch (Exception e) {
			throw new MateriaException("Erro não identificado. Contate o Admin", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public List<MateriaEntity> listar() {
		try {
			return  this.materiaRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean cadastrar(MateriaEntity materia) {
		
		try {
			this.materiaRepository.save(materia);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
