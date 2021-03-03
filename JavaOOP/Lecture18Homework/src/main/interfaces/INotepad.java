package main.interfaces;

public interface INotepad {

    void addTextToPage(String text, int pageNum);
    void addTextOnPage(String text, int pageNum);
    void deletePageText(int pageNum);
    void searchPageWord(String word);
    void printAllPagesWithDigits();
    void viewAllPages();
}