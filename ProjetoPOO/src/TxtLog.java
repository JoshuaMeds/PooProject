import java.io.*;
import java.util.ArrayList;

public class TxtLog {
    private ArrayList<Log> arrayListLog = new ArrayList<Log>();

    public void imprimirTxt(){

    }

    public void escreverTxt(){

    }

    public void apagarTxt(){

    }
    public static String leitor(String caminhoArquivo) throws IOException {
        BufferedReader leitura = null;
        StringBuilder conteudo = new StringBuilder();
        try {
            leitura = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            while ((linha = leitura.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } finally {
            if (leitura != null) {
                leitura.close();
            }
        }
        return conteudo.toString();
    }
    public void escritor(String caminhoArquivo, String conteudo) throws IOException {
        BufferedWriter escritura = null;
        try {
            escritura = new BufferedWriter(new FileWriter(caminhoArquivo));
            escritura.append("a");
        } finally {
            if (escritura != null) {
                escritura.close();
            }
        }
    }
}

