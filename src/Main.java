import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.print("Логин: ");
        String login = myObj.nextLine();

        System.out.print("Пароль: ");
        String password = myObj.nextLine();

        System.out.print("Подтвердите пароль: ");
        String confirmPassword = myObj.nextLine();

        try {
            checkAndPrintResult(login, password, confirmPassword);
            System.out.println("Вы успешно авторизировались!");
        } catch (WrongLoginException e) {
            System.out.println(e);
        } catch (WrongPasswordException e) {
            System.out.println(e);
        }
    }

    static void checkAndPrintResult(String login, String password, String confirmPassword) {
        if (!isValidField(login)) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и символы подчеркивания, и не должен превышать 20 символов.");
        }
        if (!isValidField(password)) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и символы подчеркивания, и не должен превышать 20 символов в длину.");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль и пароль для подтверждения должны совпадать.");
        }
    }

    static boolean isValidCharacters(String checkString) {
        String validCharacters = "abcdefghijklmnopqrstuvwxyz0123456789_";
        for (char c : checkString.toLowerCase().toCharArray()) {
            if (validCharacters.indexOf(c) == -1) return false;
        }
        return true;
    }

    static boolean isValidField(String login) {
        return login.length() <= 20 && isValidCharacters(login);
    }
}