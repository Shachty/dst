package dst.ass2.ejb.model.impl;

import dst.ass2.ejb.model.IPrice;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Price implements IPrice {

    @Id
    @GeneratedValue
    private Long id;

    private int nrOfHistoricalLectures;
    private BigDecimal price;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Integer getNrOfHistoricalLectures() {
        return this.nrOfHistoricalLectures;
    }

    @Override
    public void setNrOfHistoricalLectures(Integer nrOfHistoricalLectures) {
        this.nrOfHistoricalLectures = nrOfHistoricalLectures;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }


    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
