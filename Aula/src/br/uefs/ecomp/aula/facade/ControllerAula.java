/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.aula.facade;

import br.uefs.ecomp.aula.model.Aluno;
import br.uefs.ecomp.aula.model.Aula;
import br.uefs.ecomp.aula.model.Professor;
import br.uefs.ecomp.aula.util.Iterador;
import br.uefs.ecomp.aula.util.ListaEncadeada;
import java.util.Date;

/**
 * Classe ControllerAula, responsável por toda a interação de todas as classes
 * do programa: aluno, aula, professor, lista encadeada. o controller e
 * instaciado para para alterações diretamente nas classes, criando novos tipos
 * de objetos e armazenando suas informações, como também é responsável por
 * todas as ações que envolvem esses objetos. O controller é uma visão de ação
 * do mundo real, tenta fazer com que cada método seja responsável por sua ação,
 * tendo assim cada um com suas características e individualidade
 *
 * @author Allen Hichard Marques dos Santos
 */
public class ControllerAula {

    private ListaEncadeada listAluno;
    private ListaEncadeada listProfessor;
    private ListaEncadeada listAula;
    private int matricula;
    private int aulaId;
    private Aula nova;
    private ListaEncadeada auxiliar;
    private ListaEncadeada aula;

    // Deixado como atributo de classe pois foi usada em mais de um método
    // e também para ter informações de uma lista de alunos que aula contém,
    // para ser utilizada na interface.
    /**
     * Construtor do ControllerAula, onde são inicializadas os atributos de sua
     * classe, como por exemplo matricula e aulaId que começa com 1 de valor, e
     * inicialidas as três listas usadas no programa, a lista de alunos, aulas e
     * professores.
     */
    public ControllerAula() {
        matricula = 1;
        aulaId = 1;
        listAluno = new ListaEncadeada();
        listProfessor = new ListaEncadeada();
        listAula = new ListaEncadeada();
        auxiliar = new ListaEncadeada();
        aula = new ListaEncadeada();
    }

    /**
     * Método cadastrar aluno, recebe o nome de um aluno para ser cadastrado, o
     * objeto é instanciado "passado para o construtor da classe aluno" o nome e
     * a matrícula que é gerado automaticamente pelo programa após criar o
     * objeto do tipo aluno, sua referência é salva em uma lista encadeada de
     * alunos, incrementando a matrícula para o próximo aluno a ser criado ou
     * seja instanciado e retornando a referência do aluno que acabou de ser
     * cadastrado.
     *
     * @param nome
     * @return aluno
     */
    public Aluno cadastrarAluno(String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        listAluno.insereFinal(aluno);
        matricula++;
        System.out.println("Nome do aluno " + aluno.getNome() + " Matrícula: "
                + aluno.getMatricula());
        return aluno;

    }

    /**
     * Método obter aluno recebe como parâmetro a matricula do aluno desejado.
     * Com a matricula do aluno, é percorrido a lista de aluno para encontrar
     * algum aluno que tenha o atributo igual ao da matricula enviado, se
     * encontrar o aluno que tem a mesma matricula é retornado sua referência,
     * caso não encontrado retorna nulo.
     *
     * @param matricula
     * @return Aluno
     */
    public Aluno obterAluno(int matricula) {
        for (int i = 0; i < listAluno.tamanho(); i++) {
            Aluno a = (Aluno) listAluno.recupera(i);
            if (a.getMatricula() == matricula) {
                return a;
            }
        }
        return null;
    }

    /**
     * Método que retorna um objeto da classe Iterador, que faz referência a
     * lista de alunos.
     *
     * @return iterador da lista de alunos.
     */
    public Iterador listarAlunos() {
        return listAluno.iterador();
    }

    /**
     * Método cadastrar Professor, recebe o nome de um professor para ser
     * cadastrado, e recebe seu registro, o objeto é instanciado "passado para o
     * construtor da classe professor" o nome e o registro que é informado pela
     * secretária ao realizar o cadastro, após criar o objeto do tipo professor,
     * sua referência é salva em uma lista encadeada de professores, e retornado
     * a referência do professor que acabou de ser cadastrado.
     *
     * @param registro
     * @param nome
     * @return professor
     */
    public Professor cadastrarProfessor(int registro, String nome) {
        Professor professor = new Professor(registro, nome);
        listProfessor.insereFinal(professor);
        System.out.println("Nome do Professor " + professor.getProfessor() + " registro: "
                + professor.getRegistro());
        return professor;
    }

    /**
     * Método obter Professor recebe como parâmetro o registro do professor
     * desejado. Com o registro do professor, é percorrido a lista de professor
     * para encontrar algum professor que tenha o atributo igual ao do registro
     * enviado, se encontrar o professor que tem a mesmo registro é retornado
     * sua referência, caso não encontrado retorna nulo.
     *
     * @param registro
     * @return professor
     */
    public Professor obterProfessor(int registro) {
        for (int i = 0; i < listProfessor.tamanho(); i++) {
            Professor p = (Professor) listProfessor.recupera(i);
            if (p.getRegistro() == registro) {
                return p;
            }
        }
        return null;
    }

