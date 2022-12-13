import java.util.Scanner;

import javax.swing.SwingUtilities;

public class App{
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        int op = 0;

        do{
        System.out.println("Bem vindo ao estacionamento");
        System.out.println("Escolha uma opção");
        System.out.println("1 - Cadastrar veículo");
        System.out.println("2 - Listar veículo");
        System.out.println("3 - Excluir veículo");



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
                    listarVeiculo();
                    break;
                case 3:
                    removeVeiculo(scanner);
                
            

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
        public static void listarVeiculo() {
            for(Veiculo veiculo : Veiculo.veiculos){
                System.out.println(veiculo);
            }
            
        }
        private static void removeVeiculo(Scanner scanner) {
            System.out.println("Remover Veiculo");
            System.out.println("Digite seu ID: ");
            int idVeiculo = scanner.nextInt();
            try {
                Veiculo.getVeiculo(idVeiculo);
            } catch (Exception e) {
                System.out.println("Erro ao remover o veiculo, tente novamente!" + e.getMessage());
            }
            
        }












}