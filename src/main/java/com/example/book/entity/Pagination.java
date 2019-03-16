package com.example.book.entity;

import java.util.List;

/**
 * 分页查询
 *
 * @param <E>
 */
public class Pagination<E> {

    private Integer currentPageIndex;  // The current page index（当前页面索引）
    private Integer pageCount; // The number of pages（页数）
    private static final Integer PAGESIZE = 2;
    private List<E> results;

    public Pagination() {
    }

    public Pagination(Integer currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public Integer getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(Integer currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPAGESIZE() {
        return PAGESIZE;
    }

    public List<E> getResults() {
        return results;
    }

    public void setResults(List<E> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "currentPageIndex=" + currentPageIndex +
                ", pageCount=" + pageCount +
                ", results=" + results +
                '}';
    }
}