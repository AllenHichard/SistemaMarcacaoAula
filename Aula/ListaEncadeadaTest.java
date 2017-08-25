package br.uefs.ecomp.aula.util;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
 
/**
 * Classe que testa a lista encadeada.
 */
public class ListaEncadeadaTest {
    ListaEncadeada list;
    Integer data1, data2, data3;
 
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() {
        list = new ListaEncadeada();
        data1 = new Integer(1);
        data2 = new Integer(2);
        data3 = new Integer(3);
    }    
 
    /**
     * Teste de unidade que verifica se a inserção de objetos na lista está
     * ocorrendo de forma correta.
     */
    @Test
    public void testInsere(){
        list.insereFinal(data1);
        assertEquals(data1, list.recupera(0));
        list.insereFinal(data2);
        assertEquals(data2, list.recupera(1));
        assertEquals(2, list.tamanho());
       
        list.insereInicio(data3);
        assertEquals(data3, list.recupera(0));
        assertEquals(data1, list.recupera(1));
        assertEquals(3, list.tamanho());
    }
   
    /**
     * Teste de unidade que verifica se os elementos da lista estão sendo
     * recuperados corretamente.
     */
    @Test
   public void testeRecuperar(){
       list.insereFinal(data3);
       list.insereInicio(data2);
       list.insereInicio(data1);
       
       assertEquals(data1, list.recupera(0));
       assertEquals(data2, list.recupera(1));
       assertEquals(data3, list.recupera(2));
   }
   
   /**
    * Teste de unidade que verifica se os métodos de inserção e remoção estão
    * funcionando corretamente.
    */
   @Test
   public void testeAdicionarRemover(){
       assertNull(list.removeUltimo());
       
       list.insereFinal(data1);
       list.insereFinal(data2);
       list.insereFinal(data3);
       assertFalse(list.estaVazia());
       
       list.removeUltimo();
       assertFalse(list.estaVazia());
       
       list.removeInicio();
       assertFalse(list.estaVazia());
       
       list.removeUltimo();
       assertTrue(list.estaVazia());
   }
   
   /**
    * Teste de unidade que verifica se o número de elementos informado pelo
    * método está correto.
    */
   @Test
   public void testeTamanho(){
       assertEquals(list.tamanho(), 0);
       
       list.insereInicio(data1);
       assertEquals(list.tamanho(), 1);
       list.insereInicio(data2);
       assertEquals(list.tamanho(), 2);
       list.insereFinal(data3);
       list.removeUltimo();
       assertEquals(list.tamanho(), 2);
       list.insereFinal(data3);
       assertEquals(list.tamanho(), 3);
   }
   
   /**
    * Teste de unidade que verifica se o Iterador está funcionando corretamente.
    */
   @Test
   public void testeIterador(){  
       Iterador it = list.iterador();
       assertFalse(it.temProximo());
       
       list.insereInicio(data3);
       list.insereInicio(data2);
       list.insereInicio(data1);
       
       assertEquals(3, list.tamanho());
       
       it=list.iterador();
       assertTrue(it.temProximo());
       
       assertEquals(data1, it.proximo());
       assertTrue(it.temProximo());
       
       assertEquals(data2, it.proximo());
       assertTrue(it.temProximo());
       
       assertEquals(data3, it.proximo());
       assertFalse(it.temProximo());  
   }
   
}