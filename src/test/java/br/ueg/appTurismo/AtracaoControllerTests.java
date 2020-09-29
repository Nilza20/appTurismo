package br.ueg.appTurismo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import br.ueg.appTurismo.models.Atracao;
import br.ueg.appTurismo.services.AtracaoService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AtracaoControllerTests {
	
	 @LocalServerPort
	 private int port;
	
	 @MockBean
	 private AtracaoService atracaoService;
	 
	 @Autowired
	 private TestRestTemplate testRestTemplate;
	 
	 @Test
     public void getListAtracoesDeveRetornar200() throws Exception {
		 
		 List<Atracao> atracao = new ArrayList<>();
		 atracao.add(new Atracao(1L, "Pista de Caminhada"));
		 atracao.add(new Atracao(2L, "UEG"));
    	
    	BDDMockito.when(atracaoService.listAtracao()).thenReturn(atracao);

        ResponseEntity<String> response = testRestTemplate.getForEntity(
			new URL("http://localhost:" + port + "/atracoes").toString(), String.class);
        assertEquals(200, response.getStatusCodeValue());
     }
	 
	 @Test
     public void getAtracoesByIdDeveRetornar200() throws Exception {
		 Atracao atracao = new Atracao(1L, "Pista de Caminhada");
     	     	
     	 BDDMockito.when(atracaoService.findById(atracao.getId())).thenReturn(atracao);

         ResponseEntity<String> response = testRestTemplate.getForEntity(
 			new URL("http://localhost:" + port + "/atracoes/{id}")
 								.toString(), String.class, atracao.getId());
         assertEquals(200, response.getStatusCodeValue());

     }
	 
	 
	 @Test
     public void saveAtracoesDeveRetornar200() throws Exception {
		 Atracao atracao = new Atracao(1L, "Pista de Caminhada");
     	     	
     	 BDDMockito.when(atracaoService.saveAtracao(atracao)).thenReturn(atracao);

         ResponseEntity<String> response = testRestTemplate.getForEntity(
 			new URL("http://localhost:" + port + "/atracoes")
 								.toString(), String.class, atracao.getId());
         assertEquals(200, response.getStatusCodeValue());

     }
	 
	 
	 @Test
     public void deletarAtracoesDeveRetornar200() throws Exception {
		 Atracao atracao = new Atracao(1L, "Pista de Caminhada");
		 
		 BDDMockito.when(atracaoService.findById(atracao.getId())).thenReturn(atracao);     	     	
     	 BDDMockito.doNothing().when(atracaoService).deleteAtracao(atracao.getId());

         ResponseEntity<String> response = testRestTemplate.getForEntity(
 			new URL("http://localhost:" + port + "/atracoes/{id}")
 								.toString(), String.class, atracao.getId());
         assertEquals(200, response.getStatusCodeValue());

     }
	 
	
}
