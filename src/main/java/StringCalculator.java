import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    //Una cadena vacia devuelve 0

    public int add(String input) throws Exception {

        if(input.isBlank()) {
            return 0;
        }
        var deli = encontrarDelimitador(input);
        var numeros = splitInput(input, deli);

        System.out.println("delimitarod es " + deli);
        System.out.println("Array de numeros " + numeros);

        return 0;
    }

    public String encontrarDelimitador(String input) throws Exception {

        String delimitador ;

        if(Character.isDigit(input.charAt(0))){
            if (input.matches("^\\d+(,\\d+)*$"))
                delimitador = ",";
            else if(input.matches("^\\d+(\\n\\d+)*$"))
                delimitador = "\n";
            else
                throw new Exception("No es posible encontrar delimitador en la cadena");
            return delimitador;
        }

        var delimitadorTemporal = String.valueOf(input.charAt(0));
        delimitador = delimitadorTemporal;

        for (int i = 1; i < input.length(); i++){
            String caracterAEvaluar = String.valueOf(input.charAt(i));
            if(caracterAEvaluar.equals(delimitadorTemporal))
                delimitador += delimitadorTemporal;
            else
                break;
        }

        return delimitador;
    }

    public List<Integer> splitInput(String input, String delimitador) throws Exception {
        try {
            var values = new ArrayList<>(Arrays.asList(input.split(delimitador)));
            values.removeIf(item -> item == null || "".equals(item));

            return values.stream()
                         .map(item -> Integer.parseInt(item))
                         .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception("No es posible hacer split con el delimitador encontrado");
        }

    }



}
