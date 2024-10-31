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
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Usuario user = new Usuario("123", "Carlos", 1);
        Funcionario fun = new Funcionario("132", "Adilson", 2);
        Funcionario adm = new Admin("1", "administro", 4);

        Scanner sc = new Scanner(System.in);
        int escolha = 0;

        System.out.println("Escolha oque fazer:");
        System.out.println("1-Cadastrar usuario");
        escolha = sc.nextInt();

        switch (escolha){
            case 1:
                System.out.println("Informe o cpf");
                String cpf = sc.next();
                System.out.println("Informe o nome");
                String nome = sc.next();
                System.out.println("Informe o Registro");
                int registro = sc.nextInt();

                Funcionario u = new Funcionario(cpf,nome,registro);
                u.registrarPessoa();

                System.out.println("Usuario de nome "+nome+" cpf "+cpf+" e registro "+registro+" Adicionado ao Sistema");
                break;

            case 2:
                System.out.println("estro 2");
                Item i = criarItem();
                i.salvarEmArquivo();
            default:
                System.out.println("Erro");
        }


    }
}