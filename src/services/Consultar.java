package services;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import model.*;

import util.Util;

public class Consultar {
	protected ObjectContainer manager;
	public Consultar() {
		manager = Util.conectarBanco();
		consultar();
		Util.desconectar();
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicação");
		
	}
	
	public void consultar() {
		
		//consultando viagens da data de 18/01/2023
		System.out.println("\nViagens da data de 18/01/2023");
		Query q = manager.query();
		q.constrain(Viagem.class);
		q.descend("data").constrain("18/01/2023");
		List<Viagem> resultado_viagem = q.execute();
		for(Viagem vi: resultado_viagem) {
			System.out.println(vi);
		}
		
		//consultado as viagens com o veiculo de placa JYQ-1219
		System.out.println("\nViagens do veiculo JYQ-1219");
		Query q2 = manager.query();
		q2.constrain(Veiculo.class);
		q2.descend("placa").constrain("JYQ-1219");
		List<Veiculo> resultado_viagens_veiculo = q2.execute();
		for(Viagem vi: resultado_viagens_veiculo.get(0).getViagem()) {
			System.out.println(vi);
		}
		
		//consultando motoristas que tenham mais de 5 viagens
		 System.out.println("\nMotoristas com mais de 5 viagens:");
		 Query q3 = manager.query();
		 q3.constrain(Motorista.class);
		 q3.descend("lista").descend("id").constrain(5).greater();
		 List<Motorista> resultado_motoristas = q3.execute();
		 for (Motorista motorista : resultado_motoristas) {
		    System.out.println(motorista.getNome());
		 }
		
		
	}
	
	public static void main(String[] args) {
		new Consultar();
	}
}
