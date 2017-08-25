/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.aula.model;

import br.uefs.ecomp.aula.util.ListaEncadeada;

/**
 * Classe Professor, tem como característica um nome " podendo ser completo ou
 * não" recebe um registro informado pela secretária " Registro esse um número
 * inteiro", além disso professor tem uma lista de alunos pessoais, ou seja,
 * cada professor tem a lista de alunos que assistiu ou irão assistir aula.
 *
 * @author Allen Hichard Marques dos Santos
 */

public class Professor {

    private String professor;
    private int registro;
    private ListaEncadeada listaAluno;

    /**
     * Construtor da Classe Professor,inicializa todos seus atributos, registro
     * e nome do professor informados pelo usuário, e a lista de alunos sendo
     * preparada para receber alunos para ser realizada aulas.
     *
     * @param registro
     * @param professor
     */

    public Professor(int registro, String professor) {

        this.professor = professor;
        this.registro = registro;
        listaAluno = new ListaEncadeada();
    }

    /**
     * Método que permite verificar o nome do professor de um determinado objeto
     * por ser um atributo privado
     *
     * @return o nome desse professor.
     */

    public String getProfessor() {
        return professor;
    }

    /**
     * Método que recebe um nome de professor, e guarda em uma atributo da
     * classe, só sendo possível a alteração por meios de métodos por ser o
     * atributo privado.
     *
     * @param professor
     */
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    /**
     * Método que permite verificar o registro do professor de um determinado
     * objeto por ser um atributo privado
     *
     * @return registro.
     */
    public int getRegistro() {
        return registro;
    }

    /**
     * Método que recebe um registro de professor, e guarda em uma atributo da
     * classe, só sendo possível a alteração por meios de métodos por ser o
     * atributo privado.
     *
     * @param registro
     */

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    /**
     * Método que permite o acesso a lista de alunos de cada professor, lista
     * essa que guarda as informações de todos seus alunos, por ser um atributo
     * privado por meio desse método ou posso pegar suas informações.
     *
     * @return lista de alunos.
     */
    public ListaEncadeada getListaAluno() {
        return listaAluno;
    }

    /**
     * Método que permite alterar a lista de alunos de um professor, podendo
     * acrescentar ou apagar alunos de sua lista de alunos, recebendo como
     * parâmetro uma nova lista de alunos substituindo sua lista anterior.
     *
     * @param listaAluno
     */
    public void setListaAluno(ListaEncadeada listaAluno) {
        this.listaAluno = listaAluno;
    }
}
