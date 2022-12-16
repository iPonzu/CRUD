import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Estacionamento {
    
    private int idEstacionamento;
    private int vaga;
    private String setor;

    public Estacionamento(
        int idEstacionamento,
        int vaga,
        String setor

    ) throws SQLException{
        this.idEstacionamento = idEstacionamento;
        this.vaga = vaga;
        this.setor = setor;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO Estacionamento (idEstacionamento, vaga, setor) VALUES (?, ? ,?)"
        );
        stmt.setInt(1, idEstacionamento);
        stmt.setInt(2, vaga);
        stmt.setString(3, setor);
        stmt.execute();
        stmt.close();
    }
    public int getId(){
        return idEstacionamento;
    }
    public void setId(int idEstacionamento){
        this.idEstacionamento = idEstacionamento;
    }
    public String setor(){
        return setor;
    }
    public void setSetor(){
        this.setor = setor;
    }
    public int getVaga(){
        return vaga;
    }
    public void setVaga(int vaga){
        this.vaga = vaga;
    }

    public static void listarEstacionamento() throws SQLException{
        Connection connec = DAO.createConnection();
        ResultSet rs = connec.createStatement().executeQuery(
            "SELECT * FROM Estacionamento;"
        );
        while(rs.next()){
            System.out.println(
                "ID: " + rs.getInt("idEstacionamento") + 
                "vaga: " + rs.getString("vaga") + 
                "setor: " + rs.getInt("setor") 
            );

        }

    }

    public static void updateEstacionamento(int idEstacionamento, int vaga, String setor) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "UPDATE Estacionamento SET id = ?, vaga = ?, setor = ? WHERE vaga = ?;"
            );
            stmt.setInt(1, idEstacionamento);
            stmt.setInt(2, vaga);
            stmt.setString(2, setor);
            stmt.close();
    }
    public static void removeEstacionamento(int idEstacionamento) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "DELETE FROM Estacionamento WHERE id = ?;"
            );
            stmt.setInt(1, idEstacionamento);
            stmt.execute();
            stmt.close();
    }
    
    @Override 
    public String toString(){
        return "Id: " + this.idEstacionamento + "\n"
            + "vaga: " + vaga + "\n"
            + "setor: " + setor + "\n";
    }
    
    @Override
    public boolean equals (Object object){
        if(object == null || !(object instanceof Estacionamento)){
            return false;
        }
        final Estacionamento other = (Estacionamento) object;
        
        return this.getId() == other.getId();
    }
    
}
