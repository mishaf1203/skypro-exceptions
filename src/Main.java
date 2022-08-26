import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) throws WrongPasswordException {
        String login = "dsf123";
        String password = "sadkz2478";
        String confirmPassword = "sadkz2478";
        System.out.println(checkCorrect(login, password,confirmPassword));
        String loginNegative = "dsf123";
        String passwordNegative = "1234578911234567891";
        String confirmPasswordNegative = "sadk34247877777777777777";
        System.out.println(checkCorrect(loginNegative , passwordNegative,confirmPasswordNegative));
    }

    public static boolean checkCorrect(String login, String password, String confirmPassword) throws WrongPasswordException {
        try {
            if (login.toCharArray().length >= 20) {
                throw new WrongLoginException("Слишком длинный логин");
            }
            if (password.toCharArray().length >= 20 || confirmPassword.toCharArray().length >=20) {
                throw new WrongPasswordException("Слишком длинный пароль");
            }
            if (!login.matches("\\w{1,20}")) {
                throw new WrongLoginException("Логин не соответствует условиям");
            }
            if (!password.matches("\\w{1,20}")) {
                throw new WrongPasswordException("Пароль не соответствует условиям");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
        } catch (WrongLoginException | WrongPasswordException exception){
            System.out.println(exception.getMessage());
            return false;
        }

        return true;
    }

}