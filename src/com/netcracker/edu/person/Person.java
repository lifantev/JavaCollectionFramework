package com.netcracker.edu.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * <br>Person class can be used for storing the date of birth.<br/>
 * Provides method getBirthday() for representation of the date of birth
 * based on the date format entered in the method, e.g. {@link #SHORT_FORMAT_DATE} [dd/MM/yyyy]
 * or {@link #LONG_FORMAT_DATE} [dd MMMM yyyy].
 *
 * @author Danil Lifantev.
 */
public class Person {
    private Date birthday;
    public static final String SHORT_FORMAT_DATE = "dd/MM/yyyy";
    public static final String LONG_FORMAT_DATE = "dd MMMM yyyy";

    /**
     * Default constructor.
     */
    public Person() {
    }

    /**
     * Constructor specifying Person's birthday.
     * @param birthday must match to defined formats.
     * @throws IllegalArgumentException if birthday doesn't match.
     */
    public Person(String birthday) throws IllegalArgumentException{
        setBirthday(birthday);
    }

    /**
     * Gets birthday.
     * @return birthday as Date.
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Gets birthday as String.
     * @param format must be one of defined.
     * @return String representation of birthday in certain format.
     * @throws IllegalStateException if birthday wasn't set.
     * @throws IllegalArgumentException if format doesn't match to defined ones.
     */
    public String getBirthday(String format) throws IllegalStateException, IllegalArgumentException {
        if (birthday == null) throw new IllegalStateException("Birthday wasn't set yet.");

        LocalDate localDate = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        String monthStr = new SimpleDateFormat("MMMM").format(birthday);
        int day = localDate.getDayOfMonth();

        switch (format) {
            case SHORT_FORMAT_DATE:
                return day + "/" + month + "/" + year;
            case LONG_FORMAT_DATE:
                return day + " " + monthStr + " " + year;
            default:
                throw new IllegalArgumentException("Wrong date format. Must be <dd/MM/yyyy>" +
                        " or <dd MMMM yyyy>");
        }
    }

    /**
     * Sets birthday.
     * @param birthday
     * @throws IllegalArgumentException if birthday doesn't match to any format.
     */
    public void setBirthday(String birthday) throws IllegalArgumentException {
        try {
            this.birthday = new SimpleDateFormat(SHORT_FORMAT_DATE).parse(birthday);
        } catch (ParseException e) {
            try {
                this.birthday = new SimpleDateFormat(LONG_FORMAT_DATE).parse(birthday);
            } catch (ParseException pe) {
                throw new IllegalArgumentException("Wrong date format. Must match <dd/MM/yyyy>" +
                        " or <dd MMMM yyyy>.");
            }
        }
    }

    /**
     * Overrides toString() method for Person objects.
     * @return
     */
    @Override
    public String toString() {
        return "Person{" +
                "birthday=" + birthday.toString() +
                '}';
    }


    public static void main(String[] args) {
        Person[] persons = {new Person(),
                new Person("20/03/2001")};

        persons[0].setBirthday("20 March 2001");

        for (Person p : persons) {
            System.out.println(p.toString());
            System.out.println(p.getBirthday(Person.SHORT_FORMAT_DATE));
            System.out.println(p.getBirthday(Person.LONG_FORMAT_DATE));
        }
    }
}
