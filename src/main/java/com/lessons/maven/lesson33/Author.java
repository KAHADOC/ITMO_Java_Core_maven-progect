package com.lessons.maven.lesson33;

import java.time.LocalDate;

public class Author {
    private final String uniqueName;
    private final LocalDate registeredAt;
    private boolean isActive;

    public Author(String uniqueName, LocalDate registeredAt, boolean isActive) {
        this.uniqueName = uniqueName;
        this.registeredAt = registeredAt;
        this.isActive = isActive;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public LocalDate getRegisteredAt() {
        return registeredAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
