package entidades;

public class ProdutoImportado extends Produto {

	private Double livreAlfandega;

	public ProdutoImportado(String nome, Double preco, Double livreAlfandega) {
		super(nome, preco);
		this.livreAlfandega = livreAlfandega;
	}

	public Double getlivreAlfandega() {
		return livreAlfandega;
	}

	public void setlivreAlfandega(Double livreAlfandega) {
		this.livreAlfandega = livreAlfandega;
	}
	
	public Double precoTotal() {
		return getPreco() + livreAlfandega;
	}
	
	@Override
	public String tabelaPreco() {
		return getNome() 
				+ " $ " 
				+ String.format("%.2f", precoTotal())
				+ " (Livre da Alfandega: $ " 
				+ String.format("%.2f", livreAlfandega)
				+ ")";
	}
}
