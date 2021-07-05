import java.util.ArrayList;

public class PinCreator {

    public static int usersCount;  // usunięto przypisanie (jeśli się tego  nie zrobi, w poniższych metodach może wystąpić Null Pointer excetion)
    public static int divisionsCount = 4; // zmienna zbędna, nigdy nie używana
    public static int pinLength = 12;

    User[] users = new User[usersCount];
    ArrayList<User>usersWithoutPins = new ArrayList<>();


    public void generatePinsForAllUsers() {
        for (int i = 1;  i<= usersCount; i++) // zmiana i z 0 na 1; Null Pointer Exception
            users[i].setPin(generatePin(pinLength));
    }
    public void setAllUsersPin(Integer userId, String pin) {  //zmiana nazwy metody tak by reprezentowała to co robi
        for (int i = 0; i <= usersCount-1; i++) {   //dodano -1 w usersCount, w innym wypadku występuje błąd Index bound out of length
                users[i].setPin(pin);  //usunięto warunek (zawsze true)
        }
        for (User user : usersWithoutPins) {
            if(userId ==user.getId())
                usersWithoutPins.remove(user);
        }
    }

    public void setUserPin(User user, String pin) {
        user.setPin(pin);  //zmieniono ciało metody na działające. Sama metoda zbędna, to samo robi setter z klasy User

    }

    public Boolean isCharPositive(char c) {
        return ((int) c < 0); // brak zastosowania metody, niezozumiały warunek
    }

    public static String generatePin(int pinLength) {
        String pin = null; //zainicjalizowano zmienną
        for (int i = 0; i < pinLength; i++)
            pin = pin + Math.random() * 10; // wyciągnięto 10 z nawiasu i dodano znak *, usunięto (Strinng); castowanie do Stringa zbędne
        return pin;
    }

    public static Boolean isPinSameAsOld (User user, String newPin) {
        if (newPin == user.getPin()) // == zamiast =
            return true;
        else
            return false;
    }
    public Boolean hasEveryoneGotPin() {
        int counter = 0; // zainicjowalizowano zmienną, wcześniej była nieprzypisana
        try {
            for (int i = 0; i < usersCount; i++) {
                if(users[i].getPin() != null);
                counter++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if(counter == usersCount)
            return true;
        else return false;  //poprawiono return funkcji
    }

    public int countUsersWithoutPin() {  //na potrzeby uruchomienia poniższej funcji powstała niniejsza
        int counter = 0;
        for (int i = 0; i < usersCount; i++) {
            if (users[i].getPin() == null) ;
            counter++;
        }
        return counter;
    }

    public double percentageOfUsersWithPins() {
        double counter = 0;  //zaninicjalizowano zmienną i zmieniono jej typ (rezultat dzielenia może być ułamkiem)
        for (int i = 0; i < users.length; i++) {
            if (users[i].getPin() != null) {
                counter ++;
            }
        }
        return (counter / countUsersWithoutPin() * 100); // zmiana dzielnika; poprzedni byłby zawodny
    }

}
