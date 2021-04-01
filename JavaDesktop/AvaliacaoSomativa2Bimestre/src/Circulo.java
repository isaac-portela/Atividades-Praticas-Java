public class Circulo extends FiguraGeometrica {
    private double raio;

    public Circulo() {
    }

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double getArea()  {
        return Math.PI * Math.pow(this.raio, 2);

    }

    public double getPerimetro() {
        return 2 * Math.PI * this.raio;
    }

    public double getDiametro() {
        return 2 * this.raio;
    }

}
