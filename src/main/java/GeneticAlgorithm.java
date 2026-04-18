import java.util.*;

public class GeneticAlgorithm {

    public List<Individual> execute(IndividualFactory factory, int populationSize, int eliteSize, int maxGenerations) {

        List<Individual> population = new ArrayList<Individual>(populationSize);

        for (int i = 0; i < populationSize; i++) {
            population.add(factory.generate());
        }

        for (int g = 0; g < maxGenerations; g++) {

            List<Individual> offspring = getOffspring(population);
            List<Individual> mutant = getMutants(population);

            List<Individual> populationAux = new ArrayList<>(populationSize * 3);
            populationAux.addAll(population);
            populationAux.addAll(offspring);
            populationAux.addAll(mutant);

            population = naturalSelection(populationAux, populationSize, eliteSize);

            printBestFitness(g, population);
        }

        Collections.sort(population);
        return population;
    }

    private List<Individual> getOffspring(List<Individual> population) {
        List<Individual> offspringList = new ArrayList<Individual>();
        List<Individual> pool = new ArrayList<Individual>(population); // Copy of population
        Random rand = new Random();

        for (int i = 0; i < population.size() / 2; i++) {
            int index1 = rand.nextInt(pool.size());
            Individual parent1 = pool.get(index1);
            pool.remove(index1);

            int index2 = rand.nextInt(pool.size());
            Individual parent2 = pool.get(index2);
            pool.remove(index2);

            List<Individual> offspring = parent1.crossover(parent2);
            offspringList.addAll(offspring);
        }
        return offspringList;
    }

    private List<Individual> getMutants(List<Individual> population) {
        List<Individual> mutantList = new ArrayList<Individual>();

        for (Individual ind : population) {
            mutantList.add(ind.mutate());
        }
        return mutantList;
    }

    private List<Individual> naturalSelection(List<Individual> populationAux, int populationSize, int eliteSize) {
        /**
         * Elitism
         */
        List<Individual> newPopulation = new ArrayList<Individual>();
        Random rand = new Random();

        Collections.sort(populationAux);

        for (int i = 0; i < eliteSize; i++) {
            newPopulation.add(populationAux.get(0));
            populationAux.remove(0);
        }

        /**
         * Fitness Proportionate Selection
         */
        while (newPopulation.size() < populationSize) {

            // Step 1
            double sum1 = 0.0;
            for (Individual ind : populationAux) {
                double invertedFitness = 1.0 / (ind.calculateCollisions() + 1.0);
                sum1 += invertedFitness;
            }

            // Step 2
            double randomFitness = rand.nextDouble() * sum1;

            // Step 3
            double sum2 = 0.0;
            int selectedIndex = -1;

            for (int i = 0; i < populationAux.size(); i++) {
                double invertedFitness = 1.0 / (populationAux.get(i).calculateCollisions() + 1.0);
                sum2 += invertedFitness;

                if (sum2 > randomFitness) {
                    selectedIndex = i;
                    break;
                }
            }

            if (selectedIndex == -1) {
                selectedIndex = populationAux.size() - 1;
            }

            // Step 4
            newPopulation.add(populationAux.get(selectedIndex));
            populationAux.remove(selectedIndex);
        }

        return newPopulation;
    }

    private void printBestFitness(int g, List<Individual> population) {
        Collections.sort(population);
        Individual best = population.get(0);

        System.out.println("Geração: " + g + " | Melhor Fitness (Colisões): " + best.calculateCollisions());
    }
}