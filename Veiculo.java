import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Veiculo {
    
    private int id;
    private String nome;
    private String marca;
    private String modelo;
    
    private int idEstacionamento;

    public Veiculo(
        int id,
        String nome,
        String marca,
        String modelo,
        Estacionamento estacionamento
    ){
        
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.idEstacionamento = estacionamento.getId();
        
    }
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public void setId(){
        this.id = id;
    }
    public void setNome(){
        this.nome = nome;
    }
    public void setMarca(){
        this.marca = marca;
    }
    public void setModelo(){
        this.modelo = modelo;
    }
    
    
    public static Veiculo getVeiculo(int id) throws Exception {
        for(Veiculo veiculo : veiculos){
            if(veiculo.getId() == id){
                return veiculo;
            }
        }
        throw new Exception("Veiculo não encontrado");
    
    }

	public static void removeVeiculo(int idVeiculo) throws Exception {
        Veiculo veiculo = getVeiculo(idVeiculo);
        veiculo.remove(veiculo);
	}
}


@Override
public String toString(){
    return "ID: " + id + "\n"
    + "Nome: " + nome + "\n"
    + "Marca: " + marca + "\n"
    + "Modelo: " + modelo + "\n";  
}
