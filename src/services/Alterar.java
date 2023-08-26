package services;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import model.Veiculo;
import model.Viagem;
import util.Util;

public class Alterar {
	protected ObjectContainer manager;
	
	public Alterar() {
		try {
			manager = Util.conectarBanco();
			Query query, query2;
			
			System.out.println("Iniciando alterações");
			
			query = manager.query();
			query.constrain(Veiculo.class);
			query.descend("capacidade").constrain(7);
			List<Veiculo> resultado = query.execute();
			
			if(resultado.size()>0) {
				for(Veiculo v : resultado) {
					//alterando capacidade
					v.setCapacidade(4);
					manager.store(v);
					manager.commit();
					System.out.println("Veiculo : " + v + " - Tiveram a capacidade alterada para 4 " );
				}
				
			}
			
			System.out.println("Iniciando alterações nas viagens...");
			
			//
			query2 = manager.query();
			query2.constrain(Viagem.class);
			  
			 ObjectSet<Viagem> resultado2 = query2.execute();
			
			for( Viagem vi: resultado2) {
				if(vi.getQuantidade() > vi.getVeiculo().getCapacidade()) {
					vi.setQuantidade(vi.getVeiculo().getCapacidade());
					System.out.println("A viagem:" + vi + " teve sua capacidade corrigida " );
				}
			}
			
			Util.desconectar();
			System.out.println("Alterações feitas com sucesso!");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		new Alterar();
	}
}
