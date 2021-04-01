package avaliacaopratica4bimestre;

public class ConversorCliente implements  IConversor<Cliente>{

    @Override
    public Cliente converter(String object) {
        Cliente cliente = new Cliente();
        String stringSplit[] = object.split(",");
        cliente.setNome(stringSplit[0]);
        cliente.setMatricula(stringSplit[1]);
        return cliente;
    }

    @Override
    public Object[] converterParaArray(Cliente object) {
        return new Object[] {object.getNome(), object.getMatricula()};
    }
}
