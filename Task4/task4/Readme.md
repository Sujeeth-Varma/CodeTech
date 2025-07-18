# Product Recommendation System

## Overview

This Java application demonstrates a product recommendation engine using collaborative filtering with Apache Mahout. It suggests products based on user preference patterns in the sample dataset.

## Features

- Collaborative filtering algorithm
- Pearson correlation similarity metric
- Threshold-based user neighborhood
- Configurable recommendation count
- Sample dataset included

## Prerequisites

1. Java 11+
2. Apache Maven
3. Apache Mahout dependencies

## Dependencies (Maven pom.xml)

```xml
<dependencies>
    <dependency>
        <groupId>org.apache.mahout</groupId>
        <artifactId>mahout-core</artifactId>
        <version>0.9</version>
    </dependency>
    <dependency>
        <groupId>org.apache.mahout</groupId>
        <artifactId>mahout-integration</artifactId>
        <version>0.9</version>
    </dependency>
</dependencies>
```

## Setup & Execution

1. **Clone Repository**:

   ```bash
   git clone https://github.com/yourusername/recommendation-system.git
   cd recommendation-system
   ```

2. **Build Project**:

   ```bash
   mvn clean package
   ```

3. **Run Demo**:
   ```bash
   java -cp target/classes RecommendationDemo
   ```

## Sample Output

```
Top 3 recommendations for User 1:
----------------------------------
Product ID: 104    | Strength: 4.50
Product ID: 105    | Strength: 4.25
Product ID: 106    | Strength: 3.75
----------------------------------
```

## Configuration Options

- **Data File**: Modify `user_preferences.csv` to add your own data
- **Similarity Threshold**: Adjust in `ProductRecommender.java`
- **Recommendation Count**: Change in `RecommendationDemo.java`

## How It Works

1. **Data Loading**: Reads user preferences from CSV file
2. **Similarity Calculation**: Uses Pearson correlation to find similar users
3. **Neighborhood Formation**: Groups users with similarity > 0.1
4. **Recommendation Generation**: Predicts preferences based on similar users
5. **Result Filtering**: Returns top N recommendations for target user

## Customization

1. Add more users/products to `user_preferences.csv`
2. Experiment with different similarity metrics:
   - `EuclideanDistanceSimilarity`
   - `LogLikelihoodSimilarity`
   - `TanimotoCoefficientSimilarity`
3. Try different neighborhood strategies:
   - `NearestNUserNeighborhood`
   - `ClosestUserNeighborhood`

This implementation provides a functional recommendation system that can be extended for real-world e-commerce applications or content suggestion platforms.
