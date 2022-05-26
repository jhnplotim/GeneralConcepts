package ImmutableClass.javacode;

public class Subject {
    String name;
    int startYear;
    String code;

    public Subject(String name, int startYear, String code) {
        this.code = code;
        this.startYear = startYear;
        this.name = name;
    }


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Override
    public String toString() {
        return String.format("Subject(name = %s, startYear = %s, code = %s)", name, startYear, code);
    }
}