package br.uefs.ecomp.aula.facade;
 
import br.uefs.ecomp.aula.util.Iterador;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 *
 * @author Allen
 */
import br.uefs.ecomp.aula.model.*;
import java.util.Date;
 
public class AulaFacadeTest {
    AulaFacade sys;
    Aluno a1, a2, a3, a4, a5;
    Professor p1, p2;
    Date d1, d2, d3;
   
    @Before
    public void setUp() throws Exception {
        sys = new AulaFacade();
        a1 = new Aluno(1,"Jean Almeida");
        a2 = new Aluno(2, "Pericles Souza");
        a3 = new Aluno(3, "Rafaela Diniz");
        a4 = new Aluno(4, "Paula Souto");
        a5 = new Aluno(5, "Saulo Guedez");
        p1 = new Professor(1, "Romulo da Silva");
        p2 = new Professor(2, "Gerusa Mota");
        d1 = new Date(2014, 10, 10, 9, 30);
        d2 = new Date(2014, 10, 10, 14, 30);
        d3 = new Date(2014, 10, 10, 14, 30);
    }
 
    /**
     * Test of cadastrarAluno method, of class AulaFacade.
     */
    @Test
    public void testInserirObter() {
        sys.cadastrarAluno("Jean Almeida");
        assertEquals(sys.obterAluno(1).getNome(), "Jean Almeida");
        sys.cadastrarAluno("Pericles Souza");
        assertEquals(sys.obterAluno(2).getNome(), "Pericles Souza");
        sys.cadastrarAluno("Rafaela Diniz");
        assertEquals(sys.obterAluno(3).getNome(), "Rafaela Diniz");
        sys.cadastrarAluno("Paula Souto");
        assertEquals(sys.obterAluno(4).getNome(), "Paula Souto");
        sys.cadastrarAluno("Saulo Guedez");
        assertEquals(sys.obterAluno(5).getNome(), "Saulo Guedez");
        assertNull(sys.obterAluno(6));
    }
 
    /**
     * Testa se os métodos de cadastrar e obter professor foram implementados
     * corretamente.
     */
    
    @Test
    public void testCadastrarObterProfessor() {
        sys.cadastrarProfessor(1, "Romulo da Silva");
        assertEquals(sys.obterProfessor(1).getProfessor(), "Romulo da Silva");
        sys.cadastrarProfessor(2, "Gerusa Mota");
        assertEquals(sys.obterProfessor(2).getProfessor(), "Gerusa Mota");
        assertNull(sys.obterProfessor(3));
        
    }
    
    @Test
    public void testListarAlunos(){
        
        a1 = sys.cadastrarAluno("Jean Almeida");
        a2 = sys.cadastrarAluno("Pericles Souza");
        a3 = sys.cadastrarAluno("Rafaela Diniz");
       
        Iterador it = sys.listarAlunos();
       
        assertTrue(it.temProximo());
        assertEquals(it.proximo(),a1);
        assertTrue(it.temProximo());
        assertEquals(it.proximo(), a2);
        assertTrue(it.temProximo());
        assertEquals(it.proximo(), a3);
        assertFalse(it.temProximo());
    }
  
   
   
}