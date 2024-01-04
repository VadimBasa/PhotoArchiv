package archive.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//strategy = GenerationType.IDENTITY
    private Long id;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "chapter")
    private String chapter;
    @Column(name = "month_year")
    private Integer month;
    @Column(name = "year_of")
    private Integer year;
    @Column(name = "comment")
    private String comment;
    @Column(name = "dataLoad")
    private Date dateLoad;

    public User() {
    }

    public User(Long id, String lastName, String firstName, String secondName, String fileName, String chapter, Integer month, Integer year, String comment, Date dateLoad) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.fileName = fileName;
        this.chapter = chapter;
        this.month = month;
        this.year = year;
        this.comment = comment;
        this.dateLoad = dateLoad;

    }

    public User(String lastName, String firstName, String secondName, String fileName, String chapter, Integer month, Integer year, String comment, Date dateLoad) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.fileName = fileName;
        this.chapter = chapter;
        this.month = month;
        this.year = year;
        this.comment = comment;
        this.dateLoad = dateLoad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = this.firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = this.secondName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = this.fileName;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = this.chapter;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = this.month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = this.comment;
    }

    public Date dateLoad() {
        return dateLoad;
    }

    public void setDateLoad(Date dateLoad) {
        this.dateLoad = this.dateLoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(lastName, user.lastName) && Objects.equals(firstName, user.firstName)&& Objects.equals(secondName, user.secondName) && Objects.equals(fileName, user.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName,  secondName, fileName);
    }

}
