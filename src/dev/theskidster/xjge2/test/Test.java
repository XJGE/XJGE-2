package dev.theskidster.xjge2.test;

import dev.theskidster.xjge2.core.XJGE;

/**
 * @author J Hoffman
 * Created: Apr 28, 2021
 */

public class Test {

    /*
    TODO:
    this class and package are temporary and provided for testing purposes only!
    they should not be included in releases!
    */
    
    public static void main(String args[]) {
        
        XJGE.init("/dev/theskidster/xjge2/assets/");
        
        /*
        The windows default settings are as follows;
            - Centered on the screen.
            - 60% the size of the monitor its on.
            - Not resizable.
            - Will have "XJGE 2 (v1.0.0)" as its title.
            - Will have the nullchicken as its icon.
            - Will be located on the "primary" monitor.
        
        //WINKIT METHODS
            WinKit.getConnectedMonitors()                   Map<Integer, Monitor>
            WinKit.setVSyncEnabled(boolean vSyncEnabled);   void
        
        the Window class is available statically.
        
        //WINDOW GETTERS (static)
            Window.getTitle();              String
            Window.getMonitor();            Monitor
            Window.getWidth();              int
            Window.getHeight();             int
            Window.getPositionX();          int
            Window.getPositionY();          int
            Window.getResizable();          boolean
            Window.getFullscreenEnabled();  boolean
        
        //WINDOW SETTERS (static)
            Window.setTitle(String title);
            Window.setMonitor(Monitor monitor);
            Window.setDimensions(int width, int height);
            Window.setWidth(int width);
            Window.setHeight(int height);
            Window.setPosition(int xPos, int yPos);
            Window.setPositionCentered();
            Window.setPositionX(int xPos);
            Window.setPositionY(int yPos);
            Window.setResizable(boolean resizable);
            Window.setFullScreenEnabled(boolean fullscreenEnabled);
            Window.setIcon(String filename);
            
        //WINDOW MISC
        Window.handle
        Window.show() //package access only.
        
        Monitor object are available to implemeting applications, but may not
        constructed outside their package.
        
        //MONITOR GETTERS
            Monitor.handle;             long
            Monitor.name;               String
            Monitor.getAspectRatio();   String
            Monitor.getWidth()          int
            Monitor.getHeight()         int
            Monitor.getRefreshRate();   int
            Monitor.getVideoModes();    TreeMap<String, GLFWVidMode>
        
        //MONITOR SETTERS
            Monitor.setVideoMode(String operation)
        */
        
    }
    
}