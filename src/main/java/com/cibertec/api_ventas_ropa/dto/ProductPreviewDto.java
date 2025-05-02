package com.cibertec.api_ventas_ropa.dto;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPreviewDto {
	private int id;
	private String name;
	private String description;
	private String gender;
	private double price;
	private String categoryName;
	private List<String> images;
	private List<String> colors;
}
