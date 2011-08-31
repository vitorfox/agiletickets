package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class SessaoTest {


	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		assertThat(sessao.podeReservar(3), is(equalTo(false)));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		assertThat(sessao.getIngressosDisponiveis().intValue(), is(equalTo(2)));
	}
	
	@Test
	public void deveVender2IngressosSeHa2Vagas(){
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);
		assertThat(sessao.podeReservar(2), is(equalTo(true)));
	}
}
