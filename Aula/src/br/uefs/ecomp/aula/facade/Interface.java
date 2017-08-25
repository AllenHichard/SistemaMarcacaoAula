/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.aula.facade;

import br.uefs.ecomp.aula.model.Aluno;
import br.uefs.ecomp.aula.model.Aula;
import br.uefs.ecomp.aula.model.PegaData;
import br.uefs.ecomp.aula.model.Professor;
import br.uefs.ecomp.aula.util.Iterador;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe Interface tem como característica principal a interação com o usuário.
 * O usuário entra com os dados necessários para o funcionamento correto do
 * programa
 *
 * @author Allen Hichard Marques dos Santos
 */
public class Interface {

    /**
     * No menu do programa tem opções para orientação do usuário no seu manuseio
     * Descritos todas as opções abaixo: *
     */
    /**
     * Primeira opção: Cadastrar aluno, permite fazer cadastro de novos alunos
     * com matriculas geradas de forma automática.
     */
    /**
     * Segunda opção: Obter aluno de acordo com sua matrícula, esse opção será a
     * menos utilizada, apenas quando quiser verificar se é aquele aluno mesmo
     * que tem a matrícula informada.
     */
    /**
     * Terceira opção: faz um papel bem simples ela mostra todos os alunos
     * cadastrados.
     */
    /**
     * Quarta opção: Cadastrar professor, permite fazer cadastro de novos
     * professores. informando seu nome e seu registro.
     */
    /**
     * quinta opção: obter professor de acordo com seu registro.
     */
    /**
     * sexta opção: associa um aluno em uma aula, caso ele já esteja associado,
     * pelo seu número de matricula pode inpedir um novo recadastramento.
     */
    /**
     * sétima opção: caso tenha algum aluno na lista sem aula agendada, essa
     * opção irá mostrar todos os alunos no esse status.
     */
    /**
     * oitava opção: lista todos os alunos de um professor independente se já
     * está em alguma aula ou não.
     */
    /**
     * Nona opção: busca a aula do professor pelo seu ID e coloca seu status
     * como realizada.
     */
    /**
     * décima opção: lista todos os professores cadastrados.
     */
    /**
     * décima primeira opção: lista todas as aulas cadastradas até então.
     */
    /**
     * décima segunda opção: mostra quem são os alunos da próxima aula de um professor
     * escolhido pelo seu registro
     */
    /**
     * décima terceira opção: Mostra aulas de forma ordenada por data.
     */
    /**
     * décima quarta opção: todas as aulas que um professor ministrará.
     */
    private static AulaFacade controlador;
    private static Scanner imput;

