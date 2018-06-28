package pl.dezet.library.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Book details")
public class BookDetails {
    @Column(name = "id")
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate loanTime;
    private LocalDate returnBookTime;

    public LocalDate getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(LocalDate loanTime) {
        this.loanTime = loanTime;
    }

    public LocalDate getReturnBookTime() {
        return returnBookTime;
    }

    public void setReturnBookTime(LocalDate returnBookTime) {
        this.returnBookTime = returnBookTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}


