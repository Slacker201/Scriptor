package com.slacker201.scriptingApi.events;

public class CChatEvent {
    private String msg;
    private boolean sendToServer, showInClient, addToChatHistory;
    public CChatEvent (String msg, boolean addToChatHistory, boolean showInClient)
    {
        this.msg = msg;
        this.addToChatHistory = addToChatHistory;
        this.showInClient = showInClient;
        this.sendToServer = true;

    }
}
