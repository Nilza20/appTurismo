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

import br.ueg.appTurismo.models.Estabelecimento;
import br.ueg.appTurismo.services.EstabelecimentoServices;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EstabelecimentoControllerTest {
	
	
	@LocalServerPort
	private int port;
	
	@MockBean
	private EstabelecimentoServices estabelecimentoService;
	 
	@Autowired
	private TestRestTemplate testRestTemplate;
	 
	@Test
    public void getListAtracoesDeveRetornar200() throws Exception {
	 
		 List<Estabelecimento> estabelecimento = new ArrayList<>();
		 estabelecimento.add(new Estabelecimento(1L, "Pizzaria"));
   	
		 BDDMockito.when(estabelecimentoService.listEstabelecimento()).thenReturn(estabelecimento);

	     ResponseEntity<String> response = testRestTemplate.getForEntity(
				new URL("http://localhost:" + port + "/estabelecimentos").toString(), String.class);
	     assertEquals(200, response.getStatusCodeValue());
    }
	 
	 @Test
    public void getAtracoesByIdDeveRetornar200() throws Exception {
		 Estabelecimento estabelecimento = new Estabelecimento(1L, "Pizzaria");
    	     	
    	 BDDMockito.when(estabelecimentoService.findEstabelecimentoById(estabelecimento.getId())).thenReturn(estabelecimento);

        ResponseEntity<String> response = testRestTemplate.getForEntity(
			new URL("http://localhost:" + port + "/estabelecimentos/{id}")
								.toString(), String.class, estabelecimento.getId());
        assertEquals(200, response.getStatusCodeValue());

    }
	 
	 
	 @Test
    public void saveAtracoesDeveRetornar200() throws Exception {
		 Estabelecimento estabelecimento = new Estabelecimento(1L, "Pizzaria");
    	     	
    	 BDDMockito.when(estabelecimentoService.saveEstabelecimento(estabelecimento)).thenReturn(estabelecimento);

        ResponseEntity<String> response = testRestTemplate.getForEntity(
			new URL("http://localhost:" + port + "/estabelecimentos")
								.toString(), String.class, estabelecimento.getId());
        assertEquals(200, response.getStatusCodeValue());

    }
	 
	 
	 @Test
    public void deletarAtracoesDeveRetornar200() throws Exception {
		 Estabelecimento estabelecimento = new Estabelecimento(1L, "Pizzaria");
		 
		 BDDMockito.when(estabelecimentoService.findEstabelecimentoById(estabelecimento.getId())).thenReturn(estabelecimento);     	     	
    	 BDDMockito.doNothing().when(estabelecimentoService).deleteEstabelecimento(estabelecimento.getId());

        ResponseEntity<String> response = testRestTemplate.getForEntity(
			new URL("http://localhost:" + port + "/estabelecimentos/{id}")
								.toString(), String.class, estabelecimento.getId());
        assertEquals(200, response.getStatusCodeValue());

    }
}
