import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private List<Item> items = null;
    private String legendary = "Sulfuras, Hand of Ragnaros";
    private int topQuality = 50;
    private int minQuality = 0;

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

    private boolean decreaseDay(Item item){
	    int actualDays = item.getSellIn();
	    actualDays--;
	    item.setSellIn(actualDays);
	    return true;
    }

    private void decreaseQuality(Item item){
	    int quality = item.getQuality();
	    quality--;
        item.setQuality(quality);
    }
    private void increaseQuality(Item item){
        if (item.getQuality() < topQuality) {
            int quality = item.getQuality();
            quality++;
            item.setQuality(quality);
        }
    }
    private boolean isBrie (Item item){
	    if(item.name.equals("Aged Brie")){
	        return true;
        }
	    return false;
    }
    private boolean isBackstagePass (Item item){
	    if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
	        return true;
        }
        return false;
    }
    private boolean isLegendary (Item item){
        return legendary.contentEquals(item.name);
    }

    private void processDay(Item item){
        if(!isLegendary(item))
        {
            decreaseDay(item);
        }
    }

    public void updateQuality()
    {

        for (int i = 0; i < items.size(); i++){



            if(!isBrie(items.get(i))&&! isBackstagePass(items.get(i)))
            {
                if (items.get(i).getQuality() > minQuality)
                {
                    if(!isLegendary(items.get(i)))
                    {
                        decreaseQuality(items.get(i));
                    }
                }
            }
            else
            {
                increaseQuality(items.get(i));
                
                {

                    if(isBackstagePass(items.get(i)))
                    {

                        if (items.get(i).getSellIn() < 11)
                        {
                            if (items.get(i).getQuality() < topQuality)
                            {
                                increaseQuality(items.get(i));
                            }
                        }

                        if (items.get(i).getSellIn() < 6)
                        {

                        }
                    }
                }
            }

            processDay(items.get(i));

            //if(!isLegendary(items.get(i)))
            //{
            //    decreaseDay(items.get(i));
           // }



            if (items.get(i).getSellIn() < 0)
            {
                if (!isBrie(items.get(i)))
                {
                    if(!isBackstagePass(items.get(i)))
                    {
                        if (items.get(i).getQuality() > minQuality)
                        {
                            if(!isLegendary(items.get(i)))
                            {
                                decreaseQuality(items.get(i));
                            }
                        }
                    }
                    else
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                }
                else
                {
                        increaseQuality(items.get(i));
                }
            }
        }
    }

}