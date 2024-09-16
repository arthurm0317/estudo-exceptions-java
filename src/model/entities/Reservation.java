package model.entities;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNum;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNum, Date checkIn, Date checkOut) {
        this.roomNum = roomNum;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long diff = checkOut.getTime()-checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public String updateDates(Date checkIn, Date checkOut){

        Date now = new Date();
        if (checkIn.before(now)||checkOut.before(now)){
            return  ("Reservas devem ser feitas para datas futuras!");
        } else if (!checkOut.after(checkIn)) {
            return ("A data de check-out deve ser posterior a data de check-in!");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString(){
        return "Quarto " + roomNum + ", check-in: "+ sdf.format(checkIn) +", check-out: "+sdf.format(checkOut)+ ", duração: "+duration() +" noites";
    }
}
