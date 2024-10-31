import java.io.FileWriter;
import java.io.IOException;

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

    public void salvarEmArquivo() {
        try (FileWriter writer = new FileWriter("itens.txt", true)) { // true para não sobrescrever
            writer.write("Nome: " + this.nomeItem + " / "+"Categoria: " + this.categoria+ " / " +"Descrição: " + this.descricao + "\n");
            writer.write("---------------------------\n");
            System.out.println("Item salvo com sucesso no arquivo!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o item no arquivo: " + e.getMessage());
        }
    }
}