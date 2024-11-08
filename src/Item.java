import java.util.Scanner;

public class Item {
    private static int contador;
    private int idItem;
    private String nomeItem;
    private String descricao;
    private String categoria;
    public Item (){
        this.idItem = gerarId();

    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int gerarId(){
        return contador++;
    }

    public int getIdItem() {
        return idItem;
    }

    public static void setContador(int contador) {
        Item.contador = contador + 1;
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

    public void gerarItem(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o nome do Item: ");
        String nome = sc.nextLine();

        System.out.println("\nInforme a descrição do Item: ");
        String descricao = sc.nextLine();

        System.out.println("\nInforme a categoria do Item: ");
        String categoria = sc.nextLine();

        this.nomeItem = nome;
        this.descricao = descricao;
        this.categoria = categoria;

        System.out.println("Item ID#" + this.idItem + " registrado com sucesso!\n");

    }

    }
