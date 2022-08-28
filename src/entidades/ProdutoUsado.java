package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dataManufatura;

	public ProdutoUsado(String nome, Double preco, Date dataManufatura) {
		super(nome, preco);
		this.dataManufatura = dataManufatura;
	}

	public Date getManufactureDate() {
		return dataManufatura;
	}

	public void setManufactureDate(Date dataManufatura) {
		this.dataManufatura = dataManufatura;
	}
	
	@Override
	public String tabelaPreco() {
		return getNome() 
				+ " (usado) $ " 
				+ String.format("%.2f", getPreco())
				+ " (Data Manufatura: "
				+ sdf.format(dataManufatura)
				+ ")";
	}
}
