import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArmazenadorDeItem adi = new ArmazenadorDeItem();
        ArmazenadorDeUsuario adu = new ArmazenadorDeUsuario();
        Estoque estoque = new Estoque(1);
        Funcionario funcionario = new Funcionario("123.456.789-00", "João Silva", 1234);

        int escolha = -1;

        System.out.println("Bem-vindo ao Sistema de Achados e perdidos!");

        try {
            while (escolha != 0) {

                adi.armazenarArrayList(adi.carregarDoArquivo());
                adu.armazenarArrayList(adu.carregarDoArquivo());
                estoque.armazenarArrayList(estoque.carregarDoArquivo());
                Item i = new Item();

                if(adi.RetornarIdTxt() > estoque.RetornarIdTxt()){
                    int c = adi.RetornarIdTxt();
                    i.setContador(c);
                } else if (adi.RetornarIdTxt() < estoque.RetornarIdTxt()) {
                    int c = estoque.RetornarIdTxt();
                    i.setContador(c);
                } else {
                    int c = adi.RetornarIdTxt();
                    i.setContador(c);
                }

                Usuario u = new Usuario();
                u.setContador(adu.RetornarIdTxt());

                System.out.println("===============================");
                System.out.println("Escolha uma das opções abaixo:");
                System.out.println("1 - Cadastrar Usuário");
                System.out.println("2 - Registrar Item");
                System.out.println("3 - Exibir itens cadastrados");
                System.out.println("4 - Adicionar Item ao Estoque");
                System.out.println("5 - Retirar Item do Estoque");
                System.out.println("0 - Sair");
                System.out.println("===============================");

                System.out.print("Opção: \n");
                escolha = sc.nextInt();
                sc.nextLine(); // Consumir a quebra de linha após o número

                switch (escolha) {
                    case 1 -> {
                        System.out.println("Opção selecionada: Cadastrar Usuário");
                        Usuario user = new Usuario();
                        user.registrarPessoa();
                        adu.armazenarUser(user);
                        adu.salvarEmArquivo();
                    }
                    case 2 -> {
                        System.out.println("Opção selecionada: Registrar Item");
                        Item item = new Item();
                        item.gerarItem();
                        adi.armazenarItem(item);
                        adi.salvarEmArquivo();
                    }
                    case 3 -> {
                        System.out.println("Opção selecionada: Exibir itens cadastrados");
                        TxtLog lerEscrever = new TxtLog();
                        String caminhoLeitura = "src/funcionarios.txt";
                        String conteudo = TxtLog.leitor(caminhoLeitura);
                        System.out.println("Conteúdo Lido:");
                        System.out.println(conteudo);
                        lerEscrever.escritor(caminhoLeitura, conteudo);
                        System.out.println("Conteúdo escrito em: " + caminhoLeitura);
                    }
                    case 4 -> {
                        System.out.println("Opção selecionada: Adicionar Item ao Estoque\n");

                        System.out.println("O Item a ser adicionado já existe no sistema? \nDigite 1 para 'sim' e 2 para 'nao'");
                        int yn = sc.nextInt();

                        if (yn == 1) {
                            System.out.println("Opção selecionada: 'SIM'\n");
                            System.out.print("Informe o ID do item que deseja adicionar ao estoque: \n");
                            int id = sc.nextInt();
                            estoque.armazenarItem(adi.selecionarItem(id));
                            adi.retirarItem(id);
                            adi.salvarEmArquivo();
                            estoque.salvarEmArquivo();
                        } else if (yn == 2) {
                            System.out.println("\nOpção selecionada: 'NAO'\n");
                            System.out.println("Registrar Item\n");
                            Item item = new Item();
                            item.gerarItem();
                            estoque.armazenarItem(item);
                            estoque.salvarEmArquivo();
                        } else{
                            System.out.println("\nOPCAO INVALIDA\n");
                        }
                    }

                    case 5 -> {
                        System.out.println("Opção selecionada: Retirar Item do Estoque");
                        System.out.println("Itens disponíveis no estoque:");

                    }
                    case 0 -> System.out.println("Saindo do sistema... Até logo!");
                    default -> System.out.println("Erro: Opção inválida. Tente novamente.");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro de leitura ou escrita de arquivos: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
            System.out.println("Encerrando o programa...");
        }
    }
}
