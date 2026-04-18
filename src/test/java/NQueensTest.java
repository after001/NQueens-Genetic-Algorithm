import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NQueensTest {

    private static final int POPULATION = 20;
    private static final int ELITE = 4;
    private static final int GENERATIONS = 10000;

    private List<Individual> run(int n) {
        GeneticAlgorithm ga = new GeneticAlgorithm();
        return ga.execute(new IndividualNQueensFactory(n), POPULATION, ELITE, GENERATIONS);
    }

    private void print(String label, IndividualNQueens best) {
        System.out.println("\n=== " + label + " ===");
        System.out.println("Melhor Fitness (Colisões): " + best.getFitness());
        System.out.println("Configuração (Genes): " + Arrays.toString(best.getGenes()));
    }

    @Test
    public void test1_QuatroRainhas() {
        IndividualNQueens best = (IndividualNQueens) run(4).get(0);
        print("4 RAINHAS", best);
        assertEquals(0.0, best.getFitness(), 0.0);
    }

    @Test
    public void test2_SeisRainhas() {
        IndividualNQueens best = (IndividualNQueens) run(6).get(0);
        print("6 RAINHAS", best);
        assertEquals(0.0, best.getFitness(), 0.0);
    }

    @Test
    public void test3_OitoRainhas() {
        IndividualNQueens best = (IndividualNQueens) run(8).get(0);
        print("8 RAINHAS", best);
        assertEquals(0.0, best.getFitness(), 0.0);
    }

    @Test
    public void test4_DezRainhas() {
        IndividualNQueens best = (IndividualNQueens) run(10).get(0);
        print("10 RAINHAS", best);
        assertTrue("Esperado <= 2 colisões", best.getFitness() <= 2.0);
    }
}