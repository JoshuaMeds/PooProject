import java.util.ArrayList;

public class Estoque {
    private int bloco;
    private ArrayList<Item> itens;

    public Estoque(int bloco, String deposito) {
        this.bloco = bloco;
        this.itens = new ArrayList<>();
    }

    public int getBloco() {
        return bloco;
    }

    public void setBloco(int bloco) {
        this.bloco = bloco;
    }

    // adicionar um item ao estoque
    public void adicionarItem(Item p) {
        itens.add(p);
        System.out.println("Item adicionado ao estoque: " + p.getNomeItem());
    }

    // Remover um item do estoque
    public boolean removerItem(Item item) {
        if (itens.remove(item)) {
            System.out.println("Item:" + item.getNomeItem() + " foi removido do estoque");
            return true;
        } else {
            System.out.println("Item não encontrado no estoque.");
            return false;
        }
    }

    // exibir os itens do estoque
    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Itens no estoque:");
            for (Item item : itens) {
                System.out.println("Nome: " + item.getNomeItem() + ", Categoria: " + item.getCategoria() + ", Descrição: " + item.getDecricao());
            }
        }
    }
}
