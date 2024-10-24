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
}
