public class GeneticAlgorithmMain {
    public static void main(String[] args) {
        IndividuoNRainhasFactory = new IndividuoNRainhasFactory(8);
        int n = 20;
        int elite = 4;

        GeneticAlgorithm ga = new GeneticAlgorithm();
        ga.executar(factory, n, elite);

    }
}
