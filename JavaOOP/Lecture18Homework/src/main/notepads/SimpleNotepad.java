package main.notepads;

import main.interfaces.INotepad;
import main.pages.Page;

public class SimpleNotepad extends Notepad implements INotepad {

    public SimpleNotepad(Page[] pages) {
        super(pages);
    }

    @Override
    public void addTextToPage(String text, int pageNum) {
        super.addTextToPage(text, pageNum);
    }

    @Override
    public void addTextOnPage(String text, int pageNum) {
        super.addTextOnPage(text,pageNum);
    }

    @Override
    public void deletePageText(int pageNum) {
        super.deletePageText(pageNum);
    }

    @Override
    public void searchPageWord(String word) {
        super.searchPageWord(word);
    }

    @Override
    public void printAllPagesWithDigits() {
        super.printAllPagesWithDigits();
    }

    @Override
    public void viewAllPages() {
        super.viewAllPages();
    }
}