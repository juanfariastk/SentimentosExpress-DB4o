package model;

public class Viagem {
	private int id;
	private String data;
	private Veiculo veiculo ;
	private Motorista motorista;
	private String destino;
	private int quantidade;
	
	public Viagem(int id, String data, Veiculo veiculo, Motorista motorista, String destino, int quantidade) {
        this.id = id;
        this.data = data;
        this.destino = destino;
        this.quantidade = quantidade;
        this.veiculo = veiculo;
        this.motorista = motorista;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Viagem [id=" + id + ", data=" + data + ", veiculo=" + veiculo + ", motorista=" + motorista
				+ ", destino=" + destino + ", quantidade=" + quantidade + "]";
	}

}