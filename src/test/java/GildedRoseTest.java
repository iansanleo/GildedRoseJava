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

	/*

    Once the sell by date has passed, Quality degrades twice as fast
    The Quality of an item is never negative
    "Aged Brie" actually increases in Quality the older it gets
    The Quality of an item is never more than 50
    "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert

	 */
}
