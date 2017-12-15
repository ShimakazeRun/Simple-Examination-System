package web.po;

import java.util.List;

public class StudentCustom extends Student{

    private String collegeName;

    private List<SelectedCourseCustom> selectedCourseList;

    private int selectedCourseAmount;

    private int overCourseAmount;

    public int getSelectedCourseAmount() {
        return selectedCourseAmount;
    }

    public void setSelectedCourseAmount(int selectedCourseAmount) {
        this.selectedCourseAmount = selectedCourseAmount;
    }

    public int getOverCourseAmount() {
        return overCourseAmount;
    }

    public void setOverCourseAmount(int overCourseAmount) {
        this.overCourseAmount = overCourseAmount;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public List<SelectedCourseCustom> getSelectedCourseList() {
        return selectedCourseList;
    }

    public void setSelectedCourseList(List<SelectedCourseCustom> selectedCourseList) {
        this.selectedCourseList = selectedCourseList;
    }
}
