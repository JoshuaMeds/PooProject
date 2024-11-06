import java.io.IOException;
import java.util.Scanner;

public class Main {

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
        ArmazenadorDeItem adi = new ArmazenadorDeItem();
        Estoque estoque = new Estoque(1);
        Funcionario funcionario = new Funcionario("123.456.789-00", "João Silva", 1234);

        int escolha = -1;

        System.out.println("Bem-vindo ao Sistema de Achados e perdidos!");

        try {
            while (escolha != 0) {

                adi.armazenarArrayList(adi.carregarDoArquivo());
                Item i = new Item();
                i.setContador(adi.RetornarIdTxt());

                System.out.println("===============================");
                System.out.println("Escolha uma das opções abaixo:");
                System.out.println("1 - Cadastrar Usuário");
                System.out.println("2 - Registrar Item");
                System.out.println("3 - Exibir itens cadastrados");
                System.out.println("4 - Adicionar Item ao Estoque");
                System.out.println("5 - Retirar Item do Estoque");
                System.out.println("0 - Sair");
                System.out.println("===============================");

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
                        System.out.println("Opção selecionada: Adicionar Item ao Estoque");
                        System.out.print("Informe o ID do item que deseja adicionar ao estoque: ");
                        int id = sc.nextInt();
                        estoque.adicionarItemAoEstoque(adi.selecionarItem(id));
                        adi.retirarItem(id);
                        adi.salvarEmArquivo();
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
