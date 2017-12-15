package web.po;

public class SelectedCourseCustom extends Selectedcourse {

    private StudentCustom studentCustom;

    private CourseCustom courseCustom;

    //是否完成该课程
    private Boolean over = false;

    public StudentCustom getStudentCustom() {
        return studentCustom;
    }

    public void setStudentCustom(StudentCustom studentCustom) {
        this.studentCustom = studentCustom;
    }

    public CourseCustom getCourseCustom() {
        return courseCustom;
    }

    public void setCourseCustom(CourseCustom courseCustom) {
        this.courseCustom = courseCustom;
    }

    public Boolean getOver() {
        return over;
    }

    public void setOver(Boolean over) {
        this.over = over;
    }
}
