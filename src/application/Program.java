package application;

import exceptions.DomainException;
import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite o numero do quarto:");
            int num = scanner.nextInt();
            System.out.print("Data de check-in:");
            Date checkin = sdf.parse(scanner.next());
            System.out.print("Data de check-out:");
            Date checkout = sdf.parse(scanner.next());
            Reservation reservation = new Reservation(num, checkin, checkout);

            System.out.println(reservation);
            System.out.println();
            System.out.println("Entre com os dados de atualização da reserva: ");
            System.out.print("Data de check-in:");
            checkin = sdf.parse(scanner.next());
            System.out.print("Data de check-out:");
            checkout = sdf.parse(scanner.next());
            reservation.updateDates(checkin, checkout);
        }catch (ParseException e){
            System.out.println("Formato de data inserido é invalida");
        }catch (DomainException e){
            System.out.println("Erro na reserva: "+e.getMessage());
        }catch (RuntimeException e){
            System.out.println("Erro inesperado!");
        }





    }
}
