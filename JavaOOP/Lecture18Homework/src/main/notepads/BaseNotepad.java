package main.notepads;

import main.pages.Page;

public abstract class BaseNotepad {
    private final Page[] pages;

    public BaseNotepad(Page[] pages) {
        this.pages = pages;
    }

    public Page[] getPages() {
        return pages;
    }

    abstract protected void addTextToPage(String text, int pageNum);
    abstract protected void addTextOnPage(String text, int pageNum);
    abstract protected void deletePageText(int pageNum);
    abstract protected void searchPageWord(String word);
    abstract protected void printAllPagesWithDigits();
    abstract protected void viewAllPages();
}