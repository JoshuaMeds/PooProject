import java.io.*;
import java.util.ArrayList;

public class ArmazenadorDeItem {
    private ArrayList<Item> itens =  new ArrayList<>();

    public int RetornarIdTxt(){
        Item e = selecionarItemPos(itens.size() - 1);
        return e.getIdItem();
    }

    public Item selecionarItemPos(int pos){
        return itens.get(pos);
    }


    public void armazenarItem(Item i){
        itens.add(i);
    }

    public void retirarItem(int id){

        for (Item item : itens) {
            if (item.getIdItem() == id) {
                itens.remove(item);
                return;
            }
        }
        System.out.println("ID inválido ou não encontrado");
    }

    public Item selecionarItem(int id){
        for (Item item : itens) {
            if (item.getIdItem() == id) {
                return item;
            }
        }
        System.out.println("ID inválido ou não encontrado");
        return null;
    }

    public void salvarEmArquivo() {
        try (FileWriter writer = new FileWriter("itens.txt")) { // true para acrescentar ao final
            for (Item i : itens) {
                writer.write("ID:" + i.getIdItem() + ", Nome:" + i.getNomeItem() + ", Categoria:" + i.getCategoria() + ", Descricao:" + i.getDecricao() + "\n");
            }
            System.out.println("Todos os itens foram salvos com sucesso no arquivo!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os itens no arquivo: " + e.getMessage());
        }
    }



    public void armazenarArrayList(ArrayList<Item> ar){
        this.itens = ar;
    }

    public static ArrayList<Item> carregarDoArquivo() {
        ArrayList<Item> itens = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("itens.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("ID:")) { // Verifica se é uma linha de dados
                    String[] partes = linha.split(", ");
                    int id = Integer.parseInt(partes[0].split(":")[1]);
                    String nome = partes[1].split(":")[1];
                    String categoria = partes[2].split(":")[1];
                    String descricao = partes[3].split(":")[1];
                    Item i = new Item();
                    i.setNomeItem(nome);
                    i.setCategoria(categoria);
                    i.setDescricao(descricao);
                    i.setIdItem(id);
                    itens.add(i);

                }
            }
            System.out.println("Itens carregados do arquivo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar itens do arquivo: " + e.getMessage());
        }
        return itens;
    }
}
