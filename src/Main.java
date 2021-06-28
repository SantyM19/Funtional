import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        IntBinaryOperator sum   = Integer::sum;
        IntBinaryOperator rest   = (x, y)-> x - y;

        IntBinaryOperator mult = (x, y) ->
            IntStream.range(0, y + 1).reduce((acumulador, numero)->sum.applyAsInt(acumulador, x)).getAsInt();

        IntBinaryOperator div = (x, y) ->
                IntStream.range(0, x).reduce((acumulador, numero)->
                        mult.applyAsInt(numero, y) <= x ?
                                sum.applyAsInt(acumulador, 1):acumulador).getAsInt();


        System.out.println("Suma:           5 + 5 = " + sum.applyAsInt(5,5));
        System.out.println("Resta:          5 - 5 =  " + rest.applyAsInt(5,5));
        System.out.println("Multiplication: 5 x 5 = " + mult.applyAsInt(5,5));
        System.out.println("Division:       5 / 5 =  " + div.applyAsInt(10,5));

    }
}
