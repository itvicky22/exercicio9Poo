package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.ProdutoImportado;
import entidades.Produto;
import entidades.ProdutoUsado;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produto> lista = new ArrayList<>();
		
		System.out.print("Entre com o numero de produtos: ");
		int n = ler.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Produto #" + i + " dados:");
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char type = ler.next().charAt(0);
			System.out.print("Nome: ");
			ler.nextLine();
			String nome = ler.nextLine();
			System.out.print("Preco: ");
			double preco = ler.nextDouble();
			if (type == 'c') {
				lista.add(new Produto(nome, preco));
			}
			else if (type == 'u') {
				System.out.print("Data Manufatura (DD/MM/YYYY): ");
				Date data = sdf.parse(ler.next());
				lista.add(new ProdutoUsado(nome, preco, data));
			}
			else {
				System.out.print("Livre de Alfandega: ");
				double livreAlfandega = ler.nextDouble();
				lista.add(new ProdutoImportado(nome, preco, livreAlfandega));
			}
		}
		System.out.println();
		System.out.println("TABELA DE PRECOS:");
		for (Produto prod : lista) {
			System.out.println(prod.tabelaPreco());
		}
		ler.close();
	}
}