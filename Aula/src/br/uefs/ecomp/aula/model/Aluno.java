/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.aula.model;

/**
 * Classe Aluno, permite criar alunos com características diferenciadas de
 * acordo com seus atributos (característica do objeto). A classe aluno tem como
 * atributo seu nome, uma matricula que é gerada altomaticamente pelo programa,
 * e tem um método que diz se esse determinado aluno já está associado a uma
 * aula, sem à ter assistido ainda.
 *
 * @author Allen Hichard Marques dos Santos
 */

public class Aluno {

    private String nome;
    private int matricula = 0;
    private boolean temaula;

    /**
     * Construtor da Classe Aluno, recebe como parâmetro o nome e uma matricula
     * para instanciar um novo objeto ou seja um novo aluno que vai receber o
     * nome e sua matricula.
     *
     * @param matricula
     * @param nome
     */

    public Aluno(int matricula, String nome) {
        this.nome = nome;
        this.matricula = matricula;
    }

    /**
     * Método que permite verificar o nome do aluno de um determinado objeto por
     * ser um atributo privado
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que recebe um nome de aluno, e guarda em uma atributo da classe,
     * só sendo possível a alteração por meios de métodos por ser o atributo
     * privado.
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que permite verificar a matrícula do aluno de um determinado
     * objeto por ser um atributo privado
     *
     * @return
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * Método que recebe a matricula do aluno, e guarda em uma atributo da
     * classe, só sendo possível a alteração por meios de métodos por ser o
     * atributo privado.
     *
     * @param matricula
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * Método que permite verificar se o aluno já tem alguma aula associada ou
     * seja, uma aula cadastrada, caso a aula esteja cadastrada retorna
     * verdadeiro caso contrário retorna falso, por ser de um atributo privado,
     * é possível o acesso por esse método.
     *
     * @return True ou False
     */
    public boolean getTemAula() {
        return temaula;
    }

    /**
     * Método que recebe um true ou false, ou seja quando o obejeto é criado o
     * aluno recebe um status false, o método é utilizado para quando agendar a
     * aula de um determinado aluno alterar esse status para true, por ser uma
     * atribulo privado esse método garante essa alteração, mudando assim esse
     * atributo de classe.
     *
     * @param temaula "guarda true ou false"
     */
    public void setTemAula(boolean temaula) {
        this.temaula = temaula;
    }

    /**
     * Método To String, é utilizado para imprimir diretamente os atributos de
     * classe de cada objeto criado quando necessário.
     *
     * @return as impressões do atributo de classe do aluno
     */
    public String ToString() {
        return "nome " + this.nome + "matricula " + this.matricula;
    }

}
