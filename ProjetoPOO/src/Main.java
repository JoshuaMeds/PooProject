import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Item criarItem() {
        System.out.println("Área de Cadastro de Item!");
        System.out.println("Preencha todos os campos para cadastrar o Item:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cadastre o nome do Item: ");
        String nomeItem = scanner.nextLine();
        System.out.print("Cadastre a categoria do produto: ");
        String categoria = scanner.nextLine();
        System.out.print("Dê uma breve descrição ao produto: ");
        String descricao = scanner.nextLine();
        return new Item(nomeItem, descricao, categoria);
    }

    public static Usuario criarUser() {
        System.out.println("Área de Cadastro de Usuário!");
        System.out.println("Preencha todos os campos para cadastrar um usuário:");
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Informe o nome: ");
        String nome = sc.nextLine();
        System.out.print("Informe o registro: ");
        int matricula = sc.nextInt();
        return new Usuario(cpf, nome, matricula);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque(1, "Depósito Central");
        Funcionario funcionario = new Funcionario("123.456.789-00", "João Silva", 1234);

        int escolha = 0;

        System.out.println("Bem-vindo ao Sistema de Cadastro!");
        System.out.println("===============================");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Cadastrar Item");
        System.out.println("3 - Exibir itens cadastrados");
        System.out.println("4 - Adicionar Item ao Estoque");
        System.out.println("5 - Retirar Item do Estoque");
        System.out.println("0 - Sair");
        System.out.println("===============================");

        try {
            System.out.print("Opção: ");
            escolha = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha após o número

            switch (escolha) {
                case 1 -> {
                    System.out.println("Opção selecionada: Cadastrar Usuário");
                    Usuario u = criarUser();
                    u.registrarPessoa();
                    System.out.println("Usuário cadastrado com sucesso!");
                }
                case 2 -> {
                    System.out.println("Opção selecionada: Cadastrar Item");
                    Item i = criarItem();
                    i.salvarEmArquivo();
                    System.out.println("Item cadastrado com sucesso!");
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
                    System.out.println("Opção selecionada: Adicionar Item ao Estoque");
                    System.out.print("Informe o nome do item que deseja adicionar ao estoque: ");
                    String nomeItem = sc.next(); // Lê o nome do item
                    estoque.adicionarItem(nomeItem); // Tenta adicionar o item pelo nome
                }

                case 5 -> {
                    System.out.println("Opção selecionada: Retirar Item do Estoque");
                    System.out.println("Itens disponíveis no estoque:");
                    estoque.listarItens();

                    System.out.print("Digite o nome do item a ser retirado: ");
                    String nomeItem = sc.nextLine();

                    // Busca o item no estoque com base no nome
                    Item itemParaRetirar = null;
                    for (Item item : estoque.getItens()) {
                        if (item.getNomeItem().equalsIgnoreCase(nomeItem)) {
                            itemParaRetirar = item;
                            break;
                        }
                    }

                    if (itemParaRetirar != null) {
                        funcionario.retirarItemEstoque(estoque, itemParaRetirar);
                        funcionario.registrarRetirada(itemParaRetirar);
                        System.out.println("Item retirado e registrado com sucesso!");
                    } else {
                        System.out.println("Item não encontrado no estoque.");
                    }
                }
                case 0 -> System.out.println("Saindo do sistema... Até logo!");
                default -> System.out.println("Erro: Opção inválida. Tente novamente.");
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
