package sg.edu.rp.c346.id22014726.polydetails;

public class Study {
    private String type;
    private String enrolment;
    private String year;

    public Study(String type, String enrolment, String year) {
        this.type = type;
        this.enrolment = enrolment;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(String enrolment) {
        this.enrolment = enrolment;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Study{" +
                "type='" + type + '\'' +
                ", enrolment=" + enrolment +
                ", year=" + year +
                '}';
    }
}
