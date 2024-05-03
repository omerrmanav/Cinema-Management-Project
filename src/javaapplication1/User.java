
package javaapplication1;

/**
 *
 * @author omerrmanav
 */
public class User {
    private String name;
    private String mail;
    private String seatNumber;
    private String movieName;
    
    
    
    public User(String seatNumber, String name, String movieName, String mail) {
        this.name = name;
        this.mail = mail;
        this.seatNumber = seatNumber;
        this.movieName = movieName;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    
    
}
