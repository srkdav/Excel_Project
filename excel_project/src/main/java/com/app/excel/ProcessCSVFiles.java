package com.app.excel;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.app.pojo.Order;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class ProcessCSVFiles {
	public static void main(String[] args) throws IOException {
		String path1 = "D:\\Orders\\order_details_1.csv"; // Path of 1st Orders sheet
		String path2 = "D:\\Orders\\order_details_2.csv";// Path of 2ns Orders sheet
		List<Order> total_order_list = new ArrayList<Order>();
		List<Order> order_list1 = processOrderSheet(path1);
		List<Order> order_list2 = processOrderSheet(path2);
		total_order_list.addAll(order_list1);
		total_order_list.addAll(order_list2);//This contains the combined data of the 2 sheets.
		String payment_path = "D:\\Orders\\payment_sheet.csv"; // Address of the payment sheet that will be created.
		processPaymentSheet(payment_path, total_order_list);

	}

	//This method reads the CSV File using OpenCSV Library. 
	public static List<Order> processOrderSheet(String path) throws IOException {
		FileReader file_reader = new FileReader(path);
		CSVReader csv_reader = new CSVReader(file_reader);
		String[] next_values;

		List<Order> order_list = new ArrayList<Order>();
		while ((next_values = csv_reader.readNext()) != null) {
			String[] order_string = next_values; //Values are stored as String in csv
			Order order = new Order();
			order.setOrder_num(order_string[0]); //The string values are appropriately converted.
			order.setSale_amount(Integer.valueOf(order_string[1]));
			order.setCost_price(Integer.valueOf(order_string[2]));
			order.setTransferred_amt(Integer.valueOf(order_string[3]));
			order.setComm(Integer.valueOf(order_string[4]));
			order.setPay_gateway(Integer.valueOf(order_string[5]));
			order.setPic_pack(Integer.valueOf(order_string[6]));
			order_list.add(order); //Each Order is added to a list. 
		}
		return order_list;
	}


	//This method creates the final payment sheet using OpenCSV Library.
	public static void processPaymentSheet(String payment_sheet_path, List<Order> total_order_list) throws IOException {
		File payment_file = new File(payment_sheet_path); //Path of payment sheet.
		FileWriter final_payment_file = new FileWriter(payment_file);
		CSVWriter csv_writer = new CSVWriter(final_payment_file);
		List<String[]> output_data = new ArrayList<String[]>();
		output_data.add(
				new String[] { "Order Number", "Profit/loss(%)", "Transferred Amount", "Total Marketplace Charges" });
		for (Order order : total_order_list) {
			String[] payment = new String[4];
			int total_marketplace = order.getComm() + order.getPay_gateway() + order.getPic_pack();
			float profit_loss = (order.getSale_amount() - (order.getCost_price() + total_marketplace)) * 100
					/ (order.getCost_price() + total_marketplace); //formula for find Profit/Loss %
			payment[0] = order.getOrder_num(); //CSV can store only String values, values are converted accordingly. 
			payment[1] = String.valueOf(profit_loss);
			payment[2] = String.valueOf(order.getTransferred_amt());
			payment[3] = String.valueOf(total_marketplace);
			output_data.add(payment); //String array added to a List.
		}
		csv_writer.writeAll(output_data);//The list is passed as argument so it can be written into CSV file.
		csv_writer.close();
	}

}
