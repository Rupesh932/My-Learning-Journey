package core.CoreBasic.staticandfinal;

import core.CoreBasic.staticandfinal.Student.ClusterType;

public class StaticKeywordInjava {
    // 1.static method can only call other static method.
    // 2.static method can only access static variable.
    // 3.static method doesnot access of this keyword.

    static {
        System.out.println("This is static block and should print at very first line");
    }

    public static void main(String[] args) {
        Student hari = new Student("Hari", 110, Student.ClusterType.NORMAL, 71, 65.43, 5);
        Student.markAttendence(110);
        System.out.println(hari.toString());

        Student pukar = new Student("Pukar", 111, Student.ClusterType.INNOVATION, 55, 67.6, 4);
        Student.markAttendence(111);
        System.out.println(pukar.toString());

        Student dhana = new Student("Dhanaraj", 112, ClusterType.REFERENCE, 61, 73.2, 3);
        Student.markAttendence(112);
        System.out.println(dhana.toString());

        Student raju = new Student("Raju", 113, ClusterType.UNDERPRIVILEGED, 72, 71.32, 4);
        Student.markAttendence(113);
        System.out.println(raju.toString());

        Student mohan = new Student("Mohan", 114, ClusterType.SPORTS, 53, 66.7, 1);
        Student.markAttendence(114);
        System.out.println(mohan.toString());

        Student kanxi= new Student("Rabina", 115, ClusterType.UNDERPRIVILEGED, 90, 71.32, 4);
         Student.markAttendence(115);
        System.out.println(kanxi.toString());
    }
}

class Student {
    String name;
    int rollNo;
    static String collageName;
    static int count;
    Scholarship scholarship;
    int innovationRating;
    static {
        collageName = "KATHMANDU UNIVERSITY";
        count = 0;
        System.out
                .println("Static block of student is invoked and successfully initialize the collage name and counter");
    }

    enum ClusterType {
        NORMAL, UNDERPRIVILEGED, SPORTS, COLLEGE_TOPPER, CLASS_TOPPER, INNOVATION, REFERENCE, NOMINATED
    }

    Student(String name, int rollNo, ClusterType initialCluster, int attendence, double markPercentage,
            int innovationRating) {
        System.out.println("student " + name + " is constructing");
        this.name = name;
        this.rollNo = rollNo;
        this.scholarship = new Scholarship(initialCluster, attendence, markPercentage, false, innovationRating);
        count++;
        System.out.println(count + " student has been created ");
    }

    public static void markAttendence(int rollNo) {
        System.out.println("RollNo: " + rollNo + " has attendence entry successful");
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + ", CollageName:" + collageName + "]"
                + " Scholarship details: " + scholarship;
    }

    // nested static inner class
    static class Scholarship {
        boolean isScholared;
        ClusterType currentCluster;
        int attendence;
        double markPercentage;
        int innovationRating;
        double scholarAmount ;
       

        Scholarship(ClusterType currentCluster, int attendence, double markPercentage, boolean isScholared,
                int innovationRating) {
            this.currentCluster = currentCluster;
            this.attendence = attendence;
            this.markPercentage = markPercentage;
            this.isScholared = isScholared;
            this.innovationRating = innovationRating;
            this.scholarAmount = calculateScholarShip();

        }
          

        boolean isElligible() {
            if (isScholared) {
                return false;
            }
            return (currentCluster != ClusterType.NORMAL && attendence >= 60 && markPercentage >= 50);
        }

        double calculateScholarShip() {
            if (!isElligible()) {
                return 0.0;
            }
           double amount = switch (currentCluster) {
                case UNDERPRIVILEGED -> {
                    if (markPercentage >= 70) {
                        yield 100000.0;
                    } else if (markPercentage >= 45) {
                        yield 75000.0;
                    } else {
                        yield 40000.0;
                    }
                }
                case COLLEGE_TOPPER -> 60000.0;
                case CLASS_TOPPER -> 40000.0;
                case SPORTS -> {
                    if (markPercentage >= 80) {
                        yield 60000.0;
                    } else if (markPercentage >= 60) {
                        yield 40000.0;
                    } else {
                        yield 0.0;
                    }
                }
                case INNOVATION -> {

                    if (innovationRating == 5) {
                        yield 100000.0;
                    } else if (innovationRating == 4) {
                        yield 80000.0;
                    } else if (innovationRating == 3) {
                        yield 60000.0;
                    } else {
                        yield 40000.0;
                    }
                }
                case REFERENCE, NOMINATED -> {
                    if (markPercentage >= 50) {
                        yield 25000.0;
                    } else {
                        yield 0.0;
                    }
                }

                default -> 0.0;

            };
            if (amount > 0.0) {
                isScholared = true;
            }
            return amount;

        }


        @Override
        public String toString() {
            return "Scholarship [isScholared=" + isScholared + ", currentCluster=" + currentCluster + ", attendence="
                    + attendence + ", markPercentage=" + markPercentage + ", innovationRating=" + innovationRating
                    + ", scholarAmount=" + scholarAmount + "]";
        }

      

      

    }
}
