package avaliacaopratica4bimestre;

public interface IConversor <T>{
    public T converter (String object);
    public Object[] converterParaArray(T object);
}
