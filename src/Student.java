//**************************************************************************************************
// CLASS: Student (Student.java)
//
// DESCRIPTION
// Student is an abstract class and is the superclass for the OnCampusStudent and OnlineStudent
// classes. Remember that in a class hierarchy, the superclass declares data and methods that are
// common to all types of students.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring B 2019
// Project Number: 2
//
// AUTHOR: Vincent Hoang, vnhoang, vnhoang@asu.edu
//**************************************************************************************************
public abstract class Student implements Comparable<Student> {

    // Declare private instance data
    private int mCredits;

    private String mFname;

    private String mId;

    private String mLname;

    private double mTuition;

    /**
     * Student(String, String, String)
     * <p>
     * Creates a Student object and initializes the mId, mFname, and mLname instance variables by
     * calling the mutator methods.
     */
    public Student(String pId, String pFname, String pLname) {
        mId = pId;
        mFname = pFname;
        mLname = pLname;
    }

    /**
     * abstract calcTuition()
     * <p>
     * calcTuition() is to be implemented by subclasses of Student. Remember that abstract methods
     * are not implemented in a superclass but must either be implemented in a subclass, or if not,
     * then the subclass also becomes an abstract class. The reason calcTuition() is abstract
     * and intended to be implemented by the subclasses of Student is because how we calculate the
     * tuition for an OnCampusStudent is different than how we calculate the tuition for an Online-
     * Student.
     */
    protected abstract void calcTuition();

    /**
     * The java.lang.Comparable<T> interface declares one method int compareTo(T obj) that must be
     * implemented by any class which implements the interface. This method is called from Sorter.
     * keepMoving() to compare the mId fields of two Students.
     * <p>
     * Compares the mId fields of 'this' Student and pStudent. Returns -1 if this Student's mId
     * field is less than pStudent's mId field. Returns 0 if this Student's mId field is equal to
     * pStudent's mId field. Returns 1 if this Student's mId field is greater than pStudent's mId
     * field.
     * <p>
     * Note that the mId field of a Student is a java.lang.String and String also implements the
     * Comparable<String> interface and consequently, also implements a compareTo() method to
     * compare two strings. Hence, all we have to do here is to call the String class compareTo()
     * method on the two mId strings of 'this' Student and pStudent and return whatever that method
     * returns.
     */
    @Override
    public int compareTo(Student pStudent) {
        return getId().compareTo(pStudent.getId());
    }

    /**
     * Accessor method for mCredits.
     */
   public int getCredits() {
       return mCredits;
   }

    /**
     * Accessor method for mFname.
     */
    public String getFirstName() {
        return mFname;
    }

    /**
     * Accessor method for mId.
     */
    public String getId() {
        return mId;
    }

    /**
     * Accessor method for mLname.
     */
    public String getLastName() {
        return mLname;
    }

    /**
     * Accessor method for mTuition.
     */
    public double getTuition() {
        return mTuition;
    }

    /**
     * Mutator method for mCredits.
     */
    public void setCredits(int pCredits) {
        mCredits = pCredits;
    }

    /**
     * Mutator method for mFname.
     */
    public void setFirstName(String pFname) {
        mFname = pFname;
    }

    /**
     * Mutator method for mId.
     */
    public void setId(String pId) {
        mId = pId;
    }

    /**
     * Mutator method for mLname.
     */
    public void setLastName(String pLname) {
        mLname = pLname;
    }

    /**
     * Mutator method for mTuition.
     */
    public void setTuition(double pTuition) {
        mTuition = pTuition;
    }

}
