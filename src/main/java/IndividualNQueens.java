import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IndividualNQueens extends Individual {

    private double mutationRate = 0.3; // reduce to 1%
    private int[] genes; // Row index for each column (Position of Queens)
    private int geneCount; // N (Number of Queens and board size)

    public IndividualNQueens(int geneCount) {
        this.geneCount = geneCount;
        this.genes = new int[geneCount];

        Random rand = new Random();
        for (int i = 0; i < geneCount; i++) {
            this.genes[i] = rand.nextInt(geneCount);
        }
    }

    /**
     * @param parent
     */
    public IndividualNQueens(IndividualNQueens parent) {
        this.geneCount = parent.geneCount;
        this.genes = new int[geneCount];

        for (int i = 0; i < geneCount; i++) {
            this.genes[i] = parent.genes[i];
        }
    }

    /**
     * @param genes
     */
    public IndividualNQueens(int[] genes) {
        this.genes = genes;
        this.geneCount = genes.length;
    }

    @Override
    public List<Individual> crossover(Individual parent2) {
        List<Individual> offspring = new ArrayList<Individual>(2);
        IndividualNQueens p2 = (IndividualNQueens) parent2; // Downcasting

        /**
         Crossover de 2 pontos.
         int point2 = rand.nextInt(this.geneCount);
         int start = Math.min(point1, point2);
         int end = Math.max(point1, point2);
         if (i >= start && i <= end) {
         genesOffspring1[i] = p2.genes[i];
         genesOffspring2[i] = this.genes[i];
         } else {
         // Se estiver fora, mantém os originais
         genesOffspring1[i] = this.genes[i];
         genesOffspring2[i] = p2.genes[i];
         }
         */
        Random rand = new Random();
        int cutPoint = rand.nextInt(this.geneCount - 1) + 1;

        int[] genesOffspring1 = new int[this.geneCount];
        int[] genesOffspring2 = new int[this.geneCount];

        for (int i = 0; i < this.geneCount; i++) {
            if (i < cutPoint) {
                genesOffspring1[i] = this.genes[i];
                genesOffspring2[i] = p2.genes[i];
            } else {
                genesOffspring1[i] = p2.genes[i];
                genesOffspring2[i] = this.genes[i];
            }
        }

        offspring.add(new IndividualNQueens(genesOffspring1));
        offspring.add(new IndividualNQueens(genesOffspring2));

        return offspring;
    }

    @Override
    public Individual mutate() {
        IndividualNQueens mutant = new IndividualNQueens(this);

        Random rand = new Random();
        for (int i = 0; i < geneCount; i++) {
            if (rand.nextDouble() < mutationRate) {
                mutant.genes[i] = rand.nextInt(geneCount);
            }
        }
        return mutant;
    }

    @Override
    public int calculateCollisions() {
        int collisions = 0;

        for (int i = 0; i < genes.length; i++) {
            for (int j = i + 1; j < genes.length; j++) {
                boolean sameRow = (genes[i] == genes[j]);
                boolean sameDiagonal = Math.abs(genes[i] - genes[j]) == Math.abs(i - j);

                if (sameRow || sameDiagonal) {
                    collisions++;
                }
            }
        }
        return collisions;
    }

    public int[] getGenes() {
        return this.genes;
    }
}