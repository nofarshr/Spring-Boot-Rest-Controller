package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;


@RestController
public class springBootRestController {
	
	
	static LinkedList<Item> items = new LinkedList<Item>();
	
	@RequestMapping("/getAllItems")
	public LinkedList<Item> GetAllItems() {
		
		
		return items;
	}
	
	@RequestMapping("/addItem")
	public void AddItem(@RequestParam(name="itemNo", required=true)int itemNo, 
						@RequestParam(name="itemName", required=true)String itemName,
						@RequestParam(name="itemQuantity", required=true, defaultValue = "0") int itemQuantity,
						@RequestParam(name="stockCode", required=true,defaultValue = "0")int stockCode) {
		
		Item itemFirst = new Item(itemNo,itemName,itemQuantity,stockCode);
		
		springBootRestController.items.add(itemFirst);
	}
	
	@RequestMapping("/deleteItem")
	public void DeleteItem(@RequestParam(name="itemNo", required=true)int itemNo) {
		
		Item temp = null;
		for (Item x :springBootRestController.items) 
		{
			if (x.getItemNo() == itemNo)
			{
				temp = x;
			}
		}
		if (temp!=null) 
			springBootRestController.items.remove(temp);
	}
	
	@RequestMapping("/updateAddItem")
	public void UpdateAddItem(@RequestParam(name="itemNo", required=true)int itemNo, @RequestParam(name="itemQuantity", required=true, defaultValue = "0") int itemQuantity) {
		
		for (Item x :springBootRestController.items) 
		{
			if (x.getItemNo() == itemNo)
			{
				x.setItemQuantity(x.getItemQuantity()+itemQuantity);
			}
		}
	}
	
	@RequestMapping("/updateRemoveItem")
	public void UpdateRemoveItem(@RequestParam(name="itemNo", required=true)int itemNo, @RequestParam(name="itemQuantity", required=true, defaultValue = "0") int itemQuantity) {
		
		for (Item x :springBootRestController.items)
		{
			if (x.getItemNo() == itemNo)
			{
				x.setItemQuantity(x.getItemQuantity()-itemQuantity);
			}
		}
	}
	
	@RequestMapping("/searchItem")
	public Item searchItem(@RequestParam(name="itemNo", required=true)int itemNo) {
		
		for (Item x :springBootRestController.items) 
		{
			if (x.getItemNo() == itemNo) {
			
				return x;
			}
		}
		System.out.println("There's no item with that itemNo");
		return null;
	}
	
}





