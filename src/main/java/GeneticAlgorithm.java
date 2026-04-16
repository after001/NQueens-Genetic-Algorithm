import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithm {
    public Individuo executar(Factory factory, int n, int elite, int qtdGeracoes) {
        List<Individuo> initialPopulation = new ArrayList<Individuo>(n);

        for(int i = 0; i < n - 1; i++){
            initialPopulation.add(factory.getInstance());
        }

        for(int i = 0; i < qtdGeracoes; i++){
            List<Individuo> auxList = new ArrayList<>(n);
            auxList.addAll(initialPopulation);

            /*
             RETIRAR, DE 2 EM 2 PAIS DA LISTA AUXLIST
             A CADA 2 PAIS RECOMBINAR  GERANDO 2 FILHOS
             COLOCAR OS 20 FILHOS EM UMA LISTA "LIST<Individuo> filhos"
             */
            List<Individuo> mutantes = new ArrayList<>(n);
            for (int j = 0; j < n-1; j++) {
                mutantes.add(initialPopulation.get(j).mutar());
            }
            List<Individuo> join = new ArrayList<>(n*3);
            join.addAll(initialPopulation);
            join.addAll(filhos);
            join.addAll(mutantes);

            // ELITISMO
            // ROLETA
            // NEW POP
            // PRINT MELHOR IND
        }
    }
}
