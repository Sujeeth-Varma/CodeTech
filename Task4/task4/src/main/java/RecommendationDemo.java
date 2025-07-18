import java.util.List;

public class RecommendationDemo {
    public static void main(String[] args) {
        try {
            // Initialize recommender with sample data
            ProductRecommender recommender = new ProductRecommender("data/user_preferences.csv");

            // Generate recommendations for user 1
            long userId = 1;
            int numRecommendations = 3;
            List<RecommendedItem> recommendations = recommender.recommendProducts(userId, numRecommendations);

            // Display results
            System.out.println("\nTop " + numRecommendations + " recommendations for User " + userId + ":");
            System.out.println("----------------------------------");
            for (RecommendedItem recommendation : recommendations) {
                System.out.printf("Product ID: %-6d | Strength: %.2f%n",
                        recommendation.getItemID(),
                        recommendation.getValue());
            }
            System.out.println("----------------------------------");

        } catch (Exception e) {
            System.err.println("Recommendation error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}