import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private List<Item> items = null;
    private static String LEGENDARY = "Sulfuras, Hand of Ragnaros";
    private static String BRIE ="Aged Brie";
    private static String TICKETS ="Backstage passes to a TAFKAL80ETC concert";
    private static int TOPQUALITY = 50;
    private static int MINQUALITY = 0;

	public void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
}

    public GildedRose (Item item){
	    items = new ArrayList<>();
	    items.add(item);
    }

    private void decreaseDay(Item item){
	    int actualDays = item.getSellIn();
	    actualDays--;
	    item.setSellIn(actualDays);
	}

    private void decreaseQuality(Item item){
	    int quality = item.getQuality();
	    quality--;
        item.setQuality(quality);
    }
    private void increaseQuality(Item item){
        if (item.getQuality() < TOPQUALITY) {
            int quality = item.getQuality();
            quality++;
            item.setQuality(quality);
        }
    }


    private boolean isBrie (Item item){
	    return BRIE.equals(item.name);
    }
    private boolean isBackstagePass (Item item){
	    return TICKETS.equals(item.name);
    }
    private boolean isLegendary (Item item){
        return LEGENDARY.contentEquals(item.name);
    }


    private void processDay(Item item){
        if(!isLegendary(item))
        {
            decreaseDay(item);
        }
    }

    private void process_BaskstagePass_Quality(Item item){

	    if (item.getSellIn() < 11)
        {
                increaseQuality(item);
        }

        if (item.getSellIn() < 6)
        {
                increaseQuality(item);
        }

    }
    private void processItemQuality(Item item){
        if (item.getQuality() > MINQUALITY)
        {
            if(!isLegendary(item))
            {
                decreaseQuality(item);
            }
        }

    }
    private void checkSellIn(Item item){
	    if (item.getSellIn() < 0)
	    {
            processItemQuality(item);

            if(isBackstagePass(item))
            {
                item.setQuality(MINQUALITY);
            }

            if(isBrie(item))
            {
                increaseQuality(item);
            }
        }
    }


    public void updateQuality()
    {

        for (int i = 0; i < items.size(); i++){



            if(!isBrie(items.get(i)) && !isBackstagePass(items.get(i)))
            {
                processItemQuality(items.get(i));
            }
            else
            {
                increaseQuality(items.get(i));

                if(isBackstagePass(items.get(i)))
                {
                    process_BaskstagePass_Quality(items.get(i));
               }
            }

            processDay(items.get(i));

            checkSellIn(items.get(i));

        }
    }

}