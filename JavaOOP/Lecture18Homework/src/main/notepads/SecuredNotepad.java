package main.notepads;

import main.interfaces.ISecuredNotepad;
import main.pages.Page;

public class SecuredNotepad extends Notepad implements ISecuredNotepad {
    private final String password;

    public SecuredNotepad(Page[] pages, String password) {
        super(pages);
        if(!validatePassword(password)){
            throw new IllegalArgumentException("Password is not secured enough!");
        }
        this.password = password;
    }

    private boolean validatePassword(String password){
        if(password.length() < 5){
            return false;
        }
        //Другият вариант е с REGEX, но в условието пише с charAt и това ми хрумна само
        for (int i = 0; i < password.length(); i++) {
            if(Character.isDigit(password.charAt(i))){
                for (int j = 0; j < password.length(); j++){
                    if(Character.isLowerCase(password.charAt(j))){
                        for (int k = 0; k < password.length(); k++){
                            if(Character.isUpperCase(password.charAt(k))){
                                return true;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return false;
    }

    @Override
    public boolean validateLogin(String pass) {
        if(pass.equals(this.password)) {
            return true;
        }
        System.out.println("Wrong password!");
        return false;
    }

    @Override
    public void addTextToPageSecureNotepad(String text, int pageNum, String pass) {
        if(validateLogin(pass)){
            super.addTextToPage(text, pageNum);
        }
    }

    @Override
    public void addTextOnPageSecureNotepad(String text, int pageNum, String pass) {
        if(validateLogin(pass)){
            super.addTextOnPage(text, pageNum);
        }
    }

    @Override
    public void deletePageTextSecureNotepad(int pageNum, String pass) {
        if(validateLogin(pass)){
            super.deletePageText(pageNum);
        }
    }

    @Override
    public void searchPageWordSecureNotepad(String word, String pass){
        if(validateLogin(pass)) {
            super.searchPageWord(word);
        }
    }

    @Override
    public void printAllPagesWithDigitsSecureNotepad(String pass) {
        if(validateLogin(pass)) {
            super.printAllPagesWithDigits();
        }
    }

    @Override
    public void viewAllPagesSecureNotepad(String pass) {
        if(validateLogin(pass)){
            super.viewAllPages();
        }
    }
}