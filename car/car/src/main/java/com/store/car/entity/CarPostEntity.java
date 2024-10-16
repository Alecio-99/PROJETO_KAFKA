package com.store.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "car_post")
public class CarPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "car_model")
    private String model;
    @Column(name = "car_brand")
    private String brand;
    @Column(name = "car_price")
    private Double price;
    @Column(name = "car_city")
    private String city;
    @Column(name = "car_description")
    private String  description;
    @Column(name = "car_engineVersion")
    private  String engineVersion;
    @Column(name = "car_createdDate")
    private String  createdDate;
    @Column(name = "car_ownerId")
    private String ownerId;
    @Column(name = "car_ownerName")
    private  String ownerName;
    @Column(name = "car_ownerType")
    private String ownerType;
    @Column(name = "car_contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPostEntity ownerPost;

    public OwnerPostEntity getOwnerPost() {
        return ownerPost;
    }

    public void setOwnerPost(OwnerPostEntity ownerPost) {
        this.ownerPost = ownerPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPostEntity that = (CarPostEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
