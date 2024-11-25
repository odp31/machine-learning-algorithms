import java.util.*;

public class DecisionTree
  {
    private Node root;
    public void buildTree(Dataset dataset)
    {
      root = buildTreeRecursive(dataset);
    }
    private Node buildTreeRecursive(Dataset dataset)
    {
      if(dataset.isPure())
      {
        return new LeafNode(dataset.getMajorityClass());
      }
      else if(dataset.isEmpty())
      {
        return new LeafNode(dataset.getMajorityClassFromParent());
      }
      // choose best attribute to split on
      Attribute bestAttribute = chooseBestAttribute(dataset);
      // create new node
      Node node = new Node(bestAttribute);
      // split dataset based on best attribute
      Map<Object, Dataset> subsets = dataset.split(bestAttribute);
      // recursively build tree for each subset
      for(Object value : subsets.keySet())
        {
          Node childNode = buildTreeRecursive(subsets.get(value));
          node.addChild(value, childNode);
        }
      return node;
    }
    private Attribute chooseBestAttribute(Dataset dataset)
    {
      Attribute bestAttribute = null;
      double highestGain = 0;
      for(Attribute attribute : dataset.getAttributes())
        {
          double gain = calculateInformationGain(dataset, attribute);
          if(gain > highestGain)
          {
            highestGain = gain;
            bestAttribute = attribute;
          }
        }
      return bestAttribute;
    }
    
