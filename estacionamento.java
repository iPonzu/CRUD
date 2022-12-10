import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Estacionamento{
    
    private int id;
    private int vaga;
    private String setor;



    public Estacionamento(
        int id,
        int vaga,
        String setor
    )throws SQLException{
        this.id = id;
        this.vaga = vaga;
        this.setor = setor;
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
}