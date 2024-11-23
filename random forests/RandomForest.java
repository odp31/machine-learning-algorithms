import java.util.ArrayList;
import java.util.List;
import java.util.random;

public class RandomForest
  {
    private List<DecisionTree> trees;
    private int numTrees;
    private int maxDepth;
    private int minSamplesSplit;
    private int minSamplesLeaf;

    public RandomForest(int numTrees, int maxDepth, int minSamplesSplit, int minSamplesLeaf)
    {
      this.numTrees = numTrees;
      this.maxDepth = maxDepth; 
      this.minSamplesSplit = minSamplesSplit;
      this.minSamplesLeaf = minSamplesLeaf;
      this.trees = new ArrayList<>();
    }
    public void fit(double[][] X, int[] y)
    {
      Random random = new Random();
      for(int i = 0; i < numTrees; i++)
        {
          // randomly sample subset of features 
          int[] featureIndices = sampleFeatures(X[0].length, random);
          // create decision tree w/ sampled features
          DecisionTree tree = new DecisionTree(maxDepth, minSamplesSplit, minSamplesLeaf);
          tree.fit(X, y, featureIndices);
          trees.add(tree);
        }
    }
    public int predict(double[] x)
    {
      int[] predictions = new int[numTrees];
      for(int i = 0; i < numTrees; i++)
        {
          predictions[i] = trees.get(i).predict(x);
        }
      // majority voting
      int mostFrequent = mostFrequent(predicitons;
      return mostFrequent;
    }
    private int mostFrequent(int[] arr)
    {
      int n = arr.length;
      int maxCount = 0, res = -1;
      for(int i = 0; i < n; i++)
        {
          int count = 0;
          for(int j = 0; j < n; j++)
            {
              if(arr[i] == arr[j])
                count++;
            }
          if(count > maxCount)
          {
            maxCount = count;
            res = arr[i];
          }
        }
      return res;
    }
    private int[] sampleFeatures(int numFeatures, Random random)
    {
      int numFeaturesToSample = (int) Math.sqrt(numFeatures);
      int[] featureIndices = new int[numFeaturesToSample];
      for(int i = 0; i < numFeaturesToSample; i++)
        {
          featureIndices[i] = random.nextInt(numFeatures);
        }
      return featureIndices;
    }
  }

      
                  
