package com.tw.academy;

import org.junit.jupiter.api.Test;

class CashRegisterTest {
	@Test
	void should_process_execute_printing() {
		//given
		CashRegister cashRegister = new CashRegister(new Printer());
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		//verify that cashRegister.process will trigger print
	}
}
