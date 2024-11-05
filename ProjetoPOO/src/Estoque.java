import java.util.ArrayList;
import java.util.List;

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

    public List<Item> getItens() {
        return itens;
    }


    // adicionar um item ao estoque
    public void adicionarItem(String nomeItem) {
        for (Item item : itens) {
            if (item.getNomeItem().equalsIgnoreCase(nomeItem)) { // Verifica se o item já está no estoque
                System.out.println("Item " + nomeItem + " já está no estoque.");
                return;
            }
        }
        System.out.println("Item " + nomeItem + " não encontrado no estoque.");
    }

    public void adicionarItem(Item item) {
        itens.add(item); // Adiciona o item ao estoque
        System.out.println("Item " + item.getNomeItem() + " adicionado ao estoque.");
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
