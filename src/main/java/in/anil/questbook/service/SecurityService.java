package in.anil.questbook.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
