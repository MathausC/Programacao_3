package com.CC;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        NumeroComplexo numero, numero2;
        double a, b, c , d;
        int op;
        char resp;

        System.out.println("Vamos fazer calculos com número complexos.");
        do {
            System.out.print("Informe a parte real do primeiro número complexo: ");
            a = in.nextDouble(); in.nextLine();
            System.out.print("Informe a parte imaginária do primeiro número complexo: ");
            b = in.nextDouble(); in.nextLine();
            numero = new NumeroComplexo(a, b);
            System.out.print("Informe a parte real do segundo número complexo: ");
            c = in.nextDouble(); in.nextLine();
            System.out.print("Informe a parte imaginária do segundo número complexo: ");
            d = in.nextDouble(); in.nextLine();
            numero2 = new NumeroComplexo(c, d);
            System.out.println("Vamos as operações.");
            do {
                exibeMenu();
                op = in.nextInt(); in.nextLine();
                switch(op) {
                    case 1: numero.soma(numero2); break;
                    case 2: numero.multiplica(numero2); break;
                    case 3: numero.divide(numero2); break;
                    case 4: numero.éIgual(numero2); break;
                    case 0: System.out.println("Ok!"); break;
                    default: System.out.println("Opção inválida."); break;
                }
            }while(op != 0);
            System.out.print("Deseja escolher outro número? (S - sim | N - não) ");
            resp = in.next().charAt(0);
            resp = Character.toUpperCase(resp);
            while (resp != 'S' && resp != 'N') {
                System.out.println("Opção inválida.");
                System.out.print("Deseja escolher outro número? (S - sim | N - não) ");
                resp = in.next().charAt(0);
                resp = Character.toUpperCase(resp);
            }
        }
        while (resp == 'S');
        System.out.println("Obrigado e até logo!");
    }

    private static void exibeMenu() {
        System.out.println("Informe uma das opções.");
        System.out.print(
                "1 - Somar;\n" +
                "2 - Multiplicar;\n" +
                "3 - Dividir;\n" +
                "4 - Vewrificar igualdade;\n" +
                "0 - Sair ou escolher outros números.\n" +
                "Opção: "
        );
    }
}
