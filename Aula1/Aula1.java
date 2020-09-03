package Programacao_3;
import java.util.Scanner;

public class Aula1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a, b, c, raiz1, raiz2, delta;
        String mensagem;
        char resp;
        System.out.println("Vamos calcular as raizes de uma função de segundo grau.");
        do {
            System.out.print("Informe o termo de grau 2 da equação: ");
            a = in.nextDouble(); in.nextLine();
            System.out.print("Informe o termo de grau 1 da equação: ");
            b = in.nextDouble(); in.nextLine();
            System.out.print("Informe o termo de grau 0 da equação: ");
            c = in.nextDouble(); in.nextLine();

            delta = calcularDelta(a, b, c);
            if(delta < 0) {
                mensagem = "As raizes não pertencem aos reais.";
            }
            else if(delta == 0){
                raiz1 = -b/(2*a);
                mensagem = "As duas raizes tem valor de " + raiz1;
            }
            else {
                raiz1 = (-b + Math.sqrt(delta))/(2 * a);
                raiz2 = (-b - Math.sqrt(delta))/(2 * a);
                mensagem = "As raizes são " + raiz1 + " e " + raiz2 + ".";
            }

            System.out.println(mensagem);
            System.out.print("Você deseja calcular as raizes de outra função? ('S' -  sim | 'N' - não)");
            resp = in.next().charAt(0); in.nextLine();
            resp = Character.toUpperCase(resp);
            while(resp != 'S' && resp != 'N') {
                System.out.println("Opção inválida.");
                System.out.print("Você deseja calcular as raizes de outra função? ('S' -  sim | 'N' - não) ");
                resp = in.next().charAt(0); in.nextLine();
                resp = Character.toUpperCase(resp);
            }
        }
        while(resp == 'S');
        System.out.println("Até mais!");
    }

    private static double calcularDelta(double a, double b, double c) {
        return Math.pow(b, 2) - (4 * a * c);
    }
}
