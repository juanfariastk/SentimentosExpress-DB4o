package services;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import model.Motorista;
import model.Veiculo;
import model.Viagem;
import util.Util;

public class Deletar {
	
	protected ObjectContainer manager;
	
	public Deletar() {
		try {
			
			manager = Util.conectarBanco();
			System.out.println("Deletando registros...");
			
			//deletando viagem para Augusta
			Query q = manager.query();
			q.constrain(Viagem.class);
			
			Query q2 = manager.query();
			q2.constrain(Veiculo.class);
			
			Query q3 = manager.query();
			q3.constrain(Motorista.class);
			
			q.descend("destino").constrain("Augusta");
			List<Viagem> resultado = q.execute();
			
			List<Motorista> motoristas  = q3.execute();
			List<Veiculo> veiculos  = q2.execute();
			
			if(resultado.size()>0) {
				
				for(Motorista mo : motoristas) {
					if(mo.localizarViagem(resultado.get(0).getDestino()) != null) {
						manager.delete(resultado);
						manager.commit();
					}
						
				}
				
				for(Veiculo vi : veiculos) {
					if(vi.localizarViagem(resultado.get(0).getDestino()) != null) {
						manager.delete(resultado);
						manager.commit();
					}
					
						
				}
				
				
				manager.delete(resultado);
				manager.commit();
				System.out.println("Viagem para Augusta apagada com sucesso!");
			}
			
			
			
			Util.desconectar();
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new Deletar();
	}
}
