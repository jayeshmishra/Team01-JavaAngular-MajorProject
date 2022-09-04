package com.cybage.food.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.food.dao.FoodItemRepository;
import com.cybage.food.dao.RestaurantRepository;
import com.cybage.food.dao.UserRepository;
import com.cybage.food.entity.FoodItem;
import com.cybage.food.entity.Restaurant;
import com.cybage.food.entity.User;

@Service
public class ExportService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FoodItemRepository foodItemRepository;

	@Autowired
	RestaurantRepository restaurantRepository;

	// static Logger logger=LogManager.getLogger(ExportService.class);

	public void printUser() {
		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("User Data");

		List<User> userData = userRepository.findAll();

		Map<Integer, User> data = new TreeMap<>();
		for (User user : userData) {
			data.put(user.getUserId(), user);
		}
		Set<Integer> keyset = data.keySet();

		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("USER ID");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("NAME");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("EMAIL");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("MOBILE NO");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("ATTEMPT COUNT");
		header.getCell(4).setCellStyle(style);

		int rownum = 1;
		for (Integer key : keyset) {
			header = sheet.createRow(rownum++);
			User user = data.get(key);
			CellStyle style1 = workbook.createCellStyle();
			Font font1 = workbook.createFont();
			font1.setFontName("Arial");
			style1.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
			style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font1.setColor(HSSFColor.WHITE.index);
			style1.setFont(font1);
			header.createCell(0).setCellValue(user.getUserId());
			header.getCell(0).setCellStyle(style1);
			header.createCell(1).setCellValue(user.getUserName());
			header.getCell(1).setCellStyle(style1);
			header.createCell(2).setCellValue(user.getUserEmail());
			header.getCell(2).setCellStyle(style1);
			header.createCell(3).setCellValue(user.getUserMobileNo());
			header.getCell(3).setCellStyle(style1);
			header.createCell(4).setCellValue(user.getAttemptCount());
			header.getCell(4).setCellStyle(style1);
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("User_Details.xls"));
			workbook.write(out);
			out.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printFoodItemData() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Food Item Data");
		List<FoodItem> foodItemList = foodItemRepository.findAll();
		Map<Integer, FoodItem> data = new TreeMap<>();
		for (FoodItem foodMenu : foodItemList) {
			data.put(foodMenu.getFoodId(), foodMenu);
		}

		Set<Integer> keyset = data.keySet();

		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("FOOD ID");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue(" NAME");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("CATEGORY");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("PRICE");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("OFFER");
		header.getCell(4).setCellStyle(style);

		int rownum = 1;
		for (Integer key : keyset) {
			header = sheet.createRow(rownum++);
			FoodItem foodMenu = data.get(key);
			CellStyle style1 = workbook.createCellStyle();
			Font font1 = workbook.createFont();
			font1.setFontName("Arial");
			style1.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
			style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font1.setColor(HSSFColor.WHITE.index);
			style1.setFont(font1);
			header.createCell(0).setCellValue(foodMenu.getFoodId());
			header.getCell(0).setCellStyle(style1);
			header.createCell(1).setCellValue(foodMenu.getFoodName());
			header.getCell(1).setCellStyle(style1);
			header.createCell(2).setCellValue(foodMenu.getFoodDescription());
			header.getCell(2).setCellStyle(style1);
			header.createCell(3).setCellValue(foodMenu.getPrice());
			header.getCell(3).setCellStyle(style1);
			header.createCell(4).setCellValue(foodMenu.getOffer());
			header.getCell(4).setCellStyle(style1);
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("Food_Item_Details.xls"));
			workbook.write(out);
			out.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printRestaurantData() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Restaurant Data");
		List<Restaurant> restaurantList = restaurantRepository.findAll();
		Map<Integer, Restaurant> data = new TreeMap<>();
		for (Restaurant restaurant : restaurantList) {
			data.put(restaurant.getRestaurantId(), restaurant);
		}

		Set<Integer> keyset = data.keySet();

		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("RESTAURANT ID");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("NAME");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("OWNER EMAIL");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("OWNER NAME");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("THUMBNAIL");
		header.getCell(4).setCellStyle(style);

		int rownum = 1;
		for (Integer key : keyset) {
			header = sheet.createRow(rownum++);
			Restaurant restaurant = data.get(key);

			CellStyle style1 = workbook.createCellStyle();
			Font font1 = workbook.createFont();
			font1.setFontName("Arial");
			style1.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
			style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font1.setColor(HSSFColor.WHITE.index);
			style1.setFont(font1);
			header.createCell(0).setCellValue(restaurant.getRestaurantId());
			header.getCell(0).setCellStyle(style1);
			header.createCell(1).setCellValue(restaurant.getRestaurantName());
			header.getCell(1).setCellStyle(style1);
			header.createCell(2).setCellValue(restaurant.getRestaurantEmail());
			header.getCell(2).setCellStyle(style1);
			header.createCell(3).setCellValue(restaurant.getRestaurantUserName());
			header.getCell(3).setCellStyle(style1);
			header.createCell(4).setCellValue(restaurant.getThumbnail());
			header.getCell(4).setCellStyle(style1);
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("Restaurant_Details.xls"));
			workbook.write(out);
			out.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
