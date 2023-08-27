package services;

import com.db4o.ObjectContainer;

import util.Util;
import model.Motorista;
import model.Veiculo;
import model.Viagem;

public class Cadastrar {
	
	protected ObjectContainer manager;
	
	public Cadastrar() {
		try {
			manager = Util.conectarBanco();
			System.out.println("Realizando cadastros...");
			
			//motoristas
			Motorista motorista1, motorista2, motorista3, motorista4;
			motorista1 = new Motorista("68418818452", "Carlinho do Financeiro");
			motorista2 = new Motorista("24030964862", "Leozinho do Borel");
			motorista3 = new Motorista("95752634310", "Zezão Pé Grande");
			motorista4 = new Motorista("51704264906", "Juquinha da Esquina");
			
			//Veiculos
			Veiculo veiculo1, veiculo2, veiculo3, veiculo4;
			veiculo1 = new Veiculo("KBU-0214",4);
			veiculo2 = new Veiculo("NEM-9988",7);
			veiculo3 = new Veiculo("JYQ-1219",6);
			veiculo4 = new Veiculo("HYU-7848",7);
			
			//Viagens
			Viagem destino1, destino2, destino3, destino4;
			destino1 = new Viagem(Util.gerarIdViagem(), "22/10/2022", veiculo1, motorista1, "Recife", 4 );
			veiculo1.addViagem(destino1);
			motorista1.addViagem(destino1);
			
			destino2 = new Viagem(Util.gerarIdViagem(), "10/12/2022", veiculo2, motorista2, "Guarapari", 3 );
			veiculo2.addViagem(destino2);
			motorista2.addViagem(destino2);
			
			destino3 = new Viagem(Util.gerarIdViagem(), "01/09/2022", veiculo3, motorista3, "Bariloche", 7 );
			veiculo3.addViagem(destino3);
			motorista3.addViagem(destino3);
			
			destino4 = new Viagem(Util.gerarIdViagem(), "01/09/2022", veiculo4, motorista4, "Bariloche", 4);
			veiculo4.addViagem(destino4);
			motorista4.addViagem(destino4);
			
			
			//salvando motoristas
			manager.store(motorista1);
			manager.commit();
			manager.store(motorista2);
			manager.commit();
			manager.store(motorista3);
			manager.commit();
			manager.store(motorista4);
			manager.commit();
			
			//salvado veiculos
			manager.store(veiculo1);
			manager.commit();
			manager.store(veiculo2);
			manager.commit();
			manager.store(veiculo3);
			manager.commit();
			manager.store(veiculo4);
			manager.commit();
			
			//salvando viagens
			manager.store(destino1);
			manager.commit();
			manager.store(destino2);
			manager.commit();
			manager.store(destino3);
			manager.commit();
			manager.store(destino4);
			manager.commit();
			
			Util.desconectar();
			System.out.println("\n Cadastros realizados com sucesso!");
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	public static void main(String[] args) {
		new Cadastrar();
	}

}
