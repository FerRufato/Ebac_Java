import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)//para que a anotação seja acessível em tempo de execução
@Target(ElementType.TYPE)
public @interface Tabela {
    String valor();
}
