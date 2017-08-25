/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.aula.model;

import br.uefs.ecomp.aula.util.ListaEncadeada;
import java.util.Date;

/**
 * Classe Aula, responsável pelo cadastramento de novas aulas, para alunos
 * assistir e professores ministrar, como características da aula, ela recebe um
 * professor um status que de inicio é false, alterado quando a aula é
 * realizada, receve uma lista de alunos para cada aula, recebe a data da aula
 * com dia, mês, ano e hora, e como identificação recebe o iD que é gerado
 * automaticamente pelo sistema.
 *
 * @author Allen Hichard Marques dos santos
 */
public class Aula {

    private Professor professor;
    private boolean realizada;
    private ListaEncadeada aluno;
    private Date data;
    private int iD;

    /**
     * Construtor da classee Aula, que recebe como parâmetros o professor da
     * aula, a data que o professor irá ministrar essa aula para seus alunos, e
     * o iD ou seja a identificação da aula, são característica de quando uma
     * nova aula é criada posteriormente podendo ser identificada por essas
     * mesmas características.
     *
     * @param professor
     * @param data
     * @param iD
     */

    public Aula(Professor professor, Date data, int iD) {

        this.aluno = new ListaEncadeada();
        this.professor = professor;
        this.data = data;
        this.iD = iD;

    }

    /**
     * Método que permite acesso a classe professor, ou seja quando for
     * necessário querer ver o nome o professor ou seu registro, através de
     * aula, pode ser consultado os métodos de professor, para fazer alterações
     * ou consulta de atributos.
     *
     * @return professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * Método que permite fazer alterações diretamente na classe professor
     * através dos seus métodos, ou seja fazer alterações nos seus atributos,
     * recebendo o professor desejado como parâmetro.
     *
     * @param professor.
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * Método que permite verificar o status de uma determinada aula "o status é
     * se foi realizara ou não retornando um verdadeiro ou false" por ser um
     * atributo privado.
     *
     * @return realizada true ou false.
     */
    public boolean getRealizada() {
        return realizada;
    }

    /**
     * Método que recebe um true ou false para mudar o status de uma determinada
     * aula, quando essa aula é realizada por um professor, é alterado o status
     * da mesma através desse método, como o atributo é privado o método
     * setRealizada recebe uma variável realizada que alteração do status da
     * aula para true.
     *
     * @param realizada.
     */
    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    /**
     * Método que permite verificar a data de uma aula de um determinado objeto
     * por ser um atributo privado.
     *
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * Método que recebe a data da aula, e guarda em uma atributo da classe, só
     * sendo possível a alteração por meios de métodos por ser o atributo
     * privado.
     *
     * @param data da aula.
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Método que permite o acesso a lista de alunos de cada aula, lista essa
     * que guarda as informações de todos seus alunos, por ser um atributo
     * privado por meio desse método ou posso pegar suas informações.
     *
     * @return lista de alunos
     */
    public ListaEncadeada getAluno() {
        return aluno;
    }

    /**
     * Método que permite alterar a lista de alunos de uma aula, podendo
     * acrescentar ou apagar alunos de sua lista de alunos, recebendo como
     * parâmetro uma nova lista de alunos substituindo sua lista anterior.
     *
     * @param aluno uma lista encadeada.
     */
    public void setAluno(ListaEncadeada aluno) {
        this.aluno = aluno;
    }

    /**
     * Método que permite verificar o iD da aula de um determinado objeto por
     * ser um atributo privado
     *
     * @return the iD
     */
    public int getiD() {
        return iD;
    }

}
