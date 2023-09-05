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
        System.out.println("\n\nAviso: feche sempre o plugin OME antes de executar a aplicação");
    }

    public void consultar() {
        // Consultando viagens da data de 18/01/2023
        System.out.println("\nViagens da data de 18/01/2023");
        Query q = manager.query();
        q.constrain(Viagem.class);
        q.descend("data").constrain("18/01/2023");
        List<Viagem> resultado_viagem = q.execute();
        for (Viagem vi : resultado_viagem) {
            try {
                System.out.println(vi);
            } catch (NullPointerException e) {
                // Se uma exceção for lançada, apenas continue o loop sem imprimir a viagem nula
                continue;
            }
        }

        // Consultado as viagens com o veículo de placa JYQ-1219
        System.out.println("\nViagens do veículo JYQ-1219");
        Query q2 = manager.query();
        q2.constrain(Veiculo.class);
        q2.descend("placa").constrain("JYQ-1219");
        List<Veiculo> resultado_viagens_veiculo = q2.execute();
        for (Veiculo veiculo : resultado_viagens_veiculo) {
            for (Viagem vi : veiculo.getViagem()) {
                try {
                    System.out.println(vi);
                } catch (NullPointerException e) {
                    // Se uma exceção for lançada, apenas continue o loop sem imprimir a viagem nula
                    continue;
                }
            }
        }

        // Consultando motoristas que tenham mais de 5 viagens
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
