import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class InterfaceGrafica extends JFrame {

    // Componentes da interface, acho que da pra mudar o nome dos atributos
    private JTextArea textArea;     // area de texto para mostrar o conteúdo dos arquivos
    private JButton botaoEstoque;   // botçao estoque
    private JButton botaoItens;     // botão itens

    // Construtor da interface
    public InterfaceGrafica() {
        // Configurações da janela
        super("PUC ACHADOS"); // Nome Janela
        setSize(600, 500); // tamnho janela
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o loop do programa quando fechar a tela
        setLayout(new BorderLayout()); // controlador de coordenadas

        // Inicializando a instância de Estoque e os componentes da interface
        textArea = new JTextArea(); // cria a area da leitura
        textArea.setEditable(false); // Deixa a área de texto apenas para leitura
        textArea.setText("BEM VINDO AO PUC ACHADOS\nSELECIONE SUA AÇÃO"); // Mensagem de "boas vindas" da pra mudar, mas n sei como centralziar Kempa
        botaoEstoque = new JButton("Exibir Estoque");
        botaoItens = new JButton("Exibir Itens");

        // Painel para organizar os botões
        JPanel painelBotoes = new JPanel(); // cria os botões - JPanel aparentemente é obrigatorio o nome
        painelBotoes.add(botaoEstoque);
        painelBotoes.add(botaoItens);

        // Adicionando os componentes à janela
        add(new JScrollPane(textArea), BorderLayout.CENTER); // Coloca a area do texto no meio - JScrollPane defalt aparentemente
        add(painelBotoes, BorderLayout.SOUTH); // botões em baixo - BoderLayout é o indicador da onde deixar

        // configurar evento pro botão estoque
        botaoEstoque.addActionListener(new ActionListener() {
            @Override // sobre escreve a função da função, tipo configurar o run em Threads
            public void actionPerformed(ActionEvent e) {
                // cria um arraylist com as informações e função da classe item
                ArrayList<Item> itensEstoque = Estoque.carregarDoArquivo();
                StringBuilder conteudoEstoque = new StringBuilder("Itens no Estoque:\n\n");

                // formatação, talvez de pra pegar o da classe item
                for (Item item : itensEstoque) {
                    conteudoEstoque.append("ID: ").append(item.getIdItem())
                            .append(", Nome: ").append(item.getNomeItem())
                            .append(", Categoria: ").append(item.getCategoria())
                            .append(", Descrição: ").append(item.getDecricao())
                            .append("\n");
                }

                // exibe as info no area de texto
                textArea.setText(conteudoEstoque.toString());
            }
        });

        // configurar evento pro botão itens
        botaoItens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // carrega o arquivo txt, ou seja mesma coisa do botão de cima
                ArrayList<Item> itensSistema = ArmazenadorDeItem.carregarDoArquivo();
                StringBuilder conteudoItens = new StringBuilder("Itens no Sistema:\n\n");

                // Formatação e exibição dos itens no sistema
                for (Item item : itensSistema) {
                    conteudoItens.append("ID: ").append(item.getIdItem())
                            .append(", Nome: ").append(item.getNomeItem())
                            .append(", Categoria: ").append(item.getCategoria())
                            .append(", Descrição: ").append(item.getDecricao())
                            .append("\n");
                }

                // Exibe as informações na área de texto
                textArea.setText(conteudoItens.toString());
            }
        });

        // Torna a janela visível e traz para frente
        setVisible(true);
        setAlwaysOnTop(true); // Define a janela temporariamente no topo
        toFront(); // Traz a janela para frente
        requestFocus(); // Dá o foco à janela
        setAlwaysOnTop(false); // Permite que a janela seja sobreposta depois
        // Adiciona o listener para detectar o fechamento da janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("===============================");
                System.out.println("INTERFACE GRAFICA FECHADA");
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
            }
        });
    }

//    // para inicializar a interface
//    public static void main(String[] args) {
//        // tem que usar isso aqui pra garantir que não haja deadlock na interface
//        // pois ela é uma thread que fica em wait até uma ação mandar um notifine
//        // sera que da pra usar em cyberfisico?
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override // olha o metodo run ai
//            public void run() {
//                new InterfaceGrafica().setVisible(true); // cria a interface e deixa ela visivel
//            }
//        });
//    }
}
