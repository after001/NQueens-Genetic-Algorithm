import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GeneticAlgorithmMain {

    public static void main(String[] args) {

        IndividualFactory factory = new IndividualNQueensFactory(8);
        int populationSize = 20;
        int eliteSize = 4;
        int maxGenerations = 10001;

        GeneticAlgorithm ga = new GeneticAlgorithm();
        List<Individual> individualList = ga.execute(factory, populationSize, eliteSize, maxGenerations);

        if (individualList != null && !individualList.isEmpty()) {
            IndividualNQueens best = (IndividualNQueens) individualList.get(0); // Downcasting

            System.out.println("\n========================================");
            System.out.println("        RESULTADO FINAL DO AG");
            System.out.println("========================================");

            double collisions = best.getFitness();
            System.out.println("Melhor Fitness (Colisões): " + collisions);
            System.out.println("Configuração (Genes): " + Arrays.toString(best.getGenes()));

            if (collisions == 0) {
                System.out.println("SUCESSO: Solução perfeita encontrada!");
            } else {
                System.out.println("AVISO: O algoritmo parou na melhor solução local possível.");
            }
            System.out.println("========================================\n");
        }
    }
}