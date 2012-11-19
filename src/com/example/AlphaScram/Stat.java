package com.example.AlphaScram;

/**
 * Created with IntelliJ IDEA.
 * User: Abbey
 * Date: 11/10/12
 * Time: 12:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Stat {
    private int id;
    private String name;
    private String code;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name;
    }
}
