package web.po;

public class PagingVO {

    //当前页码,默认第一页
    private int currentPageNo = 1;
    //总页数
    private int totalCount;
    //页面容量
    private int pageSize = 5;
    //上一页
    private int lastPageNo;
    //下一页
    private int nextPageNo;
    //要前往的页码,默认为0
    private int toPageNo = 0;

    private int showCourse;
    private int selectedCourse;
    private int overCourse;

    public int getShowCourse() {
        return showCourse;
    }

    public void setShowCourse(int showCourse) {
        this.showCourse = showCourse;
    }

    public int getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(int selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public int getOverCourse() {
        return overCourse;
    }

    public void setOverCourse(int overCourse) {
        this.overCourse = overCourse;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    //设置当前页码
    public void setCurrentPageNo(int currentPageNo) {
        if (currentPageNo != 1) {
            this.lastPageNo = currentPageNo - 1;
        }
        this.nextPageNo = currentPageNo + 1;

        this.currentPageNo = currentPageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    //设置总页数
    public void setTotalCount(int totalCount) {
        if (totalCount % pageSize > 0) {
            this.totalCount = (totalCount / pageSize) + 1;
        } else {
            this.totalCount = totalCount / pageSize;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getLastPageNo() {
        return lastPageNo;
    }

    public void setLastPageNo(int lastPageNo) {
        this.lastPageNo = lastPageNo;
    }

    public int getNextPageNo() {
        return nextPageNo;
    }

    public void setNextPageNo(int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }

    public int getToPageNo() {
        return toPageNo;
    }

    public void setToPageNo(int toPageNo) {
        //新一页
        this.toPageNo = (toPageNo - 1) * pageSize;
        //设置跳转后当前的页码
        setCurrentPageNo(toPageNo);
    }
}
