import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class TxtLog {
    private ArrayList<Log> arrayListLog = new ArrayList<Log>();

    public void imprimirTxt(){

    }

    public void escreverTxt(){

    }

    public void apagarTxt(){

    }
    // lê o que ta dentro de um arquivo txt
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
    // escreve algo dentro de um arquivo txt
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
    // lê e printa dentro da ide o conteudo de uma linha expecifica dentro do arquivo itens.txt
    public class LeituraArquivo {

        public static String buscarLinhaItens(String caminhoArquivo, String idProcurado) {
            caminhoArquivo = "src/itens.txt";
            try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
                String linha;

                while ((linha = br.readLine()) != null) {
                    // Verifica se a linha começa com "Nome: " e contém o nome procurado
                    if (linha.startsWith("ID: " + idProcurado)) {
                        return linha;
                    }
                }

                return "Nome não encontrado no arquivo.";

            } catch (IOException e) {
                return "Erro ao ler o arquivo: " + e.getMessage();
            }
        }
    }
}

