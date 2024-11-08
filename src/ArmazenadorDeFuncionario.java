import java.io.*;
import java.util.ArrayList;

public class ArmazenadorDeFuncionario {
    protected ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public int retornarRegistroTxt() {
        int c = 0;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getRegistro() > c) {
                c = funcionario.getRegistro();
            }
        }
        return c;
    }

    public Funcionario selecionarUserPos(int pos) {
        if (pos < 0) {
            pos++;
        }
        return funcionarios.get(pos);
    }

    public void armazenarFun(Funcionario u) {
        funcionarios.add(u);
    }

    public Funcionario selecionarItem(int id) {
        for (Funcionario u : funcionarios) {
            if (u.getRegistro() == id) {
                return u;
            }
        }
        System.out.println("ID inválido ou não encontrado");
        return null;
    }

    public void salvarEmArquivo() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("funcionario.txt");
             ObjectOutputStream os = new ObjectOutputStream(fos)) {

            for (Funcionario funcionario : funcionarios) {
                os.writeObject(funcionario);
            }
        }
    }

    public void armazenarArrayList(ArrayList<Funcionario> ar) {
        this.funcionarios = ar;
    }

    public static ArrayList<Funcionario> carregarDoArquivo() throws IOException {
        ArrayList<Funcionario> f = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("funcionario.txt");
             ObjectInputStream is = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    Funcionario funcionario = (Funcionario) is.readObject();
                    f.add(funcionario);
                } catch (EOFException e) {
                    // Fim do arquivo atingido, sair do loop
                    break;
                } catch (ClassNotFoundException e) {
                    System.out.println("Erro ao carregar dados: " + e.getMessage());
                    break;
                }
            }
        }
        return f;
    }
}
