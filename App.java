import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class App{
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        do{
        System.out.println("__________________________________________");
        System.out.println("Bem vindo ao estacionamento");
        System.out.println("Escolha uma opção");
        System.out.println("1 - Cadastrar veículo");
        System.out.println("2 - Listar veículo");
        System.out.println("3 - Excluir veículo");
        System.out.println("4 - Cadastrar vaga");
        System.out.println("5 - Listar vaga");
        System.out.println("6 - Excluir vaga");
        System.out.println("__________________________________________");


        try {
                op = scanner.nextInt();
            } catch (Exception e) {  
             System.out.println("Erro, tente novamente" + e.getMessage());
            }

            switch(op){
                case 1:
                    cadastrarVeiculo(scanner);
                    break;
                case 2:
                    Veiculo.listarVeiculo();
                    break;
                case 3:
                    removeVeiculo(scanner);
                case 4:
                    cadastrarEstacionamento(scanner); //estacionamento = vaga
                    break; 
                case 5:
                    Estacionamento.listarEstacionamento();
                    break;
                case 6:
                    removeEstacionamento(scanner);
                    break;
                }   
        }while(op!= 0);
        scanner.close();
    }
     
    

        public static void cadastrarVeiculo(Scanner scanner) {
            try {
                System.out.println("Cadastrar Veiculo: ");
                System.out.println("Digite seu ID: ");
                int id = scanner.nextInt();
                System.out.println("Informe sua marca: ");
                String marca = scanner.next();
                System.out.println("Informe seu modelo: ");
                String modelo = scanner.next();

                new Veiculo(id, modelo, marca, modelo, null);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        private static void listarVeiculo() {
            for(Veiculo veiculo : Veiculo.veiculos){
                System.out.println(veiculo);
            }
            
        }
        private static void removeVeiculo(Scanner scanner) throws SQLException {
            PreparedStatement stmt = DAO.createConnection().prepareStatement(
                "DELETE FROM Veiculo WHERE id = ?;"
            );
            stmt.setInt(1, 0);
            stmt.execute();
            stmt.close();
        }
            
        
        
        public static void cadastrarEstacionamento(Scanner scanner) throws SQLException {
            try {
                System.out.println("Insira o ID da vaga: ");
                int id = scanner.nextInt();
                System.out.println("Insira o número que a vaga se encontra: ");
                int vaga = scanner.nextInt();
                System.out.println("Insira seu setor: ");
                String setor = scanner.next();

                new Estacionamento(id, vaga, setor);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    

        private static void listarEstacionamento() {
            for(Estacionamento estacionamento : Estacionamento.estacionamentos){
                System.out.println(estacionamento);
            }
        }
        public static void removeEstacionamento(Scanner scanner) throws SQLException {
            try {
                System.out.println("Informe o ID da vaga: ");
                int id = scanner.nextInt();
                Estacionamento.removeEstacionamento(id);
                System.out.println("Removido com êxito");
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
            
        }

}