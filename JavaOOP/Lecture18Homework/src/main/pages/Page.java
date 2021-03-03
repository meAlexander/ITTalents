package main.pages;

public class Page {
    private final String title;
    private String text;
    private final int pageNumber;

    public Page(String title, String text, int pageNumber) {
        this.title = title;
        this.text = text;
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addText(String newText){
        this.text = this.text.concat(" " + newText);
    }

    public void deleteText(){
        this.text = "";
    }

    public boolean searchWord(String word){
        String[] words = this.text.split("[,]+\\s|[,]|[\\s]");
        for (String s : words) {
            if (s.equals(word)) {
                System.out.println("Word: " + word + " is contained in the text!");
                return true;
            }
        }
        return false;
    }

    public boolean containsDigit(){
        for (int i = 0; i < text.length(); i++) {
            if(Character.isDigit(text.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public String viewPage(){
        return "Title: " + this.title + ", Text: " + this.text;
    }
}