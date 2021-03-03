package main.interfaces;

public interface ISecuredNotepad {
    boolean validateLogin(String pass);

    void addTextToPageSecureNotepad(String text, int pageNum, String pass);
    void addTextOnPageSecureNotepad(String text, int pageNum, String pass);
    void deletePageTextSecureNotepad(int pageNum, String pass);
    void searchPageWordSecureNotepad(String word, String pass);
    void printAllPagesWithDigitsSecureNotepad(String pass);
    void viewAllPagesSecureNotepad(String pass);
}