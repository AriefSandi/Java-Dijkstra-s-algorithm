/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class path {
    String start,desti, nPath;

    public path() {
    }

    public path(String start, String desti, String nPath) {
        this.start = start;
        this.desti = desti;
        this.nPath = nPath;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDesti() {
        return desti;
    }

    public void setDesti(String desti) {
        this.desti = desti;
    }

    public String getnPath() {
        return nPath;
    }

    public void setnPath(String nPath) {
        this.nPath = nPath;
    }

    

    
    
}
