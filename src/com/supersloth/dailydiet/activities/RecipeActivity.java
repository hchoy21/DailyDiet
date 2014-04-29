package com.supersloth.dailydiet.activities;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.supersloth.dailydiet.R;

public class RecipeActivity extends Activity {

	public static final String PREFS_NAME = "MyPreferencesFile";
	private TextView mealName, mealIng, mealDesc;
	private ImageView image;
	String rName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe);

		getActionBar().setHomeButtonEnabled(true);

		mealName = (TextView) findViewById(R.id.tvRecipeName);
		mealIng = (TextView) findViewById(R.id.tvRecipeIngredients);
		mealDesc = (TextView) findViewById(R.id.tvRecipeDescrip);
		image = (ImageView) findViewById(R.id.imgRecipePic);

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		// SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		rName = sp.getString("ChoosenMeal", "Chicken Burrito");

		if (rName.equals("Chicken Burrito")) {
			image.setImageResource(R.drawable.chickenburrito);
			mealName.setText("Chicken Burrito");

			String ingredChkBurr = "2 skinless, boneless chicken breast halves\n"
					+ "1 (4 ounce) can tomato sauce\n"
					+ "1/4 cup salsa\n"
					+ "1 (1.25 ounce) package taco seasoning mix\n"
					+ "1 teaspoon ground cumin\n"
					+ "2 cloves garlic, minced\n"
					+ "1 teaspoon chili powder\n" + " hot sauce to taste\n";
			mealIng.setText(ingredChkBurr.toString());
			String descChkBurr = "Place chicken breasts and tomato sauce in a "
					+ "medium saucepan over medium high heat. Bring to a boil, "
					+ "then add the salsa, seasoning, cumin, garlic and chili "
					+ "powder. Let simmer for 15 minutes. "
					+ "With a fork, start pulling the chicken meat apart "
					+ "into thin strings. Keep cooking pulled chicken meat and "
					+ "sauce, covered, for another 5 to 10 minutes. Add hot sauce "
					+ "to taste and stir together (Note: You may need to add a bit "
					+ "of water if the mixture is cooked too high and gets too thick.)";
			mealDesc.setText(descChkBurr.toString());

		} else if (rName.equals("Chicken Penne")) {
			image.setImageResource(R.drawable.chickenpenne);
			mealName.setText("Chicken Penne");
			String ingredChkPen = "8 ounces dry penne pasta\n"
					+ "1 tablespoon cornstarch\n"
					+ "1 (15 ounce) can chicken broth\n"
					+ "2 tablespoons olive oil\n"
					+ "1 tablespoon garlic, minced\n"
					+ "4 skinless, boneless chicken breast halves - cut into cubes\n"
					+ "1 onion, sliced\n"
					+ "1/2 green bell pepper, seeded and thinly sliced\n"
					+ "1/2 red bell pepper, seeded and thinly sliced\n"
					+ "1 (16 ounce) can diced tomatoes\n"
					+ "1 teaspoon dried oregano\n" + "1 teaspoon dried basil\n"
					+ "1/4 cup medium-dry white wine\n"
					+ "1/2 cup freshly grated Parmesan cheese";
			mealIng.setText(ingredChkPen.toString());
			String descChkPen = "Bring a large pot of lightly salted water to a boil. "
					+ "Add the penne pasta and cook until al dente, 8 to 10 minutes. "
					+ "Drain, and reserve pasta. Whisk the cornstarch and chicken broth "
					+ "together in a bowl until smooth. Set aside until needed. Heat the "
					+ "olive oil in a skillet over medium heat. Add the garlic and chicken; "
					+ "stir and cook until the chicken is no longer pink and juices run clear, "
					+ "about 10 minutes. Stir in the onion, and green and red peppers; cook "
					+ "until tender, about 5 minutes. Stir in the tomatoes, and simmer for "
					+ "10 minutes. Pour in the chicken broth mixture and wine, if desired, "
					+ "and season with oregano and basil. Stir in the cooked pasta, and simmer "
					+ "over medium heat until thoroughly heated through, about 5 minutes. Serve "
					+ "garnished with Parmesan cheese.";
			mealDesc.setText(descChkPen.toString());

		} else if (rName.equals("Chicken Teriyaki")) {
			image.setImageResource(R.drawable.chickenteriyaki);
			mealName.setText("Chicken Teriyaki");
			String ingredChkTer = "1/4 cup soy sauce\n" + "1 cup water\n"
					+ "1/3 cup maple syrup\n"
					+ "3 tablespoons dark sesame oil\n"
					+ "2 cloves garlic, crushed\n"
					+ "1 tablespoon minced fresh ginger root\n"
					+ "2 teaspoons ground black pepper\n"
					+ "5 skinless, boneless chicken breast halves\n"
					+ "1 head of broccoli\n" + "1 cup brown rice\n"
					+ "2 cups water\n" + "2 tablespoons cornstarch";
			mealIng.setText(ingredChkTer.toString());
			String descChkTer = "Mix the soy sauce, 1 cup water, maple syrup, sesame oil, garlic, "
					+ "ginger, and pepper in a large resealable plastic bag. Set aside 1/3 cup of "
					+ "the mixture. Place the chicken in the bag, seal, and marinate at least 2 hours "
					+ "in the refrigerator. Place the rice in a saucepan with 2 cups water, and bring "
					+ "to a boil. Cover, reduce heat to low, and simmer 45 minutes. Preheat the oven "
					+ "broiler. Lightly grease a baking dish. Pour marinade from the bag into a "
					+ "saucepan, and bring to a boil. Mix in the cornstarch, and cook and stir "
					+ "until thickened. Place chicken in the prepared baking dish. Basting frequently "
					+ "with the reserved 1/3 cup marinade, broil 8 minutes per side, until juices run "
					+ "clear. Place chicken over the cooked rice, and top with boiled marinade to serve.";
			mealDesc.setText(descChkTer.toString());

		} else if (rName.equals("Fish Tacos")) {
			image.setImageResource(R.drawable.fishtacos);
			mealName.setText("Fish Tacos");
			String ingredFishTaco = "1 cup all-purpose flour\n"
					+ "2 tablespoons cornstarch\n"
					+ "1 teaspoon baking powder\n" + "1/2 teaspoon salt\n"
					+ "1 egg\n" + "1 cup beer\n" + "1/2 cup plain yogurt\n"
					+ "1/2 cup mayonnaise\n" + "1 lime, juiced\n"
					+ "1 jalapeno pepper, minced\n"
					+ "1 teaspoon minced capers\n"
					+ "1/2 teaspoon dried oregano\n"
					+ "1/2 teaspoon ground cumin\n"
					+ "1/2 teaspoon dried dill weed\n"
					+ "1 teaspoon ground cayenne pepper\n"
					+ "1 quart oil for frying\n"
					+ "1 pound cod fillets, cut into 2 to 3 ounce portions\n"
					+ "1 (12 ounce) package corn tortillas\n"
					+ "1/2 medium head cabbage, finely shredded";
			mealIng.setText(ingredFishTaco.toString());
			String descFishTaco = "To make beer batter: In a large bowl, combine flour, cornstarch, "
					+ "baking powder, and salt. Blend egg and beer, then quickly stir into the flour "
					+ "mixture (don't worry about a few lumps). To make white sauce: In a medium bowl, "
					+ "mix together yogurt and mayonnaise. Gradually stir in fresh lime juice until "
					+ "consistency is slightly runny. Season with jalapeno, capers, oregano, cumin, "
					+ "dill, and cayenne. Heat oil in deep-fryer to 375 degrees F (190 degrees C). Dust "
					+ "fish pieces lightly with flour. Dip into beer batter, and fry until crisp and "
					+ "golden brown. Drain on paper towels. Lightly fry tortillas; not too crisp. To "
					+ "serve, place fried fish in a tortilla, and top with shredded cabbage, and white sauce.";
			mealDesc.setText(descFishTaco.toString());

		} else if (rName.equals("Salmon and Green Beans")) {
			image.setImageResource(R.drawable.salmon);
			mealName.setText("Salmon and Green Beans");
			String ingredSalmon = "1/4 cup butter, melted\n"
					+ "3 tablespoons Dijon mustard\n"
					+ "1 1/2 tablespoons honey\n"
					+ "1/4 cup dry bread crumbs\n"
					+ "1/4 cup finely chopped pecans\n"
					+ "4 teaspoons chopped fresh parsley\n"
					+ "4 (4 ounce) fillets salmon\n"
					+ "salt and pepper to taste\n" + "1 lemon, for garnish";
			mealIng.setText(ingredSalmon.toString());
			String descSalmon = "Preheat oven to 400 degrees F (200 degrees C). In a small bowl, stir "
					+ "together butter, mustard, and honey. Set aside. In another bowl, mix together "
					+ "bread crumbs, pecans, and parsley. Brush each salmon fillet lightly with honey "
					+ "mustard mixture, and sprinkle the tops of the fillets with the bread crumb mixture. "
					+ "Bake salmon 12 to 15 minutes in the preheated oven, or until it flakes easily with a "
					+ "fork. Season with salt and pepper, and garnish with a wedge of lemon.";
			mealDesc.setText(descSalmon.toString());

		} else if (rName.equals("Spaghetti and Meatballs")) {
			image.setImageResource(R.drawable.spaghettiwithmeatballs);
			mealName.setText("Spaghetti and Meatballs");
			String ingredSpahgetti = " 3 tablespoons olive oil\n"
					+ "3/4 cup chopped onion\n" + "4 cloves garlic, minced\n"
					+ "2 (16 ounce) cans crushed tomatoes\n"
					+ "3 (6 ounce) cans tomato paste\n" + "1 cup water\n"
					+ "1/2 cup sugar\n"
					+ "1/4 cup chopped fresh oregano, divided\n"
					+ "1 dried bay leaf\n" + "salt and pepper to taste\n"
					+ "1 pound ground round\n"
					+ "1/2 cup Italian seasoned bread crumbs\n"
					+ "1/4 cup chopped fresh parsley\n"
					+ "2 eggs, lightly beaten\n"
					+ "1/2 cup grated Parmesan cheese\n"
					+ "1 (16 ounce) package uncooked spaghetti";
			mealIng.setText(ingredSpahgetti.toString());
			String descSpahgetti = "Heat the olive oil in a large saucepan over medium heat, and cook the "
					+ "onion until lightly brown. Mix in 2 cloves garlic, and cook 1 minute. Stir in crushed "
					+ "tomatoes, tomato paste, water, sugar, 1/2 the oregano, and bay leaf. Season with salt "
					+ "and pepper. Bring to a boil, reduce heat to low, and simmer while preparing meatballs. "
					+ "In a bowl, mix the ground round, bread crumbs, remaining oregano, remaining garlic, "
					+ "parsley, eggs, and cheese. Season with salt and pepper. Roll into 1 inch balls, and "
					+ "drop into the sauce. Cook 40 minutes in the sauce, or until internal temperature of "
					+ "meatballs reaches a minimum of 160 degrees F (72 degrees C). Bring a large pot of "
					+ "lightly salted water to a boil, and stir in the spaghetti. Cook 8 to 10 minutes, "
					+ "until al dente, and drain. Serve the meatballs and sauce over the cooked spaghetti.";
			mealDesc.setText(descSpahgetti.toString());

		} else if (rName.equals("Tuna Sandwich")) {
			image.setImageResource(R.drawable.tunasandwich);
			mealName.setText("Tuna Sandwich");
			String ingredTunaSand = "1 (6 ounce) can tuna, drained\n"
					+ "1/4 cup mayonnaise\n"
					+ "1 1/2 teaspoons cream-style horseradish sauce\n"
					+ "1 tablespoon chopped dill pickles\n"
					+ "2 leaves lettuce\n" + "2 slices Swiss cheese\n"
					+ "4 slices bread\n" + "2 slices tomato\n"
					+ "2 thin slices red onion";
			mealIng.setText(ingredTunaSand.toString());

			String descTunaSand = "Combine the drained tuna, mayonnaise, horseradish sauce, and pickles in "
					+ "a small bowl until evenly mixed. Place a slice of Swiss cheese onto 2 slices of bread, "
					+ "and top with a leaf of lettuce. Spread the tuna mixture onto the lettuce leaves. Top "
					+ "with the tomato and red onion slices, and finish with the remaining slices of bread.";
			mealDesc.setText(descTunaSand.toString());
		} else if (rName.equals("Tuna Salad")) {
			image.setImageResource(R.drawable.tunasalad);
			mealName.setText("Tuna Salad");
			String ingredTunaSalad = "1/2 baguette, cut into 3/4-inch cubes (about 3 cups)\n"
					+ "4 tablespoons olive oil\n"
					+ "Coarse salt and ground pepper\n"
					+ "1 small garlic clove\n"
					+ "3 tablespoons fresh lemon juice\n"
					+ "2 teaspoons Dijon mustard\n"
					+ "1 head Boston lettuce (about 10 ounces), torn into pieces\n"
					+ "2 plum tomatoes, cored, halved lengthwise, and sliced 1/2 inch thick\n"
					+ "1 English cucumber, halved lengthwise, seeded, and thinly sliced\n"
					+ "1/2 cup pitted Kalamata olives, halved\n"
					+ "2 cans (6 ounces each) tuna packed in olive oil, drained";
			mealIng.setText(ingredTunaSalad.toString());
			String descTunaSalad = "STEP 1\n"
					+ "In a large skillet, toss bread with 2 tablespoons oil; season with salt and "
					+ "pepper. Cook over medium heat, tossing frequently, until croutons are golden "
					+ "and crisp, 10 to 12 minutes. Set aside.\n"
					+ "STEP 2\n"
					+ "Finely chop garlic, and sprinkle with salt. Using a chef's knife, press the "
					+ "flat side of the blade back and forth across garlic to make a paste. Transfer to a "
					+ "large bowl; whisk in lemon juice, mustard, and remaining oil. Season dressing with "
					+ "salt and pepper.\n"
					+ "STEP 3\n"
					+ "To bowl, add lettuce, tomatoes, cucumber, olives, and croutons; toss to combine. "
					+ "Divide salad among four plates, and top with tuna.";
			mealDesc.setText(descTunaSalad.toString());

		} else if (rName.equals("Turkey Sandwich")) {
			image.setImageResource(R.drawable.turkeysandwich);
			mealName.setText("Turkey Sandwich");
			String ingredTurkeySandwich = "1 loaf French bread\n "
					+ "4 tablespoons margarine\n "
					+ "8 ounces sliced deli turkey meat\n "
					+ "8 slices provolone cheese\n "
					+ "8 slices precooked bacon\n "
					+ "4 tablespoons mayonnaise\n "
					+ "4 tablespoons jellied cranberry sauce\n "
					+ "8 slices fresh tomatoes\n " + "4 lettuce leaves\n";
			mealIng.setText(ingredTurkeySandwich.toString());
			String descTurkeySandwich = "Preheat the oven broiler.Cut the bread "
					+ "into four pieces, and split lengthwise almost all the way "
					+ "through for four sandwiches. Spread margarine on the inside "
					+ "of each piece. Place on a baking sheet, cut side up. Toast "
					+ "\bread under preheated broiler until lightly browned, 1 "
					+ "to 2 minutes. Remove pan from the oven.Layer 4 pieces of "
					+ "bread with 2 slices each of the turkey, cheese, and bacon. "
					+ "Remove the remaining 4 slices of bread from the baking sheet "
					+ " and reserve for sandwich tops. Cool bread slightly, and "
					+ "spread mayonnaise onto the cut side of each of the 4 top "
					+ "slices.Place the bread with turkey and cheese under the "
					+ "broiler just until the cheese melts, about 1 minute. "
					+ "Remove from the broiler, and spread 1 tablespoon cranberry "
					+ "sauce over each sandwich. Layer with the tomatoes and lettuce. "
					+ "Place a top bread slice over each half, and serve.";
			mealDesc.setText(descTurkeySandwich.toString());

		}

	}

	private void backButton() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		if (android.R.id.home == item.getItemId()) {
			backButton();
		}
		return super.onOptionsItemSelected(item);
	}

}
