package com.nagarro.training.advanceJavaAssignment4.controller;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

import com.nagarro.training.advanceJavaAssignment4.comparator.PriceComparator;
import com.nagarro.training.advanceJavaAssignment4.comparator.RatingComparator;
import com.nagarro.training.advanceJavaAssignment4.dao.TshirtDao;
import com.nagarro.training.advanceJavaAssignment4.model.Tshirt;
import com.nagarro.training.advanceJavaAssignment4.model.TshirtSearchIp;

public class TshirtSearchOp {

	public static List<Tshirt> getMatchingTshirts(TshirtSearchIp tshirtsSerachIp) throws FileNotFoundException {

		String output = tshirtsSerachIp.getOutputPreference();

		List<Tshirt> matchedTshirts = TshirtDao.getTshirtlist(tshirtsSerachIp);


		if (output.equalsIgnoreCase("Price")) {

			Collections.sort(matchedTshirts, new PriceComparator());

		} else if (output.equalsIgnoreCase("Rating")) {

			Collections.sort(matchedTshirts, new RatingComparator());

		} else {

			Collections.sort(matchedTshirts, new PriceComparator());
			Collections.sort(matchedTshirts, new RatingComparator());

		}

		return matchedTshirts;
	}

}
