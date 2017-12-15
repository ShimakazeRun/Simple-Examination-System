package web.po;

public class CourseCustom extends Course{

    //所属院系名
    private String collegeName;

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeName() {
        return collegeName;
    }
}
