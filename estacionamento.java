import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class estacionamento{
    
    private int id;
    private int vaga;
    private String setor;



    estacionamento(
        int id,
        int vaga,
        String setor
    )throws SQLException{
        this.id = id;
        this.vaga = vaga;
        this.setor = setor;
    }

    
}