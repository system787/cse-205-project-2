//**************************************************************************************************
// CLASS: OnlineStudent (OnlineStudent.java)
//
// DESCRIPTION
// OnlineStudent is a child class of Student which contains additional variables that differ from the Student
// superclass. OnlineStudent also implements the calcTuition method that calculates the tuition costs specific
// to online students.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring B 2019
// Project Number: 2
//
// AUTHOR: Vincent Hoang, vnhoang, vnhoang@asu.edu
//**************************************************************************************************
public class OnlineStudent extends Student {

    private boolean mTechFee;

    /**
     * OnlineStudent
     *
     * Constructor method for creating OnlineStudent objects
     * @param pId the student's ID stored as a String
     * @param pFname the student's first name stored as a String
     * @param pLname the student's last name stored as a String
     */
    public OnlineStudent(String pId, String pFname, String pLname) {
        super(pId, pFname, pLname);
    }

    /**
     * calcTuition
     *
     * Calculates the OnlineStudent's tuition based on current rates and applicable tech fees
     */
    @Override
    protected void calcTuition() {
        double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;

        if (getTechFee()) {
            t += TuitionConstants.ONLINE_TECH_FEE;
        }

        setTuition(t);
    }

    /**
     * getTechFee
     *
     * Accessor method for student's applicable tech fee status
     * @return true for applicable tech fees, false for not applicable
     */
    public boolean getTechFee() {
        return mTechFee;
    }

    /**
     * setTechFee
     *
     * Mutator for student's tech fee applicability
     * @param pTechFee true for applicable tech fees, false for not applicable
     */
    public void setTechFee(boolean pTechFee) {
        mTechFee = pTechFee;
    }
}
