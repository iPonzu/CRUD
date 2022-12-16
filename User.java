import java.sql.PreparedStatement;

public class User {
    private int id;
    private String username;
    private String name;
    private String password;
  
  public User(
    String username,
    String name,
    String password
  ) throws Exception {
      
      this.username = username;
      this.name = name;
      this.password = password;
    
    PreparedStatement stmt = DAO.createConnection().prepareStatement(
        "INSERT INTO user (username, name, password) VALUES (?, ?, ?);" );
    
      stmt.setString (1, this.getUsername());
      stmt.setString (2, this.getName());
      stmt.setString (3, this.getPassword()); 
      stmt.execute();  
      DAO.closeConnection();
  }
  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
  @Override
  public String toString(){
    return "Usuário {" + "\n"
      + "ID: " + id + "\n"
      + "Username: " + username + "\n"
      + "Name: " + name + "\n"
      + "Password: "  + password + "}";
  }
  
  @Override
  public boolean equals(Object object) {
    if ( object == null || !( object instanceof User)) {
      return false;
    }
    final User other = (User) object;
    
    return this.id == other.id;
  }
}