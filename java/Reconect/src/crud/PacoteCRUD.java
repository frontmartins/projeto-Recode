package crud;

import java.util.Scanner;

import dao.PacoteDeViagemDAO;
import model.PacoteDeViagem;

public class PacoteCRUD {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		PacoteDeViagemDAO pacoteDAO = new PacoteDeViagemDAO();
		
		int opcao = 0, id = 0; 
		
		String  Destino, Itinerario, Datas_disponiveis,Descricao;
		float   Preco;
		
		
		do {
			
			System.out.println("\n============================== PACOTES =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o seu Destino:");
				Destino = s.nextLine();
				System.out.println("Digite o seu Itinerario:");
				Itinerario = s.nextLine();
				System.out.println("Digite o  preço  :");
				Preco = s.nextFloat();
				s.nextLine();
				System.out.println("Digite sua disponibilade:");
				Datas_disponiveis = s.nextLine();
				System.out.println("Digite sua Descriçao:");
				Descricao = s.nextLine();
				
				pacoteDAO.create(new PacoteDeViagem(Destino,Itinerario,Preco, Datas_disponiveis,Descricao));
				break;
			case 2:
				
				for (PacoteDeViagem p : pacoteDAO.read()) {
					p.Mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o seu Destino:");
				Destino = s.nextLine();
				System.out.println("Digite o seu Itinerario:");
				Itinerario = s.nextLine();
				System.out.println("Digite o  preço  :");
				Preco = s.nextFloat();
				s.nextLine();
				System.out.println("Digite sua disponibilade:");
				Datas_disponiveis = s.nextLine();
				System.out.println("Digite sua Descriçao:");
				Descricao = s.nextLine();
				pacoteDAO.update(new PacoteDeViagem(id,Destino,Itinerario,Preco, Datas_disponiveis,Descricao));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				pacoteDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				PacoteDeViagem pacote = pacoteDAO.readById(id);
				
				pacote.Mostrar();
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}
}
