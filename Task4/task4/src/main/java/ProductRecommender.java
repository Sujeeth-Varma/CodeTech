import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.List;

public class ProductRecommender {
    private final UserBasedRecommender recommender;

    public ProductRecommender(String dataFilePath) throws Exception {
        // Load user preference data
        DataModel model = new FileDataModel(new File(dataFilePath));

        // Define user similarity metric
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

        // Define user neighborhood
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);

        // Create recommender
        this.recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
    }

    public List<RecommendedItem> recommendProducts(long userId, int numRecommendations) throws TasteException {
        return recommender.recommend(userId, numRecommendations);
    }
}