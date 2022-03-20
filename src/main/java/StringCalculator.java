public class StringCalculator {

    //Una cadena vacia devuelve 0

    public int add(String input) throws Exception {

        if(input.isBlank()) {
            return 0;
        }
        var deli = encontrarDelimitador(input);
        System.out.println(deli);
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
        }

        return delimitador;
    }



}
