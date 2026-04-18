import java.util.List;

public abstract class Individual implements Comparable<Individual> {

    private double fitness; // How good the solution is
    private boolean evaluated = false; // Control Flag

    public abstract List<Individual> crossover(Individual parent2);

    public abstract Individual mutate();

    public abstract int calculateCollisions();

    public double getFitness() {
        if (!evaluated) {
            fitness = calculateCollisions();
            evaluated = true;
        }
        return fitness;
    }

    public boolean isMaximization() {
        return false; // Minimizes collisions
    }

    @Override
    public int compareTo(Individual other) {
        return Double.compare(calculateCollisions(), other.calculateCollisions());
    }
}