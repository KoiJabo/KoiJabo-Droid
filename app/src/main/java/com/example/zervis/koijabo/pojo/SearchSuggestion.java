package com.example.zervis.koijabo.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zarvis on 14/02/2016.
 */
public class SearchSuggestion {

    @SerializedName("Cuisines")
    @Expose
    private List<String> Cuisines = new ArrayList<String>();
    @SerializedName("CreditCards")
    @Expose
    private List<String> CreditCards = new ArrayList<String>();
    @SerializedName("GoodFors")
    @Expose
    private List<String> GoodFors = new ArrayList<String>();
    @SerializedName("Attires")
    @Expose
    private List<String> Attires = new ArrayList<String>();
    @SerializedName("EstablishmentType")
    @Expose
    private List<String> EstablishmentType = new ArrayList<String>();
    @SerializedName("Area")
    @Expose
    private List<String> Area = new ArrayList<String>();

    /**
     *
     * @return
     * The Cuisines
     */
    public List<String> getCuisines() {
        return Cuisines;
    }

    /**
     *
     * @param Cuisines
     * The Cuisines
     */
    public void setCuisines(List<String> Cuisines) {
        this.Cuisines = Cuisines;
    }

    /**
     *
     * @return
     * The CreditCards
     */
    public List<String> getCreditCards() {
        return CreditCards;
    }

    /**
     *
     * @param CreditCards
     * The CreditCards
     */
    public void setCreditCards(List<String> CreditCards) {
        this.CreditCards = CreditCards;
    }

    /**
     *
     * @return
     * The GoodFors
     */
    public List<String> getGoodFors() {
        return GoodFors;
    }

    /**
     *
     * @param GoodFors
     * The GoodFors
     */
    public void setGoodFors(List<String> GoodFors) {
        this.GoodFors = GoodFors;
    }

    /**
     *
     * @return
     * The Attires
     */
    public List<String> getAttires() {
        return Attires;
    }

    /**
     *
     * @param Attires
     * The Attires
     */
    public void setAttires(List<String> Attires) {
        this.Attires = Attires;
    }

    /**
     *
     * @return
     * The EstablishmentType
     */
    public List<String> getEstablishmentType() {
        return EstablishmentType;
    }

    /**
     *
     * @param EstablishmentType
     * The EstablishmentType
     */
    public void setEstablishmentType(List<String> EstablishmentType) {
        this.EstablishmentType = EstablishmentType;
    }

    /**
     *
     * @return
     * The Area
     */
    public List<String> getArea() {
        return Area;
    }

    /**
     *
     * @param Area
     * The Area
     */
    public void setArea(List<String> Area) {
        this.Area = Area;
    }
}
