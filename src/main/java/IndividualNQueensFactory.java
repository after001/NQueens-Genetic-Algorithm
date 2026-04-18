public class IndividualNQueensFactory implements IndividualFactory {

    private int geneCount;

    public IndividualNQueensFactory(int geneCount) {
        this.geneCount = geneCount;
    }

    @Override
    public Individual generate() {
        return new IndividualNQueens(this.geneCount);
    }
}