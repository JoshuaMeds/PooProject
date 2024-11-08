import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ExcecoesPersonalizadas idE = new ExcecaoNoId("");
        ExcecoesPersonalizadas aE = new ExcecaoAutorizacao("");
        ExcecoesPersonalizadas vE = new ExcecaoValidacao("");
        Scanner sc = new Scanner(System.in);
        ArmazenadorDeFuncionario adf = new ArmazenadorDeFuncionario();
        ArmazenadorDeItem adi = new ArmazenadorDeItem();
        ArmazenadorDeUsuario adu = new ArmazenadorDeUsuario();

        Estoque estoque = new Estoque(1);
        // Criar um Admin para modificar dados

        int escolha = -1;

        System.out.println("Bem-vindo ao Sistema de Achados e Perdidos!");

        adf.armazenarArrayList(adf.carregarDoArquivo());
        adi.armazenarArrayList(adi.carregarDoArquivo());
        adi.armazenarArrayList(adi.carregarDoArquivo());
        adu.armazenarArrayList(adu.carregarDoArquivo());
        estoque.armazenarArrayList(estoque.carregarDoArquivo());
        Item i = new Item();

        if (adi.RetornarIdTxt() > estoque.RetornarIdTxt()) {
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
        Funcionario f = new Funcionario();

        if (adf.retornarRegistroTxt() > adu.RetornarIdTxt()) {
            int c = adf.retornarRegistroTxt();
            u.setContador(c);
            f.setContador(c);
        } else if (adf.retornarRegistroTxt() < adu.RetornarIdTxt()) {
            int c = adu.RetornarIdTxt();
            u.setContador(c);
            f.setContador(c);
        } else {
            int c = adf.retornarRegistroTxt();
            u.setContador(c);
            f.setContador(c);
        }

        int verificacao = 0;

        Funcionario funlogin = null;
        while (verificacao == 0) {
            System.out.println("DIGITE SEU ID DE FUNCIONARIO: ");
            int idlogin = sc.nextInt();

            if (adf.selecionarFun(idlogin) == null) {
                adf.selecionarFun(idlogin);
            } else {
                funlogin = adf.selecionarFun(idlogin);
                verificacao++;
            }
        }


        if (funlogin instanceof Admin) {

            //todo: implementar main como ADMIN

            try {
                while (escolha != 0) {

                    adf.armazenarArrayList(adf.carregarDoArquivo());
                    adi.armazenarArrayList(adi.carregarDoArquivo());
                    adi.armazenarArrayList(adi.carregarDoArquivo());
                    adu.armazenarArrayList(adu.carregarDoArquivo());
                    estoque.armazenarArrayList(estoque.carregarDoArquivo());
                    Item it = new Item();

                    if (adi.RetornarIdTxt() > estoque.RetornarIdTxt()) {
                        int c = adi.RetornarIdTxt();
                        it.setContador(c);
                    } else if (adi.RetornarIdTxt() < estoque.RetornarIdTxt()) {
                        int c = estoque.RetornarIdTxt();
                        it.setContador(c);
                    } else {
                        int c = adi.RetornarIdTxt();
                        it.setContador(c);
                    }

                    Usuario us = new Usuario();
                    Funcionario fu = new Funcionario();

                    if (adf.retornarRegistroTxt() > adu.RetornarIdTxt()) {
                        int c = adf.retornarRegistroTxt();
                        us.setContador(c);
                        fu.setContador(c);
                    } else if (adf.retornarRegistroTxt() < adu.RetornarIdTxt()) {
                        int c = adu.RetornarIdTxt();
                        us.setContador(c);
                        fu.setContador(c);
                    } else {
                        int c = adf.retornarRegistroTxt();
                        u.setContador(c);
                        fu.setContador(c);
                    }


                    System.out.println("===============================");
                    System.out.println("Escolha uma das opções abaixo:");
                    System.out.println("1 - Cadastrar Usuário");
                    System.out.println("2 - Registrar Item");
                    System.out.println("3 - Exibir itens cadastrados");
                    System.out.println("4 - Adicionar Item ao Estoque");
                    System.out.println("5 - Retirar Item do Estoque");
                    System.out.println("6 - Modificar Dados de Usuário");
                    System.out.println("7 - Exibir Usuários e Funcionarios Cadastrados");
                    System.out.println("8 - Cadastrar Funcionario");
                    System.out.println("9 - Executar Interface Grafica");
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

                            System.out.println("\nItens Perdidos:\n");
                            for (Item item : adi.getItens()) {
                                System.out.println("ID: " + item.getIdItem() + ", Nome: " + item.getNomeItem() + ", Categoria: " + item.getCategoria() + ", Descricao: " + item.getDecricao());
                            }

                            System.out.println("\nItens em Estoque\n");
                            for (Item item : estoque.getItens()) {
                                System.out.println("ID: " + item.getIdItem() + ", Nome: " + item.getNomeItem() + ", Categoria: " + item.getCategoria() + ", Descricao: " + item.getDecricao());
                            }

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
                            } else {
                                System.out.println("\nOPCAO INVALIDA\n");
                            }
                        }

                        case 5 -> {
                            System.out.println("Opção selecionada: Retirar Item do Estoque");
                            System.out.println("Itens disponíveis no estoque:");
                            // Lógica para listar itens do estoque aqui
                        }

                        case 6 -> {
                            System.out.println("Opção selecionada: Modificar Dados de Usuário");
                            System.out.print("Informe o ID do usuário que deseja modificar: ");
                            int userId = sc.nextInt();
                            Usuario usuario = adu.selecionarUsuario(userId);

                            if (usuario != null) {
                                System.out.print("Novo nome: ");
                                String novoNome = sc.next();
                                System.out.print("Nova matrícula: ");
                                int novaMatricula = sc.nextInt();
                                funlogin.modificarUsuario(usuario, novoNome, novaMatricula);
                                adu.salvarEmArquivo();
                            } else {
                                System.out.println("Usuário não encontrado.");
                            }
                        }

                        case 7 -> {
                            System.out.println("Opção selecionada: Exibir Usuários e Funcionarios Cadastrados");
                            System.out.println("\nUsuarios:\n");
                            for (Usuario usuario : adu.getUsuarios()) {
                                System.out.println(usuario);
                            }

                            System.out.println("\nFuncionarios\n");
                            for (Funcionario funcionario : adf.getFuncionarios()) {
                                if (funcionario instanceof Admin) {
                                    System.out.println("ADM: SIM, ID: " + funcionario.getFunId() + ", Nome: " + funcionario.getNome() + ", CPF: " + funcionario.getCpf() + ", Registro: " + funcionario.getRegistro());
                                } else {
                                    System.out.println("ADM: NAO, ID: " + funcionario.getFunId() + ", Nome: " + funcionario.getNome() + ", CPF: " + funcionario.getCpf() + ", Registro: " + funcionario.getRegistro());
                                }

                            }
                        }

                        case 8 -> {
                            System.out.println("Opção selecionada: Cadastrar Funcionario\n");
                            Funcionario fun = new Funcionario();
                            fun.registrarPessoa();
                            adf.armazenarFun(fun);
                            adf.salvarEmArquivo();

                        }
                        case 9 -> {
                            System.out.println("Opção selecionada: Abrir Interface Gráfica");
                            System.out.println("Abrindo Interface Gráfica....");
                            // Chama a interface gráfica
                            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    new InterfaceGrafica().setVisible(true);
                                }
                            });
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

        } else if (funlogin instanceof Funcionario && funlogin != null) {

            try {
                while (escolha != 0) {

                    adf.armazenarArrayList(adf.carregarDoArquivo());
                    adi.armazenarArrayList(adi.carregarDoArquivo());
                    adi.armazenarArrayList(adi.carregarDoArquivo());
                    adu.armazenarArrayList(adu.carregarDoArquivo());
                    estoque.armazenarArrayList(estoque.carregarDoArquivo());
                    Item it = new Item();

                    if (adi.RetornarIdTxt() > estoque.RetornarIdTxt()) {
                        int c = adi.RetornarIdTxt();
                        it.setContador(c);
                    } else if (adi.RetornarIdTxt() < estoque.RetornarIdTxt()) {
                        int c = estoque.RetornarIdTxt();
                        it.setContador(c);
                    } else {
                        int c = adi.RetornarIdTxt();
                        it.setContador(c);
                    }

                    Usuario us = new Usuario();
                    Funcionario fu = new Funcionario();

                    if (adf.retornarRegistroTxt() > adu.RetornarIdTxt()) {
                        int c = adf.retornarRegistroTxt();
                        us.setContador(c);
                        fu.setContador(c);
                    } else if (adf.retornarRegistroTxt() < adu.RetornarIdTxt()) {
                        int c = adu.RetornarIdTxt();
                        us.setContador(c);
                        fu.setContador(c);
                    } else {
                        int c = adf.retornarRegistroTxt();
                        u.setContador(c);
                        fu.setContador(c);
                    }


                    System.out.println("===============================");
                    System.out.println("Escolha uma das opções abaixo:");
                    System.out.println("1 - Cadastrar Usuário");
                    System.out.println("2 - Registrar Item");
                    System.out.println("3 - Exibir itens cadastrados");
                    System.out.println("4 - Adicionar Item ao Estoque");
                    System.out.println("5 - Retirar Item do Estoque");
                    System.out.println("6 - Modificar Dados de Usuário");
                    System.out.println("7 - Exibir Usuários");
                    System.out.println("8 - Executar Interface Grafica");
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

                            System.out.println("\nItens Perdidos:\n");
                            for (Item item : adi.getItens()) {
                                System.out.println(item);
                            }

                            System.out.println("\nItens em Estoque\n");
                            for (Item item : estoque.getItens()) {
                                System.out.println(item);
                            }
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
                            } else {
                                System.out.println("\nOPCAO INVALIDA\n");
                            }
                        }

                        case 5 -> {
                            System.out.println("Opção selecionada: Retirar Item do Estoque");
                            System.out.println("Itens disponíveis no estoque:");
                            // Lógica para listar itens do estoque aqui
                        }

                        case 6 -> {
                            System.out.println("Opção selecionada: Modificar Dados de Usuário");
                            System.out.print("Informe o ID do usuário que deseja modificar: ");
                            int userId = sc.nextInt();
                            Usuario usuario = adu.selecionarUsuario(userId);

                            if (usuario != null) {
                                System.out.print("Novo nome: ");
                                String novoNome = sc.next();
                                System.out.print("Nova matrícula: ");
                                int novaMatricula = sc.nextInt();
                                funlogin.modificarUsuario(usuario, novoNome, novaMatricula);
                                adu.salvarEmArquivo();
                            } else {
                                System.out.println("Usuário não encontrado.");
                            }
                        }

                        case 7 -> {
                            System.out.println("Opção selecionada: Exibir Usuários");
                            System.out.println("\nUsuarios:\n");
                            for (Usuario usuario : adu.getUsuarios()) {
                                System.out.println(usuario);
                            }
                        }
                        case 8 -> {
                            System.out.println("Opção selecionada: Abrir Interface Gráfica");
                            System.out.println("Abrindo Interface Gráfica....");

                            // Chama a interface gráfica
                            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    new InterfaceGrafica().setVisible(true);
                                }
                            });
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
}
