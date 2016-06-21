package com.dpince.soulhunterscompanion.model;

import java.util.List;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public class User {

    List<Profile> profiles;

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}
