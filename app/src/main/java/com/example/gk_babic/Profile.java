package com.example.gk_babic;

public class Profile {

    private String username;

    // Image name (Without extension)
    private String profilePic;
    private String adress;

    public Profile(String username, String profilePic, String adress) {
        this.username= username;
        this.profilePic= profilePic;
        this.adress= adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String fullName) {
        this.adress = adress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    @Override
    public String toString()  {
        return this.username+ this.adress;
    }
}