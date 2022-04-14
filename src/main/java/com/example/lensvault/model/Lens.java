package com.example.lensvault.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Lens {
	// Lens framework accommodating attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// Lens attributes
	private String manufacturer;
	private String name;
	private Double focalLength;
	private Double largestAperture;
	private Double smallestAperture;
	// Category attribute, connects lens*-1Prime/Zoom
	@ManyToOne
	@JoinColumn(name = "primeOrZoomid")
	@JsonManagedReference
	private PrimeOrZoom primeOrZoom;
	// Category attribute, connects lens*-1Prime/Zoom
	@ManyToOne
	@JoinColumn(name = "mountid")
	@JsonManagedReference
	private Mount mount;
	private String countryOfOrigin;
	private int yearProduced;
	private int serialNumber;
	private String comment;

	public Lens() {
	}

	public Lens(String manufacturer, String name, Double focalLength, Double largestAperture, Double smallestAperture,
			PrimeOrZoom primeOrZoom, Mount mount, String countryOfOrigin, int yearProduced, int serialNumber, String comment) {
		super();
		this.manufacturer = manufacturer;
		this.name = name;
		this.focalLength = focalLength;
		this.largestAperture = largestAperture;
		this.smallestAperture = smallestAperture;
		this.primeOrZoom = primeOrZoom;
		this.mount = mount;
		this.countryOfOrigin = countryOfOrigin;
		this.yearProduced = yearProduced;
		this.serialNumber = serialNumber;
		this.comment = comment;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getFocalLength() {
		return focalLength;
	}

	public void setFocalLength(Double focalLength) {
		this.focalLength = focalLength;
	}

	public Double getLargestAperture() {
		return largestAperture;
	}

	public void setLargestAperture(Double largestAperture) {
		this.largestAperture = largestAperture;
	}

	public Double getSmallestAperture() {
		return smallestAperture;
	}

	public void setSmallestAperture(Double smallestAperture) {
		this.smallestAperture = smallestAperture;
	}

	public PrimeOrZoom getPrimeOrZoom() {
		return primeOrZoom;
	}

	public void setPrimeOrZoom(PrimeOrZoom primeOrZoom) {
		this.primeOrZoom = primeOrZoom;
	}

	public Mount getMount() {
		return mount;
	}

	public void setMount(Mount mount) {
		this.mount = mount;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public int getYearProduced() {
		return yearProduced;
	}

	public void setYearProduced(int yearProduced) {
		this.yearProduced = yearProduced;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}