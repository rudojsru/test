package sample;

public class Model {
    public double operation(double a, double b, String operation){
        switch (operation){
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            case "/":
                if (b==0)return 0;
                else return a/b;
        }

        return 0;
    }
}
