package main.notepads;

import main.pages.Page;

public abstract class Notepad extends BaseNotepad{

    public Notepad(Page[] pages) {
        super(pages);
    }

    private Page checkNumPage(int pageNum) {
        for (Page page : getPages()) {
            if (page.getPageNumber() == pageNum) {
                return page;
            }
        }
        System.out.println("Page number does not exist!");
        return null;
    }

    @Override
    protected void addTextToPage(String text, int pageNum) {
        Page page = checkNumPage(pageNum);
        if (page != null) {
            page.addText(text);
        }
    }

    @Override
    protected void addTextOnPage(String text, int pageNum) {
        Page page = checkNumPage(pageNum);
        if (page != null) {
            page.setText(text);
        }
    }

    @Override
    protected void deletePageText(int pageNum) {
        Page page = checkNumPage(pageNum);
        if (page != null) {
            page.deleteText();
        }
    }

    @Override
    protected void searchPageWord(String word){
        for(Page page : getPages()){
            if(page.searchWord(word)){
                return;
            }
        }
        System.out.println("Word: " + word + " is not contained in the text!");
    }

    @Override
    protected void printAllPagesWithDigits() {
        for(Page page : getPages()){
            if(page.containsDigit()){
                System.out.println(page.viewPage());
            }
        }
    }

    @Override
    protected void viewAllPages() {
        for (Page page : getPages()) {
            System.out.println(page.viewPage());
        }
    }
}