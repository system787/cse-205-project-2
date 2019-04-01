//**************************************************************************************************
// CLASS: OnCampusStudent (OnCampusStudent.java)
//
// DESCRIPTION
// OnCampusStudent is a child class of Student which contains additional variables that differ from the Student
// superclass. OnCampus also implements the calcTuition method that calculates the tuition costs specific
// to on campus students as well as variables to determine if the students are on campus residents
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring B 2019
// Project Number: 2
//
// AUTHOR: Vincent Hoang, vnhoang, vnhoang@asu.edu
//**************************************************************************************************
public class OnCampusStudent extends Student {

    protected static final int RESIDENT = 1;
    protected static final int NON_RESIDENT = 2;

    private int mResident;

    private double mProgramFee;

    /**
     * OnCampusStudent
     *
     * Constructor for OnCampusStudent objects
     *
     * @param pId the student's id stored as a String
     * @param pFname the student's first name stored as a String
     * @param pLname the student's last name stored as a String
     */
    public OnCampusStudent(String pId, String pFname, String pLname) {
        super(pId, pFname, pLname);
    }

    @Override
    protected void calcTuition() {
        double t;

        if (getResidency() == RESIDENT) {
            t = TuitionConstants.ONCAMP_RES_BASE;
        } else {
            t = TuitionConstants.ONCAMP_NONRES_BASE;
        }

        t += getmProgramFee();

        if (getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS) {
            t += ((getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS);
        }

        setTuition(t);
    }

    public double getmProgramFee() {
        return mProgramFee;
    }

    public int getResidency() {
        return mResident;
    }

    public void setProgramFee(double pProgramFee) {
        mProgramFee = pProgramFee;
    }

    public void setResidency(int pResidency) {
        mResident = pResidency;
    }

}
