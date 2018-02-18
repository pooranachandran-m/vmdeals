package com.vm.retail.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vm.retail.vo.Deal;

@RestController
@ComponentScan
public class DealsController {

	private static List<Deal> deals = new ArrayList<>();

	static {
		deals.add(new Deal("UID20180218_0001", "Dell XPS 15", "Offer price is 1200$ was 1500$, save 300$"));
		deals.add(new Deal("UID20180218_0002", "Dell XPS 13", "Offer price is 1100$ was 1400$, save 300$"));
		deals.add(new Deal("UID20180218_0003", "iPhone X", "Offer price is 899$ was 999$, save 100$"));
		deals.add(new Deal("UID20180218_0004", "iPhone 8", "Offer price is 799$ was 899$, save 100$"));
	}

	@GetMapping("/list")
	public List<Deal> list() {
		System.out.println("getting reqeust");
		return deals;
	}

	@PostMapping("/add")
	public Deal add(@RequestBody Deal deal) {
		deals.add(deal);
		return deal;
	}

	@PutMapping("/update/{dealId}")
	public Deal update(@PathVariable(value = "dealId") String dealId, @RequestBody Deal dealInfo) {
		Deal update = deals.stream().filter(deal -> deal.getDealId().equalsIgnoreCase(dealId)).findFirst().get();
		if (null != update) {
			update.setDealName(dealInfo.getDealName());
			update.setDealDescription(dealInfo.getDealDescription());
		}
		System.out.println("Deal  update for " + dealId);
		return update;
	}

	@DeleteMapping("/delete/{dealId}")
	public Deal delete(@PathVariable(value = "dealId") String dealId) {
		Boolean dealRemoved = deals.removeIf(deal -> deal.getDealId().equalsIgnoreCase(dealId));
		System.out.println("Deal removed for " + dealId + " is " + dealRemoved);
		return null;
	}

}
