package prjS4.ProjectSem4.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Accounts")
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByAccId", query = "SELECT a FROM Accounts a WHERE a.accId = :accId"),
    @NamedQuery(name = "Accounts.findByUserName", query = "SELECT a FROM Accounts a WHERE a.userName = :userName"),
    @NamedQuery(name = "Accounts.findByUserAvatar", query = "SELECT a FROM Accounts a WHERE a.userAvatar = :userAvatar"),
    @NamedQuery(name = "Accounts.findByUserGender", query = "SELECT a FROM Accounts a WHERE a.userGender = :userGender"),
    @NamedQuery(name = "Accounts.findByUserPhone", query = "SELECT a FROM Accounts a WHERE a.userPhone = :userPhone"),
    @NamedQuery(name = "Accounts.findByUserDob", query = "SELECT a FROM Accounts a WHERE a.userDob = :userDob"),
    @NamedQuery(name = "Accounts.findByUserEmail", query = "SELECT a FROM Accounts a WHERE a.userEmail = :userEmail"),
    @NamedQuery(name = "Accounts.findByUserPassword", query = "SELECT a FROM Accounts a WHERE a.userPassword = :userPassword"),
    @NamedQuery(name = "Accounts.findByUserStatus", query = "SELECT a FROM Accounts a WHERE a.userStatus = :userStatus")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "acc_id")
    private String accId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_avatar")
    private String userAvatar;
    @Column(name = "user_gender")
    private Integer userGender;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_dob")
    @Temporal(TemporalType.DATE)
    private Date userDob;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_status")
    private Integer userStatus;
    @OneToMany(mappedBy = "accId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comments> commentsList;
    @OneToMany(mappedBy = "accId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Access> accessList;
    @OneToMany(mappedBy = "accId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Invoices> invoicesList;

    public Accounts() {
        this.accId = UUID.randomUUID().toString();
    }

    public Accounts(String accId) {
        this.accId = accId;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getUserDob() {
        return userDob;
    }

    public void setUserDob(Date userDob) {
        this.userDob = userDob;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public List<Access> getAccessList() {
        return accessList;
    }

    public void setAccessList(List<Access> accessList) {
        this.accessList = accessList;
    }

    public List<Invoices> getInvoicesList() {
        return invoicesList;
    }

    public void setInvoicesList(List<Invoices> invoicesList) {
        this.invoicesList = invoicesList;
    }
    
}
