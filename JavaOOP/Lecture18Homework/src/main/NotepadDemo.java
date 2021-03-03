package main;

import main.interfaces.IElectronicDevice;
import main.interfaces.INotepad;
import main.interfaces.ISecuredNotepad;
import main.notepads.ElectronicSecuredNotepad;
import main.notepads.SecuredNotepad;
import main.notepads.SimpleNotepad;
import main.pages.Page;

public class NotepadDemo {
    public static void main(String[] args) {
        Page page1 = new Page("1", "1", 1);
        Page page2 = new Page("2", "2", 2);
        Page page3 = new Page("3", "3", 3);
        Page page4 = new Page("4", "4", 4);
        Page page5 = new Page("5", "5", 5);
        Page page6 = new Page("6", "6", 6);
        Page page7 = new Page("7", "7", 7);
        Page[] pages = {page1, page2, page3, page4, page5, page6, page7};

        System.out.println("=========Simple Notepad===========");
        INotepad simpleNotepad = new SimpleNotepad(pages);

        simpleNotepad.addTextToPage("da", 1);
        simpleNotepad.addTextOnPage("op", 2);
        simpleNotepad.deletePageText(3);
        System.out.println("=========Pages with digits===========");
        simpleNotepad.printAllPagesWithDigits();
        System.out.println("=========Page contains word===========");
        simpleNotepad.searchPageWord("da");
        System.out.println("=========All Pages==============");
        simpleNotepad.viewAllPages();

        System.out.println("=========Secured Notepad===========");
        ISecuredNotepad securedNotepad = new SecuredNotepad(pages, "123Oh5lP");

        securedNotepad.addTextToPageSecureNotepad("da", 4, "123");
        securedNotepad.addTextOnPageSecureNotepad("da", 5, "123");
        securedNotepad.deletePageTextSecureNotepad(6,  "123");
        System.out.println("=========Invalid password===========");
        securedNotepad.viewAllPagesSecureNotepad("13");
        System.out.println("=========Pages with digits===========");
        securedNotepad.printAllPagesWithDigitsSecureNotepad("123");
        System.out.println("=========Page contains word===========");
        securedNotepad.searchPageWordSecureNotepad("op", "123");
        System.out.println("=========All Pages==============");
        securedNotepad.viewAllPagesSecureNotepad("123");

        System.out.println("=========Electronic Secured Notepad===========");
        IElectronicDevice electronicSecuredNotepad = new ElectronicSecuredNotepad(pages, "4o56");

        System.out.println("=========Electronic Secured Notepad is not turned on===========");
        electronicSecuredNotepad.addTextOnPageSecureNotepad("do", 4, "456");
        System.out.println("=========Electronic Secured Notepad is turned on(but wrong pass)===========");
        electronicSecuredNotepad.start();
        electronicSecuredNotepad.isStarted();
        electronicSecuredNotepad.addTextOnPageSecureNotepad("do", 4, "485a6");
    }
}