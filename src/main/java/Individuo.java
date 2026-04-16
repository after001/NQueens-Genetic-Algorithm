import java.util.List;

public abstract class Individuo {
    private double avaliacao;
    private boolean avaliado = false;


    public abstract List<Individuo> recombinar(Individuo pai2);
    /*
    Individuo p1 = ...
    Individuo p2 = ...
    List<Individuo> filhos = p1.recombinar(p2);
    */
    public abstract Individuo mutar();
    public abstract double avaliar();


    public double colisoes() {
        if (!avaliado) {
            avaliacao = avaliar();
        }
        return avaliacao;
    }

    public boolean isMaximizacao() {
        return true;
    }

}
