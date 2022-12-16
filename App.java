import java.util.Scanner;
import java.sql.SQLException;

public class App {
    
    public static void main(String[] args) throws SQLException{
        
        int op = 0;
        System.out.println("Bem vindo ao CarPark Plaza");
        do{
            System.out.println("__________________________________________");
            System.out.println("1 - Cadastrar Veiculo: ");
            System.out.println("2 - Listar Veiculo: ");
            System.out.println("3 - Atualizar Veiculo: ");
            System.out.println("4 - Excluir Veiculo: ");
            System.out.println("5 - Cadastrar Estacionamento: ");
            System.out.println("6 - Listar Estacionamento: ");
            System.out.println("7 - Atualizar Estacionamento: ");
            System.out.println("8 - Excluir Estacionamento: ");
            System.out.println("__________________________________________");
            
            try{
                op = scanner.nextInt();
            }catch (Exception e){
                op = 0;
            }
            
            switch (op) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    Veiculo.listarVeiculo();
                    break;
                case 3: 
                    System.out.println("Insira o ID do veículo que você quer atualizar: ");
                    int idVeiculo = scanner.nextInt();
                    System.out.println("Informe sua marca: ");
                    String marca = scanner.next();
                    System.out.println("Agora informe seu modelo: ");
                    String modelo = scanner.next();
                    new Veiculo(idVeiculo, marca, modelo);
                    break;
                case 4: 
                    deleteVeiculo();
                    break;
                case 5:
                    cadastrarEstacionamento();
                    break;
                case 6:
                    Estacionamento.listarEstacionamento();
                    break;
                case 7: 
                    System.out.println("Informe o ID da vaga que você gostaria de atualizar");
                    int idEstacionamento = scanner.nextInt();
                    System.out.println("Agora informe o número da vaga: ");
                    int vaga = scanner.nextInt();
                    System.out.println("Informe o setor da vaga");
                    String setor = scanner.next();
                    Estacionamento.updateEstacionamento(idEstacionamento, vaga, setor);
                    break;
                case 8: 
                    removeEstacionamento();
                    break;
            }
        }while(op!= 0);
        scanner.close();
    }


    public static void cadastrarVeiculo() throws SQLException{
        try{
            System.out.println("Cadastro de Veiculos");
            System.out.println("Digite o ID do Veiculo: ");
            int idVeiculo = scanner.nextInt();
            System.out.println("Informe a marca do veículo: ");
            String marca = scanner.next();
            System.out.println("Informe o modelo do veículo: ");

            String modelo = scanner.next();
            new Veiculo(idVeiculo, marca, modelo);
        }catch(Exception e){
            System.out.println("Erro ao cadastrar o Veiculo " + e.getMessage());
        }
    }
    
    public static void deleteVeiculo() throws SQLException{
        try{
            System.out.println("Informe o id do Veiculo: ");
            int idVeiculo = scanner.nextInt();
            Veiculo.deleteVeiculo(idVeiculo);
            System.out.println("Veiculo removido com sucesso!");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
        
    public static void cadastrarEstacionamento(){
        try{
            System.out.println("Cadastro de Estacionamento");
            System.out.println("Digite o ID da vaga: ");
            int idEstacionamento = scanner.nextInt();
            System.out.println("Digite o numero da vaga: ");
            int vaga = scanner.nextInt();
            System.out.println("Informe o setor da vaga");
            String setor = scanner.next();
            
            new Estacionamento(idEstacionamento, vaga, setor);
        }catch(Exception e){
            System.out.println("Erro ao cadastrar o Estacionamento");
        }
    }
    
    public static void removeEstacionamento() throws SQLException{
        try{
        System.out.println("Informe o id do Estacionamento");
        int idEstacionamento = scanner.nextInt();
        Estacionamento.removeEstacionamento(idEstacionamento);
        System.out.println("Estacionamento removido com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Scanner scanner = new Scanner(System.in);
}
//end