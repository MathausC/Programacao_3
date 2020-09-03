package Programacao_3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a, b, c;
        char resp;
        Baskara baskara;
        System.out.println("Vamos calcular as raizes de uma função do segundo grau.");
        do {
            System.out.print("Informe a termo de grau 2: ");
            a = in.nextDouble(); in.nextLine();
            System.out.print("Informe o termo de grau 1: ");
            b = in.nextDouble(); in.nextLine();
            System.out.print("Informe o termo de grau 0: ");
            c = in.nextDouble(); in.nextLine();
            baskara = new Baskara(a, b, c);
            baskara.exibirRaiz1();
            baskara.exibirRaiz2();
            System.out.print("Você deseja verificar as raizes de mais uma função? (S - sim | N = não) ");
            resp = in.next().charAt(0);
            resp = Character.toUpperCase(resp);
            while(resp != 'S' && resp != 'N') {
                System.out.println("Opção inválida.");
                System.out.print("Você deseja verificar as raizes de mais uma função? (S - sim | N = não) ");
                resp = in.next().charAt(0);
                resp = Character.toUpperCase(resp);
            }
        }while(resp == 'S');
        System.out.println("Obrigado e até mais!");
    }
}
