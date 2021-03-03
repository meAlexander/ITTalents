package main.notepads;

import main.interfaces.IElectronicDevice;
import main.pages.Page;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice {
    private boolean isTurnedOn;

    public ElectronicSecuredNotepad(Page[] pages, String password) {
        super(pages, password);
        this.isTurnedOn = false;
    }

    @Override
    public void start() {
        this.isTurnedOn = true;
    }

    @Override
    public void stop() {
        this.isTurnedOn = false;
    }

    @Override
    public boolean isStarted() {
        if(this.isTurnedOn){
            return true;
        }
        System.out.println("Electronic Secured Notepad is not turned on!");
        return false;
    }

    @Override
    public void addTextToPageSecureNotepad(String text, int pageNum, String pass) {
        if(isStarted()){
            super.addTextToPageSecureNotepad(text, pageNum, pass);
        }
    }

    @Override
    public void addTextOnPageSecureNotepad(String text, int pageNum, String pass) {
        if(isStarted()){
            super.addTextOnPageSecureNotepad(text, pageNum, pass);
        }
    }

    @Override
    public void deletePageTextSecureNotepad(int pageNum, String pass) {
        if(isStarted()){
            super.deletePageTextSecureNotepad(pageNum, pass);
        }
    }

    @Override
    public void searchPageWordSecureNotepad(String word, String pass){
        if(isStarted()) {
            super.searchPageWordSecureNotepad(word, pass);
        }
    }

    @Override
    public void printAllPagesWithDigitsSecureNotepad(String pass) {
        if(isStarted()) {
            super.printAllPagesWithDigitsSecureNotepad(pass);
        }
    }

    @Override
    public void viewAllPagesSecureNotepad(String pass) {
        if(isStarted()){
            super.viewAllPagesSecureNotepad(pass);
        }
    }
}