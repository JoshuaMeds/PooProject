import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o loop do programa quando fechar a tela
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
                // tive que improvisar um metodo pra ler, pois na hora que estava fazendo
                // não havia um metodo para isso igual tem em estoque
                String caminhoArquivoItens = "itens.txt"; // talvez necessite mudar
                try {
                    // carrega o conteúdo do arquivo item.txt
                    String conteudoItens = TxtLog.leitor(caminhoArquivoItens);
                    // exibe o conteúdo dos itens na área de texto
                    textArea.setText("Itens no Sistema:\n\n" + conteudoItens); // talvez de erro
                } catch (IOException ex) { // sera que este tratamento q eu fiz seja personalizado
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo item.txt: " + ex.getMessage());
                }
            }
        });
    }

    // para inicializar a interface
    public static void main(String[] args) {
        // tem que usar isso aqui pra garantir que não haja deadlock na interface
        // pois ela é uma thread que fica em wait até uma ação mandar um notifine
        // sera que da pra usar em cyberfisico?
        SwingUtilities.invokeLater(new Runnable() {
            @Override // olha o metodo run ai
            public void run() {
                new InterfaceGrafica().setVisible(true); // cria a interface e deixa ela visivel
            }
        });
    }
}
