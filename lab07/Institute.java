package lab07;

import java.util.ArrayList;
import java.util.List;

class Institute {
    private String name;
    private List<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}