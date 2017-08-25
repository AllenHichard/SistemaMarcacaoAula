/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.aula.facade;

import br.uefs.ecomp.aula.model.*;
import br.uefs.ecomp.aula.util.*;
import java.util.Date;


public class AulaFacade {
	
	ControllerAula ca;
	
	public AulaFacade() {
		this.ca = new ControllerAula();
	}
	
	
	public Aluno cadastrarAluno(String nome) {
		return ca.cadastrarAluno(nome);
	}
	
	public Aluno obterAluno(int matricula) {
		return ca.obterAluno(matricula);
	}
	
	public Iterador listarAlunos() {
		return this.ca.listarAlunos();
	}
	
	public Professor cadastrarProfessor(int registro, String nome) {
		return ca.cadastrarProfessor(registro, nome);
	}
	
	public Professor obterProfessor(int registro) {
		return ca.obterProfessor(registro);
	}
	
	public Aula agendarAula(Aluno aluno, Professor professor, Date data){
		return this.ca.agendarAula(aluno, professor, data);
	}
	
	public Iterador motrarAlunosSemAula(){
		return this.ca.motrarAlunosSemAula();
	}
	
	public Iterador mostrarProfessorSeusAlunos(int registro){
		return this.ca.mostrarProfessorSeusAlunos(registro);
	}
	
	public void registrarAulaDada(Aula aula, Boolean realizada){
		//return this.ca.registrarAulaDada(aula, realizada);
	}

    
    }

    

    
    



