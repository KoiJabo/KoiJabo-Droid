package com.example.zervis.koijabo.pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Zarvis on 13/02/2016.
 */
public class Pagination {

    @SerializedName("Total")
    @Expose
    private Integer Total;
    @SerializedName("Page")
    @Expose
    private Integer Page;
    @SerializedName("Start")
    @Expose
    private Integer Start;
    @SerializedName("PageSize")
    @Expose
    private Integer PageSize;
    @SerializedName("TotalPages")
    @Expose
    private Integer TotalPages;
    @SerializedName("Returned")
    @Expose
    private Integer Returned;
    @SerializedName("NextPage")
    @Expose
    private String NextPage;

    /**
     *
     * @return
     * The Total
     */
    public Integer getTotal() {
        return Total;
    }

    /**
     *
     * @param Total
     * The Total
     */
    public void setTotal(Integer Total) {
        this.Total = Total;
    }

    /**
     *
     * @return
     * The Page
     */
    public Integer getPage() {
        return Page;
    }

    /**
     *
     * @param Page
     * The Page
     */
    public void setPage(Integer Page) {
        this.Page = Page;
    }

    /**
     *
     * @return
     * The Start
     */
    public Integer getStart() {
        return Start;
    }

    /**
     *
     * @param Start
     * The Start
     */
    public void setStart(Integer Start) {
        this.Start = Start;
    }

    /**
     *
     * @return
     * The PageSize
     */
    public Integer getPageSize() {
        return PageSize;
    }

    /**
     *
     * @param PageSize
     * The PageSize
     */
    public void setPageSize(Integer PageSize) {
        this.PageSize = PageSize;
    }

    /**
     *
     * @return
     * The TotalPages
     */
    public Integer getTotalPages() {
        return TotalPages;
    }

    /**
     *
     * @param TotalPages
     * The TotalPages
     */
    public void setTotalPages(Integer TotalPages) {
        this.TotalPages = TotalPages;
    }

    /**
     *
     * @return
     * The Returned
     */
    public Integer getReturned() {
        return Returned;
    }

    /**
     *
     * @param Returned
     * The Returned
     */
    public void setReturned(Integer Returned) {
        this.Returned = Returned;
    }

    /**
     *
     * @return
     * The NextPage
     */
    public String getNextPage() {
        return NextPage;
    }

    /**
     *
     * @param NextPage
     * The NextPage
     */
    public void setNextPage(String NextPage) {
        this.NextPage = NextPage;
    }

}