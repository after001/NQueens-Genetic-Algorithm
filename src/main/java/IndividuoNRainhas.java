import java.util.ArrayList;
import java.util.List;

public class IndividuoNRainhas extends Individuo {
    private double taxaDeMutacao = 0.3;
    private int []genes;
    private int qtdGenes;

    public IndividuoNRainhas(int qtdGenes) {
        this.genes = new int[qtdGenes];

        // PREENCHER GENES COM VALORES ALEAT[ORIO ENTRE 0 E qtdGenes-1

        this.qtdGenes = qtdGenes;
    }

    public List<Individuo> recombinar(Individuo pai2) {
        List<Individuo> filhos = new ArrayList<Individuo>(2);

        // CRIAR 2 FILHOS COM O CROSSOVER DE 1 CORTE ALEATÓRIO ENTRE P1 E P2

        filhos.add(filho1);
        filhos.add(filho2);
        return filhos;
    }

    public Individuo mutar(){
        /*
            MÉTODO QUE GERA OUTRO INDIVÍDUO COM O CONTEÚDO DO THIS.GENES MUTADOS
         */
        IndividuoNRainhas mutante = new IndividuoNRainhas(qtdGenes);

        /*
            COPIAR OS GENES (THIS.GENES) PARA O MUTANTE.
            DURANTE A CÓPIA, COM PROBABILIDADE DE TAXADEMUTACAO
            O GENE COPIADO SOFRERÁ MUTAÇÃO
         */
        return mutante;
    }

    @Override
    public double avaliar() {
        return 0;
    }

    public double colisoes() {
        int colisoes = 0;
        for (int i = 0; i < genes.length - 2; i++) {
            for (int j = 0; j < genes.length - 1; j++) {
                if (genes[i] == genes[j] || genes[i] == genes[j] + (j-i) || genes[i] == genes[j] - (j-i)) {
                    colisoes++;
                }
            }
        }
        return colisoes;
    }

    public boolean isMaximizacao() {
        return false;
    }

}
