public class IndividuoNRainhasFactory implements Factory{
    private int qtdGenes;

    public IndividuoNRainhasFactory(int qtdGenes){
        this.qtdGenes = qtdGenes;
    }

    @Override
    public Individuo getInstance() {
        return new IndividuoNRainhas(this.qtdGenes);
    }
}
