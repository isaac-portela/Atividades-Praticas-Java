public abstract class FiguraGeometrica implements Compara {
    protected String cor;
    protected boolean preenche;

    public FiguraGeometrica() {
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isPreenche() {
        return preenche;
    }

    public void setPreenche(boolean preenche) {
        this.preenche = preenche;
    }

    public abstract double getArea();

    // arrumar o to string.
    @Override
    public String toString() {
        if ((this) instanceof Circulo) {
            return "Circulo";
        } else if ((this) instanceof Retangulo) {
            return "Retangulo";
        }
        return "";
    }

    @Override
    public String Max(FiguraGeometrica[] vetor) throws AreaMaxima {
        double maior = 0;
        String string = "";
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].getArea() <= 100) {
                if (vetor[i].getArea() > maior) {
                    maior = vetor[i].getArea();
                    if (vetor[i] instanceof Circulo) {
                        string = "A figura geometrica com a maior area e o Circulo[" + i + "] :" + String.format("%.2f", maior);
                    } else if (vetor[i] instanceof Retangulo) {
                        string = "A figura geometrica com a maior area e o Retangulo[" + i + "] :" + String.format("%.2f", maior);

                    }
                }
            } else {
                throw new AreaMaxima(vetor[i].getArea(), i);
            }
        }

        return string;
    }
}
