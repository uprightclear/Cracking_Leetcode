class FoodRatings {
    HashMap<String, PriorityQueue<Food>> x = new HashMap<>(); // get pq from cuisine name
    HashMap<String, Food> menu = new HashMap<>(); // get Food (object) from food name

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++){
            Food curr = new Food(foods[i], cuisines[i], ratings[i]);
            x.putIfAbsent(cuisines[i], new PriorityQueue<>((a,b)->
                b.rating == a.rating ? a.name.compareTo(b.name) : b.rating - a.rating));
            PriorityQueue<Food> pq = x.get(cuisines[i]);
            pq.add(curr);
            menu.put(foods[i], curr);
        }
    }

    public void changeRating(String food, int newRating) {
        Food curr = menu.get(food);
        PriorityQueue<Food> pq = x.get(curr.cuisine);
        pq.remove(curr);
        curr.rating = newRating;
        pq.add(curr);
    }

    public String highestRated(String cuisine) {
        return x.get(cuisine).peek().name;
    }

    class Food{
        int rating;
        String name, cuisine;
        Food(String name, String cuisine, int rating){
            this.name = name; this.rating = rating; this.cuisine = cuisine;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */