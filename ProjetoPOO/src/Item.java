import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Item {
    private static int contador = 0;
    private int id;
    private String nomeItem;
    private String descricao;
    private String categoria;
    public Item (){
        this.id = gerarId();

    }

    public int gerarId(){
        return contador++;
    }

    public int getId() {
        return id;
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

        System.out.println("Informe a descrição do Item: ");
        String descricao = sc.nextLine();

        System.out.println("Informe a categoria do Item: ");
        String categoria = sc.nextLine();

        this.nomeItem = nome;
        this.descricao = descricao;
        this.categoria = categoria;

        System.out.println("Item ID#" + this.id + " registrado com sucesso!");

    }

    public void salvarEmArquivo() {
        try (FileWriter writer = new FileWriter("itens.txt", true)) { // true para não sobrescrever
            writer.write("ID:" + this.id + "Nome: " + this.nomeItem + " / "+"Categoria: " + this.categoria+ " / " +"Descrição: " + this.descricao + "\n");
            writer.write("---------------------------\n");
            System.out.println("Item salvo com sucesso no arquivo!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o item no arquivo: " + e.getMessage());
        }
    }
}