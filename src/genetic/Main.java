package genetic;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int min, max;
    static double mutacao;

    static String menu = "1 - Adicionar indivíduo" +
            "\n2 - Mostrar tabela" +
            "\n0 - Sair";

    public static void main(String[] args) {
        List<Individuo> individuos = new ArrayList<>();

        max = Integer.parseInt(entrada("Digite o valor máximo para entrada!"));
        min = Integer.parseInt(entrada("Digite o valor mínimo para entrada!"));
        mutacao = Double.parseDouble(entrada("Digite o valor da mutação!"));

        int opcao = Integer.parseInt(entrada(menu));

        while (opcao != 0) {

            switch (opcao) {
                case 1:
                    adicionarIndividuo(individuos);
                    break;

                case 2:
                    mostrarIndividuos(individuos);
                    break;

                default:
                    break;
            }

            opcao = Integer.parseInt(entrada(menu));
        }

    }

    public static String entrada(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    public static void mensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void adicionarIndividuo(List<Individuo> individuos) {
        int x = Integer.parseInt(entrada("Digite o valor de X!"));
        int y = Integer.parseInt(entrada("Digite o valor de Y!"));

        validarRange(x, y);

        Individuo individuo = new Individuo();

        individuo.x = x;
        individuo.y = y;

        calcularCromossomo(individuo);
        calcularFitness(individuo);

        individuos.add(individuo);
    }

    private static void validarRange(int x, int y) {
        if (x > max || x < min) {
            mensagem("Valor de X deve estar entre: " + min + " e " + max);
        }
        if (y > max || y < min) {
            mensagem("Valor de Y deve estar entre: " + min + " e " + max);
        }
    }

    private static void mostrarIndividuos(List<Individuo> individuos) {
        String resultado = "--------Indivíduos--------";

        resultado += "";
    }

    public static void calcularCromossomo(Individuo individuo) {
        String x = String.format("%04d", Integer.parseInt(Integer.toBinaryString(individuo.x)));
        String y = String.format("%04d", Integer.parseInt(Integer.toBinaryString(individuo.x)));
        individuo.cromossomo = x + y;
    }

    private static void calcularFitness(Individuo individuo) {
        individuo.fitness = Math.abs(individuo.x * individuo.y * Math.sin((Math.pow(individuo.y, Math.PI)) / 4));
    }
}
