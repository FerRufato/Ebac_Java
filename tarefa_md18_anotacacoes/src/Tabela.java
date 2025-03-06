import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)//para que a anotação seja acessível em tempo de execução
@Target(ElementType.TYPE)//para que a anotação possa ser aplicada a classes
public @interface Tabela {// Define a anotação @Tabela
    String valor();
}
