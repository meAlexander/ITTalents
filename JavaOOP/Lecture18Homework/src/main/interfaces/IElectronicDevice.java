package main.interfaces;

public interface IElectronicDevice extends ISecuredNotepad{

    void start();
    void stop();
    boolean isStarted();
}