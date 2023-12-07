package com.section1.spring.datajpa.model;

import java.io.Serializable;
import java.util.Objects;

public class PurchasesPK implements Serializable {

    private Integer cid;
    private Integer pid;

    public PurchasesPK() {
    }

    // Implement equals() and hashCode() methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasesPK that = (PurchasesPK) o;
        return Objects.equals(cid, that.cid) && Objects.equals(pid, that.pid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, pid);
    }
}