    @SuppressWarnings({"empty-statement", "static-access"})
    public static void main(String[] args) {
        controlador = new AulaFacade();

        imput = new Scanner(System.in);

        System.out.println("Aula Free - Sistema de Controle de Aulas Grátis");
        System.out.println("Curso preparatório de línguas");
        System.out.println("1 Cadastrar novo aluno");
        System.out.println("2 Obter aluno por sua matrícula");
        System.out.println("3 Listar todos os alunos cadastrados alunos");
        System.out.println("4 Cadastrar novo professor");
        System.out.println("5 Obter professor pelo seu registro");
        System.out.println("6 Agendar Aula");
        System.out.println("7 Mostrar todos os alunos sem aula agendada");
        System.out.println("8 Mostrar todos os alunos de um professor");
        System.out.println("9 Registrar aula dada");
        System.out.println("10 Listar todos os Professores registrados");
        System.out.println("11 Listar todas as aulas pelo id");
        System.out.println("12 Listar Proximos alunos de um Professor");
        System.out.println("13 Mostrar aula de forma ordenada pela data");
        System.out.println("14 Aulas que um professor ministra");
        System.out.println("Caso não deseje selecionar outra informação é só digitar qualquer"+
                " número diferente do Menu");
        System.out.println("Selecione a opção desejada");
        
        try {
            int opcao = imput.nextInt();

            while (opcao > 0 && opcao < 15) {
                if (opcao == 1) {
                    imput = new Scanner(System.in);
                    System.out.println("Informe o nome do novo aluno");
                    String aluno = imput.nextLine();
                    controlador.cadastrarAluno(aluno);
                    System.out.println("Aluno cadastrado com sucesso\n");
                } else if (opcao == 2) {
                    if (controlador.listarAlunos().temProximo()) {
                        imput = new Scanner(System.in);
                        System.out.println("Informe a matricula do aluno que deseja verificar");
                        int matricula = imput.nextInt();
                        Aluno aluno = (Aluno) controlador.obterAluno(matricula);
                        if (aluno == null) {
                            System.out.println("Não existe nenhum aluno com a matrícula informada\n");
                        } else {
                            System.out.println("Nome do aluno " + aluno.getNome() + " Matrícula: "
                                    + aluno.getMatricula() + "\n");
                        }
                    } else {
                        System.out.println("Não existe nenhum aluno cadastrado\n");
                    }
                } else if (opcao == 3) {
                    if (controlador.listarAlunos().temProximo()) {
                        Iterador it;
                        it = controlador.listarAlunos();
                        while (it.temProximo()) {
                            Aluno x = (Aluno) it.proximo();
                            System.out.println("nome: " + x.getNome() + " matricula: "
                                    + x.getMatricula() + " esta associado a alguma aula "
                                    + x.getTemAula() + "\n");
                        }
                    } else {
                        System.out.println("Não existe nenhum aluno cadastrado\n");
                    }
                } else if (opcao == 4) {
                    imput = new Scanner(System.in);
                    System.out.println("Informe o nome do novo professor");
                    String professor = imput.nextLine();
                    System.out.println("Informe o registro");
                    int registro = imput.nextInt();
                    Professor p = (Professor) controlador.obterProfessor(registro);
                     if (p==null) {
                        controlador.cadastrarProfessor(registro, professor);
                        System.out.println("professor cadastrado com sucesso\n");  
                        }
                     else if (p.getRegistro() == registro){
                        System.out.println("O professor " + p.getProfessor() + " registro "
                                    + p.getRegistro() + " já se encontra cadstrado no sistema\n");
                    }
                } else if (opcao == 5) {
                    if (controlador.ca.listarProfessor().temProximo()) {
                        imput = new Scanner(System.in);
                        System.out.println("Informe a código do professor que deseja verificar\n");
                        int registro = imput.nextInt();
                        Professor professor = (Professor) controlador.obterProfessor(registro);
                        if (professor == null) {
                            System.out.println("Não existe nenhum Professor com registro informado");
                        } else {
                            System.out.println("Nome do professor " + professor.getProfessor() + " registro: "
                                    + professor.getRegistro() + "\n");
                        }
                    } else {
                        System.out.println("Não existe nenhum professor cadastrado");
                    }
                } else if (opcao == 6) {
                    if (controlador.listarAlunos().temProximo() && controlador.ca.listarProfessor().temProximo()) {
                        imput = new Scanner(System.in);
                        System.out.println("Informe a matricula do aluno que deseja matricular");
                        int matricula = imput.nextInt();
                        Aluno aluno = controlador.obterAluno(matricula);
                        if(aluno==null){
                            System.out.println("Não existe aluno com essa matrícula");
                        }
                        else if (aluno.getTemAula() == true) {
                            System.out.println("O aluno " + aluno.getNome() + " matricula " + aluno.getMatricula()
                                    + " já está matriculado em um curso de línguas\n");
                        } else {
                            System.out.println("informe seu Professor para a aula");
                            int prof = imput.nextInt();
                            Professor professor = controlador.obterProfessor(prof);
                            if(professor == null){
                                System.out.println("Não existe o professor informado");
                            }
                            else{
                            Date data = PegaData.pegaData();
                            controlador.agendarAula(aluno, professor, data);
                        }
                        }
                    } else {
                        System.out.println("Cadastre pelo  menos um aluno e um professor\n");
                    }

                } else if (opcao == 7) {
                    if (controlador.listarAlunos().temProximo()) {
                        controlador.motrarAlunosSemAula();
                    } else {
                        System.out.println("Não existe nenhum aluno ainda cadastrado\n");
                    }
                } else if (opcao == 8) {
                    if (controlador.ca.listarProfessor().temProximo()) {
                        imput = new Scanner(System.in);
                        System.out.println("informe o código do professor para ver seus alunos");
                        int registro = imput.nextInt();
                        Professor p = (Professor) controlador.obterProfessor(registro);
                        if (p == null) {
                            System.out.println("Não existe professor com o registro informado\n");
                        } else {

                            if (controlador.listarAlunos().temProximo()) {
                                controlador.mostrarProfessorSeusAlunos(registro);
                            } else {
                                System.out.println("Não existe nenhum aluno cadastrado\n");
                            }
                        }
                    } else {
                        System.out.println("Não existe professor cadastrado no sistema\n");
                    }

                } else if (opcao == 9) {
                    if (controlador.ca.listarAulas().temProximo()) {
                        imput = new Scanner(System.in);
                        System.out.println("Informe o ID da aula que deseja ser realizada");
                        int id = imput.nextInt();
                        Aula aula = (Aula) controlador.ca.obterAula(id);
                        if (aula == null) {
                            System.out.println("Não existe aula com esse ID");
                        } else {
                            controlador.ca.obterAula(id);
                        }
                    } else {
                        System.out.println("Não existe nenhuma aula cadastrada para ser marcada como realizada");
                    }
                } else if (opcao == 10) {
                    if (controlador.ca.listarProfessor().temProximo()) {
                        Iterador it;
                        it = controlador.ca.listarProfessor();
                        while (it.temProximo()) {
                            Professor p = (Professor) it.proximo();
                            System.out.println("nome: " + p.getProfessor() + " registro: "
                                    + p.getRegistro());
                        }
                    } else {
                        System.out.println("Não existe nenhum professor cadastrado até o momento");
                    }

                } else if (opcao == 11) {
                    if (controlador.ca.listarAulas().temProximo()) {
                        Iterador it;
                        it = controlador.ca.listarAulas();
                        Iterador ip;
                        while (it.temProximo()) {
                            Aula aula = (Aula) it.proximo();
                            System.out.println("ID da aula: " + aula.getiD() + " Professor da aula "
                                    + aula.getProfessor().getProfessor()
                                    + " Data da aula "
                                    + aula.getData() + " ");
                            ip = aula.getAluno().iterador();
                            while (ip.temProximo()) {
                                Aluno a = (Aluno) ip.proximo();
                                System.out.println("Nome do aluno " + a.getNome() + " Matrícula: "
                                        + a.getMatricula() + "\n");
                            }

                        }
                    } else {
                        System.out.println("Não existe nenhuma aula a ser ministrada\n");
                    }
                } else if (opcao == 12) {
                    if (controlador.ca.listarProfessor().temProximo()) {
                        imput = new Scanner(System.in);
                        System.out.println("Informe o registro do professor");
                        int codigo = imput.nextInt();
                        Professor p = (Professor) controlador.obterProfessor(codigo);
                        if (p == null) {
                            System.out.println("Não existe professor com o registro informado");
                        } else {
                            if (p.getListaAluno().estaVazia()) {
                                System.out.println("O professor não tem nenhum aluno");
                            }
                            System.out.println("O nome do professor é "+p.getProfessor());
                            controlador.ca.proximosAlunosProfessor(codigo);
                        }
                    } else {
                        System.out.println("Não existe professor matriculado");
                    }
                } else if (opcao == 13) {
                    if (controlador.ca.listarAulas().temProximo()) {
                        controlador.ca.ordenarData();
                    } else {
                        System.out.println("Não existe nenhuma aula a ser ministrada\n");
                    }
                } else if (opcao == 14) {
                    if (controlador.ca.listarAulas().temProximo()) {
                        imput = new Scanner(System.in);
                        System.out.println("Informe o registro do professor que deseja ver suas aulas");
                        int registro = imput.nextInt();
                        Professor p = (Professor) controlador.obterProfessor(registro);

                        if (p == null) {
                            System.out.println("Não existe professor com o ID informado\n");
                        } else {
                            System.out.println("o nome do professor é " + p.getProfessor()
                                    + " seu registro " + p.getRegistro());
                            if (p.getListaAluno().estaVazia()) {
                                System.out.println("O professor não tem alunos");
                            }

                            Iterador it;
                            it = controlador.ca.listarAulas();
                            if (it.temProximo()) {
                                while (it.temProximo()) {
                                    Aula a = (Aula) it.proximo();
                                    if (a.getProfessor().getRegistro() == registro) {
                                        System.out.println("Data da aula " + a.getData() +
                                                " Status da aula " + a.getRealizada());
                                    }
                                }
                            }
                        }

                    } else {
                        System.out.println("Não existe nenhuma aula cadastrada");
                    }
                }

        System.out.println("Aula Free - Sistema de Controle de Aulas Grátis");
        System.out.println("Curso preparatório de línguas");
        System.out.println("1 Cadastrar novo aluno");
        System.out.println("2 Obter aluno por sua matrícula");
        System.out.println("3 Listar todos os alunos cadastrados alunos");
        System.out.println("4 Cadastrar novo professor");
        System.out.println("5 Obter professor pelo seu registro");
        System.out.println("6 Agendar Aula");
        System.out.println("7 Mostrar todos os alunos sem aula agendada");
        System.out.println("8 Mostrar todos os alunos de um professor");
        System.out.println("9 Registrar aula dada");
        System.out.println("10 Listar todos os Professores registrados");
        System.out.println("11 Listar todas as aulas pelo id");
        System.out.println("12 Listar Proximos alunos de um Professor");
        System.out.println("13 Mostrar aula de forma ordenada pela data");
        System.out.println("14 Aulas que um professor ministra");
        System.out.println("Caso não deseje selecionar outra informação é só digitar qualquer"+
                " número diferente do Menu");
        System.out.println("Selecione a opção desejada");

                try {
                    opcao = imput.nextInt();
                } catch (InputMismatchException opca) {
                    imput = new Scanner(System.in);
                    System.out.println("foi informado um valor inválido digite novamente a opção desejada");
                    opcao = imput.nextInt();
                }

            }
        } catch (InputMismatchException opca) {
            System.out.println("foi informado um valor inválido o programa será encerrado"
                    + "");
        }
        System.out.println("Volte sempre a utilizar nossos serviços");
    }
    
            
}
