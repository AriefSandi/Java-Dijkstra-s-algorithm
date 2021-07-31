/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.mIndex;
import model.path;
import model.src;

/**
 *
 * @author asus
 */
public class nodepath {
    public static ArrayList<src> search = new ArrayList<>();
    public static ArrayList<mIndex> index = new ArrayList<>();
    public static ArrayList<path> path = new ArrayList<>();
    
    
    //index
    public ArrayList<mIndex> getIndexList(){
      return index;  
    };
    
    public void addIndex(mIndex i){
        index.add(i);
    };
    
    public int getIndexSize() {
        return index.size();
    };
    //path
    public ArrayList<path> getPathList (){
        return path;
    };
    
    public void addPath(path p){
        path.add(p);
    };
    
    public int getPathSize(){
        return path.size();
    };
    //search
    public ArrayList<src> getSearchList(){
        return search;
    }
    public void addSearch(src s){
        search.add(s);
    };
    public int getSearchSize(){
        return search.size();
    }
}
