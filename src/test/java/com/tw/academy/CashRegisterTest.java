package com.tw.academy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class CashRegisterTest {
	@Test
	void should_call_print_when_process_given_purchase() {
		//given
		Printer printer = mock(Printer.class);
		CashRegister cashRegister = new CashRegister(printer);
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		verify(printer, times(1)).print(anyString());
	}
	@Test
	void should_print_purchase_as_string_when_process_given_purchase() {
		//given
		Printer printer = mock(Printer.class);
		CashRegister cashRegister = new CashRegister(printer);
		Purchase purchase = mock(Purchase.class);
		when(purchase.asString()).thenReturn("hello world");
		//when
		cashRegister.process(purchase);
		//then
		verify(printer, times(1)).print("hello world");
	}
	@Test
	void should_call_print_when_process_given_purchase1() {
		//given
		SpyPrinter printer = new SpyPrinter();
		CashRegister cashRegister = new CashRegister(printer);
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		assertEquals(1, printer.count);
	}

	@Test
	void should_print_purchase_as_string_when_process_given_purchase1() {
		//given
		SpyPrinter printer = new SpyPrinter();
		CashRegister cashRegister = new CashRegister(printer);
		StubPurchase purchase = new StubPurchase();
		purchase.content = "hello world";
		//when
		cashRegister.process(purchase);
		//then
		assertEquals("hello world", printer.content);
	}

	private class SpyPrinter extends Printer {
		String content;
		int count;
		{
			count = 0;
		}
		@Override
		public void print(String content) {
			count++;
			this.content = content;
		}
	}

	private class StubPurchase extends Purchase {
		String content;

		@Override
		public String asString() {
			return content;
		}
	}

}