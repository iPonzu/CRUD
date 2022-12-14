import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Veiculo {
    
    private int id;
    private String nome;
    private String marca;
    private String modelo;
    
    private int idEstacionamento;
    
    public static ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Veiculo(
        int id,
        String nome,
        String marca,
        String modelo,
        Estacionamento estacionamento

    )throws SQLException{
        
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.idEstacionamento = estacionamento.getId();

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO (nome, marca, modelo) VALUES (?,?,?) "
        );
        stmt.setInt(1, id);
        stmt.setString(2, nome);
        stmt.setString(3, marca);
        stmt.setString(4, modelo);
        stmt.execute();
        stmt.close();
        
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
    public static void listarVeiculo() throws SQLException {
        Connection connection = DAO.createConnection();
        ResultSet rs = connection.createStatement().executeQuery(
            "SELECT * FROM Veiculo;"
        );
        while(rs.next()){
            System.out.println(
                "ID: " + rs.getInt("id") +
                "Nome: " + rs.getString("nome") +
                "Marca: " + rs.getString("marca") +
                "Modelo: " + rs.getString("modelo")
            );
        }
    }

	public static void removeVeiculo(int id) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "DELETE FROM Veiculo WHERE id = ?;"
        );
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }

    @Override
    public String toString(){
    return "ID: " + id + "\n"
    + "Nome: " + nome + "\n"
    + "Marca: " + marca + "\n"
    + "Modelo: " + modelo + "\n";  
    }


}



