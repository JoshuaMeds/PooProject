import java.util.Scanner;

public class Item {
    private String nomeItem;
    private String descricao;
    private String categoria;
    public Item (String nomeItem, String descricao, String categoria){
        this.nomeItem = nomeItem;
        this.descricao = descricao;
        this.categoria =categoria;

    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getDecricao() {
        return descricao;
    }
    public String getNomeItem() {
        return nomeItem;
    }

    public String criarItem(String nomeItem, String categoria, String descricao){
        System.out.println("Área de Cadastro de Item!" +
                "Preencha todos os campos para cadastrar o Item:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastre o nome do Item:");
        nomeItem = scanner.nextLine();
        System.out.println("Cadastre a categoria do produto:");
        categoria = scanner.nextLine();
        System.out.println("De uma breve descrição ao produto:");
        descricao = scanner.nextLine();
        return System.out.printf("O Item %s foi cadastrado com sucesso", nomeItem).toString();
    }
}