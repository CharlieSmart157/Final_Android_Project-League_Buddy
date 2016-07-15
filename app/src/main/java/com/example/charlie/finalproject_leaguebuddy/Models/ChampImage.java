package com.example.charlie.finalproject_leaguebuddy.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Charlie on 12/07/2016.
 */
public class ChampImage {

    @SerializedName("w")
    @Expose
    private int w;
    @SerializedName("full")
    @Expose
    private String full;
    @SerializedName("sprite")
    @Expose
    private String sprite;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("h")
    @Expose
    private int h;
    @SerializedName("y")
    @Expose
    private int y;
    @SerializedName("x")
    @Expose
    private int x;

/**
 *
 * @return
 * The w
 */
    public int getW() {
        return w;
    }

    /**
     *
     * @param w
     * The w
     */
    public void setW(int w) {
        this.w = w;
    }

    /**
     *
     * @return
     * The full
     */
    public String getFull() {
        return full;
    }

    /**
     *
     * @param full
     * The full
     */
    public void setFull(String full) {
        this.full = full;
    }

    /**
     *
     * @return
     * The sprite
     */
    public String getSprite() {
        return sprite;
    }

    /**
     *
     * @param sprite
     * The sprite
     */
    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    /**
     *
     * @return
     * The group
     */
    public String getGroup() {
        return group;
    }

    /**
     *
     * @param group
     * The group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     *
     * @return
     * The h
     */
    public int getH() {
        return h;
    }

    /**
     *
     * @param h
     * The h
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     *
     * @return
     * The y
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     * The y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     * The x
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     * The x
     */
    public void setX(int x) {
        this.x = x;
    }

}