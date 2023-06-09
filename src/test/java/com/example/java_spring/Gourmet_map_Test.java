package com.example.java_spring;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.JAVA.Spring.JavaSpringApplication;
import com.example.JAVA.Spring.entity.Gourmet_map;
import com.example.JAVA.Spring.entity.Gourmet_map2;
import com.example.JAVA.Spring.repository.Gourmet_map_Dao;
import com.example.JAVA.Spring.repository.Gourmet_map_Dao2;
import com.example.JAVA.Spring.test.service.ifs.Gourmet_map_service;
import com.example.JAVA.Spring.vo.Gourmet_map_Response;

@SpringBootTest(classes = JavaSpringApplication.class)
public class Gourmet_map_Test {

	@Autowired
	private Gourmet_map_service gourmet_map_service;

	@Autowired
	private Gourmet_map_Dao gourmet_mapDao;

	@Autowired
	private Gourmet_map_Dao2 gourmet_mapDao2;

	@Test
	public void addStoreAndCityTest() {

		Gourmet_map gourmet_map = new Gourmet_map("êmác§", "Ys");

		gourmet_map_service.addStoreAndCity(gourmet_map.getStoreName(), gourmet_map.getCity());

		System.out.println("X¼ : " + gourmet_map.getStoreName() + " " + "és : " + gourmet_map.getCity());
	}

	@Test
	public void addItmeInfoTest() {
		Gourmet_map2 gourmet_map2 = new Gourmet_map2("êmác§", "¿Æ", 45 , 3.2);

		gourmet_map_service.addItmeInfo(gourmet_map2.getName(), gourmet_map2.getItem(), gourmet_map2.getPrice(),
				gourmet_map2.getItemreview());

		System.out.println("X¼ : " + gourmet_map2.getName() + "`êy : " + gourmet_map2.getItem() + " " + "Ji : "
				+ gourmet_map2.getPrice() + " " + "`êy]J : " + gourmet_map2.getItemreview());

	}

	@Test
	public void searchCityTest() {

		Gourmet_map gourmet_map = new Gourmet_map("äks");
		Gourmet_map_Response city = gourmet_map_service.searchCity(gourmet_map.getCity());
		for (var item : city.getgListR2()) {
			System.out.println("X¼ : " + item.getStoreName() + " " + "XÆ]J : " + item.getReview() + " " + "`êy : "
					+ item.getItem() + " " + "Ji : " + item.getPrice() + " " + "`êy]J : " + item.getItemreview());
		}

	}

	@Test
	public void searchReviewTest() {

		Gourmet_map gourmet_map = new Gourmet_map(4);
		Gourmet_map_Response Review = gourmet_map_service.searchReview(gourmet_map.getReview());

		for (var item : Review.getgListR3()) {

			System.out.println("Ýés" + item.getCity() + " " + "X¼ : " + item.getStoreName() + " " + "XÆ]J : "
					+ item.getReview() + " " + "`êy : " + item.getItem() + " " + "Ji : " + item.getPrice() + " " + "`êy]J : "
					+ item.getItemreview());
		}

	}

	

	@Test
	public void searchReviewAndItemreviewTest() {

		Gourmet_map gourmet_map = new Gourmet_map(3);
		Gourmet_map2 gourmet_map2 = new Gourmet_map2(4);

		Gourmet_map_Response reviewAndItemreview = gourmet_map_service
				.searchReviewAndItemreview(gourmet_map.getReview(), gourmet_map2.getItemreview());

		for (var item : reviewAndItemreview.getgListR3()) {

			System.out.println("Ýés" + item.getCity() + " " + "X¼ : " + item.getStoreName() + " " + "XÆ]J : "
					+ item.getReview() + " " + "`êy : " + item.getItem() + " " + "Ji : " + item.getPrice() + " " + "`êy]J : "
					+ item.getItemreview());

		}

	}

	@Test
	public void deleteStore() {
		Gourmet_map gourmet_map = new Gourmet_map("êmác§");

		Gourmet_map_Response deleteStore = gourmet_map_service.deleteStore(gourmet_map.getCity());

	}

}
