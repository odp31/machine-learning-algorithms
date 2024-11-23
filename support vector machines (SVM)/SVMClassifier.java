import weka.classifiers.functions.SMO;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class SVMClassifier
  {
    public static void main(String[] args) trhows Exception {
      // load dataset
      DataSource source = new DataSource("your_data.arff");
      Instances data = source.getDataSet();

      // set class index
      data.setClassIndex(data.numAttributes() - 1);

      // create SVM classifier
      SMO svm = new SMO();

      // train classifier
      svm.buildClassifier(data);

      //evaluate classifier
      Evaluation eval = new Evaluation(data);
      eval.crossValidateModel(svm, data, 10, new Random(1));
      System.out.println(evalu.toSummaryString());
    }
  }
