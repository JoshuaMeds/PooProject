import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Log {
    private Funcionario f;
    private Item i;
    private Estoque e;
    LocalDateTime d;

    private String log;

    public Log(){

    }

    public String logAdicionar(Funcionario f, Item i, Estoque e){
        d = LocalDateTime.now();

        return System.out.printf("%s - %s - %s - %s", f.getNome(), e.getBloco(), i.getNomeItem(), d ).toString();
    }
}
