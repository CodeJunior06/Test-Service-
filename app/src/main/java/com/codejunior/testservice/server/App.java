package com.codejunior.testservice.server;


import fi.iki.elonen.NanoHTTPD;

public class App extends NanoHTTPD {

    public App(int port) {
        super(port);
    }

    @Override
    public Response serve(IHTTPSession session) {

        return newFixedLengthResponse("OKEY TEST");
    }
}
