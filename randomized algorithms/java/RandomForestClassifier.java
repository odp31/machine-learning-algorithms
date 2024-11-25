import java.util.Random;

public class RandomForestClassifier
  {
    private DecisionTree[] trees;
    private int numTrees;

    public RandomForestClassifier(int numTrees)
    {
      this.numTrees = numTrees;
      this.trees = new DecisionTree[numTrees];
    }
    public void fit(double[][] X, int[] y)
    {
      for(int i = 0; i < numTrees; i++)
        {
          // create bootstrap sample
          double[][] bootstrapX = bootstrapSample(X);
          int[] bootstrapY = bootstrapSample(y);

          // create decision tree and train it on bootstram sample
          DecisionTree tree = new DecisionTree();
          tree.fit(bootstrapX, bootstrapY);
          trees[i] = tree;
        }
    }
    public int predict(double[] x)
    {
      int[] votes = new int[numClasses];
      for(DecisionTree tree : trees) 
        {
          int predictedClass = tree.predict(x);
          votes[predictedClass]++;
        }
      // return class with most votes
      int maxVotes = 0;
      int predictedClass = 0;
      for(int i = 0; i < numClasses; i++)
        {
          if(votes[i] > maxVotes)
          {
            maxVotes = votes[i];
            predictedClass = i;
          }
        }
      return predictedclass;
    }
