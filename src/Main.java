import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) {

        allChecksLoginAndPass("log", "password", "password");
        allChecksLoginAndPass("log123232131231231231221231gfsdgsdgfdgsdfg23123123", "password", "password");
        allChecksLoginAndPass("log", "password1", "password");
        allChecksLoginAndPass("login", "password", "ssddsad22");
        allChecksLoginAndPass("loGin", "paSsword", "sSSddsad22");
        allChecksLoginAndPass("Viking#", "123456", "123456");
        allChecksLoginAndPass("Viking#", "123456", "133456");
    }





    // соединяем все чеки в единый чек-форму и отлавливаем (кетчим) ошибки из рантаймов
    public static boolean allChecksLoginAndPass(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
            return true;

        } catch (WrongLoginException exception) {
            System.out.println(" wrong login- " + exception.getMessage());
            return false;
        } catch (WrongPassException exception) {
            System.out.println(" wrong password- "+ exception.getMessage());
            return false;
        }
    }


    // метод на проверку логина
    private static void checkLogin(String login) {
        if (loginLenght(login, 20) || alpabetTest(login)) {
            throw new WrongLoginException(" login is wrong ");
        }

    }

    // метод на проверку пассворда и подтверждения пассворда
    private static void checkPassword(String password, String confirmPassword) {
        if (loginLenght(password, 20) || alpabetTest(password) || equalsString(password, confirmPassword)) {
            throw new WrongPassException(" Pass is wrong ");
        }
    }

    // проверка что цифр будет больше длины надписи
    private static boolean loginLenght(String string, int lenght) {
        return string.length() > lenght;

    }

    // проверка что пароли не равны
    private static boolean equalsString(String value1, String value2) {
        return !value1.equals(value2);
    }

    // проверка на буквы, цифры и _

    private static boolean alpabetTest(String string) {
        final String alphabet = "qwertyuiopasdfghjklzxcvbnm1234567890_";
        for (int i = 0; i < string.length(); i++) {
            if (!alphabet.contains(String.valueOf(string.charAt(i)).toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}