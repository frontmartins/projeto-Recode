package crud;

import java.util.Scanner;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteCRUD {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		
		int opcao = 0, id = 0; 
		
		String Nome, Endereco, Telefone, Email, Historico_De_Viagens;
		
		
		do {
			
			System.out.println("\n============================== CLIENTES =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o Nome:");
				Nome = s.nextLine();
				System.out.println("Digite o Email:");
				Email = s.nextLine();
				System.out.println("Digite a Telefone:");
				Telefone = s.nextLine();
				System.out.println("Digite seu Historico De Viagem:");
				Historico_De_Viagens = s.nextLine();
				System.out.println("Digite seu Endereço:");
				Endereco = s.nextLine();
				
				clienteDAO.create(new Cliente(Nome,Endereco, Telefone, Email, Historico_De_Viagens));
				break;
			case 2:
				
				for (Cliente c : clienteDAO.read()) {
					c.Mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o Nome:");
				Nome = s.nextLine();
				System.out.println("Digite o Email:");
				Email = s.nextLine();
				System.out.println("Digite a Telefone:");
				Telefone = s.nextLine();
				System.out.println("Digite seu Historico De Viagem:");
				Historico_De_Viagens = s.nextLine();
				System.out.println("Digite seu Endereço:");
				Endereco = s.nextLine();
				
				clienteDAO.update(new Cliente(id,Nome,Endereco, Telefone, Email, Historico_De_Viagens));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				clienteDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Cliente cliente = clienteDAO.readById(id);
				
				cliente.Mostrar();
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}
}
