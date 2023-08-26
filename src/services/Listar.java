package services;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import model.Veiculo;
import model.Viagem;
import model.Motorista;
import util.Util;

public class Listar {
	protected ObjectContainer manager;
	
	public Listar() {
		
		try {
			manager = Util.conectarBanco();
			
			System.out.println(" -> Lista de Viagens  <- ");
			Query q = manager.query();
			q.constrain(Viagem.class);
			List<Viagem> viagensResultado = q.execute();
			for (Viagem vi: viagensResultado){
				System.out.println(vi);
			}
			
			System.out.println(" -> Lista de Veículos  <- ");
			
			Query q2 = manager.query();
			q2.constrain(Veiculo.class);
			List<Veiculo> veiculoResultado = q2.execute();
			for (Veiculo ve: veiculoResultado) {
				System.out.println(ve);
			}
			
			System.out.println(" -> Lista de Motoristas  <- ");
			
			Query q3 = manager.query();
			q3.constrain(Motorista.class);
			List<Motorista> motoristaResultado = q3.execute();
			for (Motorista mo: motoristaResultado) {
				System.out.println(mo);
			}
			
			System.out.println("Listagem encerrada!");
			
			Util.desconectar();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new Listar();
	}
	
}
