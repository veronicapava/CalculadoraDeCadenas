public class App {

    public static void main(String[] args) throws Exception {
        StringCalculator cal = new StringCalculator();

        var result =cal.add("$99$9$6");
        System.out.println(result);
    }
}
