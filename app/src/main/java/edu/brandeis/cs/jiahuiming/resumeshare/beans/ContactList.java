package edu.brandeis.cs.jiahuiming.resumeshare.beans;

/**
 * Created by Horace on 16/11/8.
 */
public class ContactList {

    private int imageId;
    private String name;
    private String account;
    private String resume;
    private String linkedin;
    public ContactList(int imageId,String name,String account,String resume,String linkedin){
        this.imageId=imageId;
        this.name=name;
        this.account=account;
        this.resume=resume;
        this.linkedin=linkedin;


    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}
