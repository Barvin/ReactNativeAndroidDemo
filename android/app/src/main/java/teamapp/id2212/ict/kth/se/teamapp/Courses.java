package teamapp.id2212.ict.kth.se.teamapp;

import java.util.ArrayList;

/**
 * Created by arvin on 2017-05-27.
 */

public class Courses {

    private ArrayList<String> courses = new ArrayList<String>();

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourse(String courseName) {
        courses.add(courseName);
    }
}
