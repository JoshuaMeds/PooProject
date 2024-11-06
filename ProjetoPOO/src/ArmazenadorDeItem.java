import java.util.ArrayList;

public class ArmazenadorDeItem {
    private ArrayList<Item> itens =  new ArrayList<>();

    public void armazenarItem(Item i){
        itens.add(i);
    }

    public void retirarItem(int id){

        for (Item item : itens) {
            if (item.getId() == id) {
                itens.remove(item);
                return;
            }
        }
        System.out.println("ID inválido ou não encontrado");
    }

    public Item selecionarItem(int id){
        for (Item item : itens) {
            if (item.getId() == id) {
                return item;
            }
        }
        System.out.println("ID inválido ou não encontrado");
        return null;
    }
}
