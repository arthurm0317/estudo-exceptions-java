package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o numero do quarto:");
        int num = scanner.nextInt();
        System.out.print("Data de check-in:");
        Date checkin = sdf.parse(scanner.next());
        System.out.print("Data de check-out:");
        Date checkout = sdf.parse(scanner.next());

        if(!checkout.after(checkin)){
            System.out.println("A data de check-out deve ser posterior a data de check-in!");
        }
        else {
            Reservation reservation = new Reservation(num, checkin, checkout);
            System.out.println(reservation);
            System.out.println();
            System.out.println("Entre com os dados de atualização da reserva: ");
            System.out.print("Data de check-in:");
            checkin = sdf.parse(scanner.next());
            System.out.print("Data de check-out:");
            checkout = sdf.parse(scanner.next());
            Date now = new Date();
            if (checkin.before(now)||checkout.before(now)){
                System.out.println("Reservas devem ser feitas para datas futuras!");
            } else if (!checkout.after(checkin)) {
                System.out.println("A data de check-out deve ser posterior a data de check-in!");
            }else {
                reservation.updateDates(checkin, checkout);
                System.out.println(reservation);
            }

        }



    }
}
