public class DecisionTree
  {
    private Node root;
    public void train(Dataset trainingData)
    {
      root = buildTree(trainingData);
    }
    private Node buildTree(Dataset dataset)
    {
      if(dataset.isPure()) 
      {
        return new LeafNode(dataset.getMajorityClass());
      }
      else if(dataset.isEmpty())
      {
        return new LeafNode(getMostFrequentClass(trainingData));
      }
      // find best attribute to pslit on
      Attribute bestAttribute = findBestAttribute(dataset);

      // create new internal node
      Node node = new InternalNode(bestAttribute);

      // split dataset based on best attribute
      for (Object value: bestAttribute.getPossibleValues())
        {
          Dataset subset = dataset.split(bestAttribute, value);
          node.addChild(buildTree(subset));
        }
      return node;
    }

    
