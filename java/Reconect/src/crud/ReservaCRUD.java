package crud;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.PacoteDeViagemDAO;
import dao.ReservaDAO;
import model.Cliente;
import model.PacoteDeViagem;
import model.Reserva;

public class ReservaCRUD {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		ReservaDAO reservaDAO = new ReservaDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int opcao = 0, id = 0, pacoteid, clienteid;

		String dataReserva, statusReserva;
		Date data = new Date();
		ClienteDAO clientedao = new ClienteDAO();
		PacoteDeViagemDAO pacotedao = new PacoteDeViagemDAO();
		do {

			System.out.println("\n============================== RESERVAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite o ID do cliente:");
				clienteid = s.nextInt();
				System.out.println("Digite o pacote do cliente:");
				pacoteid = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data da reserva:");
				dataReserva = s.nextLine();
				System.out.println("Digite o status da reserva  :");
				statusReserva = s.nextLine();
				Cliente cliente = clientedao.readById(clienteid);
				PacoteDeViagem pacote = pacotedao.readById(pacoteid);
				try {

					data = sdf.parse(dataReserva);
				} catch (Exception e) {
					// TODO: handle exception
				}

				reservaDAO.create(new Reserva(cliente, pacote, data, statusReserva));
				break;
			case 2:

				for (Reserva r : reservaDAO.read()) {
					r.Mostrar();
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o ID do cliente:");
				clienteid = s.nextInt();
				System.out.println("Digite o pacote do cliente:");
				pacoteid = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data da reserva:");
				dataReserva = s.nextLine();
				System.out.println("Digite o status da reserva  :");
				statusReserva = s.nextLine();
				Cliente cliente1 = clientedao.readById(clienteid);
				PacoteDeViagem pacote1 = pacotedao.readById(pacoteid);
				try {

					data = sdf.parse(dataReserva);
				} catch (Exception e) {
					// TODO: handle exception
				}
				reservaDAO.update(new Reserva(id, cliente1, pacote1, data, statusReserva));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				reservaDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Reserva reserva = reservaDAO.readById(id);

				reserva.Mostrar();
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}
