package com.kymnyth.recipeapp.bootstrap;

import com.kymnyth.recipeapp.domain.*;
import com.kymnyth.recipeapp.repositories.UnitOfMeasureRepository;
import com.kymnyth.recipeapp.services.CategoryService;
import com.kymnyth.recipeapp.services.RecipeService;
import com.kymnyth.recipeapp.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {
    RecipeService recipeService;
    CategoryService categoryService;
    UnitOfMeasureService unitOfMeasureService;

    public DataLoader(RecipeService recipeService, CategoryService categoryService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if(recipeService.getRecipes().isEmpty()){
            loadData();
        }
    }

    private void loadData(){

        //Recipes
        List<Recipe> recipes = new ArrayList<>(2);
        log.debug("Creating UOMs");
        // Unit of Measures
        UnitOfMeasure optionalEach = unitOfMeasureService.getUnitOfMeasureByDesc("Each");
        UnitOfMeasure optionalTablespoon = unitOfMeasureService.getUnitOfMeasureByDesc("Tablespoon");
        UnitOfMeasure optionalTeaspoon = unitOfMeasureService.getUnitOfMeasureByDesc("Teaspoon");
        UnitOfMeasure optionalDash = unitOfMeasureService.getUnitOfMeasureByDesc("Dash");
        UnitOfMeasure optionalCup = unitOfMeasureService.getUnitOfMeasureByDesc("Cup");
        UnitOfMeasure optionalPint = unitOfMeasureService.getUnitOfMeasureByDesc("Pint");
        log.debug("Creating Categories");
        //Categories
        Category optionalAmerican = categoryService.getCategoryByName("American");
        Category optionalMexican = categoryService.getCategoryByName("Mexican");

        log.debug("Creating Perfect Guac Recipe");
        // Perfect Guac
        Recipe perfectGuacamole = new Recipe();
        perfectGuacamole.getCategories().add(optionalAmerican);
        perfectGuacamole.getCategories().add(optionalMexican);
        perfectGuacamole.setCookTime(10);
        perfectGuacamole.setPrepTime(0);
        perfectGuacamole.setServings(4);
        perfectGuacamole.setSource("SimplyRecipes.com");
        perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        perfectGuacamole.setDescription("How to Make Perfect Guacamole");
        perfectGuacamole.setDifficulty(Difficulty.EASY);
        perfectGuacamole.setDirections("Cut the avocado, remove flesh:\n" +
                "1.Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl. 2.Mash with a fork:\n" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)  3.Add salt, lime juice, and the rest:\n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.  4. Serve:\n" +
                "Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
        perfectGuacamole.addIngredient(new Ingredient("ripe avocados", new BigDecimal("2"), optionalEach ));
        perfectGuacamole.addIngredient(new Ingredient("salt", new BigDecimal(.25), optionalTeaspoon ));
        perfectGuacamole.addIngredient(new Ingredient("fresh lime juice", new BigDecimal("1"), optionalTablespoon ));
        perfectGuacamole.addIngredient(new Ingredient("minced red onion", new BigDecimal("2"), optionalTablespoon ));
        perfectGuacamole.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal("2"), optionalEach ));
        perfectGuacamole.addIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal("2"), optionalTablespoon ));
        perfectGuacamole.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal("1"), optionalDash ));
        perfectGuacamole.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(.5), optionalEach ));
        perfectGuacamole.addIngredient(new Ingredient("Red radishes or jicama, to garnish", new BigDecimal("1"), optionalEach ));
        perfectGuacamole.addIngredient(new Ingredient("Tortilla chips, to serve", new BigDecimal("1"), optionalEach ));
        Notes guacNotes = new Notes("Guacamole! Did you know that over 2 billion pounds of avocados are consumed each year in the U.S.? (Google it.) That's over 7 pounds per person. I'm guessing that most of those avocados go into what has become America's favorite dip, guacamole.\n" +
                "\n" +
                "Where Does Guacamole Come From?\n" +
                "The word \"guacamole\", and the dip, are both originally from Mexico, where avocados have been cultivated for thousands of years. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).  Ingredients for Easy Guacamole\n" +
                "All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato .\n" +
                "\n" +
                "Guacamole Tip: Use Ripe Avocados\n" +
                "The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off.\n" +
                "\n" +
                "Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.  The Best Way to Cut an Avocado\n" +
                "To slice open an avocado, cut it in half lengthwise with a sharp chef's knife and twist apart the sides. One side will have the pit. To remove it, you can do one of two things:\n" +
                "\n" +
                "Method #1: Gently tap the pit with your chef's knife so the knife gets wedged into the pit. Twist your knife slightly to dislodge the pit and lift to remove. If you use this method, first protect your hand with a thick kitchen towel before proceeding.\n" +
                "Method #2: Cut the side with the pit in half again, exposing more of the pit. Use your fingers or a spoon to remove the pit\n" +
                "Once the pit is removed, just cut the avocado into chunks right inside the peel and use a spoon to scoop them out.\n" +
                "\n" +
                "Still curious? Read more about How to Cut and Peel an Avocado.  Guacamole Variations\n" +
                "Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). You can get creative with homemade guacamole!\n" +
                "\n" +
                "Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Don't have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.  Other Ways to Use Guacamole\n" +
                "Guacamole has a role in the kitchen beyond a party dip, of course. It's great scooped on top of nachos and also makes an excellent topping or side for enchiladas, tacos, grilled salmon, or oven-baked chicken.\n" +
                "\n" +
                "Guacamole is great in foods, as well. Try mixing some guacamole into a tuna sandwich or your next batch of deviled eggs.\n" +
                "\n" +
                "How to Store Guacamole\n" +
                "Guacamole is best eaten right after it's made. Like apples, avocados start to oxidize and turn brown once they've been cut. That said, the acid in the lime juice you add to guacamole can help slow down that process, and if you store the guacamole properly, you can easily make it a few hours ahead if you are preparing for a party.\n" +
                "\n" +
                "The trick to keeping guacamole green is to make sure air doesn't touch it! Transfer it to a container, cover with plastic wrap, and press down on the plastic wrap to squeeze out any air pockets. Make sure any exposed surface of the guacamole is touching the plastic wrap, not air. This will keep the amount of browning to a minimum.\n" +
                "\n" +
                "You can store the guacamole in the fridge this way for up to three days.\n" +
                "\n" +
                "If you leave the guacamole exposed to air, it will start to brown and discolor. That browning isn't very appetizing, but the guacamole is still good. You can either scrape off the brown parts and discard, or stir them into the rest of the guacamole.");
        perfectGuacamole.setNotes(guacNotes);
        recipes.add(perfectGuacamole);
        log.debug("Perfect Guac Recipe Added");
        log.debug("Adding Spicy Tacos");
        //Spicy Tacos
        Recipe chxTaco = new Recipe();
        chxTaco.getCategories().add(optionalAmerican);
        chxTaco.getCategories().add(optionalMexican);
        chxTaco.setPrepTime(20);
        chxTaco.setCookTime(15);
        chxTaco.setServings(4);
        chxTaco.setSource("SimplyRecipes.com");
        chxTaco.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");


        chxTaco.setDescription("Spicy Grilled Chicken Tacos");
        chxTaco.setDifficulty(Difficulty.MODERATE);
        chxTaco.setDirections("1. Prepare a gas or charcoal grill for medium-high, direct heat  2. Make the marinade and coat the chicken:\n" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.  3. Grill the chicken:\n" +
                "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.  4. Warm the tortillas:\n" +
                "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.  5. Assemble the tacos:\n" +
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        chxTaco.addIngredient(new Ingredient("ancho chili powder", new BigDecimal("2"), optionalTablespoon));
        chxTaco.addIngredient(new Ingredient("dried oregano", new BigDecimal("1"), optionalTeaspoon));
        chxTaco.addIngredient(new Ingredient("dried cumin", new BigDecimal("1"), optionalTeaspoon));
        chxTaco.addIngredient(new Ingredient("sugar", new BigDecimal("1"), optionalTeaspoon));
        chxTaco.addIngredient(new Ingredient("salt", new BigDecimal(".5"), optionalTeaspoon));
        chxTaco.addIngredient(new Ingredient("garlic clove, finely chopped", new BigDecimal("1"), optionalEach));
        chxTaco.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal("1"), optionalTablespoon));
        chxTaco.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal("3"), optionalTablespoon));
        chxTaco.addIngredient(new Ingredient("olive oil", new BigDecimal("2"), optionalTablespoon));
        chxTaco.addIngredient(new Ingredient("skinless, boneless chicken thighs(1 1/4 lbs)", new BigDecimal("6"), optionalEach));
        chxTaco.addIngredient(new Ingredient("small corn tortillas", new BigDecimal("8"), optionalEach));
        chxTaco.addIngredient(new Ingredient("packed baby arugula", new BigDecimal("3"), optionalCup));
        chxTaco.addIngredient(new Ingredient("medium ripe avocados", new BigDecimal("2"), optionalEach));
        chxTaco.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal("4"), optionalEach));
        chxTaco.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), optionalPint));
        chxTaco.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), optionalEach));
        chxTaco.addIngredient(new Ingredient("roughly chopped cilantro", new BigDecimal("1"), optionalEach));
        chxTaco.addIngredient(new Ingredient("sour cream thinned with 1/4 cup milk", new BigDecimal(".5"), optionalCup));
        chxTaco.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal("1"), optionalEach));
        Notes tacoNotes = new Notes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today's tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!  The ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find ancho chile powder at any markets that sell Mexican ingredients, or online.\n" +
                "\n" +
                "I like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well – this green isn't traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos.\n" +
                "\n" +
                "Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them.\n" +
                "\n" +
                "You could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day? Now that's living!");
        chxTaco.setNotes(tacoNotes);
        recipes.add(chxTaco);
        log.debug("Spicy Tacos recipe added");

        recipeService.setRecipes(recipes);
    }
}
