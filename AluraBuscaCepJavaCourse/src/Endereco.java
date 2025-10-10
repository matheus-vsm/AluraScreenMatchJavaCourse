public class Endereco {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(EnderecoViaCep meuEndereco) {
        this.cep = meuEndereco.cep();
        this.rua = meuEndereco.logradouro();
        this.bairro = meuEndereco.bairro();
        this.cidade = meuEndereco.localidade();
        this.uf = meuEndereco.uf();
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return rua + ", " + bairro + ", " + cep + ", " + cidade + "-" + uf;
    }
}
