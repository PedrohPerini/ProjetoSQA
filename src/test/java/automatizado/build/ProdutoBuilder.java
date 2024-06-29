package automatizado.build;



import automatizado.page.ProdutosPO;

public class ProdutoBuilder {
    private Integer codigo = 0000;
    private String nome = "Produto";
    private Integer quantidade = 10;
    private Double valor = 1.0;
    private String data = "20/06/2024";

    private ProdutosPO produtosPO;

    public ProdutoBuilder(ProdutosPO produtosPO){
        this.produtosPO = produtosPO;
    }

    public ProdutoBuilder adcCodigo(Integer codigo){
        this.codigo = codigo;
        return this;
    }

    public ProdutoBuilder adcNome(String nome){
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder adcQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }


    public ProdutoBuilder adcValor(Double valor){
        this.valor = valor;
        return this;
    }


    public ProdutoBuilder adcData(String data){
        this.data = data;
        return this;
    }

    public void builder(){
        produtosPO.inputCodigoModal.sendKeys((codigo != null) ? codigo.toString():"");
        produtosPO.inputNomeModal.sendKeys(nome);
        produtosPO.inputQuantidadeModal.sendKeys((quantidade != null) ? quantidade.toString(): "");
        produtosPO.inputValorModal.sendKeys((valor != null) ? valor.toString():"");
        produtosPO.inputDataModal.sendKeys(data);

    }



}

