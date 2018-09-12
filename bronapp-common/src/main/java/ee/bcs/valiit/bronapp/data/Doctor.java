package ee.bcs.valiit.bronapp.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "doctor")
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doctor extends BaseEntity {

    @Column(name = "name")
    private String doctorname;

    @Column(name = "appointment")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", timezone = "Europe/Tallinn")
    private Date date;

    @Column(name = "patient")
    private String customername;

    @Column(name = "patient_phone")
    private String phone;

    @Column(name = "comment")
    private String comment;



//    @OneToMany(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SELECT)
//    @JoinColumn(name = "customer_id")
//    @OrderBy("account_number asc")
//    private List<Account> accounts;

}