    /**
     * Método obter Aula recebe como parâmetro o iD da aula desejada. Com o iD
     * da aula, é percorrido a lista de aulas para encontrar alguma aula que
     * tenha o atributo igual ao do iD enviado, se encontrar a aula que tem a
     * mesmo iD é retornado sua referência, caso não encontrado retorna nulo.
     * "Detalhe, esse método chama o metodo de registrar aula dada, que passa a
     * aula encontrada e altera seu status"
     *
     * @param id
     * @return aula
     */
    public Aula obterAula(int id) {
        for (int i = 0; i < listAula.tamanho(); i++) {
            Aula aul = (Aula) listAula.recupera(i);
            if (aul.getiD() == id) {
                if (aul.getRealizada() == false) {
                    registrarAulaDada(aul, true);
                    System.out.println("A aula com o id: " + aul.getiD()
                            + " foi realizada com sucesso");
                    return aul;
                }
            }
        }
        return null;
    }

    /**
     * O método agendar aula, faz o cadastro de alunos em uma aula com o
     * professor desejado, o aluno escolhe o dia, mas, a secretária diz o
     * horário da aula com o professor. Esse método tem três condições para
     * cumprir com as exigência do problema que é: o aluno só pode assistir uma
     * aula, o professor pode ministrar aulas para vários alunos em uma sala,
     * mas um mesmo professor não pode ministrar duas aulas no mesmo horário. A
     * primeira condição diz que se não existir aula, todas as condições sao
     * compatíveis e é cadastrado o aluno, com seu professor, na data informada.
     * A segunda condição diz como o professor já é enviado o desejado, só é
     * analisar se ele tem aula naquele horário, se ele tiver aula, o aluno é
     * associado a aula não criando uma nova aula, se naquele horário novo não
     * haver aula, é criado uma nova aula com o professor informado na data
     * cadastrada.
     *
     * @param aluno
     * @param professor
     * @param data
     * @return aula
     */
    public Aula agendarAula(Aluno aluno, Professor professor, Date data) {

        for (int i = 0; i < listAula.tamanho(); i++) {
            Aula aul = (Aula) listAula.recupera(i);
            if (aul.getData().equals(data) && aul.getProfessor().equals(professor)) {
                aluno.setTemAula(true);
                professor.getListaAluno().insereFinal(aluno);
                nova.getAluno().insereFinal(aluno);
                return nova;
            }
        }

        nova = new Aula(professor, data, aulaId);
        aluno.setTemAula(true);
        professor.getListaAluno().insereFinal(aluno);
        nova.getAluno().insereFinal(aluno);
        listAula.insereFinal(nova);
        System.out.println(nova.getiD());
        aulaId++;
        return nova;

    }

    /**
     * Método mostrar alunos sem aula, analisa se na lista de alunos tem alguém
     * com o status de aula agendada false "método chamado de TemAula" se o
     * status desse aluno ainda for falso, é mostrado os alunos da lista que
     * ainda não foram agendado aula.
     *
     * @return Iterador da lista de alunos.
     */
    public Iterador motrarAlunosSemAula() {
        Iterador it;
        it = listAluno.iterador();
        while (it.temProximo()) {
            Aluno x = (Aluno) it.proximo();
            if (x.getTemAula() == false) {
                System.out.println("nome: " + x.getNome() + " matricula: "
                        + x.getMatricula() + " esta associado a alguma aula "
                        + x.getTemAula() + "\n");
            }
        }
        return listAluno.iterador();
    }

    /**
     * Método que retorna um objeto da classe Iterador, que faz referência a
     * lista de professores.
     *
     * @return iterador da lista de professores.
     */
    public Iterador listarProfessor() {
        return listProfessor.iterador();
    }

    /**
     * Método que retorna um objeto da classe Iterador, que faz referência a
     * lista de aulas.
     *
     * @return iterador da lista de aulas.
     */
    public Iterador listarAulas() {
        return listAula.iterador();
    }

    /**
     * Método mostrar todos alunos do professor. Independente do status
     * verdadeiro ou falso é mostrado todos seus alunos se já assistiu aula ou
     * não. Pelo registro do professor, é percorrido a lista de professores para
     * encontrar o professor que tem o registro informado, ao encontrar esse
     * professor, é acessado a lista de aluno que cada professor tem, e mostrar
     * todos os alunos cadastrados na lista de alunos de professor.
     *
     * @param registro
     * @return iterador
     */
    public Iterador mostrarProfessorSeusAlunos(int registro) {
        for (int i = 0; i < listProfessor.tamanho(); i++) {
            Professor p = (Professor) listProfessor.recupera(i);
            if (p.getRegistro() == registro) {
                Iterador it;
                it = p.getListaAluno().iterador();
                while (it.temProximo()) {
                    Aluno a = (Aluno) it.proximo();
                    System.out.println("Nome do aluno " + a.getNome() + " Matrícula: "
                            + a.getMatricula() + "\n");
                }

            }

        }
        return listProfessor.iterador();
    }

