package ImmutableClass.javacode;

// 1. Make class final to prevent subclasses from inheriting and modifying properties of the class
// 2. Make properties of the class final & private
// 3. Only provide getters to the outside world (NO SETTERS)
// 4. Deep copy
// 4.1. If the class takes an object of another class as an input, deepcopy (Do not shallow copy)
// 4.2. Do not return stored object but copy of it

// 1. Final class
public final class Test {
    // 2. final and private properties
    private final int passMark;
    private final int noOfStudents;
    private final Subject subject;

    public Test(int passMark, int noOfStudents, Subject subject) {
        this.noOfStudents = noOfStudents;
        this.passMark = passMark;

        // 4.1 Deep copy instead of saving same reference to avoid calling method from having a reference to it and possibly changing it
        this.subject = new Subject(subject.name, subject.startYear, subject.code);
    }

    // 3. Only getters
    public int getPassMark() {
        return passMark;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public Subject getSubject() {
        // 4.2. Do not return stored object reference but only a copy
        return new Subject(subject.name, subject.startYear, subject.code);
    }

    @Override
    public String toString() {
        return String.format("Test(subject = '%s', \n noOfStudents = %s, \n passMark = %s)", subject, noOfStudents, passMark);
    }


    public static void main(String... args) {

        Subject subject = new Subject("History", 2021, "HIS21");
        

        System.out.println("Subject before any modification");
        System.out.println(subject);

        int passMark = 50;

        int noOfStudents = 78;

        Test test = new Test(passMark, noOfStudents, subject);

        System.out.println("Test before any modification");
        System.out.println(test);

        // Modify
        passMark = 23;
        noOfStudents = 90;
        subject.code = "NW";
        subject.name = "RANDOM";
        // test.noOfStudents = noOfStudents; // (Uncomment to test that you can't change class properties)
        // test.subject = subject;
        //test.passMark = passMark; 

        System.out.println("\nSubject after modification");
        System.out.println(subject);

        System.out.println("Test after modification");
        System.out.println(test);


        subject = test.getSubject();
        subject.code = "NW";
        subject.name = "RANDOM";
        subject.startYear = 2000;

        System.out.println("\nSubject after modification 2");
        System.out.println(subject);

        System.out.println("Test after modification 2");
        System.out.println(test);

    }

}