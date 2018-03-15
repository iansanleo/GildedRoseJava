import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseTest {


	/*

    //descript All items have a SellIn value which denotes the number of days we have to sell the item
    //descript All items have a Quality value which denotes how valuable the item is
    At the end of each day our system lowers both values for every item

	 */
	@Test
	public void EndDay_SellIn_Quality_Decrease(){
		//arrange
		int sellIn = 1;
		int quality = 1;
		Item testItem = new Item(" name", sellIn, quality);

		//act
		GildedRose gR = new GildedRose(testItem);
		gR.updateQuality();

		//assert
		assertEquals(testItem.quality,quality-1);
		assertEquals(testItem.sellIn, sellIn-1);

	}


//Once the sell by date has passed, Quality degrades twice as fast
	@Test
	public void QualityDegradesTwice_WhenDatePassed() {
		//arrange
		int sellIn = 0;
		int quality = 4;
		Item testItem = new Item(" name", sellIn, quality);

		//act
		GildedRose gR = new GildedRose(testItem);
		gR.updateQuality();

		//assert
		assertEquals(testItem.quality,quality-2);
		assertEquals(testItem.sellIn, sellIn-1);
	}
	//The Quality of an item is never negative
	@Test
	public void QualityNoNegative() {
		//arrange
		int qualityCero = 0;
		Item testItem = new Item(" name", 1, qualityCero);

		//act
		GildedRose gR = new GildedRose(testItem);
		gR.updateQuality();

		//assert
		//assertEquals(testItem.quality,qualityCero);
		assertFalse(testItem.quality<qualityCero);

	}
	//"Aged Brie" actually increases in Quality the older it gets
	@Test
	public void AgedBrie_increasesQuality(){
		//arrange
		String name ="Aged Brie";
		int iniQuality = 1;
		Item testItem = new Item(name, 3,iniQuality);

		//act
		GildedRose gR = new GildedRose(testItem);
		gR.updateQuality();

		//assert
		assertTrue(testItem.quality > iniQuality);
	}
	//The Quality of an item is never more than 50
	@Test
	public void QualityUnder_L (){
		//arrange
		int topQuality = 50;
		Item testItem = new Item("",2,49);

		//act
		GildedRose gR = new GildedRose(testItem);
		gR.updateQuality();

		//assert
		assertTrue(testItem.quality < topQuality);
	}
	//"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	@Test
	public void Sulfuras_NoSold_NoDecreaseQuality(){
		//arrange
		String name = "Sulfuras, Hand of Ragnaros";
		int iniQuality = 3;
		Item testItem = new Item(name,2,iniQuality);

		//act
		GildedRose gR = new GildedRose(testItem);
		gR.updateQuality();

		//assert
		assertTrue(testItem.quality >= iniQuality);

	}
	//    "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches;
	// Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	// Quality drops to 0 after the concert


}
