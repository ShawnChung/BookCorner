package com.csair.pls.budget.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.csair.pls.budget.domain.BudgetYear;
import com.csair.pls.budget.infra.exception.BudgetYearOutOfBoundaryException;


public class BudgetYearTest {
	@Test
	public void testCreate() {
		BudgetYear year = BudgetYear.create(2015);
		assertEquals(2015, year.getYear());
	}
	
	@Test
	public void testMinYear() {
		try {
			BudgetYear year1899 = BudgetYear.create(1899);
			fail("此处应该抛出异常");
		} catch (BudgetYearOutOfBoundaryException e) {
			assertTrue(true);
		}
		
		BudgetYear year1900 = BudgetYear.create(1900);
		assertEquals(BudgetYear.MIN_YEAR, year1900.getYear());
	}
	
	@Test
	public void testMaxYear() {
		try {
			BudgetYear year2100 = BudgetYear.create(2100);
			fail("此处应该抛出异常");
		} catch (BudgetYearOutOfBoundaryException e) {
			assertTrue(true);
		}
		BudgetYear year2099 = BudgetYear.create(2099);
		assertEquals(BudgetYear.MAX_YEAR, year2099.getYear());
	}

	@Test
	public void testEquals() {
		BudgetYear year = BudgetYear.create(1900);
		BudgetYear sameYear = BudgetYear.create(1900);
		assertEquals(year, sameYear);
	}

	@Test
	public void testToString() {
		BudgetYear year = BudgetYear.create(2015);
		assertEquals("2015", year.toString());
	}
}
