

public class AreaMaxima extends Exception{
    public AreaMaxima() {

    }
    public  AreaMaxima(double area,int i){
        super("A area da Figura["+ i +"] e " + String.format("%.2f", area) + ", porem ela não pode ser maior do que 100\nERRO, resorteando as dimençoes!");
    }
}
