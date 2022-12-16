import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Veiculo {

    private int idVeiculo;
    private String marca;
    private String modelo;
    private int idEstacionamento;


    public Veiculo(
        int idVeiculo,
        String marca,
        String modelo

    )throws SQLException{

        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.idEstacionamento = idEstacionamento;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO Veiculo (idVeiculo, marca, modelo, estacionamento_idEstacionamento) VALUES (?, ?, ?, ?)"
        );
        stmt.setInt(1, idVeiculo);
        stmt.setString(2, marca);
        stmt.setString(3, modelo);
        stmt.setInt(1, 1);
        stmt.execute();
        stmt.close();
    } 

    public static void listarVeiculo() throws SQLException{
        Connection connec = DAO.createConnection();
        ResultSet rs = connec.createStatement().executeQuery(
            "SELECT * FROM Veiculo;"
        );
        while(rs.next()){
            System.out.println(
                "ID: " + rs.getInt("idVeiculo") + 
                "Descrição: " + rs.getString("marca") + 
                "modelo: " + rs.getString("modelo")  
            );
        }
    }

    public static void updateVeiculo(int idVeiculo, String marca, String modelo) throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "UPDATE Veiculo SET id = ?, marca = ?, modelo = ? WHERE id = ?;"
        );
        stmt.setInt(1, idVeiculo);   
        stmt.setString(2, marca);  
        stmt.setString(3, modelo);  
        stmt.close(); 
        stmt.execute();
    }

    public static void deleteVeiculo(int idVeiculo) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "DELETE FROM Veiculo WHERE idVeiculo = ?;"
        );
        stmt.setInt(1, idVeiculo);
        stmt.execute();
        stmt.close();
    }
    
    public int getidVeiculo(){
        return idVeiculo;
    }
    public void setId(int idVeiculo){
        this.idVeiculo = idVeiculo;
    }
    public String getmarca(){
        return marca;
    }
    public void setmarca(String marca){
        this.marca = marca;
    }
    public String getmodelo(){
        return modelo;
    }
    public void setmodelo(String modelo){
        this.modelo = modelo;
    }
    public void idEstacionamento(int idEstacionamento){
        this.idEstacionamento = idEstacionamento;
    }

    @Override
    public String toString(){
        return "Id: " + idVeiculo + "\n"
        + "Descrição: " + marca + "\n"
        + "modelo: " + modelo + "\n";
    } 

    @Override 
    public boolean equals (Object object){
        if(object == null || !(object instanceof Veiculo)){
            return false;
        }
        final Veiculo other = (Veiculo) object;

        return this.getidVeiculo() == other.getidVeiculo();
    }
}
