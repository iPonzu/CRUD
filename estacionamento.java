import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Estacionamento{
    
    private int id;
    private int vaga;
    private String setor;

    static ArrayList<Estacionamento> estacionamentos = new ArrayList<>();

    public Estacionamento(
        int id,
        int vaga,
        String setor
    )throws SQLException{
        this.id = id;
        this.vaga = vaga;
        this.setor = setor;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
          "INSERT INTO Estacionamento (id, vaga, setor) VALUES (?,?,?)"  
        );
        stmt.setInt(1, vaga);
        stmt.setString(2, setor);
        stmt.setInt(3, vaga);
        stmt.execute();
        stmt.close();
    }
    public int getId(){
        return id;
    }
    public int getVaga(){
        return vaga;
    }
    public String getSetor(){
        return setor;
    }
 
    public void setId(int id){
        this.id = id;
    }
    public void setVaga(int vaga){
        this.vaga = vaga;
    }
    public void setSetor(String setor){
        this.setor = setor;
    }

    public static Estacionamento getEstacionamento(int id) throws Exception {
        for(Estacionamento estacionamento : estacionamentos){
            if(estacionamento.getId() == id)
            return estacionamento;
        }
        throw new Exception("Não foi possível cadastrar, tente novamente");
    }
    public static void listarEstacionamento() throws SQLException {
        Connection connection = DAO.createConnection();
        ResultSet rs = connection.createStatement().executeQuery(
            "SELECT * FROM Estacionamento;"
        );
        while(rs.next()){
            System.out.println(
                "ID: " + rs.getInt("id") +
                "Vaga: " + rs.getString("vaga") +
                "Setor: " + rs.getString("setor")
            );
        }
        
    }
    public static void removeEstacionamento(int id) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "DELETE FROM Estacionamento WHERE id = ?;"
        );
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
    
    @Override 
    public String toString(){
        return "ID: " + id + "\n"
            + "Vaga: " + vaga + "\n"
            + "Setor: " + this.setor + "\n";
    }
    
    @Override
    public boolean equals (Object object){
        if(object == null || !(object instanceof Veiculo)){
            return false;
        }
        final Veiculo other = (Veiculo) object;
        
        return this.getId() == other.getId();
    }
}