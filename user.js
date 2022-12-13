class User {
    constructor(username, name, password) {
      this.id = 0;
      this.username = null;
      this.name = null;
      this.password = null;
  
      this.username = this.username;
      this.name = this.name;
      this.password = this.password;
      let stmt = DAO.createConnection().prepareStatement('INSERT INTO user (username, name, password) VALUES (?, ?, ?);');
      stmt.setString(1, this.getUsername());
      stmt.setString(2, this.getName());
      stmt.setString(3, this.getPassoword());
      stmt.execute();
      DAO.closeConnection();
    }
    getId() {
      return this.id;
    }
    setId(id) {
      this.id = this.id;
    }
    getUsername() {
      return this.username;
    }
    setUsername(username) {
      this.username = this.username;
    }
    getName() {
      return this.name;
    }
    setName(name) {
      this.name = this.name;
    }
    getPassword() {
      return this.password;
    }
    setPassword(password) {
      this.password = this.password;
    }
    toString() {
      return 'Usuário {' + '\n' + 'ID: ' + this.id + '\n' + 'Username: ' + this.username + '\n' + 'Name: ' + this.name + '\n' + 'Password: ' + this.password + '}';
    }
    equals(object) {
      if (object === null || !(object instanceof User)) {
        return false;
      }
      const other = object;
      return this.id === other.id;
    }
  }