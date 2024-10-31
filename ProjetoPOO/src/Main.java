import java.util.Scanner;

public class Main {
    public static Item criarItem() {
        System.out.println("Área de Cadastro de Item!" +
                "Preencha todos os campos para cadastrar o Item:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastre o nome do Item:");
        String nomeItem = scanner.nextLine();
        System.out.println("Cadastre a categoria do produto:");
        String categoria = scanner.nextLine();
        System.out.println("De uma breve descrição ao produto:");
        String descricao = scanner.nextLine();
        return new Item(nomeItem, descricao, categoria);
    }

    // Criar cliente
    public static Usuario criarUser(){
        System.out.println("Área de Cadastro de Usuario!" +
                "Preencha todos os campos para cadastrar um usuario:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o cpf");
        String cpf = sc.nextLine();
        System.out.println("Informe o nome");
        String nome = sc.nextLine();
        System.out.println("Informe o Registro");
        int matricula = sc.nextInt();
        return new Usuario(cpf,nome,matricula);
    }

    // Criar funcionário e admin
    public static Funcionario criarUser2() {
        System.out.println("Área de Cadastro de Usuario!" +
                "Preencha todos os campos para cadastrar um usuario:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o cpf");
        String cpf = sc.nextLine();
        System.out.println("Informe o nome");
        String nome = sc.nextLine();
        System.out.println("Informe o Registro");
        int matricula = sc.nextInt();
        // Cadastrar como ADM (A)
        // if A -->  return new Admin(cpf,nome,matricula);
        // else --> return new Funcionario(cpf,nome,matricula)
        return new Admin(cpf,nome,matricula);
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        int escolha = 0;

        System.out.println("Escolha oque fazer:");
        System.out.println("1-Cadastrar Usuario");
        System.out.println("2-Cadastrar Item");
        escolha = sc.nextInt();

        switch (escolha){
            case 1:
                Usuario u = criarUser();
                u.registrarPessoa();
                break;

            case 2:
                Item i = criarItem();
                i.salvarEmArquivo();
                break;
            default:
                System.out.println("Erro");
        }


    }
}