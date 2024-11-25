import java.util.HashMap;
import java.util.Map;
import java.util.Random; 

public class RandomizedSearch
  {
    public static <T> T randomSearch(Model<T> model, Map<String, Object> param_distributions, int iterations)
    {
      Random random = new Random();
      T bestModel = null;
      double bestScore = Double.NEGATIVE_INFINITY;

      for(int i = 0; i < iterations; i++)
        {
          Map<String, Object> params = new HashMap<>();
          for(Map.Entry<String, Object> entry: param_distributions.entrySet())
            {
              String paramName = entry.getKey();
              Object[] paramValues = (Object[]) entry.getValue();
              int index = random.nextInt(paramValues.length);
              params.put(paramName, paramValues[index]);
            }
          model.setParams(params);
          double score = model.evaluate();
          if(score > bestScore)
          {
            bestScore = score;
            bestModel = model.clone();
          }
        }
      return bestModel;
    }
    // example usage
    public static void main(String[] args)
    {
      Model<YourModel> modle = new YourModel();
      Map<String, Object> param_distributions = new HashMap<>();
      param_distributions.put("learning_rate", new Double[]{0.01, 0.001, 0.0001});
      param_distributions.put("batch_size", new Integer[]{32, 64, 128});

      YourModel bestModel = RandomizedSearch.randomSearch(model, param_distributions, 10);
    }
  }