    /**
     * Método registrar aula dada, recebe como parâmetro a aula que será mudada
     * o status. No método buscar aula é encontrado essa aula e após encontrar
     * essa aula, é chamado esse método, que apenas muda o status de realizado
     * para verdadeiro.
     *
     * @param aula
     * @param realizada
     */
    public void registrarAulaDada(Aula aula, Boolean realizada) {
        aula.setRealizada(true);

    }

    /**
     * Método próximos alunos de um professor, após ser informado o registro do
     * professor que deseja ver seus próximos alunos, é verificado a menor data
     * de aulas dele que ainda tem o status false ou seja aula não dada. Na
     * lista de aula é encontrado as aulas que o professor irá ministrar, tendo
     * certeza de que a aula ainda não foi ministrada pelo método realizada em
     * aula. Encontrando a menor data, é percorrido a lista de aulas para
     * encontrar a data que foi encontrada "a menor data" como já encontrado o
     * professor daquela data foi pego a aula que tem aquela data com o
     * professor informado pelo registro e impresso a lista de alunos desta
     * aula.
     *
     * @param registro
     */
    public void proximosAlunosProfessor(int registro) {
        Date data = null;
        Date menorData;
        for (int i = 0; i < listAula.tamanho(); i++) {
            Aula aul = (Aula) listAula.recupera(i);
            if (aul.getProfessor().getRegistro() == registro) {
                if (aul.getRealizada() == false) {
                    menorData = aul.getData();
                    if (data == null) {
                        data = menorData;
                    } else if (menorData.before(data)) {
                        data = menorData;
                    }

                }
            }
        }
        Iterador it;
        for (int j = 0; j < listAula.tamanho(); j++) {
            Aula aulas = (Aula) listAula.recupera(j);
                if (aulas.getData() == data) {
                    if (aulas.getRealizada() == false) {
                        it = aulas.getAluno().iterador();
                        while (it.temProximo()) {
                            Aluno a = (Aluno) it.proximo();
                            System.out.println("nome: " + a.getNome() + " matricula: "
                                    + a.getMatricula());
                        }

                    }
                    
                
            }
        }
    }

    /**
     * Método que retorna o iterador da lista de alunos que cada aula contém.
     *
     * @return iterador da lista de alunos de aula
     */
    public Iterador getAula() {
        return nova.getAluno().iterador();
    }

    // Método explicado Abaixo, não colocado no javadoc, pois seu método é privado
    private Iterador getAuxiliar() {
        Iterador it;
        it = listAula.iterador();
        while (it.temProximo()) {
            Aula a = (Aula) it.proximo();
            aula.insereFinal(a);
        }
        return listAluno.iterador();
    }

    /**
     * Método ordenar data, ele recebe uma cópia da lista de aula, cópia essa
     * feita pelo método privado de classe getAuxiliar, para ordenar por data.
     * Foi feito essa cópia para poder ser mostrado ao usuário uma ordenação
     * tanto por data como pelo id da aula. Esse método pega a cópia feita da
     * lista de aula e retira elemento por elemento da cópia da lista de acordo
     * com a menor data, formando uma nova lista com a referência ordenada por
     * data.
     *
     * @return Iterador da lista ordenada.
     */
    public Iterador ordenarData() {
        Date mdata = null;
        getAuxiliar();
        for (int j = 0; j < aula.tamanho(); j++) {
            for (int k = 0; k < aula.tamanho(); k++) {
                Aula aul = (Aula) aula.recupera(k);
                if (mdata == null) {
                    mdata = aul.getData();
                } else if (aul.getData().before(mdata)) {
                    mdata = aul.getData();
                }

            }
            Iterador ip;
            for (int i = 0; i < aula.tamanho(); i++) {
                Aula a = (Aula) aula.recupera(i);

                if (a.getData().equals(mdata)) {
                    auxiliar.insereFinal(a);
                    aula.delete(a);
                    System.out.println("ID da aula: " + a.getiD() + " Professor da aula "
                            + a.getProfessor().getProfessor()
                            + " Data da aula "
                            + a.getData() + " ");
                    j = -1;
                    mdata = null;
                    ip = a.getAluno().iterador();
                    while (ip.temProximo()) {
                        Aluno b = (Aluno) ip.proximo();
                        System.out.println("Nome do aluno " + b.getNome() + " Matrícula: "
                                + b.getMatricula() + "\n");
                    }
                }
            }

        }
        return auxiliar.iterador();
    }

}
