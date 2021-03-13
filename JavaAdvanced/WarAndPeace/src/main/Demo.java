package main;

import java.io.*;

public class Demo {
    public static void main(String[] args) {
        File file = new File("Lev Tolstoy - War and Peace.txt");

        BookReview bookReview = new BookReview(file);
        bookReview.viewReview();
    }
}