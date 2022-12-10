import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionDB {
    public static void main(String[] args) {
        try{
            Connection connection = DAO.createConnection();
            // Usuario usuario = new Usuario("lucas.doces", "Lucas dos Doces", "773");

            /* INSERT Usuário */
            /*PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO usuario (user_name, name, password) VALUES (?, ?, ?);"
            );
            stmt.setString(1, usuario.getUserName());
            stmt.setString(2, usuario.getName());
            stmt.setString(3, usuario.getPassword());
            stmt.execute();*/

            /* SELECT ALL USERS */
            imprimirUsuarios(connection);

            /* DELETE id = 2 */
            PreparedStatement stmt = connection.prepareStatement(
                "DELETE FROM usuario WHERE id = ?;"
            );
            stmt.setInt(1, 2);
            stmt.execute();
            imprimirUsuarios(connection);

            /* UPDATE id = 1 */
            stmt = connection.prepareStatement(
                "UPDATE usuario SET user_name = ?, name = ?, password = ? WHERE id = ?;"
            );
            stmt.setString(1, "tia.bolos");
            stmt.setString(2, "Tia dos Bolos");
            stmt.setString(3, "123457");
            stmt.setInt(4, 1);
            stmt.execute();
            imprimirUsuarios(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static void imprimirUsuarios(Connection connection) throws Exception {
        ResultSet rs = connection.createStatement().executeQuery(
            "SELECT * FROM usuario;"
        );
        while(rs.next()){
            User usuario2 = new Usuario(
                rs.getInt("id"), 
                rs.getString("user_name"),
                rs.getString("name"),
                rs.getString("password")
            );
            System.out.println(usuario2);
            System.out.println("-------------------------------");
        }
    }
}