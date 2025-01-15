package DesafioProcessoSeletivo;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        double salarioBase = 2000.00;
        String[] candidatosSelecionados = selecionarCandidatos(salarioBase);

        System.out.println("\nTentando contato com os candidatos selecionados...\n");
        int totalLigações = realizarLigações(candidatosSelecionados);
    }

    static String[] selecionarCandidatos(double salarioBase) {
        String[] candidatos = {"Felipe", "Lucas", "Levi", "Irene", "Márcia", "Marcos", "Vanda", "Rafael"};
        ArrayList<String> selecionados = new ArrayList<>();
        int candidatoAtual = 0;

        while (selecionados.size() < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("O candidato %s solicitou este salário: %.2f\n", candidato, salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                selecionados.add(candidato);
                System.out.println("O candidato " + candidato + " foi selecionado");
            } else {
                System.out.println("O candidato " + candidato + " não foi selecionado.");
            }
            candidatoAtual++;
        }
        return selecionados.toArray(new String[0]);
    }

    static int realizarLigações(String[] candidatosSelecionados) {
        int totalLigações = 0;

        for (String candidato : candidatosSelecionados) {
            int tentativas = 0;
            boolean atendeu = false;

            while (tentativas < 3) {
                tentativas++;
                totalLigações++;

                if (ThreadLocalRandom.current().nextBoolean()) {
                    System.out.println("O candidato " + candidato + " atendeu na " +tentativas+"° tentativa e foi contratado.");
                    atendeu = true;
                    break;
                }
            }
            if (!atendeu) {
                System.out.println("O candidato " + candidato + " perdeu a vaga por não atender às ligações.");
            }
        }
        return totalLigações;
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}
